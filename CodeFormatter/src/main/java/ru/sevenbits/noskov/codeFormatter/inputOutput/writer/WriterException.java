package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

import java.io.IOException;

/**
 * Exception classes implemented IWriter.
 */
public class WriterException extends Exception {
    /**
     * Constructor.
     *
     * @param e - caught WriterException.
     */
    public WriterException(final IOException e) {
        super(e);
    }

    public WriterException(String msg, IOException e) {
        super(msg, e);
    }
}
