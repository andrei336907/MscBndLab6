package org.andrea.data;

import java.util.Date;

public class DefaultMusicBand extends MusicBand {
    public DefaultMusicBand(String name, Coordinates coordinates, Date creationDate, Long numberOfParticipants, MusicGenre genre, Label label) {
        super(name, coordinates, numberOfParticipants, creationDate, genre, label);
        setCreationDate(new Date());
    }
}
