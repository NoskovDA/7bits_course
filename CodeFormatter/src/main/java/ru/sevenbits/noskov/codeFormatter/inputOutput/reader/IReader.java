package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import java.io.Closeable;

/**
 * Reader interface.
 */
public interface IReader{
    /**
     *
     * @return read char.
     * @throws ReaderException
     */
    int read() throws ReaderException;

    /**
     *
     * @throws ReaderException
     */
    void close() throws ReaderException;
}
