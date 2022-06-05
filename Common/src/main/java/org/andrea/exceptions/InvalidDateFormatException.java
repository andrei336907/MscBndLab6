package org.andrea.exceptions;

public class InvalidDateFormatException extends InvalidDataException {

    public InvalidDateFormatException() {
        super("Date format must be YYYY-MM-DD");
    }
}
