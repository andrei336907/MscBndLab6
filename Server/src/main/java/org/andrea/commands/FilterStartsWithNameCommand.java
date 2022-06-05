package org.andrea.commands;

import org.andrea.collection.CollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.EmptyCollectionException;
import org.andrea.exceptions.MissedCommandArgumentException;

import java.util.List;

public class FilterStartsWithNameCommand extends CommandImpl {
    private CollectionManager<MusicBand> collectionManager;

    public FilterStartsWithNameCommand(CollectionManager<MusicBand> cm) {
        super("filter", CommandType.NORMAL);
        collectionManager = cm;
    }

    @Override
    public String execute() {
        if (!hasStringArgument()) throw new MissedCommandArgumentException();
        if (collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
        String start = getStringArg();
        List<MusicBand> list = collectionManager.filterStartsWithName(getStringArg());
        if (list.isEmpty()) return "none of elements have name which starts with " + start;
        String s = list.stream()
                .sorted(new MusicBand.SortingComparator())
                .map(e -> e.toString()).reduce("", (a, b) -> a + b + "\n");
        return s;
    }
}
