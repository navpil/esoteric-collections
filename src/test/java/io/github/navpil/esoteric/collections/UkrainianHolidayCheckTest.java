package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UkrainianHolidayCheckTest {

    @Test
    void isLenientHoliday() {

        UkrainianHolidayCheck ukrainianHolidayCheck = new UkrainianHolidayCheck();
        Instant instant = ZonedDateTime.of(
                LocalDate.of(2023, Month.APRIL, 22),
                LocalTime.of(20, 52),
                ZoneId.of("Europe/Kyiv")).toInstant();
        assert ukrainianHolidayCheck.isLenientHoliday(instant);

    }

    @Test
    void isStrictHoliday() {

        UkrainianHolidayCheck ukrainianHolidayCheck = new UkrainianHolidayCheck();
        Instant sunday = ZonedDateTime.of(
                LocalDate.of(2023, Month.APRIL, 23),
                LocalTime.of(20, 52),
                ZoneId.of("Europe/Kyiv")).toInstant();
        assert ukrainianHolidayCheck.isStrictHoliday(sunday);

        Instant independenceDay = ZonedDateTime.of(
                LocalDate.of(2023, Month.AUGUST, 24),
                LocalTime.of(20, 52),
                ZoneId.of("Europe/Kyiv")).toInstant();
        assert ukrainianHolidayCheck.isStrictHoliday(independenceDay);

    }
}