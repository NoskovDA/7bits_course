package ru.sevenbits.noskov.codeFormatter.formatter;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.IWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

/**
 * Code formatter.
 */
public class Formatter implements IFormatter {

    /**
     * Constructor
     */
    public Formatter(){}

    @Override
    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        final int TAB_SIZE = 4;
        try {
            int tabLevel = 0;

            char current = ' ';
            char previous;
            while (reader.hasNext()) {
                if (tabLevel < 0) {
                    tabLevel = 0;
                }
                previous = current;
                current = reader.read();
                switch (current) {
                    case '{':
                        if (previous == '\n') {
                            for (int i = 0; i < tabLevel * TAB_SIZE; i++) {
                                writer.write(' ');
                            }
                        }
                        writer.write(current);
                        writer.write('\n');
                        current = '\n';
                        tabLevel++;

                        break;

                    case '}':
                        tabLevel--;
                        if (previous != '\n') {
                            writer.write('\n');
                        }
                        for (int i = 0; i < tabLevel * TAB_SIZE; i++) {
                            writer.write(' ');
                        }
                        writer.write(current);
                        writer.write('\n');
                        current = '\n';
                        break;

                    case ';':
                        writer.write(current);
                        writer.write('\n');
                        current = '\n';
                        break;

                    default:
                        if (previous == '\n') {
                            for (int i = 0; i < tabLevel * TAB_SIZE; i++) {
                                writer.write(' ');
                            }
                        }
                        writer.write(current);
                        break;
                }
            }

        } catch (WriterException e) {
            throw new FormatterException(e);
        } catch (ReaderException e) {
            throw new FormatterException(e);
        }
    }
}
