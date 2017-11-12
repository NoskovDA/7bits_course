package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class StringWriterTest {
    @Test
    public void simpleTest() {
        try {
            String s = "string;";
            StringWriter stringWriter = new StringWriter();
            for (int i=0; i<s.length(); i++) {
                stringWriter.write(s.charAt(i));
            }
            assertEquals(s,stringWriter.toString());
        }  catch (WriterException e) {
            fail(e.getMessage());
        }

    }
}
