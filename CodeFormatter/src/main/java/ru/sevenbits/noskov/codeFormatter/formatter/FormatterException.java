package ru.sevenbits.noskov.codeFormatter.formatter;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

/**
 * Formatter class exception.
 */
public class FormatterException extends Throwable {
    /**
     * Constructor.
     *
     * @param e - caught WriterException.
     */
    public FormatterException(final WriterException e) {
        super(e);
    }

    /**
     * Constructor.
     *
     * @param e - caught WriterException.
     */
    public FormatterException(final ReaderException e) {
        super(e);
    }
}
