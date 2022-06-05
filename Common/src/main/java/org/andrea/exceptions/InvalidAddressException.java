package org.andrea.exceptions;

public class InvalidAddressException extends ConnectionException {
    public InvalidAddressException() {
        super("Invalid address");
    }

    public InvalidAddressException(String s) {
        super(s);
    }
}
