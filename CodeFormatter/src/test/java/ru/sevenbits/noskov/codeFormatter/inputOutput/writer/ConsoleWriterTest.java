package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

import org.junit.Test;

import static org.junit.Assert.fail;

public class ConsoleWriterTest {
    @Test
    public void simpleTest() {
        ConsoleWriter consoleWriter = new ConsoleWriter();
        String s = "qwerty";
        try {
            for (int i=0; i<s.length(); i++) {
                consoleWriter.write(s.charAt(i));
        }
        consoleWriter.close();
        } catch (WriterException e) {
            fail(e.getMessage());
        }
    }
}
