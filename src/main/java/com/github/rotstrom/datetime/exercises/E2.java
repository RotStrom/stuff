package com.github.rotstrom.datetime.exercises;

import java.time.*;

/**
 * 2. Write an example that, for a given month of the current year, lists all of the Mondays in that month.
 * todo: rewrite with recursion (functional style) and with temporal queries
 */
public class E2 {
    public static void main(String[] args) {
        Year currentYear = Year.of(2015);
        Month month = Month.APRIL;

        printAllMondays(YearMonth.of(currentYear.getValue(), month.getValue()));
    }

    private static void printAllMondays(YearMonth date) {
        System.out.printf("Mondays in %s:%n", date.getMonth());
        for (int i = 1; i < date.lengthOfMonth(); i++) {
            LocalDate dayOfCheck = LocalDate.of(date.getYear(), date.getMonth(), i);
            if (dayOfCheck.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println(dayOfCheck);
            }
        }
    }
}
