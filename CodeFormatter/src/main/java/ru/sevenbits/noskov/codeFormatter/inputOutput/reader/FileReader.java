package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Reader from file.
 */
public class FileReader implements IReader {
    private FileInputStream fileInputStream;

    /**
     *
     * @param path - path to file.
     * @throws ReaderException
     */
    public FileReader(Path path) throws ReaderException {
        try {
            fileInputStream = new FileInputStream(path.toFile());
        } catch (FileNotFoundException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public void close() throws ReaderException {
        try {
            fileInputStream.close();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public char read() throws ReaderException {
        try {
            return (char) fileInputStream.read();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public boolean isAvailable() throws ReaderException {
        try {
            return (fileInputStream.available()>0);
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

}
