package ru.sevenbits.noskov.codeFormatter.inputOutput;

/**
 *  Closeable stream interface.
 */
public interface ICloseable extends AutoCloseable {
    @Override
    void close() throws Exception;
}
