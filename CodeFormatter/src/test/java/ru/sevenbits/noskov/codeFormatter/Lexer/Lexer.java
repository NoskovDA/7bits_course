package ru.sevenbits.noskov.codeFormatter.Lexer;

import org.junit.Test;
import ru.sevenbits.noskov.codeFormatter.formatter.Lexer.ILexer;
import ru.sevenbits.noskov.codeFormatter.formatter.Token.IToken;
import ru.sevenbits.noskov.codeFormatter.formatter.Token.TokenException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.StringReader;

public class Lexer {
    @Test
    public void simpleTest() throws ReaderException, TokenException {
        String inputString =
                "while (inputStream.hasNext()) {\n" +
                        "    char symbol = inputStream.read();\n" +
                        "    if (symbol == ‘ ‘) {\n" +
                        "        whiteSpaceCount++;\n" +
                        "    }\n" +
                        "}\n";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new ru.sevenbits.noskov.codeFormatter.formatter.Lexer.Lexer(reader);
        IToken token;
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
            System.out.println(token.getName());
            System.out.println(token.getLexeme().toString());
        }
    }
}
