package comgmail.alexchebotov.formatter.reader;

import java.io.*;

/**
 * Reads data from File source and returns one character at a time
 */
public class ReaderFile implements IReader {

    private Reader stream;
    private int character;
    private boolean isEndOfFile = false;  // if true - source has reached the end, false otherwise

    /**
     * Create/open stream of source file
     * @param source - a file to read data from
     * @throws ReaderException - any exception will be caught and passed a caller
     */
    public void createStream(final File source) throws ReaderException {

        try {
            this.stream = new InputStreamReader(new FileInputStream(source), "utf-8");
        } catch (IOException e) {
            throw new ReaderException("Some issue to create Reader's stream" + source.toString(), e);
        }
    }

    /**
     * Reads character by character from file and returns one character at a time until the source gets its end
     * @return one character extracted from the source
     * @throws ReaderException - any exception will be caught and passed a caller
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

    /**
     * checks whether source has reached the end
     * @return true if reached, false otherwise
     */
    public boolean isEndOfSource() {
        return isEndOfFile;
    }

    /**
     * Closes stream source
     * @throws ReaderException - any exception will be caught and passed a caller
     */
    public void closeStream() throws ReaderException {
        try {
            this.stream.close();
        } catch (IOException e) {
            throw new ReaderException("Some issue with Reader's stream", e);
        }
    }
}
