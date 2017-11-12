package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import java.io.IOException;

/**
 *
 * Exception classes implemented IReader.
 */
public class ReaderException extends Throwable {
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
}
