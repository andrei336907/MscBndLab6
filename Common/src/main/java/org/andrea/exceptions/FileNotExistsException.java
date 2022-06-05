package org.andrea.exceptions;

public class FileNotExistsException extends FileException {
    public FileNotExistsException() {
        super("Can't find the file.");
    }
}
