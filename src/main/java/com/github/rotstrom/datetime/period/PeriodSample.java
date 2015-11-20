package com.github.rotstrom.datetime.period;

import java.time.LocalDate;
import java.time.Period;

public class PeriodSample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2015, 11, 20);
        LocalDate payday = LocalDate.of(2015, 11, 23);

        System.out.printf("There are %s days until payday.%n", Period.between(today, payday).getDays());
    }
}
