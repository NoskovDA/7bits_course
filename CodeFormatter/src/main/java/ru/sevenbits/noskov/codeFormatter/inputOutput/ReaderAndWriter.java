package ru.sevenbits.noskov.codeFormatter.inputOutput;

import org.apache.commons.lang3.StringUtils;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ConsoleReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.FileReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.ReaderException;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.ConsoleWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.FileWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.IWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

import java.nio.file.Paths;

/**
 * Class line is created by the reader and writer by arguments from command. (Factory pattern)
 */
//Magic numbers
//Too much if
public final class ReaderAndWriter {
    private IReader reader;
    private IWriter writer;

    /**
     *
     * @param args - arguments from command
     * @throws ReaderAndWriterException
     */
    public ReaderAndWriter(final String[] args) throws ReaderAndWriterException {
        if ((args.length < 2) || (args.length > 4)) {
            throw new ReaderAndWriterException(ErrorCodes.WRONGN_NUMBER_PARAMETERS.getErrorString());
        }

        if (args[0].equals(Parameters.FILE.getParameter())) {
            try {
                this.reader = new FileReader(Paths.get(args[1]));
            } catch (ReaderException e) {
                throw new ReaderAndWriterException(e);
            }
            this.writer = getWriter(args, 2);
        } else {
            if (args[0].equals(Parameters.CONSOLE.getParameter())) {
                this.reader = new ConsoleReader();
                this.writer = getWriter(args, 1);
            } else {
                throw new ReaderAndWriterException(ErrorCodes.UNKNOWN_PARAMETER.getErrorString() + ": " + args[0]);
            }
        }
    }

    private static IWriter getWriter(final String[] args, final int position) throws ReaderAndWriterException {
        if (StringUtils.isEmpty(args[position])) {
            throw new ReaderAndWriterException(ErrorCodes.EMTY_PARAMETER.getErrorString());
        }

        if (args[position].equals(Parameters.FILE.getParameter())) {
            if (StringUtils.isEmpty(args[position + 1])) {
                throw new ReaderAndWriterException(ErrorCodes.EMTY_PARAMETER.getErrorString());
            }
            try {
                return new FileWriter(Paths.get(args[position + 1]));
            } catch (WriterException e) {
                throw new ReaderAndWriterException(e);
            }
        } else {
            if (args[position].equals(Parameters.CONSOLE.getParameter())) {
                return new ConsoleWriter();
            } else {
                throw new ReaderAndWriterException(ErrorCodes.UNKNOWN_PARAMETER.getErrorString() + ": " + args[position]);
            }
        }
    }

    public IReader getReader() {
        return reader;
    }

    public IWriter getWriter() {
        return writer;
    }
}
