package ru.sevenbits.Noskov.codeFormatter.InputOutput.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ConsoleWriter implements IWriter{
    private BufferedWriter bufferedWriter;

    public ConsoleWriter() {
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public void write(char c) throws WriterException {
        try {
            bufferedWriter.write(c);
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

    @Override
    public void close() throws IOException {
        bufferedWriter.close();
    }

}
