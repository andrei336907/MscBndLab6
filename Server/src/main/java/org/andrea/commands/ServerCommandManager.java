package org.andrea.commands;

import org.andrea.collection.CollectionManager;
import org.andrea.connection.AnswerMsg;
import org.andrea.connection.Request;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.CommandException;
import org.andrea.file.ReaderWriter;
import org.andrea.log.Log;
import org.andrea.server.Server;

import static org.andrea.io.OutputManager.print;

public class ServerCommandManager extends CommandManager {
    private Server server;
    private CollectionManager<MusicBand> collectionManager;
    private ReaderWriter fileManager;

    public ServerCommandManager(Server server) {
        this.server = server;
        collectionManager = server.getCollectionManager();
        fileManager = server.getFileManager();
        addCommand(new AddCommand(collectionManager));
        addCommand(new ClearCommand(collectionManager));
        addCommand(new CountLessThanGenreCommand(collectionManager));
        addCommand(new ExecuteScriptCommand(this));
        addCommand(new ExitCommand());
        addCommand(new FilterStartsWithNameCommand(collectionManager));
        addCommand(new HelpCommand());
        addCommand(new InfoCommand(collectionManager));
        addCommand(new PrintFieldAscendingLabelCommand(collectionManager));
        addCommand(new RemoveByIdCommand(collectionManager));
        addCommand(new RemoveFirstCommand(collectionManager));
        addCommand(new RemoveLastCommand(collectionManager));
        addCommand(new SaveCommand(collectionManager, fileManager));
        addCommand(new ShowCommand(collectionManager));
        addCommand(new UpdateCommand(collectionManager));
    }

    public Server getServer() {
        return server;
    }

    @Override
    public AnswerMsg runCommand(Request msg) {
        AnswerMsg res = new AnswerMsg();
//        Command cmd = getCommand(msg);
//        cmd.setArgument(msg);
//        res = (AnswerMsg) cmd.run();
        try {
            Command cmd = getCommand(msg);
            cmd.setArgument(msg);
            res = (AnswerMsg) cmd.run();
        } catch (CommandException e) {
            res.error(e.getMessage());
        }
        switch (res.getStatus()) {
            case EXIT:
                Log.logger.fatal(res.getMessage());
                server.close();
                break;
//            case FINE:
//            case ERROR:
//                Log.logger.error(res.getMessage());
//                break;
            default:
                Log.logger.info(res.getMessage());
                break;
        }
        print(res);
        return res;
    }
}
