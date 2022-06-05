package org.andrea.connection;

import org.andrea.data.MusicBand;

import java.io.Serializable;

public interface Request extends Serializable {

    public String getStringArg();

    public MusicBand getMusicBand();

    public String getCommandName();

}
