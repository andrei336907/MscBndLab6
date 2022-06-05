package org.andrea.exceptions;

public class CannotCreateFileException extends FileException {
    public CannotCreateFileException() {
        super("Can't create the file.");
    }
}
