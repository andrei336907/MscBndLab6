package org.andrea.exceptions;

public class CommandException extends RuntimeException {
    public CommandException(String s) {
        super(s);
    }
}