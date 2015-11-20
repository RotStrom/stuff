package com.github.rotstrom.datetime.formatting;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class FormattingSample {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");

    public static void main(String[] args) {
        ZoneId leavingZone = ZoneId.of("Europe/Moscow");
        ZonedDateTime departure = ZonedDateTime.of(
                LocalDate.of(2015, Month.JANUARY, 15),
                LocalTime.of(23, 0),
                leavingZone
        );

        ZonedDateTime arrival = departure.withZoneSameInstant(ZoneId.of("Europe/Berlin")).plus(3, ChronoUnit.HOURS);

        formatAndPrint("Departure", departure, dtf);
        formatAndPrint("Arrival", arrival, dtf);
    }

    private static void formatAndPrint(String description, ZonedDateTime dateTime, DateTimeFormatter formatter) {
        try {
            String out = dateTime.format(formatter);
            System.out.printf("%s: %s (%s)%n", description, out, dateTime.getZone());
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", dateTime);
            throw ex;
        }
    }
}
