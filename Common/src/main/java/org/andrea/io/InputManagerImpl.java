package org.andrea.io;

import org.andrea.connection.CommandMessage;
import org.andrea.data.Coordinates;
import org.andrea.data.Label;
import org.andrea.data.MusicBand;
import org.andrea.data.MusicGenre;
import org.andrea.exceptions.*;

import java.util.Date;
import java.util.Scanner;

import static org.andrea.utils.DateConverter.parseDate;


public abstract class InputManagerImpl implements InputManager {
    private Scanner scanner;

    public InputManagerImpl(Scanner sc) {
        this.scanner = sc;
        scanner.useDelimiter("\n");
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;

    }

    public String readMusicBandName() throws EmptyStringException {
        String s = scanner.nextLine().trim();
        if (s.equals("")) {
            throw new EmptyStringException();
        }
        return s;
    }

    public int readXCoord() throws InvalidNumberException {
        int x;
        try {
            x = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
        return x;

    }

    public double readYCoord() throws InvalidNumberException {
        double y;
        try {
            y = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
        return y;
    }

    public Coordinates readCoords() throws InvalidNumberException {
        int x = readXCoord();
        double y = readYCoord();
        Coordinates coord = new Coordinates(x, y);
        return coord;
    }

    public Date readCreationDate() throws InvalidDateFormatException {
        String date = scanner.nextLine().trim();
        if (date.equals("")) {
            return null;
        } else {
            return parseDate(date);
        }
    }

    public Long readNumberOfParticipants() throws InvalidNumberException {
        long numberOfParticipants;
        try {
            numberOfParticipants = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
        if (numberOfParticipants <= 0) {
            throw new InvalidNumberException("must be greater than 0");
        }
        return numberOfParticipants;
    }

    public MusicGenre readGenre() throws InvalidEnumException {
        String s = scanner.nextLine().trim();
        try {
            return MusicGenre.valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidEnumException();
        }
    }

    public String readLabelName() {
        String s = scanner.nextLine();
        if (s.equals("")) {
            return null;
        }
        return s;

    }

    public Label readLabel() {
        String labelName = readLabelName();
        return new Label(labelName);
    }

    public MusicBand readMBand() throws InvalidDataException {
        MusicBand musicBand = null;
        String musicBandName = readMusicBandName();
        Coordinates coordinates = readCoords();
        Date date = new Date();
        Long numberOfParticipants = readNumberOfParticipants();
        MusicGenre musicGenre = readGenre();
        Label labelName = readLabel();
        musicBand = new MusicBand(musicBandName, coordinates, numberOfParticipants, date, musicGenre, labelName);
        return musicBand;
    }

    public CommandMessage readCommand() {
        String cmd = scanner.nextLine();
        String arg = null;
        MusicBand musicBand = null;
        //if command has an argument
        if (cmd.contains(" ")) {
            String arr[] = cmd.split(" ", 2);
            cmd = arr[0];
            arg = arr[1];

        }
        if (cmd.equals("add") || cmd.equals("update")) {
            try {
                musicBand = readMBand();
            } catch (InvalidDataException e) {
            }
            ;
        }
        return new CommandMessage(cmd, arg, musicBand);
    }

}
