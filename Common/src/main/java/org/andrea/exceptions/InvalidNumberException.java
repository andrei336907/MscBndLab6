package org.andrea.exceptions;

public class InvalidNumberException extends InvalidDataException {

    public InvalidNumberException(String s) {
        super(s);
    }

    public InvalidNumberException() {
        super("Invalid number format");
    }
}
