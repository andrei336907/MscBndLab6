package org.andrea.commands;

import org.andrea.collection.CollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.EmptyCollectionException;
import org.andrea.exceptions.InvalidDataException;

public class ClearCommand extends CommandImpl {
    private CollectionManager<MusicBand> collectionManager;

    public ClearCommand(CollectionManager<MusicBand> cm) {
        super("clear", CommandType.NORMAL);
        collectionManager = cm;
    }

    @Override
    public String execute() throws InvalidDataException {
        if (collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
        collectionManager.clear();
        return "collection cleared";
    }

}
