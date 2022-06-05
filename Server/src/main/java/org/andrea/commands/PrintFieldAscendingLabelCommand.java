package org.andrea.commands;

import org.andrea.collection.CollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.*;

import java.util.List;

public class PrintFieldAscendingLabelCommand extends CommandImpl {
    private CollectionManager<MusicBand> collectionManager;

    public PrintFieldAscendingLabelCommand(CollectionManager<MusicBand> collectionManager) {
        super("print", CommandType.NORMAL);
        this.collectionManager = collectionManager;
    }

    @Override
    public String execute() throws InvalidDataException, CommandException, FileException, ConnectionException {
        if (collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
        List<String> list = collectionManager.printFieldAscendingLabel();
        return list.stream().reduce("", (a, b) -> a + b + "\n");

    }
}
