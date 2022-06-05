package org.andrea.exceptions;

public class NoSuchCommandException extends CommandException {
    public NoSuchCommandException() {
        super("Wrong command");
    }
}
