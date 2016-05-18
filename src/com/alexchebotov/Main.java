package com.alexchebotov;

import com.alexchebotov.Formatter.Formatter;
import com.alexchebotov.Processor.Processor;

import java.io.*;

public class Main {

    private static File fileIn;
    private static File fileOut;
    private static int bufSize;


    public static void main(String[] args) throws IOException {

        fileIn = new File("/home/protomint/JavaProjects/7bits/CodeFormatter/someJavaCodeInput.txt");
        fileOut = new File("/home/protomint/JavaProjects/7bits/CodeFormatter/someJavaCodeOutput.txt");

        bufSize = 1024;

        InputStream in = new FileInputStream(fileIn);
        OutputStream out = new FileOutputStream(fileOut);
        Formatter formatter = new Formatter();

        Processor processor = new Processor(in, out, formatter, bufSize);
        processor.process();

    }
}