package com.livecounter.helpers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateHelper {
    public static LocalDate decreaseDaysFromNow(final int days) {
        LocalDate today = LocalDate.now();
        LocalDate before = today.minus(days, ChronoUnit.WEEKS);
        return before;
    }
}
