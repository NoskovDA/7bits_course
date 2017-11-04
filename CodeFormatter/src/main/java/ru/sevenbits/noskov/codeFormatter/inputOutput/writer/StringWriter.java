package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

public class StringWriter implements IWriter {
    private StringBuilder stringBuilder;

    public StringWriter(final String string) {
        this.stringBuilder = new StringBuilder(string);
    }

    @Override
    public void write(final char c) throws WriterException {
        stringBuilder.append(c);
    }
}
