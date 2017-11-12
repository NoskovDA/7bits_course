package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

/**
 * Writer to string.
 */
public class StringWriter implements IWriter {
    private StringBuilder stringBuilder;

    /**
     * Constructor
     */
    public StringWriter() {
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void write(final char c) throws WriterException {
        stringBuilder.append(c);
    }

    public String getString() {
        return stringBuilder.toString();
    }
}
