package org.andrea.commands;


import org.andrea.collection.CollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.EmptyCollectionException;
import org.andrea.exceptions.InvalidDataException;

public class RemoveLastCommand extends CommandImpl {
    private CollectionManager<MusicBand> collectionManager;

    public RemoveLastCommand(CollectionManager<MusicBand> cm) {
        super("remove_last", CommandType.NORMAL);
        collectionManager = cm;
    }


    @Override
    public String execute() throws InvalidDataException {
        if (collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
        Integer id = collectionManager.getCollection().get(collectionManager.getCollection().size() - 1).getId();
        collectionManager.removeFirst();
        return "Element " + Integer.toString(id) + " successfully deleted";
    }

}
