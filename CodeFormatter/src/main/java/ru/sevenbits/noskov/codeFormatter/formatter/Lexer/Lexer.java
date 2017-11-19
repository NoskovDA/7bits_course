package ru.sevenbits.noskov.codeFormatter.formatter.Lexer;

import ru.sevenbits.noskov.codeFormatter.formatter.Token.IToken;
import ru.sevenbits.noskov.codeFormatter.formatter.Token.Token;
import ru.sevenbits.noskov.codeFormatter.formatter.Token.TokenException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;

public class Lexer implements ILexer {
    private IReader reader;
    private char current;


    public Lexer(IReader reader) throws ReaderException {
        this.reader = reader;
        current = reader.read();
    }

    @Override
    public IToken readToken() throws ReaderException, TokenException {
        char previous = 0; //null in utf8
        int stop = 1;
        StringBuilder stringBuilder = new StringBuilder();
        do {

            if ((previous == 0 || previous == '\n') && (current == ' ')) {
                int i =0;
                previous = current;
                while (reader.hasNext() && current == ' ') {
                    current = reader.read();
                    stringBuilder.append(previous);
                }
                System.out.println(stringBuilder.length());
                return new Token("spaces at the beginning of the line", stringBuilder);
            }

            if (previous == 0) {
                if (current == '{') {
                    previous = current;
                    if (reader.hasNext()) {
                        current = reader.read();
                    }
                    return new Token("opening brace", new StringBuilder().append(previous));
                } else {
                    if (current == '}') {
                        previous = current;
                        if (reader.hasNext()) {
                            current = reader.read();
                        }
                        return new Token("closing brace", new StringBuilder().append(previous));
                    } else {
                        if (current == ';') {
                            previous = current;
                            if (reader.hasNext()) {
                                current = reader.read();
                            }
                            return new Token("semicolon", new StringBuilder().append(previous));
                        } else {
                            if (current == '\n') {
                                previous = current;
                                if (reader.hasNext()) {
                                    current = reader.read();
                                }
                                return new Token("new line", new StringBuilder().append(previous));

                            }
                        }
                    }
                }
            }

            if (current == '{' || current == '}' || current == ';' || current == '\n') { //change to map
                return new Token("something", stringBuilder) ;
            }

            previous = current;
            stringBuilder.append(previous);


            if (reader.hasNext()) {
                current = reader.read();
            } else {
                if (stop == 0) {
                    current = 0;
                }
                stop--;
            }
        } while (reader.hasNext());
        return new Token("something",stringBuilder);
    }

    @Override
    public boolean hasMoreTokens() {
        return reader.hasNext() || current != 0;
    }
}
