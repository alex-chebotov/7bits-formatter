package comgmail.alexchebotov.formatter.reader;

import java.io.*;

/**
 * Reads data from String source symbol by symbol and returns array of bytes
 */
public class ReaderString implements IReader {

    private Reader stream;
    private int character;
    private boolean isEndOfSource = false;

    /**
     * Create InputStream object
     * @return InputStream stream object
     * @throws ReaderException
     */
    public void createStream(final String source) throws ReaderException {

        try {

            this.stream = new StringReader(source);

        } catch (Exception e) {

            throw new ReaderException("Some issue to create Reader's stream for" + source.toString(), e);

        }
    }

    /**
     * Read data from source by "bufferSize" portions
     * @return symbols by symbols extracted from the data portions
     * @throws ReaderException
     */
    public char read() throws ReaderException {

        try {

            character = this.stream.read();

            if (character == -1) {

                isEndOfSource = true;

            }

            return (char) character;

        } catch (IOException e) {

            throw new ReaderException("Some issue to read from source", e);
        }
    }


    public boolean isEndOfSource() {

        return isEndOfSource;

    }

    /**
     * Close stream source
     * @throws ReaderException
     */
    public void closeStream() throws ReaderException {

        try {

            this.stream.close();

        } catch (IOException e) {

            throw new ReaderException("Some issue with Reader's stream", e);
        }
    }

}
