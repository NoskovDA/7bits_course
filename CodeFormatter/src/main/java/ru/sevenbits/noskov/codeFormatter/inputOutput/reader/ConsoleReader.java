package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import ru.sevenbits.noskov.codeFormatter.inputOutput.ErrorCodes;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ICloseable;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * reader from console.
 */
public class ConsoleReader implements IReader, ICloseable {
    private Reader reader;
    private int current;

    /**
     * Constructor.
     */
    public ConsoleReader() {
        this.reader = new InputStreamReader(System.in);
    }
    @Override
    public void close() throws Exception {
        try {
            reader.close();
        } catch (IOException e) {
            throw new Exception(ErrorCodes.STREAM_READER_NOT_CLOSED.getErrorString().concat(ConsoleReader.class.getSimpleName()), e);
        }
    }

    @Override
    public char read() throws ReaderException {
        try {
            if (current != -1) {
                return (char) current;
            } else {
                if (hasNext()) {
                    return (char) current;
                } else {
                    throw new ReaderException(ErrorCodes.END_STREAM.getErrorString());
                }
            }
        } finally {
            current = -1;
        }
    }

    @Override
    public boolean hasNext() throws ReaderException {
        try {
            current = reader.read();
            return current >= 0;
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }
}
