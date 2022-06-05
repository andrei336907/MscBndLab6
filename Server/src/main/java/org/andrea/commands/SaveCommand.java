package org.andrea.commands;

import org.andrea.collection.CollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.FileException;
import org.andrea.file.ReaderWriter;

public class SaveCommand extends CommandImpl {
    ReaderWriter fileManager;
    CollectionManager<MusicBand> collectionManager;

    public SaveCommand(CollectionManager<MusicBand> cm, ReaderWriter fm) {
        super("save", CommandType.SERVER_ONLY);
        collectionManager = cm;
        fileManager = fm;
    }

    @Override
    public String execute() throws FileException {
        if (hasStringArgument()) {
            fileManager.setPath(getStringArg());
        }
        ;
        fileManager.write(collectionManager.serializeCollection());
        return "collection successfully saved";
    }
}
