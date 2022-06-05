package org.andrea.main;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import org.andrea.collection.CollectionManager;
import org.andrea.collection.MusicBandCollectionManager;
import org.andrea.data.MusicBand;
import org.andrea.exceptions.ConnectionException;
import org.andrea.exceptions.InvalidPortException;
import org.andrea.exceptions.InvalidProgramArgumentsException;
import org.andrea.server.Server;

import java.util.*;

import static org.andrea.io.OutputManager.print;


/**
 * main class for launching server with arguments
 */
public class Main {
    public static void main(String[] args) throws Exception {
        args = new String[]{"6666","ttt"};
        int port = 0;
        String strPort = "";
        String path = "music_band_database.json";
        try {
            if (args.length >= 2) {
                path = args[1];
                strPort = args[0];
            }
            if (args.length == 1) strPort = args[0];
            if (args.length == 0) throw new InvalidProgramArgumentsException("no address passed by arguments");
            try {
                port = Integer.parseInt(strPort);
            } catch (NumberFormatException e) {
                throw new InvalidPortException();
            }
            Server server = new Server(port, path);
            server.start();
            server.consoleMode();

        } catch (InvalidProgramArgumentsException | ConnectionException e) {
            print(e.getMessage());
        }

    }


}
