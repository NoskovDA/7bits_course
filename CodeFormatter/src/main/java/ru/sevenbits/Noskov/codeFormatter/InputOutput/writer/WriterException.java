package ru.sevenbits.Noskov.codeFormatter.InputOutput.writer;

import java.io.IOException;

public class WriterException extends Throwable {
    public WriterException(IOException e) {
        super(e);
    }
}
