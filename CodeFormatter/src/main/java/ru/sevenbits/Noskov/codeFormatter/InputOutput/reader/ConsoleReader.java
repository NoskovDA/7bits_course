package ru.sevenbits.Noskov.codeFormatter.InputOutput.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleReader implements IReader{
    private Scanner scanner;
    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int read() throws ReaderException {
        return scanner.next().charAt(0);
    }

    @Override
    public boolean isAvailable() throws ReaderException {
        return scanner.hasNext();
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }
}
