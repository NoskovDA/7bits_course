package ru.sevenbits.noskov.codeFormatter.inputOutput;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

/**
 * ReaderAndWriter class exception.
 */
public class FactoryException extends Exception {

    /**
     * Constructor.
     *
     * @param message - exception message.
     */
    public FactoryException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param e - caught WriterException.
     */
    public FactoryException(final WriterException e) {
        super(e);
    }

    /**
     * Constructor.
     *
     * @param e - caught ReaderException.
     */
    public FactoryException(final ReaderException e) {
        super(e);
    }
}
