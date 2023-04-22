package io.github.navpil.esoteric.collections;

public class HolidayAllowCheck implements AllowCheck {

    private final HolidayCheck holidayCheck;

    public HolidayAllowCheck(HolidayCheck holidayCheck) {
        this.holidayCheck = holidayCheck;
    }

    @Override
    public void checkSizeAllowed() {
        checkReadPermissions();
    }

    @Override
    public void checkContainsAllowed() {
        checkRemoveAllowed();
    }

    @Override
    public void checkIterationAllowed() {
        checkReadPermissions();
    }

    @Override
    public void checkAddAllowed() {
        checkWritePermissions();
    }

    @Override
    public void checkRemoveAllowed() {
        checkWritePermissions();
    }

    private void checkReadPermissions() {
        //Work on every day, except strict holiday
        if (holidayCheck.isStrictHoliday()) {
            throw new IDontWorkOnHolidayException();
        }
    }

    private void checkWritePermissions() {
        //Work only on working days, no hard work even on Saturday
        if (holidayCheck.isLenientHoliday() || holidayCheck.isStrictHoliday()) {
            throw new IDontWorkOnHolidayException();
        }
    }

    public static class IDontWorkOnHolidayException extends RuntimeException {
    }
}
