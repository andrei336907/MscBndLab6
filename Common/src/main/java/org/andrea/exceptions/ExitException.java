package org.andrea.exceptions;

public class ExitException extends CommandException {
    public ExitException() {
        super("Shutting down...");
    }
}
