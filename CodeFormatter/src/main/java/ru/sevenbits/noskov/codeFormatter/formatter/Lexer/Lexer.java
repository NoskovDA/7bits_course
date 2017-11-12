package ru.sevenbits.noskov.codeFormatter.formatter.Lexer;

import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.StringWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

public class Lexer implements ILexer {
    private StringWriter writer;

    @Override
    public String disassemble(IReader reader) throws ReaderException, WriterException {
            char current;
            while (reader.hasNext()) {
                current = reader.read();
                switch (current) {
                    case '{':
                        writer.write(current);
                        return writer.getString();

                    case '}':
                        writer.write(current);
                        return writer.getString();

                    case ';':
                        writer.write(current);
                        return writer.getString();

                    default:
                        writer.write(current);
                        break;
                }
            }
            return writer.getString();
    }
}
