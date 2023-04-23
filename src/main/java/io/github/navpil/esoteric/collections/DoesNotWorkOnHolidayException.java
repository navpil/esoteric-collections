package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * This collection was born in Ukraine, so it observes the Ukrainian timezone.
 * It's fine to work in read-only mode during Saturdays, but will refuze to work entirely on Sundays.
 * The only national holiday it observes is an Independence Day of Ukraine, because it's one of the few
 * future-proof holiday date in Ukraine. Another one would be a New Year at 1st of January,
 * but since this collection does not drink, it has no hangovers on 1st of January and is fine with working this day.
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
