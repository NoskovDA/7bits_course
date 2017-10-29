package ru.sevenbits.Noskov.codeFormatter.InputOutput;

import ru.sevenbits.Noskov.codeFormatter.InputOutput.reader.ReaderException;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.writer.WriterException;

public class ReaderAndWriterException extends Throwable {
    public ReaderAndWriterException(String s) {
        super(s);
    }

    public ReaderAndWriterException(WriterException e) {
        super(e);
    }

    public ReaderAndWriterException(ReaderException e) {
        super(e);
    }
}
