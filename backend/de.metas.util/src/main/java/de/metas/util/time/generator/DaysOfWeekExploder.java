package de.metas.util.time.generator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Collection;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import de.metas.util.Check;
import lombok.Value;

@Value
public class DaysOfWeekExploder implements IDateSequenceExploder
{
	public static final DaysOfWeekExploder of(final Collection<DayOfWeek> weekDays)
	{
		final ImmutableSet<DayOfWeek> weekDaysSet = ImmutableSet.copyOf(weekDays);
		if (weekDaysSet.equals(ALL_DAYS_OF_WEEK_LIST))
		{
			return ALL_DAYS_OF_WEEK;
		}
		return new DaysOfWeekExploder(weekDaysSet);
	}

	public static final DaysOfWeekExploder of(final DayOfWeek... weekDays)
	{
		return of(ImmutableSet.copyOf(weekDays));
	}

	private static final ImmutableSet<DayOfWeek> ALL_DAYS_OF_WEEK_LIST = ImmutableSet.copyOf(DayOfWeek.values());

	public static final DaysOfWeekExploder ALL_DAYS_OF_WEEK = new DaysOfWeekExploder(ALL_DAYS_OF_WEEK_LIST);

	private final ImmutableSet<DayOfWeek> weekDays;
	private final DayOfWeek firstDayOfTheWeek;

	private DaysOfWeekExploder(final ImmutableSet<DayOfWeek> weekDays)
	{
		Check.assumeNotEmpty(weekDays, "weekDays not empty");
		this.weekDays = weekDays;
		this.firstDayOfTheWeek = DayOfWeek.MONDAY;
	}

	/**
	 * @return all dates which are in same week as <code>date</code> and are equal or after it
	 */
	@Override
	public Set<LocalDateTime> explodeForward(final LocalDateTime date)
	{
		final DayOfWeek currentDayOfWeek = date.getDayOfWeek();

		return weekDays.stream()
				.filter(dayOfWeek -> dayOfWeek.getValue() >= currentDayOfWeek.getValue())
				.map(dayOfWeek -> date.with(TemporalAdjusters.nextOrSame(dayOfWeek)))
				.collect(ImmutableSet.toImmutableSet());
	}

	/**
	 * @return all dates which are in one week range from <code>date</code>
	 */
	@Override
	public Set<LocalDateTime> explodeBackward(final LocalDateTime date)
	{
		return weekDays.stream()
				.map(dayOfWeek -> date.with(TemporalAdjusters.previousOrSame(dayOfWeek)))
				.collect(ImmutableSet.toImmutableSet());
	}
}
