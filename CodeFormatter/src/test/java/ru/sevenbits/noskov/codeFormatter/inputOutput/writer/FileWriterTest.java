package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.Assert.fail;

public class FileWriterTest {
    @Test
    public void simpleTest() {
        try {
            String s = "string";
            FileWriter fileWriter = new FileWriter(Paths.get("example/inputFile.java"));
            for (int i=0; i<s.length(); i++) {
                fileWriter.write(s.charAt(i));
            }
        } catch (WriterException e) {
            fail(e.getMessage());
        }

    }
}
