package org.andrea.data;

public interface Collectionable extends Comparable<Collectionable>, Validateable {

    public int getId();

    public void setId(int id);

    public String getMBName();

    public long getNumberOfParticipants();

    public boolean validate();

    public int compareTo(Collectionable musicBand);
}
