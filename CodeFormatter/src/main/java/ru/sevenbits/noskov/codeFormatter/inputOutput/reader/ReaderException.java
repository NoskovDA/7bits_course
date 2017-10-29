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
    public ReaderException(IOException e) {
        super(e);
    }

    /**
     * Constructor.
     *
     * @param message - exception message..
     */
    public ReaderException(String message) {
        super(message);
    }
}
