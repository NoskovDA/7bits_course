package ru.sevenbits.Noskov.codeFormatter.formatter;

import ru.sevenbits.Noskov.codeFormatter.InputOutput.reader.IReader;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.reader.ReaderException;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.writer.IWriter;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.writer.WriterException;

public class Formatter {

    public static void format(IReader reader, IWriter writer) throws FormatterException {
        final int TAB_SIZE = 4;
        try {
            int tabLevel = 0;

            char current = ' ';
            while (reader.isAvailable()) {
                if (tabLevel < 0) {
                    tabLevel = 0;
                }

                char previous = current;
                current = (char)reader.read();
                switch (current) {
                    case '{':
                        for (int i = 0; i < tabLevel * TAB_SIZE; i++) {
                            writer.write(' ');
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
