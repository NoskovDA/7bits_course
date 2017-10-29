package ru.sevenbits.noskov.codeFormatter.inputOutput.reader;

import java.io.IOException;
import java.util.Scanner;

/**
 * Reader from console.
 */
public class ConsoleReader implements IReader {
    private Scanner scanner;

    /**
     * Constructor.
     */
    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public char read() throws ReaderException {
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
