package comgmail.alexchebotov.formatter.reader;

import java.io.*;

/**
 * Reads data from File source by "bufferSize" portions and returns array of bytes
 */
public class ReaderFile implements IReader {

    private Reader stream;
    private int character;
    private boolean isEndOfFile = false;

    /**
     * Create InputStream object
     * @throws ReaderException
     */
    public void createStream(final File source) throws ReaderException {

        try {

            this.stream = new InputStreamReader(new FileInputStream(source), "utf-8");

        } catch (IOException e) {

            throw new ReaderException("Some issue to create Reader's stream", e);

        }
    }

    /**
     * Reads character by character from file and returns one character at a time
     * @return one character
     * @throws ReaderException
     */
    public char read() throws ReaderException {

        try {

            character = this.stream.read();

            if (character == -1) {

                isEndOfFile = true;

            }

            return (char) character;

        } catch (IOException e) {

            throw new ReaderException("Some issue to read from source", e);
        }
    }

    public boolean isEndOfSource() {

        return isEndOfFile;

    }

    /**
     * Close stream source
     * @throws IOException
     */
    public void closeStream() throws ReaderException {

        try {

            this.stream.close();

        } catch (IOException e) {

            throw new ReaderException("Some issue with Reader's stream", e);
        }
    }
}
