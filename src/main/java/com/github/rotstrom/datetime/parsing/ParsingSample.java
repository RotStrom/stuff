package com.github.rotstrom.datetime.parsing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class ParsingSample {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d yyyy");

    public static void main(String[] args) {
        parseAndPrint("19590709", DateTimeFormatter.BASIC_ISO_DATE);
        parseAndPrint("Jan 3 2003", dtf);
        parseAndPrint("Jun 23 2003", dtf);
    }

    private static void parseAndPrint(String in, DateTimeFormatter dtf) {
        try {
            LocalDate date = LocalDate.parse(in, dtf);
            System.out.printf("Result of parsing [%s]: %s%n", in, date);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", in);
            throw ex;
        }
    }
}
