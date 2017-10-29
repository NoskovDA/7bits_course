package ru.sevenbits.Noskov.codeFormatter.InputOutput.reader;

import java.io.IOException;

public class ReaderException extends Throwable {
    public ReaderException(IOException e) {
        super(e);
    }

    public ReaderException(String s) {
        super(s);
    }
}
