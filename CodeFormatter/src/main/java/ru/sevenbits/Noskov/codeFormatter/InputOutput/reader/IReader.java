package ru.sevenbits.Noskov.codeFormatter.InputOutput.reader;

import java.io.Closeable;

public interface IReader extends Closeable {
    int read() throws ReaderException;
    boolean isAvailable() throws ReaderException;
}
