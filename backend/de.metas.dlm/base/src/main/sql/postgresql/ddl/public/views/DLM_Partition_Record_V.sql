
DROP VIEW IF EXISTS public.DLM_Partition_Record_V;
CREATE VIEW public.DLM_Partition_Record_V AS
SELECT 
	c.DLM_Partition_Config_ID, p.DLM_Partition_ID, t.TableName, t.IsDLM, t.AD_Table_ID, 
	records.Record_ID AS DLM_Partition_Record_V_ID,
	records.AD_Client_ID,
	records.DLM_Level,
	records.AD_Org_ID,
	records.Record_ID, 
	records.Created,
	records.CreatedBy,
	records.Updated,
	records.UpdatedBy,
	records.IsActive
FROM DLM_Partition p
	JOIN DLM_Partition_Config c 
			ON p.DLM_Partition_Config_ID=c.DLM_Partition_Config_ID
	JOIN DLM_Partition_Config_Line l 
			ON l.DLM_Partition_Config_ID=c.DLM_Partition_Config_ID
		JOIN AD_Table t 
				ON t.AD_Table_ID=l.DLM_Referencing_Table_ID

	JOIN LATERAL (SELECT * FROM dlm.get_dlm_records(t.TableName, p.DLM_Partition_ID) ) records ON t.IsDLM='Y'
;
COMMENT ON VIEW DLM_Partition_Record_V IS
'gh #489: select DLM_Partition_IDs and the records that belong to the respective partition.';
