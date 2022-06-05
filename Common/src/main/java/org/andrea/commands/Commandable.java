package org.andrea.commands;

import org.andrea.connection.Request;
import org.andrea.connection.Response;
import org.andrea.exceptions.FileException;

public interface Commandable {
    /**
     * adds command
     *
     * @param key-command name
     * @param cmd-command callback
     */
    public default void addCommand(String key, Command cmd) {
        addCommand(key, cmd);
    }


    public void addCommand(Command cmd);

    /**
     * runs command
     *
     * @param rq
     */
    public Response runCommand(Request rq);

    public Command getCommand(String key);

    public default Command getCommand(Request rq) {
        return getCommand(rq.getCommandName());
    }

    public boolean hasCommand(String s);

    public default boolean hasCommand(Request rq) {
        return hasCommand(rq.getCommandName());
    }

    /**
     * runs program in console
     */
    public void consoleMode();

    /**
     * especially for executing scripts
     */
    public void fileMode(String path) throws FileException;
}
