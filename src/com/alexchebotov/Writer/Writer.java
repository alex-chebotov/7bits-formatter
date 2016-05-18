package com.alexchebotov.Writer;

import java.io.*;

/**
 * Created by protomint on 5/16/16.
 */
public class Writer implements IWriter {


    public void write(OutputStream out, byte[] dataStreamOutput) throws IOException {

        // System.out.println("Hi5!");

        out.write(dataStreamOutput);

    }

    public void closeStream(OutputStream out) throws IOException {

        out.close();

    }

}
