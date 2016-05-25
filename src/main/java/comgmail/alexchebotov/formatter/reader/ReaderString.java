package comgmail.alexchebotov.formatter.reader;

import java.io.*;

/**
 * Reads data from String source symbol by symbol and returns one character at a time
 */
public class ReaderString implements IReader {

    private Reader stream;
    private int character;
    private boolean isEndOfSource = false; // if true - source has reached the end, false otherwise

    /**
     * Create stream of source file
     * @param source - a string to read from
     * @throws ReaderException -  - any exception will be caught and passed a caller
     */
    public void createStream(final String source) throws ReaderException {
        try {
            this.stream = new StringReader(source);
        } catch (Exception e) {
            throw new ReaderException("Some issue to create Reader's stream for string: " + source, e);
        }
    }

    /**
     * Reads character by character from string and returns one character at a time until the source gets its end
     * @return one character extracted from the source
     * @throws ReaderException any exception will be caught and passed a caller
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

    /**
     * checks whether source has reached the end
     * @return true if reached, false otherwise
     */
    public boolean isEndOfSource() {

        return isEndOfSource;
    }

    /**
     * Closes stream source
     * @throws ReaderException -  - any exception will be caught and passed a caller
     */
    public void closeStream() throws ReaderException {

        try {
            this.stream.close();
        } catch (IOException e) {
            throw new ReaderException("Some issue with Reader's stream", e);
        }
    }
}
