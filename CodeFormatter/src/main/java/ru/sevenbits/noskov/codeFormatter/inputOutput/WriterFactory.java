package ru.sevenbits.noskov.codeFormatter.inputOutput;

import org.apache.commons.lang3.StringUtils;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.ConsoleWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.FileWriter;
import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.WriterException;

import java.nio.file.Paths;

public class WriterFactory {
    public static CloseableWriter getWriter(String writerParameter) throws FactoryException {
        if (StringUtils.isEmpty(writerParameter)) {
            throw new FactoryException(ErrorCodes.EMPTY_INPUT_STRING.getErrorString());
        }

        if (writerParameter.equals(Parameters.CONSOLE.getParameter())) {
            return new ConsoleWriter();
        } else {
            try {
                return new FileWriter(Paths.get(writerParameter));
            } catch (WriterException e) {
                throw new FactoryException(e);
            }
        }
    }

}
