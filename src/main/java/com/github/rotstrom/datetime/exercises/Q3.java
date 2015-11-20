package com.github.rotstrom.datetime.exercises;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 4. How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
 */
public class Q3 {
    public static void main(String[]args){
        instant2ZonedDateTime(Instant.EPOCH, ZoneId.of("Europe/Moscow"));
        zonedDateTime2Instant(ZonedDateTime.now());
    }

    public static void instant2ZonedDateTime(Instant date, ZoneId zone) {
        ZonedDateTime zdt = date.atZone(zone);
        System.out.printf("Instant %s to ZonedDateTime: %s%n", date, zdt);
    }

    public static void zonedDateTime2Instant(ZonedDateTime dateTime) {
        System.out.printf("ZonedDateTime %s to Instant: %s", dateTime, dateTime.toInstant());
    }
}
