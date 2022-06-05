package org.andrea.exceptions;

public class InvalidPortException extends ConnectionException {
    public InvalidPortException() {
        super("Invalid port");
    }
}
