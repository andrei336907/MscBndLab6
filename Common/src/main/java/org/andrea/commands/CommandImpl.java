package org.andrea.commands;

import org.andrea.connection.AnswerMsg;
import org.andrea.connection.Request;
import org.andrea.connection.Response;
import org.andrea.connection.Status;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.*;

/**
 * it implements inteface Command and realizes some of it's methods
 * it is extended by command classes in server module
 */
public abstract class CommandImpl implements Command {
    private String name;
    private CommandType ct;
    private Request argument;

    /**
     * class constructor
     *
     * @param n
     * @param t
     */
    public CommandImpl(String n, CommandType t) {
        name = n;
        ct = t;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return type of command
     */
    public CommandType getType() {
        return ct;
    }

    /**
     * @return argument
     */
    public Request getArgument() {
        return argument;
    }

    /**
     * sets argument which we've pointed
     *
     * @param a
     */

    public void setArgument(Request a) {
        argument = a;
    }

    /**
     * custom execute command
     *
     * @return
     * @throws InvalidDataException
     * @throws CommandException
     * @throws FileException
     * @throws ConnectionException
     */
    public abstract String execute() throws InvalidDataException, CommandException, FileException, ConnectionException;

    /**
     * wraps execute into response
     *
     * @return
     */
    public Response run() {
        AnswerMsg result = new AnswerMsg();
        try {
            result.info(execute());

        } catch (ExitException e) {
            result.info(e.getMessage());
            result.setStatus(Status.EXIT);
        } catch (InvalidDataException | CommandException | FileException |
                 ConnectionException e) {
            result.error(e.getMessage());

        }
        return result;
    }

    public boolean hasStringArgument() {
        return argument != null && argument.getStringArg() != null && !argument.getStringArg().equals("");
    }

    public boolean hasMusicBandArgument() {
        return argument != null && argument.getMusicBand() != null;
    }

    public String getStringArg() {
        return getArgument().getStringArg();
    }

    public MusicBand getMusicBandArg() {
        return getArgument().getMusicBand();
    }


}
