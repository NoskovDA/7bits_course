package ru.sevenbits.noskov.codeFormatter.formatter;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.IWriter;

/**
 * Formatter interface.
 */
public interface IFormatter {
    /**
     * Format code.
     *
     * @param reader - object implemented IReader.
     * @param writer - object implemented IWriter.
     * @throws FormatterException when something goes wrong​
     */
    void format(IReader reader, IWriter writer) throws FormatterException;
}
