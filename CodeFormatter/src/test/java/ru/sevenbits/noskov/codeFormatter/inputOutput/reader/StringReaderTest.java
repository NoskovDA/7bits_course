package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringReaderTest {

    @Test
    public void simpleTest() {
        try {
            StringReader stringReader = new StringReader("string");
            StringBuilder stringBuilder = new StringBuilder();
            while (stringReader.hasNext()) {
                stringBuilder.append(stringReader.read());
            }
            assertEquals(stringBuilder.toString(),"string");
        } catch (ReaderException e) {
            fail(e.getMessage());
        }
    }
}
