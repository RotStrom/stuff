package com.github.rotstrom.datetime.duration;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

class DurationSample {
    public static void main(String[] args) {
        Duration d = Duration.of(2, ChronoUnit.HOURS);

        Instant t1 = Instant.EPOCH;
        Instant t2 = t1.plus(3, ChronoUnit.DAYS);

        Duration diff = Duration.between(t1, t2);

        if (diff.compareTo(d) > 0) {
            System.out.println("Duration between t1 and t2 is more than " + d.toHours() + " hours.");
            System.out.println("Duration between t1 and t2 is " + diff.toHours() + "hours.");
        }
    }
}
