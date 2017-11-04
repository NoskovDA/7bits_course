package ru.sevenbits.noskov.codeFormatter.inputOutput;

import org.junit.Test;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ConsoleReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.FileReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.ConsoleWriterTest;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.FileWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ReaderAndWriterTest {
    @Test
    public void fileToFileTest(){
        String[] args = new String[4];
        args[0] = "-f";
        args[1] = "example/inputFile.java";
        args[2] = "-f";
        args[3] = "example/outputFile.java";

        try {
            ReaderAndWriter readerAndWriter = new ReaderAndWriter(args);
            assertEquals(readerAndWriter.getReader().getClass(), FileReader.class);
            assertEquals(readerAndWriter.getWriter().getClass(), FileWriter.class);
        } catch (ReaderAndWriterException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void fileToConsoleTest(){
        String[] args = new String[3];
        args[0] = "-f";
        args[1] = "example/inputFile.java";
        args[2] = "-c";

        try {
            ReaderAndWriter readerAndWriter = new ReaderAndWriter(args);
            assertEquals(readerAndWriter.getReader().getClass(), FileReader.class);
            assertEquals(readerAndWriter.getWriter().getClass(), ConsoleWriterTest.class);
        } catch (ReaderAndWriterException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void consoleToConsoleTest(){
        String[] args = new String[2];
        args[0] = "-c";
        args[1] = "-c";

        try {
            ReaderAndWriter readerAndWriter = new ReaderAndWriter(args);
            assertEquals(readerAndWriter.getReader().getClass(), ConsoleReader.class);
            assertEquals(readerAndWriter.getWriter().getClass(), ConsoleWriterTest.class);
        } catch (ReaderAndWriterException e) {
            fail(e.getMessage());
        }
    }


    @Test
    public void consoleToFile(){
        String[] args = new String[3];
        args[0] = "-c";
        args[1] = "-f";
        args[2] = "example/inputFile.java";

        try {
            ReaderAndWriter readerAndWriter = new ReaderAndWriter(args);
            assertEquals(readerAndWriter.getReader().getClass(), ConsoleReader.class);
            assertEquals(readerAndWriter.getWriter().getClass(), FileWriter.class);
        } catch (ReaderAndWriterException e) {
            fail(e.getMessage());
        }

    }
}
