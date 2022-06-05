package org.andrea.collection;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import org.andrea.data.MusicBand;
import org.andrea.json.CollectionDeserializer;
import org.andrea.json.DateDeserializer;
import org.andrea.json.DateSerializer;

import java.lang.reflect.Type;
import java.util.*;


public class MusicBandCollectionManager implements CollectionManager<MusicBand> {



    private AbstractList<MusicBand> collection;
    private Date date;
    private Set<Integer> uniqueIds;
    private int count;


    /**
     * Constructor, set start values
     */

    @Inject
    public MusicBandCollectionManager(AbstractList collection, Set uniqueIds) {
        this.uniqueIds = uniqueIds;
        this.collection = collection;
        this.date = new Date();
    }

    public int generateNextId() {
        if (collection.isEmpty()) return 1;
        else {
            Vector<MusicBand> vector = (Vector<MusicBand>)collection;
            int id = vector.lastElement().getId() + 1;
            if (uniqueIds.contains(id)) {
                while (uniqueIds.contains(id)) id += 1;
            }
            uniqueIds.add(id);
            return id;
        }

    }

    public void sort() {
        Collections.sort(collection);
    }

    public Vector<MusicBand> getCollection() {
        return (Vector<MusicBand>)collection;
    }

    public void add(MusicBand musicBand) {
        musicBand.setId(generateNextId());
        collection.add(musicBand);
        System.out.println("You've added element:" + "\n" + musicBand.toString());
    }

    public String getInfo() {
        return "PriorityQueue of MusicBand, size: " + Integer.toString(collection.size()) + ", initialization date: " + date.toString();

    }

    public boolean checkID(Integer id) {
        for (MusicBand musicBand : collection) {
            if (musicBand.getId() == id) return true;
        }
        return false;
    }

    public boolean removeByID(Integer id) {
        for (MusicBand musicBand : collection) {
            if (musicBand.getId() == id) {
                collection.remove(musicBand);
                uniqueIds.remove(id);
                System.out.println("Element " + Integer.toString(id) + " successfully deleted");
                return false;
            }
        }
        return false;
    }

    public boolean updateByID(Integer id, MusicBand newMusicBand) {
        int idx = 0;
        for (MusicBand musicBand : collection) {
            if (musicBand.getId() == id) {
                newMusicBand.setId(id);
                collection.set(idx, newMusicBand);
                System.out.println("element " + Integer.toString(id) + " successfully updated");
                return false;
            }
            idx += 1;
        }
        return false;
    }


    public int getSize() {
        return collection.size();
    }

    public void clear() {
        collection.clear();
        uniqueIds.clear();
        System.out.println("Collection cleared");
    }

    public Integer countLessThenGenre(String genre) {

        for (MusicBand musicBand : collection) {
            if (musicBand.getMusicGenre().toString().compareTo(genre.toString()) > 0) {
                count++;
            }
        }
        return count;
    }

    public List<String> printFieldAscendingLabel() {
        List<String> list = new ArrayList<>();
        for (MusicBand musicBand : collection) {
            list.add(musicBand.getAllLabels().toString());
        }
        Collections.sort(list);
        return list;
    }


    public void removeFirst() {
        int id = collection.get(0).getId();
        collection.remove(0);
        uniqueIds.remove(id);
        System.out.println("element " + Integer.toString(id) + " successfully deleted");

    }

    public void removeLast() {
        int id = collection.get(collection.size() - 1).getId();
        collection.remove(collection.size() - 1);
        uniqueIds.remove(id);
        System.out.println("element " + Integer.toString(id) + " successfully deleted");


    }


    public List<MusicBand> filterStartsWithName(String start) {
        LinkedList<MusicBand> list = new LinkedList<>();
        for (MusicBand musicBand : collection) {
            if (musicBand.getMBName().startsWith(start.trim())) {
                list.add(musicBand);
            }
        }
        if (list.isEmpty()) System.out.println("none of elements have name which starts with " + start);
        else {
            System.out.println("Starts with: " + start);
            for (MusicBand musicBand : list) {
                System.out.println(musicBand.toString());
            }
        }
        return null;
    }

    public boolean deserializeCollection(String json) {
        boolean success = true;
        try {
            if (json == null || json.equals("")) {
                collection = new Vector<MusicBand>();
            } else {
                Type collectionType = new TypeToken<Vector<MusicBand>>() {
                }.getType();
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Date.class, new DateDeserializer())
                        .registerTypeAdapter(collectionType, new CollectionDeserializer(uniqueIds))
                        .create();
                collection = gson.fromJson(json.trim(), collectionType);
            }
        } catch (JsonParseException e) {
            success = false;
        }
        return success;
    }


    public String serializeCollection() {
        if (collection == null || collection.isEmpty()) return "";
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializer())
                .setPrettyPrinting().create();
        String json = gson.toJson(collection);
        return json;

    }

}
