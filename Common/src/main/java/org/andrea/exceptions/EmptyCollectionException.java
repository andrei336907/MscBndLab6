package org.andrea.exceptions;

public class EmptyCollectionException extends CommandException {
    public EmptyCollectionException() {
        super("Collection is empty!");
    }
}
