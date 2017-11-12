package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

/**
 * reader interface.
 */
public interface IReader {
    /**
     *
     * @return read char.
     * @throws ReaderException when something goes wrong​
     */
    char read() throws ReaderException;

    /**
     *
     * @return true if and only if this reader has another char of input
     * @throws ReaderException when something goes wrong​
     */
    boolean hasNext() throws ReaderException;
}
