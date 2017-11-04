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

    boolean hasNext() throws ReaderException;
}
