package ru.sevenbits.noskov.codeFormatter.formatter;

import ru.sevenbits.noskov.codeFormatter.formatter.Lexer.ILexer;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.IWriter;

/**
 * Formatter interface.
 */
public interface IFormatter {
    /**
     * Format code.
     *
     * @param lexer - object implemented ILexer.
     * @param writer - object implemented IWriter.
     * @throws FormatterException when something goes wrong​
     */
    void format(ILexer lexer, IWriter writer) throws FormatterException;
}
