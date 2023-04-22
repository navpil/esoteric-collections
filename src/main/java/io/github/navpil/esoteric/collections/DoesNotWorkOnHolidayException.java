package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * This collection was born in Ukraine, so it observes the Ukrainian timezone.
 * It's fine to work in read-only mode during Saturdays, but will refuze to work entirely on Sundays.
 * The only national holiday it observes is an Independence Day of Ukraine, because it's the only
 * future-proof holiday date in Ukraine.
 * @param <T>
 */
public class DoesNotWorkOnHolidayException<T> extends ConditionalListWrapper<T> {

    private static final AllowCheck HOLIDAY_CHECK = new HolidayAllowCheck(new UkrainianHolidayCheck());

    public DoesNotWorkOnHolidayException(List<T> wrapped) {
        super(wrapped, HOLIDAY_CHECK);
    }
    public DoesNotWorkOnHolidayException() {
        this(new ArrayList<>());
    }
}
