package comgmail.alexchebotov.formatter;

import com.sun.corba.se.spi.legacy.interceptor.UnknownType;
import comgmail.alexchebotov.formatter.formatter.Formatter;
import comgmail.alexchebotov.formatter.reader.FileReader;
import comgmail.alexchebotov.formatter.reader.ReaderException;
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
//    private T2 stringIn;
//    private T2 stringOut;
    private static String style;
    private Formatter formatter;
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
        FileReader fileReader;
        FileWriter fileWriter;
        InputStream streamIn;
        OutputStream streamOut;

        if (this.source.getClass() == File.class) {

            System.out.println("File--------------------------------------------------");

            fileReader = new FileReader();
            streamIn = fileReader.createStream((File) source);

            fileWriter = new FileWriter();
            streamOut = fileWriter.createStream((File) destination);

//        } else if (this.source.getClass() == String.class) {
//
//            fileReader = new FileReader();
//            InputStreamReader streamIn = fileReader.createStream((String) source);
//
//            fileWriter = new FileWriter();
//            OutputStream streamOut = fileWriter.createStream((File) destination);

        } else {

            System.out.println("Unknown source type");
            throw new UnknownType();

        }


        Formatter formatter = new Formatter();
        formatter.dictionaryInitialize();

//        if (style.equals("Java")) {
//
//            formatter formatter = new formatter();
//
//        } else {
//
//            formatter formatter = new formatter();
//        }

        while (true) {

            try {

                dataStreamStringOutput = "";

                dataStreamInput = fileReader.read(streamIn, bufferSize);

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

                    //System.out.println(dataStreamStringOutput);

                }

                dataStreamOutput = new String(dataStreamStringOutput).getBytes();

                fileWriter.write(streamOut, dataStreamOutput);

            } catch (ReaderException e) {

                System.out.println("reached end of file: " + source);

                fileWriter.closeStream(streamOut);
                fileReader.closeStream(streamIn);

            }

        }

    }

}
