package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import ru.sevenbits.noskov.codeFormatter.inputOutput.CloseableReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ErrorCodes;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ICloseable;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * reader from console.
 */
public class ConsoleReader implements CloseableReader {
    private Reader reader;
    private int current;

    /**
     * Constructor.
     */
    public ConsoleReader() throws ReaderException {
        this.reader = new InputStreamReader(System.in);
        try {
            current = reader.read();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public void close() throws ReaderException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new ReaderException(ErrorCodes.STREAM_READER_NOT_CLOSED.getErrorString().concat(ConsoleReader.class.getSimpleName()), e);
        }
    }

    @Override
    public char read() throws ReaderException {
        try {
            if (current != -1) {
                try {
                    return (char) current;
                } finally {
                    current = reader.read();
                }
            } else {
                throw new ReaderException(ErrorCodes.END_STREAM.getErrorString());
            }
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public boolean hasNext(){
        return current >= 0;
    }
}
