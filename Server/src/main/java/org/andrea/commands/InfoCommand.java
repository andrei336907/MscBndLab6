package org.andrea.commands;

import org.andrea.collection.CollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.InvalidDataException;

public class InfoCommand extends CommandImpl {
    private CollectionManager<MusicBand> collectionManager;

    public InfoCommand(CollectionManager<MusicBand> cm) {
        super("info", CommandType.NORMAL);
        collectionManager = cm;
    }

    @Override
    public String execute() throws InvalidDataException {
        return collectionManager.getInfo();
    }

}
