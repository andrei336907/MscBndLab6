package org.andrea.exceptions;

public class EmptyStringException extends InvalidDataException {
    public EmptyStringException() {
        super("String can't be empty");
    }
}
