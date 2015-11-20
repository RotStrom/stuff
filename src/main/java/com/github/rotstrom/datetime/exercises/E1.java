package com.github.rotstrom.datetime.exercises;

import java.time.Month;
import java.time.YearMonth;

/**
 * 1. Write an example that, for a given year, reports the length of each month within that year.
 */
public class E1 {
    public static void main(String[] args) {
        String input = "2012";
        printMonthsLength(Integer.valueOf(input));
    }

    private static void printMonthsLength(int year) {
        System.out.printf("Year: %s%n", year);
        for (Month month : Month.values()) {
            System.out.printf("%s: %s days%n", month, YearMonth.of(year, month).lengthOfMonth());
        }
    }
}
