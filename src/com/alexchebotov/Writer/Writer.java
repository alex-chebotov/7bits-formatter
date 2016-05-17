package com.alexchebotov.Writer;

import java.io.*;

/**
 * Created by protomint on 5/16/16.
 */
public class Writer implements IWriter {

/*    private static File fileOut;

    private static OutputStream fileStream;

    public Writer(File file) throws FileNotFoundException {

        fileOut = file;

        OutputStream fileStream = new FileOutputStream(fileOut);

    }*/

    public void write(OutputStream out, byte[] dataStreamOutput) throws IOException {

        // System.out.println("Hi5!");

        out.write(dataStreamOutput);

    }

    public void closeStream(OutputStream out) throws IOException {

        out.close();

    }


/*    private File fileOut = new File("/home/protomint/JavaProjects/7bits/7bits-checkstyle.xml");

    OutputStream fileStream = new FileOutputStream(fileOut);

    Writer fileWriter = new OutputStreamWriter(fileStream, "utf-8");

    PrintWriter printWriter = new PrintWriter(fileWriter);

    printWriter.println("hello");*/

}
