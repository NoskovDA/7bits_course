package ru.sevenbits.noskov.codeFormatter.formatter;

import ru.sevenbits.noskov.codeFormatter.formatter.Token.TokenException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

/**
 * Formatter class exception.
 */
public class FormatterException extends Exception {
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

    public FormatterException(TokenException e) {
        super(e);
    }
}
