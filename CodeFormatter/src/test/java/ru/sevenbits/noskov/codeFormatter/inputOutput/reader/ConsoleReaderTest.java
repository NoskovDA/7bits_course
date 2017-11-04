package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import org.junit.Test;

import static org.junit.Assert.fail;

public class ConsoleReaderTest {
    @Test
    public void simpleTest() {
        ConsoleReader consoleReader = new ConsoleReader();
        try {
            System.out.println(consoleReader.read());
            consoleReader.close();
        } catch (ReaderException | Exception e) {
            fail(e.getMessage());
        }

    }
}
