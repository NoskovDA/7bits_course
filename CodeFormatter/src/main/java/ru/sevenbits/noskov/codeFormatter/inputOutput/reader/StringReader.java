package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import org.apache.commons.lang3.StringUtils;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ErrorCodes;

public class StringReader implements IReader {
    private String string;
    private int index;

    public StringReader(String string) throws ReaderException {
        if (StringUtils.isEmpty(string)) {
            throw new ReaderException(ErrorCodes.EMPTY_INPUT_STRING.getErrorString());
        }
        this.string = string;
    }

    @Override
    public char read() throws ReaderException {
       try {
           return string.charAt(index);
       } finally {
           index++;
       }
    }

    @Override
    public boolean hasNext() throws ReaderException {
        return index < string.length();
    }
}
