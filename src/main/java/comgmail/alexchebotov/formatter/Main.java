package comgmail.alexchebotov.formatter;

import com.sun.corba.se.spi.legacy.interceptor.UnknownType;

import java.io.File;
import java.io.IOException;


/**
 * The package perform formatting a set of symbols from an incoming stream accordingly to specific rules
 * into an outcoming set of symbols.
 * Incoming stream is provided by "reader" package from a sources Files or Strings.
 * The stream gets passed "formatter" to cut out or add in some symbols.
 * The Formatted stream gets passed "writer" to be written in destination object File or String.
 * "handler" manages processes, decide what and can interrupt the process.
 */

public class Main {

    private static File fileIn;
    private static File fileOut;
    private static String stringIn;
    private static String formatStyle ;

    /**
     * bufferSize - size of buffer in bits that "reader" can take from the source at a time
     */
    private static int bufferSize;

    public static void main(String[] args) throws IOException, UnknownType {

        fileIn = new File("/home/protomint/JavaProjects/7bits/Formatter/someJavaCodeInput.txt");
        fileOut = new File("/home/protomint/JavaProjects/7bits/Formatter/someJavaCodeOutput.txt");
        stringIn = "while(inputStream.hasNext()){char symbol = inputStream.read();if (symbol == \"\"){whiteSpaceCount++;}}000000000000000555555555555555555;";

        bufferSize = 1;

        formatStyle = "Java";

        Handler handlerFile = new Handler(fileIn, fileOut, formatStyle, bufferSize);
        handlerFile.process();

        Handler handlerString = new Handler(stringIn, fileOut, formatStyle, bufferSize);
        handlerString.process();

    }

}
