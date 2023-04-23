package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import static io.github.navpil.esoteric.collections.UkrainianHolidayCheck.UKRAINE_TIMEZONE;

class UkrainianHolidayCheckTest {

    @Test
    void isLenientHoliday() {

        UkrainianHolidayCheck ukrainianHolidayCheck = new UkrainianHolidayCheck();
        Instant instant = getSaturday();
        assert ukrainianHolidayCheck.isLenientHoliday(instant);

    }

    @Test
    void isStrictHoliday() {

        UkrainianHolidayCheck ukrainianHolidayCheck = new UkrainianHolidayCheck();
        Instant sunday = getSunday();
        assert ukrainianHolidayCheck.isStrictHoliday(sunday);

        Instant independenceDay = ZonedDateTime.of(
                LocalDate.of(2023, Month.AUGUST, 24),
                LocalTime.of(20, 52),
                UKRAINE_TIMEZONE).toInstant();
        assert ukrainianHolidayCheck.isStrictHoliday(independenceDay);

    }

    @Test
    void isHolidayWithClock() {
        UkrainianHolidayCheck holidayCheck = new UkrainianHolidayCheck();
        holidayCheck.setClock(Clock.fixed(getSunday(), UKRAINE_TIMEZONE));

        assert holidayCheck.isStrictHoliday();

        holidayCheck.setClock(Clock.fixed(getSaturday()
                .minus(4, ChronoUnit.DAYS), UKRAINE_TIMEZONE));

        assert !holidayCheck.isLenientHoliday();
        assert !holidayCheck.isStrictHoliday();
    }

    private static Instant getSaturday() {
        return ZonedDateTime.of(
                LocalDate.of(2023, Month.APRIL, 22),
                LocalTime.of(20, 52),
                UKRAINE_TIMEZONE).toInstant();
    }

    private static Instant getSunday() {
        return ZonedDateTime.of(
                LocalDate.of(2023, Month.APRIL, 23),
                LocalTime.of(20, 52),
                UKRAINE_TIMEZONE).toInstant();
    }
}