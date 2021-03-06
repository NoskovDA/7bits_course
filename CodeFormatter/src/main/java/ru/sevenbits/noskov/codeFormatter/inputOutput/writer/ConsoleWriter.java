package ru.sevenbits.noskov.codeFormatter.inputOutput.writer;

import ru.sevenbits.noskov.codeFormatter.inputOutput.CloseableWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.ErrorCodes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Writer to console.
 */
public class ConsoleWriter implements CloseableWriter {
    private BufferedWriter bufferedWriter;

    /**
     * Constructor.
     *
     */
    public ConsoleWriter() {
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public void write(final char c) throws WriterException {
        try {
            bufferedWriter.write(c);
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

    @Override
    public void close() throws WriterException {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new WriterException(ErrorCodes.STREAM_WRITER_NOT_CLOSED.getErrorString().concat(ConsoleWriter.class.getSimpleName()), e);
        }
    }

}
