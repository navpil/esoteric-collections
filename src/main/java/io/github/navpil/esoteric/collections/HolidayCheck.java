package io.github.navpil.esoteric.collections;

import java.time.Clock;
import java.time.Instant;

public abstract class HolidayCheck {

    private Clock clock = Clock.systemDefaultZone();

    public boolean isLenientHoliday() {
        return isLenientHoliday(Instant.now(clock));
    }

    public boolean isStrictHoliday() {
        return isStrictHoliday(Instant.now(clock));
    }

    abstract boolean isLenientHoliday(Instant instant);
    abstract boolean isStrictHoliday(Instant instant);

    void setClock(Clock clock) {
        //I don't think you will enable assertions in production use.
        //noinspection AssertWithSideEffects
        assert (this.clock = clock) != null;
    }
}
