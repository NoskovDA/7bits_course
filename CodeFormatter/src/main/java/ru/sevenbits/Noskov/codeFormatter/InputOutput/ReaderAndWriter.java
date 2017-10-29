package ru.sevenbits.Noskov.codeFormatter.InputOutput;

import org.apache.commons.lang3.StringUtils;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.reader.ConsoleReader;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.reader.FileReader;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.reader.IReader;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.reader.ReaderException;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.writer.ConsoleWriter;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.writer.FileWriter;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.writer.IWriter;
import ru.sevenbits.Noskov.codeFormatter.InputOutput.writer.WriterException;

import java.nio.file.Paths;

public class ReaderAndWriter {
    private IReader reader;
    private IWriter writer;

    public ReaderAndWriter(String[] args) throws ReaderAndWriterException {
        if ((args.length < 2) || (args.length > 4)){
            throw new ReaderAndWriterException(ErrorCodes.WRONGN_NUMBER_PARAMETERS.getErrorString());
        }

        if (args[0].equals(Parameters.FILE.getParameter())){
            try {
                this.reader = new FileReader(Paths.get(args[1]));
            } catch (ReaderException e) {
                throw new ReaderAndWriterException(e);
            }
            this.writer = getWriter(args, 2);
        } else{
            if (args[0].equals(Parameters.CONSOLE.getParameter())) {
                this.reader = new ConsoleReader();
                this.writer = getWriter(args, 1);
            }else{
                throw new ReaderAndWriterException(ErrorCodes.UNKNOWN_PARAMETER.getErrorString() + ": " + args[0]);
            }
        }
    }

    private static IWriter getWriter(String[] args, int position) throws ReaderAndWriterException {
        if (StringUtils.isEmpty(args[position])){
            throw new ReaderAndWriterException(ErrorCodes.EMTY_PARAMETER.getErrorString());
        }

        if (args[position].equals(Parameters.FILE.getParameter())){
            if (StringUtils.isEmpty(args[position+1])){
                throw new ReaderAndWriterException(ErrorCodes.EMTY_PARAMETER.getErrorString());
            }
            try {
                return new FileWriter(Paths.get(args[position+1]));
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

    private void setReader(IReader reader) {
        this.reader = reader;
    }

    private void setWriter(IWriter writer) {
        this.writer = writer;
    }

    public IReader getReader() {
        return reader;
    }

    public IWriter getWriter() {
        return writer;
    }
}
