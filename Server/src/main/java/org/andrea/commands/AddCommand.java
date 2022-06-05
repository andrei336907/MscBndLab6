package org.andrea.commands;

import org.andrea.collection.CollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.CommandException;
import org.andrea.exceptions.InvalidDataException;

public class AddCommand extends CommandImpl {
    private CollectionManager<MusicBand> collectionManager;

    public AddCommand(CollectionManager<MusicBand> cm) {
        super("add", CommandType.NORMAL);
        collectionManager = cm;
    }

    public CollectionManager<MusicBand> getManager() {
        return collectionManager;
    }

    @Override
    public String execute() throws InvalidDataException, CommandException {
        getManager().add(getMusicBandArg());
        return getMusicBandArg().toString();
    }
}
