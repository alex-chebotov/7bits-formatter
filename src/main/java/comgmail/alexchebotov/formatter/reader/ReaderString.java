package comgmail.alexchebotov.formatter.reader;

import java.io.*;

/**
 * Created by protomint on 5/18/16.
 */
public class ReaderString<T1> implements IReader {

    private Reader stream;

    /**
     * Create InputStream object
     * @return InputStream stream object
     * @throws FileNotFoundException
     */
    public void createStream(final String source) throws FileNotFoundException {

        this.stream = new StringReader(source);

    }

    /**
     * Read data from source by "bufferSize" portions
     * @param bufferSize - size of the portion in bits
     * @return symbols by symbols extracted from the data portions
     * @throws IOException
     */
    public byte[] read(int bufferSize) throws ReaderException, IOException {

        int character = this.stream.read();

        byte[] characterSet = new byte[] {(byte) character};

        if (character == -1) {

            throw new ReaderException();

        }

        return characterSet;
    }

    /**
     * Close stream source
     * @throws IOException
     */
    public void closeStream() throws IOException {

        this.stream.close();

    }

}
