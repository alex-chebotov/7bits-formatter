package comgmail.alexchebotov.formatter;

import com.sun.corba.se.spi.legacy.interceptor.UnknownType;
import comgmail.alexchebotov.formatter.reader.ReaderException;
import comgmail.alexchebotov.formatter.reader.ReaderFile;
import comgmail.alexchebotov.formatter.reader.ReaderString;
import comgmail.alexchebotov.formatter.writer.FileWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Takes a source file or string, decides what a method going to be invoked to read chunk of data from them,
 * then picks what a formatting style going to be implemented, finally formatted data pass to be written in file.
 * @param <T1> permit to use different sources whether binary or text.
 */
public class Handler<T1> {

    private T1 source;
    private T1 destination;
    private static String style;
    private int bufferSize;
    private List<String> stringList;
    private String dataStreamStringOutput;

    /**
     * Class constructor. See JavaDoc for Class Handler
     * @param source - file or string which data to be transformed
     * @param destination - file in which transformed data to be written
     * @param formatStyle - formatting style, for instance, "Java"
     * @param bufSize - data portions reader would take at a time
     * @throws UnknownType
     */
    public Handler(final T1 source, final T1 destination, final String formatStyle, final int bufSize) throws UnknownType {

        this.source = source;
        this.destination = destination;
        style = formatStyle;
        bufferSize = bufSize;
    }

    /**
     * Perform Handler class purpose
     * @throws IOException
     * @throws UnknownType
     * Most likely it would better split up this (class) method two class with one interface or use generics for source types
     */
    public void process() throws IOException, UnknownType {

        byte[] dataStreamInput;
        byte[] dataStreamOutput;
        String characterSet;
        ReaderFile readerFile = null;
        ReaderString readerString = null;

        if (this.source.getClass() == File.class) {

            readerFile = new ReaderFile();
            readerFile.createStream((File) source);

        } else if (this.source.getClass() == String.class) {

            readerString = new ReaderString();
            readerString.createStream((String) source);

        } else {

            System.out.println("Unknown source type");
            throw new UnknownType();

        }

        FileWriter fileWriter = new FileWriter();
        fileWriter.createStream((File) destination);

//        if (style.equals("Java")) {
//
//            formatter formatter = new formatter();
//
//        } else {
//
//            formatter formatter = new formatter();
//        }

        Formatter formatter = new Formatter();
        formatter.dictionaryInitialize();

        while (true) {

            try {

                dataStreamStringOutput = "";

                if (this.source.getClass() == File.class) {

                    dataStreamInput = readerFile.read(bufferSize);

                } else if (this.source.getClass() == String.class) {

                    dataStreamInput = readerString.read(bufferSize);

                } else {

                    System.out.println("Unknown source type");
                    throw new UnknownType();

                }

                for (byte item : dataStreamInput) {

                    if (item == '\0') {

                        break;

                    }

                    stringList = new ArrayList<String>();

                    characterSet = formatter.format((char) item);

                    stringList.add(characterSet);

                    for (String s : stringList) {

                        dataStreamStringOutput += s;

                    }

                }

                dataStreamOutput = new String(dataStreamStringOutput).getBytes();

                fileWriter.write(dataStreamOutput);

            } catch (ReaderException e) {

                System.out.println("reached end of file: " + source);

                fileWriter.closeStream();

                if (this.source.getClass() == File.class) {

                    readerFile.closeStream();
                    break;

                } else if (this.source.getClass() == String.class) {

                    readerString.closeStream();
                    break;

                } else {

                    throw new UnknownType("Unknown source type");

                }

            }

        }

    }

}
