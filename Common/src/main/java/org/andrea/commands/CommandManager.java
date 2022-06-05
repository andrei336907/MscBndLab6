package org.andrea.commands;

import com.google.inject.Inject;
import org.andrea.connection.CommandMessage;
import org.andrea.connection.Response;
import org.andrea.connection.Status;
import org.andrea.exceptions.FileException;
import org.andrea.exceptions.NoSuchCommandException;
import org.andrea.io.ConsoleInputManager;
import org.andrea.io.FileInputManager;
import org.andrea.io.InputManager;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

public abstract class CommandManager implements Commandable, Closeable {

    private static Stack<String> callStack;
    private Map<String, Command> map;


    @Inject
    private InputManager inputManager;
    private boolean isRunning;
    private String currentScriptFileName;

    /**
     * class constructor
     */
    public CommandManager() {
        isRunning = false;
        currentScriptFileName = "";
        map = new HashMap<String, Command>();
    }

    public static String getHelp() {
        return "\r\nhelp : show help for available commands\r\n\r\ninfo : Write to standard output information about the collection (type,\r\ninitialization date, number of elements, etc.)\r\n\r\nshow : print to standard output all elements of the collection in\r\nstring representation\r\n\r\nadd {element} : add a new element to the collection\r\n\r\nupdate id {element} : update the value of the collection element whose id\r\nequal to given\r\n\r\nremove_by_id id remove_by_id id : remove an element from the collection by its id\r\n\r\nclear : clear the collection\r\n\r\nsave (file_name - optional) : save the collection to a file\r\n\r\nexecute_script file_name : read and execute script from specified file.\r\nThe script contains commands in the same form in which they are entered\r\nuser is interactive.\r\n\r\nexit : exit the program (without saving to a file)\r\n\r\nremove_first : remove the first element from the collection\r\n\r\nremove_last : remove the last element from the collection \r\n\r\ncount_less_than_genre genre : print the number of elements whose genre field value is less than the specified one\r\n\r\nfilter_starts_with_name name : output elements, value of field name\r\nwhich starts with the given substring\r\n\r\nprint_field_ascending_label : print the values of the label field of all elements in ascending order\r\n";

    }

    public void clearStack() {
        callStack.clear();
    }

    public Stack<String> getStack() {
        return callStack;
    }

    public String getCurrentScriptFileName() {
        return currentScriptFileName;
    }

    public void addCommand(Command c) {
        map.put(c.getName(), c);
    }

    public void addCommand(Command c, String key) {
        map.put(key, c);
    }

    public Command getCommand(String s) {
        if (!hasCommand(s)) throw new NoSuchCommandException();

        Command cmd = map.get(s);
        return cmd;
    }

    public boolean hasCommand(String s) {
        return map.containsKey(s);
    }

    public void consoleMode() {
        isRunning = true;
        inputManager = new ConsoleInputManager();
        while (isRunning) {
            try {
                System.out.println("Enter 'help' to see all commands with descriptions.");
                CommandMessage commandMessage = inputManager.readCommand();
                Response answerMeassage = runCommand(commandMessage);
                if (answerMeassage.getStatus() == Status.EXIT) {
                    close();
                }
            } catch (NoSuchElementException e) {
                inputManager = new ConsoleInputManager();
            }
        }
    }

    public void fileMode(String path) throws FileException {
        currentScriptFileName = path;
        inputManager = new FileInputManager(path);
        isRunning = true;
        while (isRunning && inputManager.getScanner().hasNextLine()) {
            CommandMessage commandMessage = inputManager.readCommand();
            Response answerMessage = runCommand(commandMessage);
            if (answerMessage.getStatus() == Status.EXIT) {
                close();
            }
        }
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public void setInputManager(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean s) {
        isRunning = s;
    }

    public void close() {
        setRunning(false);
    }
}
