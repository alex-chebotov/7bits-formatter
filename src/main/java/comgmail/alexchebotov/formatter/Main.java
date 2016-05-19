package comgmail.alexchebotov.formatter;

import comgmail.alexchebotov.formatter.Handler.Handler;

import java.io.File;
import java.io.IOException;


/**
 * The package perform formatting a set of symbols from an incoming stream accordingly to specific rules
 * into an outcoming set of symbols.
 * Incoming stream is provided by "Reader" package from a sources Files or Strings.
 * The stream gets passed "Formatter" to cut out or add in some symbols.
 * The Formatted stream gets passed "Writer" to be written in destination object File or String.
 * "Handler" manages processes, decide what and can interrupt the process.
 */

public class Main {

    private static File fileIn;
    private static File fileOut;
    private static String stringIn;
    private static String stringOut;
    private static String formatStyle ;

    /**
     * bufferSize - size of buffer in bits that "Reader" can take from the source at a time
     */
    private static int bufferSize;

    public static void main(String[] args) throws IOException {

        fileIn = new File("/home/protomint/JavaProjects/7bits/Formatter/someJavaCodeInput.txt");
        fileOut = new File("/home/protomint/JavaProjects/7bits/Formatter/someJavaCodeOutput.txt");
        stringIn = "while(inputStream.hasNext()){char symbol = inputStream.read();if (symbol == \"\"){whiteSpaceCount++;}}0000000000000000000000000000000;";

        bufferSize = 1;

        formatStyle = "Java";

        Handler handler = new Handler(fileIn, fileOut, formatStyle, bufferSize);
        handler.process();

    }

}
