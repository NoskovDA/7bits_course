package ru.sevenbits.noskov.codeFormatter.inputOutput;

import org.apache.commons.lang3.StringUtils;
import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.*;

import java.io.Closeable;
import java.nio.file.Paths;

public class ReaderFactory {
    public static CloseableReader getReader(String readerParameter) throws FactoryException {
        if (StringUtils.isEmpty(readerParameter)) {
            throw new FactoryException(ErrorCodes.EMPTY_INPUT_STRING.getErrorString());
        }

        if (readerParameter.equals(Parameters.CONSOLE.getParameter())) {
            try {
                return new ConsoleReader();
            } catch (ReaderException e) {
                throw new FactoryException(e);
            }
        } else {
            try {
                return new FileReader(Paths.get(readerParameter));
            } catch (ReaderException e) {
                throw new FactoryException(e);
            }
        }
    }
}
