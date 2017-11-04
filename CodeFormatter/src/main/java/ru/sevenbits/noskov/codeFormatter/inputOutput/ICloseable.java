package ru.sevenbits.noskov.codeFormatter.inputOutput;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;

public interface ICloseable extends AutoCloseable {
    @Override
    void close() throws Exception;
}
