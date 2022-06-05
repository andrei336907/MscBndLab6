package org.andrea.exceptions;

public class ConnectionTimeOutException extends ConnectionException {
    public ConnectionTimeOutException() {
        super("Response timed out.");
    }
}
