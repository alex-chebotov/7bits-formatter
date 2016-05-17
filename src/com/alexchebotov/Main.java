package com.alexchebotov;

import com.alexchebotov.Formatter.Formatter;
import com.alexchebotov.Processor.Processor;

import java.io.*;

public class Main {

    private static File fileIn;
    private static File fileOut;
    private static int bufSize;


    public static void main(String[] args) throws IOException {

        fileIn = new File("/home/protomint/JavaProjects/7bits/format/someJavaCodeInput.java");
        fileOut = new File("/home/protomint/JavaProjects/7bits/format/someJavaCodeOutput.java");

        bufSize = 1024;

        InputStream in = new FileInputStream(fileIn);
        OutputStream out = new FileOutputStream(fileOut);
        Formatter formatter = new Formatter();

        Processor processor = new Processor(in, out, formatter, bufSize);
        processor.process();

    }
}