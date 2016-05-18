package comgmail.alexchebotov.formatter.Handler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by protomint on 5/18/16.
 */
public class Handler implements IHandler {

    InputStream readerProcessor;
    OutputStream writerProcessor;
    Formatter formatterProcessor;
    int bufSizeProcessor;

    public Handler(InputStream in, OutputStream out, Formatter formatter, int bufSize) {

        readerProcessor = in;
        writerProcessor = out;
        formatterProcessor = formatter;
        bufSizeProcessor = bufSize;

    }

    public void process() throws IOException {

        byte[] dataStreamInput;
        byte[] dataStreamOutput;

        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        Formatter formatter = new Formatter();

        while (true) {

            dataStreamInput = fileReader.read(readerProcessor, bufSizeProcessor);

            if (dataStreamInput.length > 0) {

                dataStreamOutput = formatter.format(dataStreamInput);

                fileWriter.write(writerProcessor, dataStreamOutput);

            } else {

                break;

            }

        }

        fileWriter.closeStream(writerProcessor);
        fileReader.closeStream(readerProcessor);

    }

}
