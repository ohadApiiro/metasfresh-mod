package org.compiere.acct;

import com.google.common.collect.ImmutableList;
import de.metas.acct.GLCategoryId;
import de.metas.acct.accounts.AccountProvider;
import de.metas.acct.accounts.AccountProviderExtension;
import de.metas.acct.accounts.BPartnerCustomerAccountType;
import de.metas.acct.accounts.BPartnerGroupAccountType;
import de.metas.acct.accounts.BPartnerVendorAccountType;
import de.metas.acct.accounts.DefaultAccountType;
import de.metas.acct.accounts.GLAccountType;
import de.metas.acct.api.AccountId;
import de.metas.acct.api.AcctSchema;
import de.metas.acct.api.AcctSchemaGeneralLedger;
import de.metas.acct.doc.AcctDocContext;
import de.metas.acct.doc.AcctDocRequiredServicesFacade;
import de.metas.acct.doc.PostingException;
import de.metas.banking.BankAccount;
import de.metas.banking.BankAccountId;
import de.metas.banking.accounting.BankAccountAcctType;
import de.metas.bpartner.BPartnerId;
import de.metas.common.util.CoalesceUtil;
import de.metas.costing.ChargeId;
import de.metas.currency.CurrencyConversionContext;
import de.metas.currency.CurrencyPrecision;
import de.metas.currency.ICurrencyDAO;
import de.metas.currency.exceptions.NoCurrencyRateFoundException;
import de.metas.document.DocBaseType;
import de.metas.document.DocTypeId;
import de.metas.document.engine.DocStatus;
import de.metas.error.AdIssueId;
import de.metas.i18n.AdMessageKey;
import de.metas.i18n.BooleanWithReason;
import de.metas.lang.SOTrx;
import de.metas.location.LocationId;
import de.metas.logging.LogManager;
import de.metas.money.CurrencyConversionTypeId;
import de.metas.money.CurrencyId;
import de.metas.order.OrderId;
import de.metas.organization.InstantAndOrgId;
import de.metas.organization.LocalDateAndOrgId;
import de.metas.organization.OrgId;
import de.metas.product.ProductId;
import de.metas.product.acct.api.ActivityId;
import de.metas.project.ProjectId;
import de.metas.sectionCode.SectionCodeId;
import de.metas.user.UserId;
import de.metas.util.Check;
import de.metas.util.NumberUtils;
import de.metas.util.lang.RepoIdAware;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import org.adempiere.ad.trx.api.ITrx;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.model.InterfaceWrapperHelper;
import org.adempiere.service.ClientId;
import org.adempiere.util.lang.impl.TableRecordReference;
import org.adempiere.util.logging.LoggingHelper;
import org.adempiere.warehouse.WarehouseId;
import org.compiere.model.I_C_BP_BankAccount;
import org.compiere.model.I_C_DocType;
import org.compiere.model.MAccount;
import org.compiere.model.MNote;
import org.compiere.model.MPeriod;
import org.compiere.model.PO;
import org.compiere.model.POInfo;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.TrxRunnable2;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.IntFunction;

/**
 * Posting Document Root.
 *
 * <pre>
 *  Table               Base Document Types (C_DocType.DocBaseType & AD_Reference_ID=183)
 *      Class           AD_Table_ID
 *  ------------------  ------------------------------
 *  C_Invoice:          ARI, ARC, ARF, API, APC
 *      Doc_Invoice     318 - has C_DocType_ID
 *
 *  C_Payment:          ARP, APP
 *      Doc_Payment     335 - has C_DocType_ID
 *
 *  C_Order:            SOO, POO,  POR (Requisition)
 *      Doc_Order       259 - has C_DocType_ID
 *
 *  M_InOut:            MMS, MMR
 *      Doc_InOut       319 - DocType derived
 *
 *  M_Inventory:        MMI
 *      Doc_Inventory   321 - DocType fixed
 *
 *  M_Movement:         MMM
 *      Doc_Movement    323 - DocType fixed
 *
 *  M_Production:       MMP
 *      Doc_Production  325 - DocType fixed
 *
 * M_Production:        MMO
 *      Doc_CostCollector  330 - DocType fixed
 *
 *  C_BankStatement:    CMB
 *      Doc_Bank        392 - DocType fixed
 *
 *  C_Cash:             CMC
 *      Doc_Cash        407 - DocType fixed
 *
 *  C_Allocation:       CMA
 *      Doc_Allocation  390 - DocType fixed
 *
 *  GL_Journal:         GLJ
 *      Doc_GLJournal   224 = has C_DocType_ID
 *
 *  Matching Invoice    MXI
 *      M_MatchInv      472 - DocType fixed
 *
 *  Matching PO         MXP
 *      M_MatchPO       473 - DocType fixed
 *
 * Project Issue		PJI
 * 	C_ProjectIssue	623 - DocType fixed
 *
 * @author Jorg Janke
 * @author victor.perez@e-evolution.com, e-Evolution <a href="http://www.e-evolution.com">...</a>
 * <li>FR [ 2520591 ] Support multiples calendar for Org
 */
@SuppressWarnings({ "OptionalUsedAsFieldOrParameterType", "OptionalAssignedToNull" })
public abstract class Doc<DocLineType extends DocLine<?>>
{
	private final String SYSCONFIG_CREATE_NOTE_ON_ERROR = "org.compiere.acct.Doc.createNoteOnPostError";

	@Getter(AccessLevel.PROTECTED)
	protected final AcctDocRequiredServicesFacade services;


	private static final Logger log = LogManager.getLogger(Doc.class);

	protected Doc(final AcctDocContext ctx)
	{
		this(ctx, null); // defaultDocBaseType=null
	}

	/**
	 * @param ctx                construction parameters
	 * @param defaultDocBaseType suggested DocBaseType to be used
	 */
	protected Doc(@NonNull final AcctDocContext ctx, @Nullable final DocBaseType defaultDocBaseType)
	{
		services = ctx.getServices();
		acctSchemas = ctx.getAcctSchemas();

		//
		// Document model
		final Object documentModel = ctx.getDocumentModel();
		p_po = InterfaceWrapperHelper.getPO(documentModel);
		Check.assumeNotNull(p_po, "p_po not null");

		// IMPORTANT: to make sure events like FactAcctListenersService.fireAfterUnpost will use the thread inherited trx
		p_po.set_TrxName(ITrx.TRXNAME_ThreadInherited);

		_docStatus = extractDocStatus(p_po);

		// Document Type
		setDocBaseType(defaultDocBaseType);
	}   // Doc

	private static DocStatus extractDocStatus(@NonNull final PO po)
	{
		final int index = po.get_ColumnIndex("DocStatus");
		if (index >= 0)
		{
			return DocStatus.ofNullableCodeOrUnknown((String)po.get_Value(index));
		}
		else
		{
			return null; // no DocStatus (e.g. M_MatchInv etc)
		}
	}

	/**
	 * Accounting Schemas
	 */
	private final ImmutableList<AcctSchema> acctSchemas;
	/**
	 * The Document
	 */
	private final PO p_po;
	/**
	 * Document Type
	 */
	private DocBaseType _docBaseType = null;
	/**
	 * Document Status
	 */
	private final DocStatus _docStatus;
	/**
	 * Document No
	 */
	private String m_DocumentNo = null;
	/**
	 * Description
	 */
	private String m_Description = null;
	/**
	 * GL Category
	 */
	private GLCategoryId m_GL_Category_ID;
	/**
	 * GL Period
	 */
	private MPeriod m_period = null;
	/**
	 * Period ID
	 */
	private int m_C_Period_ID = 0;
	@Nullable private final LocationId locationFromId = null;
	@Nullable private final LocationId locationToId = null;
	private LocalDateAndOrgId _dateAcct = null;
	private LocalDateAndOrgId _dateDoc = null;
	/**
	 *
	 * Is (Source) Multi-Currency Document - i.e. the document has different currencies (if true, the document will not be source balanced)
	 */
	private boolean m_MultiCurrency = false;
	/**
	 * BP Sales Region
	 */
	private int m_BP_C_SalesRegion_ID = -1;
	@Nullable private Optional<BPartnerId> _bpartnerId; // lazy

	/**
	 * Bank Account
	 */
	@Nullable private Optional<BankAccountId> _bankAccountId = null; // lazy
	@Nullable private BankAccount bankAccount = null;
	/**
	 * Cach Book
	 */
	private int m_C_CashBook_ID = -1;

	@Nullable private Optional<CurrencyId> _currencyId; // lazy
	@Nullable private CurrencyPrecision _currencyPrecision; // lazy

	/**
	 * Contained Doc Lines
	 */
	private List<DocLineType> docLines;

	private AccountProvider _accountProvider; // lazy

	public final String get_TableName()
	{
		return getPO().get_TableName();
	}

	protected final int get_Table_ID()
	{
		return getPO().get_Table_ID();
	}

	/**
	 * @return record id
	 */
	public final int get_ID()
	{
		return getPO().get_ID();
	}

	/**
	 * Get Persistent Object
	 *
	 * @return po
	 */
	private PO getPO()
	{
		return p_po;
	}    // getPO

	protected final <T> T getModel(final Class<T> modelClass)
	{
		return InterfaceWrapperHelper.create(getPO(), modelClass);
	}

	protected final void setDocLines(final List<DocLineType> docLines)
	{
		this.docLines = docLines;
	}

	protected final List<DocLineType> getDocLines()
	{
		return docLines;
	}

	/**
	 * Post Document.
	 *
	 * <pre>
	 *  - try to lock document (Processed='Y' (AND Processing='N' AND Posted='N'))
	 * 		- if not ok - return false
	 *          - postlogic (for all Accounting Schema)
	 *              - create Fact lines
	 *          - postCommit
	 *              - commits Fact lines and Document & sets Processing = 'N'
	 *              - if error - create Note
	 * </pre>
	 *
	 * @param force  if true ignore that locked
	 * @param repost if true ignore that already posted
	 */
	public final void post(final boolean force, final boolean repost)
	{
		lock(force, repost);

		//
		// Do the actual posting
		services.runInThreadInheritedTrx(new TrxRunnable2()
		{
			PostingException postingException;

			@Override
			public void run(final String localTrxName_NOTUSED)
			{
				post0(repost);
			}

			@Override
			public boolean doCatch(final Throwable e)
			{
				final PostingException postingException = newPostingException(e);
				this.postingException = postingException;

				final boolean createNote = services.getSysConfigBooleanValue(SYSCONFIG_CREATE_NOTE_ON_ERROR);
				if (createNote)
				{
					createErrorNote(postingException);
				}
				LoggingHelper.log(log, postingException.getLogLevel(), postingException.getLocalizedMessage(), postingException);

				throw postingException;
			}

			@Override
			public void doFinally()
			{
				//
				// Unlock (in parent transaction)
				unlock(postingException);
			}
		});
	}

	private static boolean isDocStatusValidForPosting(@Nullable final DocStatus docStatus)
	{
		return docStatus == null // This is a valid case (e.g. M_MatchInv, M_MatchPO)
				|| docStatus.isCompletedOrClosedReversedOrVoided();

	}

	private void post0(final boolean repost)
	{
		//
		// Validate document's DocStatus
		final DocStatus docStatus = getDocStatus();
		if (!isDocStatusValidForPosting(docStatus))
		{
			throw newPostingException()
					.setPreserveDocumentPostedStatus()
					.setDetailMessage("Invalid DocStatus='" + docStatus + "' for DocumentNo=" + getDocumentNo());
		}

		//
		// Validate document's AD_Client_ID
		if (!getClientId().equals(acctSchemas.get(0).getClientId()))
		{
			throw newPostingException()
					.setPreserveDocumentPostedStatus()
					.setDetailMessage("AD_Client_ID Conflict - Document=" + getClientId()
							+ ", AcctSchema=" + acctSchemas.get(0).getClientId());
		}

		//
		// Load document details
		try
		{
			loadDocumentDetails();
		}
		catch (final Exception ex)
		{
			throw newPostingException(ex)
					.setPreserveDocumentPostedStatus();
		}

		//
		// Delete existing Accounting
		if (repost)
		{
			if (isPosted() && !isPeriodOpen())    // already posted - don't delete if period closed
			{
				throw newPostingException()
						.setPreserveDocumentPostedStatus()
						.setDetailMessage("@PeriodClosed@");
			}

			// delete existing accounting records
			deleteAcct();
		}
		else if (isPosted())
		{
			throw newPostingException()
					.setPreserveDocumentPostedStatus()
					.setDetailMessage("@AlreadyPosted@");
		}

		//
		// Create Fact per AcctSchema
		final List<Fact> facts = new ArrayList<>();
		for (final AcctSchema acctSchema : acctSchemas)
		{
			if (isSkipPosting(acctSchema))
			{
				continue;
			}

			// post
			final List<Fact> factsForAcctSchema = postLogic(acctSchema);
			facts.addAll(factsForAcctSchema);
		}

		//
		// Fire event: BEFORE_POST
		services.fireBeforePostEvent(getPO());

		//
		// Save facts
		for (final Fact fact : facts)
		{
			fact.save();
		}

		//
		// Fire event: AFTER_POST
		services.fireAfterPostEvent(getPO());
		// Execute after document posted code
		afterPost();

		//
		// Dispose facts
		for (final Fact fact : facts)
		{
			fact.dispose();
		}
	}

	private boolean isSkipPosting(final AcctSchema acctSchema)
	{
		// if acct schema has "only" org, skip
		boolean skip = false;
		if (acctSchema.isPostOnlyForSomeOrgs())
		{
			// Header Level Org
			skip = acctSchema.isDisallowPostingForOrg(getOrgId());
			// Line Level Org
			final List<DocLineType> docLines = getDocLines();
			if (docLines != null)
			{
				for (int line = 0; skip && line < docLines.size(); line++)
				{
					skip = acctSchema.isDisallowPostingForOrg(docLines.get(line).getOrgId());
					if (!skip)
					{
						break;
					}
				}
			}
		}
		return skip;
	}

	private void deleteAcct()
	{
		final Object documentPO = getPO();
		services.deleteFactAcctByDocumentModel(documentPO);
	}

	private List<Fact> postLogic(final AcctSchema acctSchema)
	{
		// rejectUnbalanced
		final AcctSchemaGeneralLedger acctSchemaGL = acctSchema.getGeneralLedger();
		if (!acctSchemaGL.isSuspenseBalancing() && !isBalanced())
		{
			throw newPostingException()
					.setAcctSchema(acctSchema)
					.setPostingStatus(PostingStatus.NotBalanced);
		}

		// rejectUnconvertible
		checkConvertible(acctSchema);

		// rejectPeriodClosed
		if (!isPeriodOpen())
		{
			throw newPostingException()
					.setAcctSchema(acctSchema)
					.setPostingStatus(PostingStatus.PeriodClosed);
		}

		//
		// Create facts for accounting schema
		final List<Fact> facts = createFacts(acctSchema);
		if (facts == null)
		{
			throw newPostingException()
					.setAcctSchema(acctSchema)
					.setPostingStatus(PostingStatus.Error)
					.setDetailMessage("No facts");
		}

		//
		// Process facts: validate, GL distribution, balance etc
		for (final Fact fact : facts)
		{
			processFacts(fact);
		}

		return facts;
	}   // postLogic

	private void processFacts(final Fact fact)
	{
		if (fact == null)
		{
			throw newPostingException()
					// .setAcctSchema(acctSchema)
					.setPostingStatus(PostingStatus.Error)
					.setDetailMessage("No fact");
		}

		final AcctSchema acctSchema = fact.getAcctSchema();

		// check accounts
		final BooleanWithReason checkAccountsResult = fact.checkAccounts();
		if (checkAccountsResult.isFalse())
		{
			throw newPostingException()
					.setAcctSchema(acctSchema)
					.setPostingStatus(PostingStatus.InvalidAccount)
					.setDetailMessage(checkAccountsResult.getReason())
					.setFact(fact);
		}

		// distribute
		try
		{
			fact.distribute();
		}
		catch (final Exception e)
		{
			throw newPostingException(e)
					.setAcctSchema(acctSchema)
					.setPostingStatus(PostingStatus.Error)
					.setFact(fact)
					.setDetailMessage("Fact distribution error: " + e.getLocalizedMessage());
		}

		// Balance source amounts
		if (fact.isSingleCurrency() && !fact.isSourceBalanced())
		{
			fact.balanceSource();
			if (!fact.isSourceBalanced())
			{
				throw newPostingException()
						.setAcctSchema(acctSchema)
						.setPostingStatus(PostingStatus.NotBalanced)
						.setFact(fact)
						.setDetailMessage("Source amounts not balanced");
			}
		}

		// balanceSegments
		if (!fact.isSegmentBalanced())
		{
			fact.balanceSegments();
			if (!fact.isSegmentBalanced())
			{
				throw newPostingException()
						.setAcctSchema(acctSchema)
						.setPostingStatus(PostingStatus.NotBalanced)
						.setFact(fact)
						.setDetailMessage("Segment not balanced");
			}
		}

		// balanceAccounting
		if (!fact.isAcctBalanced())
		{
			fact.balanceAccounting();
			if (!fact.isAcctBalanced())
			{
				throw newPostingException()
						.setAcctSchema(acctSchema)
						.setPostingStatus(PostingStatus.NotBalanced)
						.setFact(fact)
						.setDetailMessage("Accountable amounts not balanced");
			}
		}
	}

	/**
	 * Lock document
	 *
	 * @param force  force posting
	 * @param repost true if is document re-posting; i.e. it will assume the document was not already posted
	 */
	private void lock(final boolean force, final boolean repost)
	{
		final String tableName = get_TableName();
		final int recordId = get_ID();

		final StringBuilder sql = new StringBuilder("UPDATE ");
		sql.append(tableName).append(" SET Processing='Y' WHERE ")
				.append(tableName).append("_ID=").append(recordId)
				.append(" AND Processed='Y' AND IsActive='Y'");
		if (!force)
		{
			sql.append(" AND (Processing='N' OR Processing IS NULL)");
		}
		if (!repost)
		{
			sql.append(" AND Posted='N'");
		}

		final int updatedCount = DB.executeUpdateAndThrowExceptionOnFail(sql.toString(), ITrx.TRXNAME_ThreadInherited);
		if (updatedCount != 1)
		{
			final PO po = getPO();
			final String errmsg = force ? "Cannot Lock - ReSubmit" : "Cannot Lock - ReSubmit or RePost with Force";
			throw newPostingException()
					.setDetailMessage(errmsg)
					.addDetailMessage("Hint: it could be that for some reason, the document remained locked (i.e. Processing=Y), so you could unlock it to fix the issue.")
					.setParameter("Processing", po.get_Value("Processing"))
					.setParameter("Processed", po.get_Value("Processed"))
					.setParameter("IsActive", po.get_Value("IsActive"))
					.setParameter("Posted", po.get_Value("Posted"))
					.setParameter("SQL", sql.toString())
					.setPostingStatus(PostingStatus.NotPosted)
					.setPreserveDocumentPostedStatus();
		}
	}

	private void unlock(final PostingException exception)
	{
		final String tableName = get_TableName();
		final POInfo poInfo = POInfo.getPOInfoNotNull(tableName);
		final String keyColumnName = poInfo.getKeyColumnName();
		final int recordId = get_ID();

		final StringBuilder sql = new StringBuilder("UPDATE ")
				.append(tableName).append(" SET ");

		//
		// Processing (i.e. unlock it)
		sql.append("Processing='N'");

		//
		// Posted
		final boolean updatePostedStatus = exception != null && !exception.isPreserveDocumentPostedStatus();
		if (exception == null)
		{
			sql.append(", Posted=").append(DB.TO_STRING(PostingStatus.Posted.getStatusCode()));
		}
		else if (updatePostedStatus)
		{
			final PostingStatus postingStatus = exception.getPostingStatus(PostingStatus.Error);
			sql.append(", Posted=").append(DB.TO_STRING(postingStatus.getStatusCode()));
		}

		//
		// PostingError_Issue_ID
		final String COLUMNNAME_PostingError_Issue_ID = "PostingError_Issue_ID";
		final boolean hasPostingIssueColumn = poInfo.hasColumnName(COLUMNNAME_PostingError_Issue_ID);
		if (hasPostingIssueColumn)
		{
			final AdIssueId postingErrorIssueId = exception != null
					? services.createIssue(exception)
					: null;

			final AdIssueId previousPostingErrorIssueId = AdIssueId.ofRepoIdOrNull(getPO().get_ValueAsInt(COLUMNNAME_PostingError_Issue_ID));
			if (previousPostingErrorIssueId != null
					&& !previousPostingErrorIssueId.equals(postingErrorIssueId))
			{
				services.markIssueDeprecated(previousPostingErrorIssueId);
			}

			if (postingErrorIssueId != null)
			{

				sql.append(", ").append(COLUMNNAME_PostingError_Issue_ID).append("=").append(postingErrorIssueId.getRepoId());
			}
			else
			{
				sql.append(", ").append(COLUMNNAME_PostingError_Issue_ID).append(" = NULL ");
			}
		}

		sql.append("\n WHERE ").append(keyColumnName).append("=").append(recordId);

		final int updateCount = DB.executeUpdateAndThrowExceptionOnFail(sql.toString(), ITrx.TRXNAME_ThreadInherited);

		fireDocumentChanged();

		if (updateCount != 1)
		{
			throw newPostingException()
					.setDetailMessage("Unable to unlock");
		}
	}

	private void fireDocumentChanged()
	{
		services.fireDocumentChanged(get_TableName(), get_ID());
	}

	/**************************************************************************
	 * Load Document Type and GL Info. Set p_DocumentType and p_GL_Category_ID
	 *
	 * @return document type (i.e. DocBaseType)
	 */
	protected final DocBaseType getDocBaseType()
	{
		if (_docBaseType == null)
		{
			setDocBaseType(null);
		}
		return _docBaseType;
	}

	/**
	 * Load Document Type and GL Info. Set p_DocumentType and p_GL_Category_ID
	 *
	 * @param docBaseType optional document base type to be used.
	 */
	private void setDocBaseType(@Nullable final DocBaseType docBaseType)
	{
		if (docBaseType != null)
		{
			_docBaseType = docBaseType;
		}

		// No Document Type defined
		final DocTypeId docTypeId = getC_DocType_ID();
		if (_docBaseType == null && docTypeId != null)
		{
			final I_C_DocType docType = services.getDocTypeById(docTypeId);
			_docBaseType = DocBaseType.ofCode(docType.getDocBaseType());
			m_GL_Category_ID = GLCategoryId.ofRepoId(docType.getGL_Category_ID());
		}
		if (_docBaseType == null)
		{
			log.error("No DocBaseType for C_DocType_ID={}, DocumentNo={}", docTypeId, getDocumentNo());
		}

		// Still no GL_Category - get Default GL Category
		if (m_GL_Category_ID == null)
		{
			m_GL_Category_ID = services.getDefaultGLCategoryId(getClientId()).orElse(null);
		}

		//
		if (m_GL_Category_ID == null)
		{
			log.warn("No default GL_Category - {}", this);
		}

		if (_docBaseType == null)
		{
			throw new IllegalStateException("Document Type not found");
		}
	}

	/**************************************************************************
	 * Is the Source Document Balanced
	 *
	 * @return true if (source) balanced
	 */
	private boolean isBalanced()
	{
		// Multi-Currency documents are source balanced by definition
		if (isMultiCurrency())
		{
			return true;
		}
		//
		final boolean retValue = getBalance().signum() == 0;
		if (retValue)
		{
			log.debug("Yes - {}", this);
		}
		else
		{
			log.warn("NO - {}", this);
		}
		return retValue;
	}    // isBalanced

	/**
	 * Makes sure the document is convertible from it's currency to accounting currency.
	 */
	protected void checkConvertible(final AcctSchema acctSchema)
	{
		// No Currency in document
		final CurrencyId docCurrencyId = getCurrencyId();
		if (docCurrencyId == null)
		{
			return;
		}

		// Get All Currencies
		final Set<CurrencyId> currencyIds = new HashSet<>();
		currencyIds.add(docCurrencyId);

		final List<DocLineType> docLines = getDocLines();
		if (docLines != null)
		{
			for (final DocLineType docLine : docLines)
			{
				final CurrencyId currencyId = docLine.getCurrencyId();
				if (currencyId != null)
				{
					currencyIds.add(currencyId);
				}
			}
		}

		// Check
		final CurrencyId acctCurrencyId = acctSchema.getCurrencyId();
		for (final CurrencyId currencyId : currencyIds)
		{
			if (CurrencyId.equals(currencyId, acctCurrencyId))
			{
				continue;
			}

			final CurrencyConversionContext conversionCtx = getCurrencyConversionContext();
			try
			{
				services.getCurrencyRate(conversionCtx, currencyId, acctCurrencyId);
			}
			catch (final NoCurrencyRateFoundException e)
			{
				throw newPostingException(e)
						.setAcctSchema(acctSchema)
						.setPostingStatus(PostingStatus.NotConvertible);
			}
		}
	}

	protected CurrencyConversionContext getCurrencyConversionContext()
	{
		return services.createCurrencyConversionContext(
				getDateAcct(),
				getCurrencyConversionTypeId(),
				getClientId());
	}

	/**
	 * Calculate Period from DateAcct. m_C_Period_ID is set to -1 of not open to 0 if not found
	 */
	private void setPeriod()
	{
		if (m_period != null)
		{
			return;
		}

		// Period defined in GL Journal (e.g. adjustment period)
		final int periodId = getValueAsIntOrZero("C_Period_ID");
		if (periodId > 0)
		{
			m_period = MPeriod.get(Env.getCtx(), periodId);
		}
		if (m_period == null)
		{
			m_period = MPeriod.get(Env.getCtx(), getDateAcctAsTimestamp(), getOrgId().getRepoId());
		}

		// Is Period Open?
		if (m_period != null
				&& m_period.isOpen(getDocBaseType(), getDateAcctAsTimestamp(), getOrgId().getRepoId()))
		{
			m_C_Period_ID = m_period.getC_Period_ID();
		}
		else
		{
			m_C_Period_ID = -1;
		}
	}

	protected final int getC_Period_ID()
	{
		if (m_period == null)
		{
			setPeriod();
		}
		return m_C_Period_ID;
	}    // getC_Period_ID

	/**
	 * Is Period Open
	 *
	 * @return true if period is open
	 */
	private boolean isPeriodOpen()
	{
		setPeriod();
		final boolean open = m_C_Period_ID > 0;
		if (open)
		{
			log.debug("isPeriodOpen: Yes - {}", this);
		}
		else
		{
			log.warn("isPeriodOpen: NO - {}", this);
		}
		return open;
	}    // isPeriodOpen

	/**
	 * Amount Type - Invoice - Gross
	 */
	public static final int AMTTYPE_Gross = 0;
	/**
	 * Amount Type - Invoice - Net
	 */
	public static final int AMTTYPE_Net = 1;
	/**
	 * Amount Type - Invoice - Charge
	 */
	public static final int AMTTYPE_Charge = 2;

	/**
	 * Source Amounts (may not all be used)
	 */
	private final BigDecimal[] m_Amounts = new BigDecimal[] { BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO };

	/**
	 * Get the Amount (loaded in loadDocumentDetails)
	 *
	 * @param AmtType see AMTTYPE_*
	 * @return Amount
	 */
	@Nullable
	protected final BigDecimal getAmount(final int AmtType)
	{
		if (AmtType < 0 || AmtType >= m_Amounts.length)
		{
			return null;
		}
		return m_Amounts[AmtType];
	}    // getAmount

	/**
	 * Set the Amount
	 *
	 * @param AmtType see AMTTYPE_*
	 * @param amt     Amount
	 */
	protected final void setAmount(final int AmtType, final BigDecimal amt)
	{
		if (AmtType < 0 || AmtType >= m_Amounts.length)
		{
			return;
		}
		if (amt == null)
		{
			m_Amounts[AmtType] = BigDecimal.ZERO;
		}
		else
		{
			m_Amounts[AmtType] = amt;
		}
	}    // setAmount

	/**
	 * Get Amount with index 0
	 *
	 * @return Amount (primary document amount)
	 */
	protected final BigDecimal getAmount()
	{
		return m_Amounts[0];
	}   // getAmount

	protected final MAccount getCustomerAccount(
			@NonNull final BPartnerCustomerAccountType acctType,
			@NonNull final AcctSchema acctSchema)
	{
		return getAccountProvider().getBPartnerCustomerAccount(acctSchema.getId(), getBPartnerId(), acctType);
	}

	protected final AccountId getCustomerAccountId(
			@NonNull final BPartnerCustomerAccountType acctType,
			@NonNull final AcctSchema acctSchema)
	{
		return getAccountProvider().getBPartnerCustomerAccountId(acctSchema.getId(), getBPartnerId(), acctType);
	}

	protected final AccountId getVendorAccountId(
			@NonNull final BPartnerVendorAccountType acctType,
			@NonNull final AcctSchema acctSchema)
	{
		return getAccountProvider().getBPartnerVendorAccountId(acctSchema.getId(), getBPartnerId(), acctType);
	}

	protected final MAccount getVendorAccount(
			@NonNull final BPartnerVendorAccountType acctType,
			@NonNull final AcctSchema acctSchema)
	{
		return getAccountProvider().getBPartnerVendorAccount(acctSchema.getId(), getBPartnerId(), acctType);
	}

	protected final MAccount getBPGroupAccount(
			@NonNull final BPartnerGroupAccountType acctType,
			@NonNull final AcctSchema acctSchema)
	{
		return getAccountProvider().getBPGroupAccount(acctSchema.getId(), getBPartnerId(), acctType);
	}

	protected final MAccount getBankAccountAccount(
			@NonNull final BankAccountAcctType acctType,
			@NonNull final AcctSchema acctSchema)
	{
		final BankAccountId bpBankAccountId = getBPBankAccountId();
		if (bpBankAccountId == null)
		{
			throw newPostingException().setDetailMessage("No Bank Statement set");
		}

		final AccountId accountId = getAccountProvider().getBankAccountAccountId(acctSchema.getId(), bpBankAccountId, acctType);
		return services.getAccountById(accountId);
	}

	public MAccount getGLAccount(
			@NonNull final GLAccountType acctType,
			@NonNull final AcctSchema as)
	{
		final AccountId accountId = getAccountProvider().getGLAccountId(as, acctType);
		return services.getAccountById(accountId);
	}

	protected final AccountProvider getAccountProvider()
	{
		AccountProvider accountProvider = this._accountProvider;
		if (accountProvider == null)
		{
			accountProvider = this._accountProvider = services.newAccountProvider()
					.extension(createAccountProviderExtension())
					.build();
		}
		return accountProvider;
	}

	@Nullable
	protected AccountProviderExtension createAccountProviderExtension()
	{
		return null;
	}

	protected final MAccount getRealizedGainAcct(final AcctSchema as)
	{
		final AccountId accountId = getAccountProvider().getDefaultAccountId(as, DefaultAccountType.RealizedGain);
		return services.getAccountById(accountId);
	}

	protected final MAccount getRealizedLossAcct(final AcctSchema as)
	{
		final AccountId accountId = getAccountProvider().getDefaultAccountId(as, DefaultAccountType.RealizedLoss);
		return services.getAccountById(accountId);
	}

	@Override
	public String toString()
	{
		return getPO().toString();
	}

	protected final ClientId getClientId()
	{
		return ClientId.ofRepoId(getPO().getAD_Client_ID());
	}

	protected final OrgId getOrgId()
	{
		return OrgId.ofRepoId(getPO().getAD_Org_ID());
	}

	protected String getDocumentNo()
	{
		if (m_DocumentNo == null)
		{
			m_DocumentNo = CoalesceUtil.coalesceSuppliers(
					() -> getValueAsString("DocumentNo"),
					() -> getValueAsString("Name"),
					() -> {
						throw new AdempiereException("DocumentNo not found");
					});
		}
		return m_DocumentNo;
	}

	@Nullable
	protected final DocStatus getDocStatus()
	{
		return _docStatus;
	}

	protected final String getDescription()
	{
		if (m_Description == null)
		{
			m_Description = getValueAsString("Description");
			if (m_Description == null)
			{
				m_Description = "";
			}
		}
		return m_Description;
	}

	protected final CurrencyId getCurrencyId()
	{
		if (_currencyId == null)
		{
			_currencyId = getValueAsOptionalId("C_Currency_ID", CurrencyId::ofRepoIdOrNull);
		}

		return _currencyId.orElse(null);
	}

	protected final void setC_Currency_ID(final CurrencyId currencyId)
	{
		_currencyId = Optional.ofNullable(currencyId);
		_currencyPrecision = null;
	}

	protected final void setNoCurrency()
	{
		final CurrencyId currencyId = null;
		setC_Currency_ID(currencyId);
	}

	protected final boolean isMultiCurrency()
	{
		return m_MultiCurrency;
	}

	protected final void setIsMultiCurrency()
	{
		m_MultiCurrency = true;
	}

	protected final CurrencyConversionTypeId getCurrencyConversionTypeId()
	{
		return CurrencyConversionTypeId.ofRepoIdOrNull(getValueAsIntOrZero("C_ConversionType_ID"));
	}

	public final int getStdPrecision()
	{
		if (_currencyPrecision != null)
		{
			return _currencyPrecision.toInt();
		}

		final CurrencyId currencyId = getCurrencyId();
		if (currencyId == null)
		{
			return ICurrencyDAO.DEFAULT_PRECISION.toInt();
		}

		_currencyPrecision = services.getCurrencyStandardPrecision(currencyId);
		return _currencyPrecision.toInt();
	}

	protected final GLCategoryId getGL_Category_ID()
	{
		return m_GL_Category_ID;
	}

	protected final int getGL_Budget_ID()
	{
		return getValueAsIntOrZero("GL_Budget_ID");
	}

	@NonNull
	protected final LocalDateAndOrgId getDateAcct()
	{
		return CoalesceUtil.coalesceSuppliersNotNull(
				() -> _dateAcct,
				() -> getValueAsLocalDateOrNull("DateAcct"),
				() -> {
					throw new AdempiereException("No DateAcct");
				});
	}

	@NonNull
	protected final Timestamp getDateAcctAsTimestamp()
	{
		return getDateAcct().toTimestamp(services::getTimeZone);
	}

	protected final void setDateAcct(@NonNull final Timestamp dateAcct)
	{
		setDateAcct(LocalDateAndOrgId.ofTimestamp(dateAcct, getOrgId(), getServices()::getTimeZone));
	}

	protected final void setDateAcct(@NonNull final InstantAndOrgId dateAcct)
	{
		_dateAcct = dateAcct.toLocalDateAndOrgId(services::getTimeZone);
	}

	protected final void setDateAcct(@NonNull final LocalDateAndOrgId dateAcct)
	{
		_dateAcct = dateAcct;
	}

	protected final LocalDateAndOrgId getDateDoc()
	{
		return CoalesceUtil.coalesceSuppliers(
				() -> _dateDoc,
				() -> getValueAsLocalDateOrNull("DateDoc"),
				() -> getValueAsLocalDateOrNull("MovementDate"),
				() -> {
					throw new AdempiereException("No DateDoc");
				});
	}

	@NonNull
	protected final Timestamp getDateDocAsTimestamp()
	{
		return getDateDoc().toTimestamp(services::getTimeZone);
	}

	protected final void setDateDoc(final Timestamp dateDoc)
	{
		setDateDoc(LocalDateAndOrgId.ofTimestamp(dateDoc, getOrgId(), getServices()::getTimeZone));
	}

	protected final void setDateDoc(final LocalDateAndOrgId dateDoc)
	{
		_dateDoc = dateDoc;
	}

	protected final void setDateDoc(@NonNull final InstantAndOrgId dateDoc)
	{
		_dateDoc = dateDoc.toLocalDateAndOrgId(services::getTimeZone);
	}

	private boolean isPosted()
	{
		final Boolean posted = getValueAsBooleanOrNull("Posted");
		if (posted == null)
		{
			throw new AdempiereException("Posted column is missing or it's null");
		}
		return posted;
	}

	public final boolean isSOTrx()
	{
		return CoalesceUtil.coalesceSuppliersNotNull(
				() -> getValueAsBooleanOrNull("IsSOTrx"),
				() -> getValueAsBooleanOrNull("IsReceipt"),
				SOTrx.PURCHASE::toBoolean);
	}

	@Nullable
	protected final DocTypeId getC_DocType_ID()
	{
		final DocTypeId docTypeId = DocTypeId.ofRepoIdOrNull(getValueAsIntOrZero("C_DocType_ID"));
		if (docTypeId != null)
		{
			return docTypeId;
		}

		// fallback
		return DocTypeId.ofRepoIdOrNull(getValueAsIntOrZero("C_DocTypeTarget_ID"));
	}

	protected final Optional<ChargeId> getC_Charge_ID()
	{
		return getValueAsOptionalId("C_Charge_ID", ChargeId::ofRepoIdOrNull);
	}

	@Nullable
	protected final UserId getSalesRepId()
	{
		return getValueAsIdOrNull("SalesRep_ID", UserId::ofRepoIdOrNull);
	}

	/**
	 * Get C_BP_BankAccount_ID if it was previously set using {@link #setBPBankAccountId(BankAccountId)}, or attempts to get it from our <code>p_po</code> (document record).
	 */
	final BankAccountId getBPBankAccountId()
	{
		Optional<BankAccountId> bankAccountId = _bankAccountId;
		if (bankAccountId == null)
		{
			bankAccountId = _bankAccountId = getValueAsOptionalId(
					I_C_BP_BankAccount.COLUMNNAME_C_BP_BankAccount_ID,
					BankAccountId::ofRepoIdOrNull);
		}

		return bankAccountId.orElse(null);
	}

	final void setBPBankAccountId(@Nullable final BankAccountId bankAccountId)
	{
		_bankAccountId = Optional.ofNullable(bankAccountId);
	}

	@Nullable
	protected final BankAccount getBankAccount()
	{
		final BankAccountId bankAccountId = getBPBankAccountId();
		if (bankAccountId == null)
		{
			return null;
		}
		if (bankAccount == null || !BankAccountId.equals(bankAccount.getId(), bankAccountId))
		{
			bankAccount = services.getBankAccountById(bankAccountId);
		}
		return bankAccount;
	}

	protected final int getC_CashBook_ID()
	{
		if (m_C_CashBook_ID == -1)
		{
			m_C_CashBook_ID = getValueAsIntOrZero("C_CashBook_ID");
			if (m_C_CashBook_ID <= 0)
			{
				m_C_CashBook_ID = 0;
			}
		}
		return m_C_CashBook_ID;
	}

	protected final void setC_CashBook_ID(final int C_CashBook_ID)
	{
		m_C_CashBook_ID = C_CashBook_ID;
	}

	protected final WarehouseId getWarehouseId()
	{
		return getValueAsIdOrNull("M_Warehouse_ID", WarehouseId::ofRepoIdOrNull);
	}

	/**
	 * Get C_BPartner_ID
	 *
	 * @return BPartner
	 */
	protected final BPartnerId getBPartnerId()
	{
		if (_bpartnerId == null)
		{
			_bpartnerId = getValueAsOptionalId("C_BPartner_ID", BPartnerId::ofRepoIdOrNull);
		}
		return _bpartnerId.orElse(null);
	}

	protected final void setBPartnerId(final BPartnerId bpartnerId)
	{
		_bpartnerId = Optional.ofNullable(bpartnerId);
	}

	protected final int getC_BPartner_Location_ID()
	{
		return getValueAsIntOrZero("C_BPartner_Location_ID");
	}

	@Nullable
	protected final ProjectId getC_Project_ID()
	{
		return getValueAsOptionalId("C_Project_ID", ProjectId::ofRepoIdOrNull).orElse(null);
	}

	protected final int getC_SalesRegion_ID()
	{
		return getValueAsIntOrZero("C_SalesRegion_ID");
	}

	protected final int getBP_C_SalesRegion_ID()
	{
		if (m_BP_C_SalesRegion_ID == -1)
		{
			m_BP_C_SalesRegion_ID = getC_SalesRegion_ID();
			if (m_BP_C_SalesRegion_ID <= 0)
			{
				m_BP_C_SalesRegion_ID = 0;
			}
		}
		return m_BP_C_SalesRegion_ID;
	}

	/**
	 * Set BPartner's C_SalesRegion_ID
	 */
	protected final void setBP_C_SalesRegion_ID(final int C_SalesRegion_ID)
	{
		m_BP_C_SalesRegion_ID = C_SalesRegion_ID;
	}

	@Nullable
	protected final ActivityId getActivityId()
	{
		return ActivityId.ofRepoIdOrNull(getValueAsIntOrZero("C_Activity_ID"));
	}

	@Nullable
	protected final OrderId getOrderId()
	{
		return OrderId.ofRepoIdOrNull(getValueAsIntOrZero("C_Order_ID"));
	}

	protected final int getC_Campaign_ID()
	{
		return getValueAsIntOrZero("C_Campaign_ID");
	}

	@Nullable
	protected final ProductId getProductId()
	{
		return getValueAsIdOrNull("M_Product_ID", ProductId::ofRepoIdOrNull);
	}

	@Nullable
	protected final OrgId getOrgTrxId()
	{
		return getValueAsIdOrNull("AD_OrgTrx_ID", OrgId::ofRepoIdOrNull);
	}

	@Nullable
	protected final LocationId getLocationFromId()
	{
		return locationFromId;
	}

	@Nullable
	protected final LocationId getLocationToId()
	{
		return locationToId;
	}

	protected final int getUser1_ID()
	{
		return getValueAsIntOrZero("User1_ID");
	}

	protected final int getUser2_ID()
	{
		return getValueAsIntOrZero("User2_ID");
	}

	@Nullable
	protected final SectionCodeId getSectionCodeId()
	{
		return getValueAsIdOrNull("M_SectionCode_ID", SectionCodeId::ofRepoIdOrNull);
	}

	protected final int getValueAsIntOrZero(final String ColumnName)
	{
		final PO po = getPO();
		final int index = po.get_ColumnIndex(ColumnName);
		if (index != -1)
		{
			final Integer ii = (Integer)po.get_Value(index);
			if (ii != null)
			{
				return ii;
			}
		}
		return 0;
	}

	@Nullable
	private <T extends RepoIdAware> T getValueAsIdOrNull(final String columnName, final IntFunction<T> idOrNullMapper)
	{
		final PO po = getPO();
		final int index = po.get_ColumnIndex(columnName);
		if (index < 0)
		{
			return null;
		}

		final Object valueObj = po.get_Value(index);
		final Integer valueInt = NumberUtils.asInteger(valueObj, null);
		if (valueInt == null)
		{
			return null;
		}

		return idOrNullMapper.apply(valueInt);
	}

	private <T extends RepoIdAware> Optional<T> getValueAsOptionalId(final String columnName, final IntFunction<T> idOrNullMapper)
	{
		final T id = getValueAsIdOrNull(columnName, idOrNullMapper);
		return Optional.ofNullable(id);
	}

	@Nullable
	private LocalDateAndOrgId getValueAsLocalDateOrNull(final String columnName)
	{
		@NonNull final PO po = getPO();
		final int index = po.get_ColumnIndex(columnName);
		if (index != -1)
		{
			final Timestamp ts = po.get_ValueAsTimestamp(index);
			if (ts != null)
			{
				final OrgId orgId = OrgId.ofRepoId(po.getAD_Org_ID());
				return LocalDateAndOrgId.ofTimestamp(ts, orgId, getServices()::getTimeZone);
			}
		}

		return null;
	}

	@Nullable
	private Boolean getValueAsBooleanOrNull(final String columnName)
	{
		final PO po = getPO();
		final int index = po.get_ColumnIndex(columnName);
		if (index != -1)
		{
			final Object valueObj = po.get_Value(index);
			return DisplayType.toBoolean(valueObj, null);
		}

		return null;
	}

	@Nullable
	protected String getValueAsString(final String columnName)
	{
		final PO po = getPO();
		final int index = po.get_ColumnIndex(columnName);
		if (index != -1)
		{
			final Object valueObj = po.get_Value(index);
			return valueObj != null ? valueObj.toString() : null;
		}

		return null;
	}

	/**
	 * Load Document Details
	 */
	protected abstract void loadDocumentDetails();

	/**
	 * Get Source Currency Balance - subtracts line (and tax) amounts from total - no rounding
	 *
	 * @return positive amount, if total header is bigger than lines
	 */
	protected abstract BigDecimal getBalance();

	/**
	 * Create Facts (the accounting logic)
	 *
	 * @param as accounting schema
	 * @return Facts
	 */
	protected abstract List<Fact> createFacts(final AcctSchema as);

	/**
	 * Method called after everything was Posted and saved to database, right before committing.
	 */
	protected void afterPost()
	{
		// nothing on this level
	}

	protected final PostingException newPostingException()
	{
		final Throwable e = null;
		return newPostingException(e);
	}

	protected final PostingException newPostingException(@Nullable final Throwable e)
	{
		final PostingException postingException;
		if (e == null)
		{
			postingException = new PostingException(this);
		}
		else if (e instanceof PostingException)
		{
			postingException = (PostingException)e;
		}
		else
		{
			postingException = new PostingException(this, e)
					.setPostingStatus(PostingStatus.Error);
		}

		if (isPosted())
		{
			postingException.setPreserveDocumentPostedStatus();
		}

		return postingException;
	}

	private void createErrorNote(final PostingException ex)
	{
		DB.saveConstraints();
		try
		{
			DB.getConstraints().setOnlyAllowedTrxNamePrefixes(false).incMaxTrx(1);

			final PostingStatus postingStatus = ex.getPostingStatus(PostingStatus.Error);
			final AdMessageKey AD_MessageValue = postingStatus.getAD_Message();
			final PO po = getPO();
			final int AD_User_ID = po.getUpdatedBy();
			final String adLanguage = Env.getADLanguageOrBaseLanguage();

			final MNote note = new MNote(
					Env.getCtx(),
					AD_MessageValue.toAD_Message(),
					AD_User_ID,
					getClientId().getRepoId(),
					getOrgId().getRepoId(),
					ITrx.TRXNAME_None);
			note.setRecord(po.get_Table_ID(), po.get_ID());
			note.setReference(toString());    // Document

			final StringBuilder text = new StringBuilder();
			text.append(services.translate(AD_MessageValue).translate(adLanguage));
			final String p_Error = ex.getDetailMessage().translate(adLanguage);
			if (!Check.isEmpty(p_Error, true))
			{
				text.append(" (").append(p_Error).append(")");
			}

			text.append(" - ").append(getClass().getSimpleName());
			final boolean loaded = getDocLines() != null;
			if (loaded)
			{
				text.append(" (").append(getDocBaseType())
						.append(" - DocumentNo=").append(getDocumentNo())
						.append(", DateAcct=").append(getDateAcct())
						.append(", Amount=").append(getAmount())
						.append(", Sta=").append(postingStatus)
						.append(" - PeriodOpen=").append(isPeriodOpen())
						.append(", Balanced=").append(isBalanced())
						.append(")");
			}
			note.setTextMsg(text.toString());
			note.save();
			// p_Error = Text.toString();
		}
		catch (final Exception noteEx)
		{
			log.warn("Failed to create the error note. Skipped", noteEx);
		}
		finally
		{
			DB.restoreConstraints();
		}
	}

	/**
	 * Post immediate given list of documents.
	 * <p>
	 * IMPORTANT: This method won't fail if any of the documents's posting is failing, because we don't want to prevent the main document posting because of this.
	 */
	protected final <ID extends RepoIdAware> void postDependingDocuments(
			final String tableName,
			final Collection<ID> documentIds)
	{
		if (documentIds == null || documentIds.isEmpty())
		{
			return; // nothing to do
		}

		// task 08643: the list of documentModels might originate from a bag (i.e. InArrayFilter does not filter at all when given an empty set of values).
		// so we assume that if there are >=200 items, it's that bug and there are not really that many documentModels.
		// Note: we fixed the issue in the method's current callers (Doc_InOut and Doc_Invoice).
		if (documentIds.size() >= 200)
		{
			final PostingException ex = newPostingException()
					.setDocument(this)
					.setDetailMessage("There are too many depending document models to post. This might be a problem in filtering (legacy-bug in InArrayFilter).");
			log.warn("Got to many depending documents to post. Skip posting depending documents.", ex);
			return;
		}

		final ClientId clientId = getClientId();
		for (final ID documentId : documentIds)
		{
			final TableRecordReference documentRef = TableRecordReference.of(tableName, documentId);
			services.postImmediateNoFail(documentRef, clientId);
		}
	}
}   // Doc
