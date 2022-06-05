package org.andrea.utils;

import org.andrea.exceptions.InvalidDateFormatException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateConverter {
    private static DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    private static DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String dateToString(Date date) {
        return dateFormatter.format(date);
    }

    public static String dateToString(LocalDate date) {
        return localDateFormatter.format(date);

    }


    public static LocalDate parseLocalDate(String s) throws InvalidDateFormatException {
        try {
            return LocalDate.parse(s, localDateFormatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException();
        }
    }

    public static Date parseDate(String s) throws InvalidDateFormatException {
        try {
            return dateFormatter.parse(s);
        } catch (ParseException e) {
            throw new InvalidDateFormatException();
        }
    }


}
