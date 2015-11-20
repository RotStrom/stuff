package com.github.rotstrom.datetime.temporal;

import java.time.*;
import java.time.temporal.*;

/**
 * Used to retrieve information from a temporal-based object
 * todo: report an error in https://docs.oracle.com/javase/tutorial/datetime/iso/queries.html :
 * ...
 * TemporalQueries query = TemporalQueries.precision();
 * ...
 * TemporalQuery instead of TemporalQueries
 */
public class TemporalQueriesSample {
    public static void main(String[] args) {
        //simple usage
        printPrecision(LocalDate.now());
        printPrecision(LocalDateTime.now());
        printPrecision(Year.now());
        printPrecision(YearMonth.now());
        printPrecision(Instant.now());

        LocalDate date = LocalDate.of(2015, Month.APRIL, 5);

        //using custom query
        if (new CustomQuery().queryFrom(date)) {
            System.out.printf("%s is in vacations%n", date);
        } else {
            System.out.printf("%s is not in vacations%n", date);
        }

        //using lambda
        if (date.query(TemporalQueriesSample::isBirthday)) {
            System.out.printf("%s is a birthday", date);
        } else {
            System.out.printf("%s is not a birthday", date);
        }
    }

    private static void printPrecision(Temporal date) {
        TemporalQuery query = TemporalQueries.precision();
        System.out.printf("%s pricision is: %s%n", date.getClass().getSimpleName(), date.query(query));
    }

    private static Boolean isBirthday(TemporalAccessor date) {
        Month month = Month.of(date.get(ChronoField.MONTH_OF_YEAR));
        int day = date.get(ChronoField.DAY_OF_MONTH);

        if (month == Month.APRIL && day == 4) return Boolean.TRUE;

        return Boolean.FALSE;
    }

    static class CustomQuery implements TemporalQuery {
        private int year = 2016;
        private Month month = Month.JANUARY;
        private int startDay = 1;
        private int endDay = 10;
        private TemporalAccessor startDate = LocalDate.of(year, month, startDay);
        private TemporalAccessor endDate = LocalDate.of(year, month, endDay);

        @Override
        public Boolean queryFrom(TemporalAccessor date) {
            Month month = Month.of(date.get(ChronoField.MONTH_OF_YEAR));
            int day = date.get(ChronoField.DAY_OF_MONTH);

            if (day > startDay && day < endDay && month == this.month) return Boolean.TRUE;

            return Boolean.FALSE;
        }
    }
}
