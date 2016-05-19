package comgmail.alexchebotov.formatter.Handler;

import comgmail.alexchebotov.formatter.Formatter.Formatter;
import comgmail.alexchebotov.formatter.Reader.FileReader;
import comgmail.alexchebotov.formatter.Reader.ReaderException;
import comgmail.alexchebotov.formatter.Writer.FileWriter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by protomint on 5/18/16.
 */
public class Handler implements IHandler {

    private File fileIn;
    private File fileOut;
    private static String style;
    private Formatter formatter;
    private int bufferSize;

    public Handler(File sourceIn, File sourceOut, final String formatStyle , int bufSize) {

        fileIn = sourceIn;
        fileOut = sourceOut;
        style = formatStyle;
        bufferSize = bufSize;

    }

    public void process() throws IOException {

        byte[] dataStreamInput;
        byte[] dataStreamOutput;
        char[] characterSet = new char[0];


        FileReader fileReader = new FileReader();
        InputStream streamIn = fileReader.createStream(fileIn);

        FileWriter fileWriter = new FileWriter();
        OutputStream streamOut = fileWriter.createStream(fileOut);

        Formatter formatter = new Formatter();

//        if (style.equals("Java")) {
//
//            Formatter formatter = new Formatter();
//
//        } else {
//
//            Formatter formatter = new Formatter();
//        }

        while (true) {

            try {

                dataStreamInput = fileReader.read(streamIn, bufferSize);

                for (byte item : dataStreamInput) {

                    characterSet = formatter.format((char) item);
                }

                dataStreamOutput = new String(characterSet).getBytes();

                fileWriter.write(streamOut, dataStreamOutput);

            } catch (ReaderException e) {

                System.out.println("reached end of file: " + fileIn);

                fileWriter.closeStream(streamOut);
                fileReader.closeStream(streamIn);

            }

        }

    }

}
