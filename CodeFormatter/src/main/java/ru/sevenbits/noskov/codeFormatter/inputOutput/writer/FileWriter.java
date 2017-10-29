package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Writer to file.
 */
public class FileWriter implements IWriter {
    private FileOutputStream fileOutputStream;

    /**
     *Constructor
     *
     * @param path - path to file.
     * @throws WriterException
     */
    public FileWriter(Path path) throws WriterException {
        try {
            fileOutputStream = new FileOutputStream(path.toFile());
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

    @Override
    public void write(final char c) throws WriterException {
        try {
            fileOutputStream.write(c);
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

    @Override
    public void close() throws WriterException {
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }
}
