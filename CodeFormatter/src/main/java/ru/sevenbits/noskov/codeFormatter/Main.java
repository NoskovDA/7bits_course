//package ru.sevenbits.noskov.codeFormatter;
//
//import ru.sevenbits.noskov.codeFormatter.formatter.IFormatter;
//import ru.sevenbits.noskov.codeFormatter.inputOutput.*;
//import ru.sevenbits.noskov.codeFormatter.inputOutput.reader.IReader;
//import ru.sevenbits.noskov.codeFormatter.inputOutput.writer.IWriter;
//import ru.sevenbits.noskov.codeFormatter.formatter.Formatter;
//import ru.sevenbits.noskov.codeFormatter.formatter.FormatterException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * Main class.
// */
//public class Main {
//
//    /**
//     * Main method.
//     *
//     * @param args - array of arguments.
//     * Example: formatter -f file1.txt -f file2.java (read from file1.txt, write in file2.java)
//     * formatter -c -f file.java (read from console, write to file.java)
//     * formatter -c -c (read from the console and write to the console)
//     */
//    public static void main(final String[] args) {
//        Logger logger = LoggerFactory.getLogger(ru.sevenbits.noskov.codeFormatter.Main.class);
//        try (CloseableReader reader = ReaderFactory.getReader(args[0]);
//             CloseableWriter writer = WriterFactory.getWriter(args[1])){
//
//            IFormatter formatter = new Formatter();
//            formatter.format(reader, writer);
//        } catch (FormatterException e) {
//            logger.error("Exception while formatting.");
//        } catch (FactoryException e) {
//            logger.error("Exception witch parameters.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
