package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.fail;

public class FileReaderTest {
    @Test
    public void simpleTest(){
        try {
            FileReader fileReader = new FileReader(Paths.get("example/inputFile.java"));
            while (fileReader.hasNext()) {
                System.out.println(fileReader.read()); //придумать как сравнить
            }
        } catch (ReaderException e) {
            fail(e.getMessage());
        }
    }
}
