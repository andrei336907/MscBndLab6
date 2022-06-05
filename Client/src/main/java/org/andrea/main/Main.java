package org.andrea.main;



import org.andrea.client.Client;
import org.andrea.exceptions.ConnectionException;
import org.andrea.exceptions.InvalidPortException;
import org.andrea.exceptions.InvalidProgramArgumentsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;

import static org.andrea.io.OutputManager.print;


public class Main {
    public static Logger logger = LogManager.getLogger("logger");
//    static final Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));


        args = new String[]{"localhost","6666"};
        String addr = "";
        int port = 0;
        try {
            if (args.length != 2) throw new InvalidProgramArgumentsException("no address passed by arguments");
            addr = args[0];
            try {
                port = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                throw new InvalidPortException();
            }
            Client client = new Client(addr, port);
            client.start();
            print("Alex, postav zachet");
        } catch (InvalidProgramArgumentsException | ConnectionException e) {
            print(e.getMessage());
        }

        //System.out.println(res.getMessage());
    }
}
