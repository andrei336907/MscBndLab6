package org.andrea.exceptions;

public class RecursiveScriptExecuteException extends CommandException {
    public RecursiveScriptExecuteException() {
        super("Recursive script execute attempt.");
    }
}
