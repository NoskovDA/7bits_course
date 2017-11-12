package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;
import java.nio.file.Path;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ErrorCodes;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ICloseable;


/**
 * reader from file.
 */
public class FileReader implements IReader, ICloseable  {
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
        } catch (FileNotFoundException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            reader.close();
        } catch (IOException e) {
            throw new Exception(ErrorCodes.STREAM_READER_NOT_CLOSED.getErrorString().concat(FileReader.class.getSimpleName()), e);
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
