package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

import java.io.Closeable;
import java.io.IOException;

/**
 * Writer interface.
 */
public interface IWriter {
    /**
     * write char
     *
     * @param c - character for writing.
     * @throws WriterException when something goes wrong​
     */
    void write(char c) throws WriterException;
}
