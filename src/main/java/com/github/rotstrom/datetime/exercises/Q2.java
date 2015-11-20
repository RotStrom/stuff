package com.github.rotstrom.datetime.exercises;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * 2. Given a random date, how would you find the date of the previous Thursday?
 */
public class Q2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2015, 11, 20);

        DayOfWeek day = DayOfWeek.THURSDAY;

        LocalDate previous = date.with(TemporalAdjusters.previous(day));

        System.out.printf("Today is %s (%s). The previous %s was on %s%n", date, date.getDayOfWeek(), day, previous);
    }
}
