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
    char read() throws ReaderException;

    /**
     *
     * @return true if and only if this IReader can read next char.
     * @throws ReaderException
     */
    boolean isAvailable() throws ReaderException;

    /**
     *
     * @throws ReaderException
     */
    void close() throws ReaderException;
}
