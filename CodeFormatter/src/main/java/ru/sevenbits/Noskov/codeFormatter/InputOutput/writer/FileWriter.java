package ru.sevenbits.Noskov.codeFormatter.InputOutput.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileWriter implements IWriter{
    private FileOutputStream fileOutputStream;

    public FileWriter(Path path) throws WriterException {
        try {
            fileOutputStream = new FileOutputStream(path.toFile());
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

    @Override
    public void write(char c) throws WriterException {
        try {
            fileOutputStream.write(c);
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}
