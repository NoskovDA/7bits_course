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
            String expected = "{\n    {\n        {\n        }\n    }\n}\n;\n;\n;\n{\n}";
            String res = "";
            IReader reader = new StringReader("{{{}}};;;{}");
            IWriter writer = new StringWriter(res);
            Formatter formatter = new Formatter();
            formatter.format(reader, writer);
            assertEquals(expected,res);
        } catch (ReaderException | FormatterException e) {
            fail(e.getMessage());
        }
    }
}
