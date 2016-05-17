package com.alexchebotov;

import com.alexchebotov.Formatter.Formatter;
import com.alexchebotov.Processor.Processor;
import com.alexchebotov.Reader.Reader;
import com.alexchebotov.Writer.Writer;

import java.io.*;

public class Main {

    private static File fileIn;
    private static File fileOut;
    private static Reader reader;
    private static Writer writer;
    private static Formatter formatter;
    private static int bufSize;


    public static void main(String[] args) throws IOException {


//        fileIn = new File("/home/protomint/JavaProjects/7bits/7bits-checkstyle.xml");
//        fileOut = new File("/home/protomint/JavaProjects/7bits/7bits-checkstyle_.xml");

        fileIn = new File("/home/protomint/JavaProjects/7bits/format/someJavaCodeInput.java");
        fileOut = new File("/home/protomint/JavaProjects/7bits/format/someJavaCodeOutput.java");

        bufSize = 1024;

//        reader = new Reader(fileIn);
//        writer = new Writer(fileOut);
//        formatter = new Formatter();

        InputStream in = new FileInputStream(fileIn);
        OutputStream out = new FileOutputStream(fileOut);


//        Processor processor = new Processor(reader, writer, formatter, bufSize);
        Processor processor = new Processor(in, out, formatter, bufSize);
        processor.process();

    }
}