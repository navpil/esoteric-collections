package io.github.navpil.esoteric.collections;

import java.time.Instant;

public abstract class HolidayCheck {

    public boolean isLenientHoliday() {
        return isLenientHoliday(Instant.now());
    }

    public boolean isStrictHoliday() {
        return isStrictHoliday(Instant.now());
    }

    abstract boolean isLenientHoliday(Instant instant);
    abstract boolean isStrictHoliday(Instant instant);
}
