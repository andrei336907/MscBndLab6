package org.andrea.commands;

import org.andrea.client.Client;
import org.andrea.connection.AnswerMsg;
import org.andrea.connection.Request;
import org.andrea.connection.Status;
import org.andrea.exceptions.ConnectionException;
import org.andrea.exceptions.ConnectionTimeOutException;
import org.andrea.exceptions.InvalidDataException;

import static org.andrea.io.OutputManager.print;


/**
 * command manager for client
 */
public class ClientCommandManager extends CommandManager {
    private Client client;

    public ClientCommandManager(Client c) {
        client = c;
        addCommand(new ExecuteScriptCommand(this));
        addCommand(new ExitCommand());
        addCommand(new HelpCommand());
    }

    public Client getClient() {
        return client;
    }


    @Override
    public AnswerMsg runCommand(Request msg) {
        AnswerMsg res = new AnswerMsg();
        if (hasCommand(msg)) {
            Command cmd = getCommand(msg);
            cmd.setArgument(msg);
            res = (AnswerMsg) cmd.run();
        } else {
            try {
                client.send(msg);
                res = (AnswerMsg) client.receive();
            } catch (ConnectionTimeOutException e) {
                res.info("no attempts left, shutting down").setStatus(Status.EXIT);
            } catch (InvalidDataException | ConnectionException e) {
                res.error(e.getMessage());
            }
        }
//        print(res);
        String mapping = method(msg.getCommandName());
//        print(mapping);
        print(mapping + " / " + res);
        return res;
    }

    public String method(String commandnAME){
        if (commandnAME.equals("add")){
            return "POST";
        }
        else if (commandnAME.contains("remove")){
            return "DELETE";
        }
        else if (commandnAME.contains("update")){
            return "PUT";
        }
        else {
            return "GET";
        }
    }
}
