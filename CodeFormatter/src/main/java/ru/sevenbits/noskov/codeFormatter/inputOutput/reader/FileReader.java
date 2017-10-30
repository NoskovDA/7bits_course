package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import java.io.*;
import java.nio.file.Path;

/**
 * Reader from file.
 */
public class FileReader implements IReader {
    private Reader reader;

    /**
     *
     * @param path - path to file.
     * @throws ReaderException
     */
    public FileReader(final Path path) throws ReaderException {
        try {
            reader = new InputStreamReader(new FileInputStream(path.toFile()));
        } catch (FileNotFoundException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public void close() throws ReaderException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public int read() throws ReaderException {
        try {
            return reader.read();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

}
