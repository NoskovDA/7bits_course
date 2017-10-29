package ru.sevenbits.noskov.codeFormatter.inputOutput;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

/**
 * ReaderAndWriter class exception.
 */
public class ReaderAndWriterException extends Throwable {

    /**
     * Constructor.
     *
     * @param message - exception message.
     */
    public ReaderAndWriterException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param e - caught WriterException.
     */
    public ReaderAndWriterException(final WriterException e) {
        super(e);
    }

    /**
     * Constructor.
     *
     * @param e - caught ReaderException.
     */
    public ReaderAndWriterException(final ReaderException e) {
        super(e);
    }
}
