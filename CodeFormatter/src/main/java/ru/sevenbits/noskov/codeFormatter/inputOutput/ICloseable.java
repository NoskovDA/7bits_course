package ru.sevenbits.noskov.codeFormatter.inputOutput;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

/**
 *  Closeable stream interface.
 */
public interface ICloseable extends AutoCloseable {
    @Override
    void close() throws ReaderException, WriterException;
}
