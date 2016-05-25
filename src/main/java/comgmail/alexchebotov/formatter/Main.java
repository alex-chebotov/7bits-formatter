package comgmail.alexchebotov.formatter;

import comgmail.alexchebotov.formatter.reader.ReaderException;
import comgmail.alexchebotov.formatter.reader.ReaderFile;
import comgmail.alexchebotov.formatter.reader.ReaderString;
import comgmail.alexchebotov.formatter.writer.WriterException;
import comgmail.alexchebotov.formatter.writer.WriterFile;
import comgmail.alexchebotov.formatter.writer.WriterString;

import java.io.File;


/**
 * The package performs formatting a set of symbols from an incoming stream accordingly to specific rules
 * into an outcoming set of symbols.
 * Incoming stream is provided by "reader" package from a sources Files or Strings.
 * The stream gets passed "formatter" to cut out or add in some symbols.
 * The Formatted stream gets passed "writer" to be written in destination object File or String.
 */
final class Main {

    private Main() {

    }

    private static File fileIn;
    private static File fileOut;
    private static String stringIn;
    private static String stringOut;

    /**
     *
     * @param args
     */
    public static void main(final String[] args) {

        fileIn = new File("/home/protomint/JavaProjects/7bits/Formatter/someJavaCodeInput.txt");
        fileOut = new File("/home/protomint/JavaProjects/7bits/Formatter/someJavaCodeOutput.txt");
        stringIn = "while(inputStream.hasNext()){char symbol = inputStream.read();if (symbol == \"\"){whiteSpaceCount++;}}000000000000000555555555555555555;";

        ReaderFile readerFile = null;
        ReaderString readerString = null;
        WriterFile writerFile = null;
        WriterString writerString = null;
        Formatter formatter;

        try {

            readerFile = new ReaderFile();
            readerFile.createStream(fileIn);

            readerString = new ReaderString();
            readerString.createStream(stringIn);

        } catch (ReaderException e) {

            System.out.println(e);

        }

        try {

            writerFile = new WriterFile();
            writerFile.createStream(fileOut);

            writerString = new WriterString();

        } catch (WriterException e) {

            System.out.println(e);
        }

        try {

            formatter = new Formatter(readerFile, writerFile);
            formatter.dictionaryInitialize();
            formatter.format();

            formatter = new Formatter(readerString, writerString);
            formatter.dictionaryInitialize();
            formatter.format();
            stringOut = writerString.getData();
            System.out.println(stringOut);

        } catch (FormatterException e) {

            System.out.println(e);
        }
    }
}
