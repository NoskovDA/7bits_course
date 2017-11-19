package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;
import java.nio.file.Path;

import ru.sevenbits.noskov.codeFormatter.inputOutput.CloseableReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ErrorCodes;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ICloseable;


/**
 * reader from file.
 */
public class FileReader implements CloseableReader {
    private Reader reader;
    private int current;

    /**
     *
     * @param path - path to file.
     * @throws ReaderException - when can't open reader with this input Path.
     */
    public FileReader(final Path path) throws ReaderException {
        try {
            reader = new InputStreamReader(new FileInputStream(path.toFile()));
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
            throw new ReaderException(ErrorCodes.STREAM_READER_NOT_CLOSED.getErrorString().concat(FileReader.class.getSimpleName()), e);
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
            throw new ReaderException();
        }
    }

    @Override
    public boolean hasNext() {
        return current >= 0;
    }

}
