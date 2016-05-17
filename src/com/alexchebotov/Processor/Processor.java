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

/*    Reader readerProcessor;
    Writer writerProcessor;
    Formatter formatterProcessor;
    int bufSizeProcessor;


    public Processor(Reader reader, Writer writer, Formatter formatter, int bufSize) {

        readerProcessor = reader;
        writerProcessor = writer;
        formatterProcessor = formatter;
        bufSizeProcessor = bufSize;

    }*/


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

        // dataStream = reader.read(readerProcessor, bufSizeProcessor);

        // System.out.println(dataStream);

        // long num = 55555;

        while (true) {

            dataStreamInput = reader.read(readerProcessor, bufSizeProcessor);

            // System.out.println(dataStream);
            //System.out.println(dataStream.length);

            if (dataStreamInput.length > 0) {

                // System.out.println("Hi2!");

                dataStreamOutput = formatter.format(dataStreamInput);

                // System.out.println("Hi3!");

                writer.write(writerProcessor, dataStreamOutput);

            } else {

                break;

            }

            // num--;

        }

        writer.closeStream(writerProcessor);
        reader.closeStream(readerProcessor);

    }

}
