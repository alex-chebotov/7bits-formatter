package comgmail.alexchebotov.formatter.reader;

import java.io.*;

/**
 * Created by protomint on 5/18/16.
 */
public class ReaderFile implements IReader {

    private InputStream stream;

    /**
     * Create InputStream object
     * @throws FileNotFoundException
     */
    public void createStream(final File source) throws FileNotFoundException {

        this.stream = new FileInputStream(source);

    }

    /**
     * Read data from source by "bufferSize" portions
     * @param bufferSize - size of the portion in bits
     * @return symbols by symbols extracted from the data portions
     * @throws IOException
     */
    public byte[] read(int bufferSize) throws ReaderException, IOException {

        byte[] buffer = new byte[bufferSize];

        int stopByte;

        stopByte = this.stream.read(buffer);

        if (stopByte == -1) {

            throw new ReaderException();

        }

        return buffer;
    }

    /**
     * Close stream source
     * @throws IOException
     */
    public void closeStream() throws IOException {

        this.stream.close();

    }

}
