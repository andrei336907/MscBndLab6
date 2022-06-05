package org.andrea.exceptions;

public class InvalidEnumException extends InvalidDataException {
    public InvalidEnumException() {
        super("Wrong constant");
    }
}
