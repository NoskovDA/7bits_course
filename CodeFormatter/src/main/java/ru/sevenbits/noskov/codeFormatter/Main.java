package ru.sevenbits.noskov.codeFormatter;

import ru.sevenbits.noskov.codeFormatter.inputOutput.ReaderAndWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ReaderAndWriterException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.IWriter;
import ru.sevenbits.noskov.codeFormatter.formatter.Formatter;
import ru.sevenbits.noskov.codeFormatter.formatter.FormatterException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

/**
 * Main class.
 */
public class Main {

    /**
     * Main method.
     *
     * @param args - array of arguments.
     */
    public static void main(final String[] args) {
        Logger logger = LoggerFactory.getLogger(ru.sevenbits.noskov.codeFormatter.Main.class);
        try {
            ReaderAndWriter readerAndWriter = new ReaderAndWriter(args);
            IReader reader = readerAndWriter.getReader();
            IWriter writer = readerAndWriter.getWriter();

            Formatter.format(reader, writer);
            try {
                reader.close();
            } catch (IOException e) {
                throw new ReaderException(e);
            }
            try {
                writer.close();
            } catch (IOException e) {
                throw new WriterException(e);
            }
        } catch (ReaderException e) {
            logger.error("Exception while reading.");
        } catch (WriterException e) {
            logger.error("Exception while writing.");
        } catch (FormatterException e) {
            logger.error("Exception while formatting.");
        } catch (ReaderAndWriterException e) {
            logger.error("Exception witch parameters.");

        }
    }
}
