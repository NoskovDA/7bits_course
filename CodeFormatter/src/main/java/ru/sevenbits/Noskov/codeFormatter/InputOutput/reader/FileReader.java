package ru.sevenbits.Noskov.codeFormatter.InputOutput.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class FileReader implements IReader{
    private FileInputStream fileInputStream;


    public FileReader(Path path) throws ReaderException {
        try {
            fileInputStream = new FileInputStream(path.toFile());
        } catch (FileNotFoundException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public void close() throws IOException {
            fileInputStream.close();
    }

    @Override
    public int read() throws ReaderException {
        try {
            return fileInputStream.read();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public boolean isAvailable() throws ReaderException {
        try {
            return (fileInputStream.available()>0);
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

}
