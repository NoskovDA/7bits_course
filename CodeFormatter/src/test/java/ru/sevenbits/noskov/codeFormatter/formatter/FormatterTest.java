package ru.sevenbits.noskov.codeFormatter.formatter;

import org.junit.Test;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.StringReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.IWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.StringWriter;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class FormatterTest {
    @Test
    public void simpleTest() {
        try {
            String expected = "{\n    {\n        {\n        }\n    }\n}\n;\n;\n;\n{\n}\n";
            StringReader reader = new StringReader("{{{}}};;;{}");
            StringWriter writer = new StringWriter();
            Formatter formatter = new Formatter();
            formatter.format(reader, writer);
            assertEquals(expected,writer.getString());
        } catch (ReaderException | FormatterException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testWitchWords() {
        try {
            String expected =
                    "while (inputStream.hasNext()) {\n" +
                    "    char symbol = inputStream.read();\n" +
                    "    if (symbol == ‘ ‘) {\n" +
                    "        whiteSpaceCount++;\n" +
                    "    }\n" +
                    "}\n";
            StringReader reader = new StringReader("while (inputStream.hasNext()) {char symbol = inputStream.read();if (symbol == ‘ ‘) {whiteSpaceCount++;}}");

            StringWriter writer = new StringWriter();
            Formatter formatter = new Formatter();
            formatter.format(reader, writer);
            assertEquals(expected,writer.getString());
        } catch (ReaderException | FormatterException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIf() {
        try {
            String expected =
                            "if (symbol == ‘ ‘) {\n" +
                            "    whiteSpaceCount++;\n" +
                            "}\n";
            StringReader reader = new StringReader("if (symbol == ‘ ‘) {whiteSpaceCount++;}");

            StringWriter writer = new StringWriter();
            Formatter formatter = new Formatter();
            formatter.format(reader, writer);
            assertEquals(expected,writer.getString());
        } catch (ReaderException | FormatterException e) {
            fail(e.getMessage());
        }
    }

}
