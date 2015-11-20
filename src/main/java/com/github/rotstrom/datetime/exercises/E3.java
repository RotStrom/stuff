package com.github.rotstrom.datetime.exercises;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class E3 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2015, 11, 13);
        LocalDate date2 = LocalDate.of(2015, 11, 20);

        checkDate(date1);
        checkDate(date2);
    }

    private static void checkDate(TemporalAccessor date) {
        if (date.query(E3::isFriday13)) {
            System.out.printf("%s is a Friday of 13%n", date);
        } else {
            System.out.printf("%s is not a Friday of 13%n", date);
        }
    }

    public static Boolean isFriday13(TemporalAccessor date) {
        return (date.get(ChronoField.DAY_OF_MONTH) == 13
                && date.get(ChronoField.DAY_OF_WEEK) == DayOfWeek.FRIDAY.getValue());
    }
}
