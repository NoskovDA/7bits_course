package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import java.io.IOException;

/**
 *
 * Exception classes implemented IReader.
 */
public class ReaderException extends Exception {
    /**
     * Constructor.
     *
     * @param e - caught ReaderException..
     */
    public ReaderException(final IOException e) {
        super(e);
    }

    /**
     * Constructor.
     *
     * @param message - exception message..
     */
    public ReaderException(final String message) {
        super(message);
    }

    public ReaderException() {
        super();
    }

    public ReaderException(String msg, IOException e) {
        super(msg, e);
    }
}
