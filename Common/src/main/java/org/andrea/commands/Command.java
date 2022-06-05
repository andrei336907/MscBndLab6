package org.andrea.commands;

import org.andrea.commands.CommandType;
import org.andrea.connection.Request;
import org.andrea.connection.Response;

/**
 * interface with methods for CommandImpl class and command classes in server
 */

public interface Command {
    public String getName();

    public CommandType getType();

    public Response run();

    public void setArgument(Request a);

}
