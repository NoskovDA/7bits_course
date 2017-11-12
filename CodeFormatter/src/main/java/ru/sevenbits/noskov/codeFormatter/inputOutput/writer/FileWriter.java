package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

import ru.sevenbits.noskov.codeFormatter.inputOutput.ErrorCodes;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ICloseable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;

/**
 * Writer to file.
 */
public class FileWriter implements IWriter, ICloseable {
    private Writer writer;

    /**
     *Constructor
     *
     * @param path - path to file.
     * @throws WriterException when can't open reader with this input Path.
     */
    public FileWriter(final Path path) throws WriterException {
        try {
            writer = new OutputStreamWriter(new FileOutputStream(path.toFile()));
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

    @Override
    public void write(final char c) throws WriterException {
        try {
            writer.write(c);
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            writer.close();
        } catch (IOException e) {
            throw new Exception(ErrorCodes.STREAM_WRITER_NOT_CLOSED.getErrorString().concat(FileWriter.class.getSimpleName()), e);
        }
    }
}
