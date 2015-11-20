package com.github.rotstrom.datetime.temporal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static java.lang.System.out;

class TemporalAdjustersSample {
    //todo: many paydays - common case
    public static class PaydayAdjuster implements TemporalAdjuster {
        private int firstPayDay = 8;
        private int secondPayDay = 23;

        @Override
        public Temporal adjustInto(Temporal input) {
            LocalDate date = LocalDate.from(input);

            int day = firstPayDay;

            if (date.getDayOfMonth() < firstPayDay) {
                date = date.withDayOfMonth(day);
            } else if (date.getDayOfMonth() < secondPayDay) {
                day = secondPayDay;
                date = date.withDayOfMonth(day);
            } else {
                date = date.withDayOfMonth(day).plus(1, ChronoUnit.MONTHS);
            }

            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
            }

            return input.with(date);
        }
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2015, Month.NOVEMBER, 23);
        DayOfWeek dotw = date.getDayOfWeek();

        out.printf("%s is on a %s%n", date, dotw);
        out.printf("Fist day of Month: %s%n", date.with(TemporalAdjusters.firstDayOfMonth()));

        printNextPayday(LocalDate.of(2015, Month.NOVEMBER, 1));
        printNextPayday(LocalDate.of(2015, Month.NOVEMBER, 8));
        printNextPayday(LocalDate.of(2015, Month.NOVEMBER, 20));
        printNextPayday(LocalDate.of(2015, Month.NOVEMBER, 25));
    }

    public static void printNextPayday(LocalDate date) {
        LocalDate nextPayday = date.with(new PaydayAdjuster());
        out.printf("The next payday for %s is %s (%s)%n",
                date,
                nextPayday,
                nextPayday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
    }
}
