package ru.sevenbits.noskov.codeFormatter.formatter.Lexer;

import ru.sevenbits.noskov.codeFormatter.formatter.Token.IToken;
import ru.sevenbits.noskov.codeFormatter.formatter.Token.TokenException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;

public interface ILexer {
    IToken readToken() throws ReaderException, TokenException;
    boolean hasMoreTokens();
}
