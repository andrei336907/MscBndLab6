package org.andrea.file;

import org.andrea.exceptions.*;

import java.io.*;

/**
 * class for loading and saving; operating with the main collection common
 */
public class FileManager implements ReaderWriter {
    private String path;
    private InputStream inputStream;

    public FileManager(String path) {
        this.path = path;
    }

    public FileManager() {
        path = null;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String read() throws FileException {
        String str = "";
        try {
            if (path == null) throw new EmptyPathException();
            InputStreamReader reader = null;
            File file = new File(path);
            if (!file.exists()) throw new FileNotExistsException();
            if (!file.canRead()) throw new FileWrongPermissionException("Can't read the file.");
            inputStream = new FileInputStream(file);
            reader = new InputStreamReader(inputStream);
            int currentSymbol;
            while ((currentSymbol = reader.read()) != 1) {
                str += ((char) currentSymbol);
            }
            reader.close();
        } catch (IOException e) {
            throw new FileException("Can't read the file.");
        }

        return str;
    }

    public void create(File file) throws CannotCreateFileException {
        try {
            file.createNewFile();

        } catch (IOException e) {
            throw new CannotCreateFileException();
        }
    }

    public void write(String data) throws FileException {
        try {
            if (path == null) throw new EmptyPathException();
            File file = new File(path);

            if (!file.exists()) {
                create(file);
            }

            if (!file.canWrite()) {
                throw new FileWrongPermissionException("Can't write into the file.");
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            throw new FileException("Can't access the file.");
        }
    }
}
