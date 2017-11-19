package ru.sevenbits.noskov.codeFormatter.formatter;

import ru.sevenbits.noskov.codeFormatter.formatter.Lexer.ILexer;
import ru.sevenbits.noskov.codeFormatter.formatter.Token.IToken;
import ru.sevenbits.noskov.codeFormatter.formatter.Token.Token;
import ru.sevenbits.noskov.codeFormatter.formatter.Token.TokenException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.IWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

import java.util.Objects;

/**
 * Code formatter.
 */
public class Formatter implements IFormatter {

    /**
     * Constructor
     */
    public Formatter(){}

    @Override
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException {
        final int TAB_SIZE = 4;
        try {
            int tabLevel = 0;

            IToken currentToken = null;
            IToken previousToken;
            IToken newLineToken = new Token("new line", new StringBuilder().append('\n'));
            while (lexer.hasMoreTokens()) {
                if (tabLevel < 0) {
                    tabLevel = 0;
                }

                previousToken = currentToken;
                currentToken = lexer.readToken();

                 if (Objects.equals(currentToken.getName(), "opening brace")) {
                     if (previousToken != null && "new line".equals(previousToken.getName())) {
                         for (int i = 0; i < tabLevel * TAB_SIZE; i++) {
                             writer.write(' ');
                         }
                     }
                     for (int i = 0; i < currentToken.getLexeme().length(); i++) {
                         writer.write(currentToken.getLexeme().charAt(i));
                     }
                     writer.write('\n');
                     currentToken = newLineToken;
                     tabLevel++;
                 }
                 else {
                     if (Objects.equals(currentToken.getName(), "closing brace")) {
                         tabLevel--;
                         if (previousToken != null && !Objects.equals(previousToken.getName(), "new line")) {
                             writer.write('\n');
                         }
                         for (int i = 0; i < tabLevel * TAB_SIZE; i++) {
                             writer.write(' ');
                         }
                         for (int i = 0; i < currentToken.getLexeme().length(); i++) {
                             writer.write(currentToken.getLexeme().charAt(i));
                         }
                         writer.write('\n');
                         currentToken = newLineToken;
                     }
                     else {
                         if (Objects.equals(currentToken.getName(), "semicolon")) {
                             for (int i = 0; i < currentToken.getLexeme().length(); i++) {
                                 writer.write(currentToken.getLexeme().charAt(i));
                             }
                             writer.write('\n');
                             currentToken = newLineToken;
                         }
                         else{
                             if (previousToken != null && "new line".equals(previousToken.getName())) {
                                 for (int i = 0; i < tabLevel * TAB_SIZE; i++) {
                                     writer.write(' ');
                                 }
                             }
                             for (int i = 0; i < currentToken.getLexeme().length(); i++) {
                                 writer.write(currentToken.getLexeme().charAt(i));
                             }
                         }
                     }
                 }
            }
        } catch (WriterException e) {
            throw new FormatterException(e);
        } catch (ReaderException e) {
            throw new FormatterException(e);
        } catch (TokenException e) {
            throw new FormatterException(e);
        }
    }
}
