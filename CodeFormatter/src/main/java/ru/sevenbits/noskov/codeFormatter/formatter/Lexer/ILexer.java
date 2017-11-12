package ru.sevenbits.noskov.codeFormatter.formatter.Lexer;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

public interface ILexer {
    String disassemble(IReader reader) throws ReaderException, WriterException;
}
