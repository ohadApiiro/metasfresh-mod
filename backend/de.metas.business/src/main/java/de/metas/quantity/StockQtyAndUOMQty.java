package de.metas.quantity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.metas.product.ProductId;
import de.metas.uom.UOMPrecision;
import de.metas.util.Check;
import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import static de.metas.util.Check.assumeNotNull;

@Value
@ToString(doNotUseGetters = true)
public class StockQtyAndUOMQty
{
	ProductId productId;

	Quantity stockQty;

	/**
	 * Quantity in a "parallel" UOM. Note that often there is no fix UOM conversion rule between this quantity and {@link #getStockingQty()}.
	 */
	Quantity uomQty;

	@Builder(toBuilder = true)
	@JsonCreator
	private StockQtyAndUOMQty(
			@JsonProperty("productId") @NonNull final ProductId productId,
			@JsonProperty("stockQty") @NonNull final Quantity stockQty,
			@JsonProperty("uomQty") @Nullable final Quantity uomQty)
	{
		this.productId = productId;
		this.stockQty = stockQty;
		this.uomQty = uomQty;
	}

	@JsonIgnore
	public Optional<Quantity> getUOMQtyOpt()
	{
		return Optional.ofNullable(uomQty);
	}

	@JsonIgnore
	public boolean isUOMQtySet()
	{
		return uomQty != null;
	}

	@JsonIgnore
	public Quantity getUOMQtyNotNull()
	{
		return assumeNotNull(uomQty, "uomQty may not be null; this={}", this);
	}

	@JsonProperty("uomQty")
	private Quantity getUOMQty()
	{
		return uomQty;
	}

	public StockQtyAndUOMQty add(@NonNull final StockQtyAndUOMQty other)
	{
		Check.assumeEquals(productId, other.productId, "The other instance's productId need to be equal to this instance's productId; this={}; other={}", this, other);

		return StockQtyAndUOMQty.builder()
				.productId(productId)
				.stockQty(stockQty.add(other.getStockQty()))
				.uomQty(addNullables(uomQty, other.uomQty))
				.build();
	}

	private static Quantity addNullables(@Nullable final Quantity qty1, @Nullable final Quantity qty2)
	{
		if (qty1 != null)
		{
			return qty2 != null ? qty1.add(qty2) : qty1;
		}
		else
		{
			return qty2;
		}
	}

	public int signum()
	{
		return getStockQty().signum();
	}

	/**
	 * @return negated quantity if <code>condition</code> is true; else return this
	 */
	public StockQtyAndUOMQty negateIf(final boolean condition)
	{
		return condition ? negate() : this;
	}

	public StockQtyAndUOMQty negateIfNot(final boolean condition)
	{
		return !condition ? negate() : this;
	}

	public StockQtyAndUOMQty negate()
	{
		final StockQtyAndUOMQtyBuilder result = StockQtyAndUOMQty
				.builder()
				.productId(productId)
				.stockQty(stockQty.negate());

		if (getUOMQtyOpt().isPresent())
		{
			result.uomQty(uomQty.negate());
		}

		return result.build();
	}

	public StockQtyAndUOMQty toZero()
	{
		return toBuilder()
				.stockQty(stockQty.toZero())
				.uomQty(uomQty != null ? uomQty.toZero() : null)
				.build();
	}

	public StockQtyAndUOMQty subtract(@NonNull final StockQtyAndUOMQty other)
	{
		Check.assumeEquals(productId, other.productId, "The other instance's productId need to be equal to this instance's productId; this={}; other={}", this, other);

		final StockQtyAndUOMQtyBuilder result = StockQtyAndUOMQty.builder()
				.productId(productId)
				.stockQty(stockQty.subtract(other.getStockQty()));

		if (getUOMQtyOpt().isPresent())
		{
			Check.assume(other.getUOMQtyOpt().isPresent(), "If this instance's uomQty is present, then the other instance's uomQty also needs to be present; this={}; other={}", this, other);
			result.uomQty(uomQty.subtract(other.uomQty));
		}

		return result.build();
	}

	public StockQtyAndUOMQty multiply(@NonNull final BigDecimal factor)
	{
		final StockQtyAndUOMQtyBuilder result = this
				.toBuilder()
				.stockQty(stockQty.multiply(factor));
		if (uomQty != null)
		{
			result.uomQty(uomQty.multiply(factor));
		}
		return result.build();
	}

	public StockQtyAndUOMQty setScale(
			@NonNull final UOMPrecision stockQtyPrecision,
			@Nullable final UOMPrecision uomQtyPrecision,
			@NonNull final RoundingMode roundingMode)
	{
		final StockQtyAndUOMQtyBuilder builder = this.toBuilder()
				.stockQty(stockQty.setScale(stockQtyPrecision, roundingMode));
		if (uomQty != null && uomQtyPrecision != null)
		{
			builder.uomQty(uomQty.setScale(uomQtyPrecision, roundingMode));
		}
		return builder.build();
	}

	public StockQtyAndUOMQty divide(
			@NonNull final BigDecimal divident,
			final int scale,
			@NonNull final RoundingMode roundingMode)
	{
		final StockQtyAndUOMQtyBuilder result = this
				.toBuilder()
				.stockQty(stockQty.divide(divident, scale, roundingMode));
		if (uomQty != null)
		{
			result.uomQty(uomQty.divide(divident, scale, roundingMode));
		}
		return result.build();
	}

	/**
	 * @return the minimum by looking at the stock quantities.
	 * Important: if this instance's stock quantity is equal to {@code other}'s stock quantity, then return {@code this}.
	 */
	public StockQtyAndUOMQty min(@NonNull final StockQtyAndUOMQty other)
	{
		if (this.getStockQty().compareTo(other.getStockQty()) <= 0)
		{
			return this;
		}
		return other;
	}

	@NonNull
	public static StockQtyAndUOMQty toZeroIfNegative(@NonNull final StockQtyAndUOMQty stockQtyAndUOMQty)
	{
		return stockQtyAndUOMQty.signum() < 0
				? stockQtyAndUOMQty.toZero()
				: stockQtyAndUOMQty;
	}

	@NonNull
	public static StockQtyAndUOMQty toZeroIfPositive(@NonNull final StockQtyAndUOMQty stockQtyAndUOMQty)
	{
		return stockQtyAndUOMQty.signum() > 0
				? stockQtyAndUOMQty.toZero()
				: stockQtyAndUOMQty;
	}
}
