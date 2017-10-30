package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Reader from console.
 */
public class ConsoleReader implements IReader {
    private Reader reader;

    /**
     * Constructor.
     */
    public ConsoleReader() {
        this.reader = new InputStreamReader(System.in);
    }

    @Override
    public int read() throws ReaderException {
        try {
            return reader.read();
        } catch (IOException e) {
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
}
