package io.github.navpil.esoteric.collections;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UkrainianHolidayCheck extends HolidayCheck {

    //Kyiv, not Kiev.
    //If you fail on java.lang.ExceptionInInitializerError, update your Java timezones with Oracle's TZUpdater util
    // Download TZUpdater and run "java -jar tzupdater.jar --location"
    public static final ZoneId UKRAINE_TIMEZONE = ZoneId.of("Europe/Kyiv");

    @Override
    public boolean isLenientHoliday(Instant instant) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, UKRAINE_TIMEZONE);
        DayOfWeek dayOfWeek = zonedDateTime.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY;
    }

    @Override
    public boolean isStrictHoliday(Instant instant) {
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Kyiv"));
        DayOfWeek dayOfWeek = zonedDateTime.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SUNDAY || isUkraineIndependenceDay(zonedDateTime);
    }

    private boolean isUkraineIndependenceDay(ZonedDateTime zonedDateTime) {
        LocalDate localDate = zonedDateTime.toLocalDate();
        return localDate.getDayOfMonth() == 24 && localDate.getMonth() == Month.AUGUST;
    }
}
