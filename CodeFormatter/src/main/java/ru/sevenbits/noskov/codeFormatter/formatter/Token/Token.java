package ru.sevenbits.noskov.codeFormatter.formatter.Token;

import org.apache.commons.lang3.StringUtils;

public class Token implements IToken{
    private String name;
    private StringBuilder lexeme;

    public Token(String name, StringBuilder lexeme) throws TokenException {
        if (StringUtils.isEmpty(name)){
            throw new TokenException("Name is empty");
        }
        this.name = name;
        this.lexeme = lexeme;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public StringBuilder getLexeme() {
        return lexeme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLexeme(StringBuilder lexeme) {
        this.lexeme = lexeme;
    }
}
