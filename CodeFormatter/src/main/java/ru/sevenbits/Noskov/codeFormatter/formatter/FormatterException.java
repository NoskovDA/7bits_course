package ru.sevenbits.Noskov.codeFormatter.formatter;

import ru.sevenbits.Noskov.codeFormatter.InputOutput.reader.ReaderException;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.writer.WriterException;

public class FormatterException extends Throwable {
    public FormatterException(WriterException e) {
        super(e);
    }

    public FormatterException(ReaderException e) {
        super(e);
    }
}
