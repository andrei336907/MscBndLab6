package org.andrea.exceptions;

/**
 * thrown when port already in use
 */
public class PortAlreadyInUseException extends ConnectionException {
    public PortAlreadyInUseException() {
        super("port already in use");
    }
}