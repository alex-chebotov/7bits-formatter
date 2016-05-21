package comgmail.alexchebotov.formatter.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Reads data from String source symbol by symbol and returns array of bytes
 */
public class ReaderString implements IReader {

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
    public byte[] read(int bufferSize) throws ReaderException {

        byte[] characterSet = null;

        try {

            int character = this.stream.read();

            characterSet = new byte[] {(byte) character};

            if (character == -1) {

                throw new IOException();

            }

        } catch (IOException e) {

                throw new ReaderException(e);
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
