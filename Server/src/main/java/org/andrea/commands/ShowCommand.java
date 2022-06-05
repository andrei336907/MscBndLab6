package org.andrea.commands;

import org.andrea.collection.CollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.EmptyCollectionException;

public class ShowCommand extends CommandImpl {
    private CollectionManager<MusicBand> collectionManager;

    public ShowCommand(CollectionManager<MusicBand> cm) {
        super("show", CommandType.NORMAL);
        collectionManager = cm;
    }

    @Override
    public String execute() {
        if (collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
        collectionManager.sort();
        return collectionManager.serializeCollection();
    }

}
