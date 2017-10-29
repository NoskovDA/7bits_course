package ru.sevenbits.Noskov.codeFormatter;

import ru.sevenbits.Noskov.codeFormatter.InputOutput.ReaderAndWriter;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.ReaderAndWriterException;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.reader.IReader;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.writer.IWriter;
import ru.sevenbits.Noskov.codeFormatter.formatter.Formatter;
import ru.sevenbits.Noskov.codeFormatter.formatter.FormatterException;
import java.io.IOException;

public class Main {
    public static void main(final String[] args) {
        try {
            ReaderAndWriter readerAndWriter = new ReaderAndWriter(args);
            IReader reader = readerAndWriter.getReader();
            IWriter writer = readerAndWriter.getWriter();

            Formatter.format(reader, writer);
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ReaderAndWriterException e) {
            e.printStackTrace();
        } catch (FormatterException e) {
            e.printStackTrace();
        }
    }
}
