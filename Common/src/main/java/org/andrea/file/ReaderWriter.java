package org.andrea.file;


import org.andrea.exceptions.FileException;

public interface ReaderWriter {
    /**
     * sets path to file
     *
     * @param path
     */
    public void setPath(String path);

    /**
     * reads data
     *
     * @return
     * @throws FileException
     */
    public String read() throws FileException;

    /**
     * saves data
     *
     * @param data
     * @throws FileException
     */
    public void write(String data) throws FileException;
}
