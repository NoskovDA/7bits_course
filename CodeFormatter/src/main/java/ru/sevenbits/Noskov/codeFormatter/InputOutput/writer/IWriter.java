package ru.sevenbits.Noskov.codeFormatter.InputOutput.writer;

import java.io.Closeable;

public interface IWriter extends Closeable{
    void write(char c) throws WriterException;
}
