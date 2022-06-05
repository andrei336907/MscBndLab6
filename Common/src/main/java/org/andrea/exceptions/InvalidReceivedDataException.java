package org.andrea.exceptions;

public class InvalidReceivedDataException extends InvalidDataException {
    public InvalidReceivedDataException() {
        super("Received data is damaged");
    }
}
