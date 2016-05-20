package comgmail.alexchebotov.formatter;

import com.sun.corba.se.spi.legacy.interceptor.UnknownType;
import comgmail.alexchebotov.formatter.formatter.Formatter;
import comgmail.alexchebotov.formatter.reader.*;
import comgmail.alexchebotov.formatter.reader.ReaderFile;
import comgmail.alexchebotov.formatter.reader.ReaderString;
import comgmail.alexchebotov.formatter.writer.FileWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by protomint on 5/18/16.
 */
public class Handler<T1> {

    private T1 source;
    private T1 destination;
    private static String style;
    private int bufferSize;
    List<String> stringList;
    String dataStreamStringOutput;

    public Handler(T1 source, T1 destination, final String formatStyle , int bufSize) throws UnknownType {

        this.source = source;
        this.destination = destination;
        style = formatStyle;
        bufferSize = bufSize;
    }

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

                    System.out.println("File--------------------------------------------------");
                    readerFile.closeStream();

                } else if (this.source.getClass() == String.class) {

                    readerString.closeStream();

                } else {

                    System.out.println("Unknown source type");
                    throw new UnknownType();

                }

            }

        }

    }

}
