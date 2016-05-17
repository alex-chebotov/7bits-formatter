package com.alexchebotov.Processor;

import com.alexchebotov.Formatter.Formatter;
import com.alexchebotov.Reader.Reader;
import com.alexchebotov.Writer.Writer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by protomint on 5/17/16.
 */
public class Processor implements IProcessor{

    InputStream readerProcessor;
    OutputStream writerProcessor;
    Formatter formatterProcessor;
    int bufSizeProcessor;

    public Processor(InputStream in, OutputStream out, Formatter formatter, int bufSize) {

        readerProcessor = in;
        writerProcessor = out;
        formatterProcessor = formatter;
        bufSizeProcessor = bufSize;

    }

    public void process() throws IOException {

        byte[] dataStreamInput;
        byte[] dataStreamOutput;

        Reader reader = new Reader();
        Writer writer = new Writer();
        Formatter formatter = new Formatter();

        while (true) {

            dataStreamInput = reader.read(readerProcessor, bufSizeProcessor);

            if (dataStreamInput.length > 0) {

                dataStreamOutput = formatter.format(dataStreamInput);

                writer.write(writerProcessor, dataStreamOutput);

            } else {

                break;

            }

        }

        writer.closeStream(writerProcessor);
        reader.closeStream(readerProcessor);

    }

}
