package ru.sevenbits.noskov.codeFormatter;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class MainTest {
    @Test
    public void fileToFileTest() {
        String[] args = new String[4];
        args[0] = "-f";
        args[1] = "/example/inputFile.java";
        args[2] = "-f";
        args[3] = "/example/outputFile.java";
        Main.main(args);
    }

    @Test
    public void fileToConsoleTest() {
        String[] args = new String[3];
        args[0] = "-f";
        args[1] = "/example/inputFile.java";
        args[2] = "-c";
        Main.main(args);
    }

    @Test
    public void consoleToConsoleTest() {
        String[] args = new String[2];
        args[0] = "-c";
        args[1] = "-c";
        Main.main(args);
    }
}
