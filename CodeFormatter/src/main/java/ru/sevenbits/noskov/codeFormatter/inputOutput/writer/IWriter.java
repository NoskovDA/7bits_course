package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

import java.io.Closeable;

/**
 * Writer interface.
 */
public interface IWriter extends Closeable {
    /**
     *
     * @param c - character for writing.
     * @throws WriterException
     */
    void write(char c) throws WriterException;
}
