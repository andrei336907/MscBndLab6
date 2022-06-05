package org.andrea.connection;

import org.andrea.data.MusicBand;

import java.io.Serializable;

public class CommandMessage implements Request {

    private String commandName;
    private String commandStringArgument;
    private Serializable commandObjectArgument;

    /**
     * class constructor
     *
     * @param commandName
     * @param commandStringArgument
     * @param commandObjectArgument
     */
    public CommandMessage(String commandName, String commandStringArgument, Serializable commandObjectArgument) {
        this.commandObjectArgument = commandObjectArgument;
        this.commandName = commandName;
        this.commandStringArgument = commandStringArgument;
    }

    public String getStringArg() {
        return commandStringArgument;
    }


    public MusicBand getMusicBand() {
        return (MusicBand) commandObjectArgument;
    }


    public String getCommandName() {
        return commandName;
    }
}
