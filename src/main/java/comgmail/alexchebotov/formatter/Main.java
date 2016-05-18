package comgmail.alexchebotov.formatter;

import javax.annotation.processing.Processor;
import java.io.*;

/**
 *
 * Format a set of symbols from an incoming stream accordingly to specific rules outcoming a set of symbols stream.
 * Incoming stream is provided by "Reader" package from a sources Files or Strings.
 * Outcoming stream
 *
 *
 * rules you can find in "Formatter" package to
 */
public class Main {

    private static File fileIn;
    private static File fileOut;
    private static String stringIn;
    private static String stringOut;
    private static int bufSize;

    public static void main(String[] args) throws IOException {

        fileIn = new File("/home/protomint/JavaProjects/7bits/CodeFormatter/someJavaCodeInput.txt");
        fileOut = new File("/home/protomint/JavaProjects/7bits/CodeFormatter/someJavaCodeOutput.txt");
        stringIn = "while(inputStream.hasNext()){char symbol = inputStream.read();if (symbol == \"\"){whiteSpaceCount++;}}0000000000000000000000000000000;";

        bufSize = 1024;



    }

}
