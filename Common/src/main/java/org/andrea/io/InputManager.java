package org.andrea.io;

import org.andrea.connection.CommandMessage;
import org.andrea.data.Coordinates;
import org.andrea.data.MusicBand;
import org.andrea.data.MusicGenre;
import org.andrea.exceptions.*;

import java.util.Date;
import java.util.Scanner;

public interface InputManager {
    /**
     * reads name of mb from input
     *
     * @return
     * @throws EmptyStringException
     */
    public String readMusicBandName() throws EmptyStringException;

    /**
     * read x coordinates from input
     *
     * @return
     * @throws InvalidNumberException
     */
    public int readXCoord() throws InvalidNumberException;

    /**
     * read y coordinates from input
     *
     * @return
     * @throws InvalidNumberException
     */
    public double readYCoord() throws InvalidNumberException;

    /**
     * reads coordinates from input
     *
     * @return
     * @throws InvalidNumberException
     */
    public Coordinates readCoords() throws InvalidNumberException;

    /**
     * read data from input
     *
     * @return
     * @throws InvalidDataException
     */
    public Date readCreationDate() throws InvalidDateFormatException;

    /**
     * read Number Of Participants from input
     *
     * @return
     * @throws InvalidNumberException
     */
    public Long readNumberOfParticipants() throws InvalidNumberException;

    /**
     * read genre from input
     *
     * @return
     * @throws InvalidEnumException
     */
    public MusicGenre readGenre() throws InvalidEnumException;


    /**
     * reads name of label from input
     *
     * @return
     */
    public String readLabelName();

    /**
     * read music band from input
     *
     * @return
     * @throws InvalidDataException
     */
    public MusicBand readMBand() throws InvalidDataException;

    /**
     * reads command-argument pair from input
     *
     * @return
     */
    public CommandMessage readCommand();

    /**
     * gets input scanner
     *
     * @return
     */
    public Scanner getScanner();
}