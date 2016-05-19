package comgmail.alexchebotov.formatter.Reader;

import java.io.*;

/**
 * Created by protomint on 5/18/16.
 */
public class FileReader implements IReader {

    /**
     * Create InputStream object
     * @param fileIn - a file provided by "Handler" which "Reader" takes data from
     * @return InputStream stream object
     * @throws FileNotFoundException
     */
    public InputStream createStream(final File fileIn) throws FileNotFoundException {

        return new FileInputStream(fileIn);

    }

    /**
     * Read data from source by "bufferSize" portions
     * @param stream - stream from the source
     * @param bufferSize - size of the portion in bits
     * @return symbols by symbols extracted from the data portions
     * @throws IOException
     */
    public char read(final InputStream stream, int bufferSize) throws ReaderException, IOException {

        byte[] buffer = new byte[bufferSize];

        char character = ' ';

        int stopByte;

        stopByte = stream.read(buffer);

        if (stopByte == -1) {

            throw new ReaderException();

        }

        for (byte item : buffer) {

            character = (char) item;

        }

        //System.out.println(character);

        return character;

    }

    /**
     * Close stream source
     * @param stream to close
     * @throws IOException
     */
    public void closeStream(final InputStream stream) throws IOException {

        stream.close();

    }

}
