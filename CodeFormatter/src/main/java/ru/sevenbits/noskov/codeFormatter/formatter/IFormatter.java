package ru.sevenbits.noskov.codeFormatter.formatter;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.IWriter;

public interface IFormatter {
    /**
     * Format code.
     *
     * @param reader - object implemented IReader.
     * @param writer - object implemented IWriter.
     * @throws FormatterException
     */
    void format(final IReader reader, final IWriter writer) throws FormatterException;
}
