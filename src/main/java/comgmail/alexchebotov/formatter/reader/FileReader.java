package comgmail.alexchebotov.formatter.reader;

import java.io.*;

/**
 * Created by protomint on 5/18/16.
 */
public class FileReader implements IReader {

    /**
     * Create InputStream object
     * @param fileIn - a file provided by "handler" which "reader" takes data from
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
    public byte[] read(final InputStream stream, int bufferSize) throws ReaderException, IOException {

        byte[] buffer = new byte[bufferSize];

        int stopByte;

        stopByte = stream.read(buffer);

        if (stopByte == -1) {

            throw new ReaderException();

        }

        return buffer;
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
