package org.andrea.commands;

import org.andrea.collection.CollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.EmptyCollectionException;
import org.andrea.exceptions.InvalidDataException;

public class RemoveFirstCommand extends CommandImpl {
    private CollectionManager<MusicBand> collectionManager;

    public RemoveFirstCommand(CollectionManager<MusicBand> cm) {
        super("remove_first", CommandType.NORMAL);
        collectionManager = cm;
    }


    @Override
    public String execute() throws InvalidDataException {
        if (collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
        Integer id = collectionManager.getCollection().get(0).getId();
        collectionManager.removeFirst();
        return "element " + Integer.toString(id) + " successfully deleted";
    }

}
