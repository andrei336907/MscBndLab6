package org.andrea.exceptions;

public class EmptyPathException extends FileException {

    public EmptyPathException() {
        super("Path is empty.");
    }
}
