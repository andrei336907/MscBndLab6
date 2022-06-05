package org.andrea.data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class MusicBand implements Collectionable, Serializable {
    //public final String getMusicGenre = null;
    public Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    public Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private MusicGenre genre; //Поле не может быть null
    private Label label; //Поле может быть null
    //public Object getGenre;

    /**
     * @param name
     * @param coordinates
     * @param numberOfParticipants
     * @param creationDate
     * @param genre
     * @param label
     */
    public MusicBand(String name, Coordinates coordinates, Long numberOfParticipants, Date creationDate, MusicGenre genre, Label label) {
        //creationDate= new Date();

        this.creationDate = creationDate;
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.label = label;
    }

    /**
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * set new id. for changing numer of elements inn collection.
     *
     * @param ID
     */
    public void setId(int ID) {
        id = ID;
    }

    /**
     * @return name of music band(str)
     */
    public String getMBName() {
        return name;
    }

    /**
     * @return Number Of Participants(long)
     */
    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * @return creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date date) {
        creationDate = date;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public MusicGenre getMusicGenre() {
        return genre;
    }

    public Label getAllLabels() {
        return label;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strCreationDate = dateFormat.format(creationDate);

        String s = "";
        s += "{\n";
        s += " \"id\" : " + Integer.toString(id) + ",\n";
        s += " \"name\" : " + "\"" + name + "\"" + ",\n";
        s += " \"coordinates\" : " + coordinates.toString() + ",\n";
        s += " \"creationDate\" : " + "\"" + strCreationDate + "\"" + ",\n";
        s += " \"genre\" : " + "\"" + genre.toString() + "\"" + ",\n";
        s += " \"numberOfParticipants\" : " + "\"" + numberOfParticipants.toString() + "\"" + ",\n";
        if (label != null) s += " \"bestAlbum\" : " + "\"" + label.toString() + "\"" + ",\n";
        s += "}";
        return s;
    }

    @Override
    /**
     * bool
     * @param obj
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        MusicBand another = (MusicBand) obj;
        return this.getId() == another.getId();

    }

    /**
     * @return возвращает {@code true}если все условия по заполнению полей после парсинга соблюдены, а иначе - {@code false}
     */


    public int compareTo(Collectionable musicBand) {
        int result = Long.compare(this.numberOfParticipants, musicBand.getNumberOfParticipants());
        return result;
    }

    public boolean validate() {
        return (id != null && id > 0
                && name != null && !name.equals("")
                && coordinates != null && coordinates.validate()
                && creationDate != null
                && numberOfParticipants != null && numberOfParticipants > 0
                && genre != null
                && label.validate());
    }

    /**
     * comparator for sorting
     */

    public static class SortingComparator implements Comparator<MusicBand> {
        public int compare(MusicBand first, MusicBand second) {
            int result = Double.compare(first.getCoordinates().getX(), second.getCoordinates().getX());
            if (result == 0) {
                result = Double.compare(first.getCoordinates().getY(), second.getCoordinates().getY());
            }
            return result;
        }
    }


}
