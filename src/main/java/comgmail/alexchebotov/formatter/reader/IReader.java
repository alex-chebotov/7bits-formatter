package comgmail.alexchebotov.formatter.reader;

/**
 * Reads data from a source
 */
public interface IReader {

    /**
     * Reads data from a source and returns one character at a time
     * @return a character extracted from the source
     * @throws ReaderException
     */
    char read() throws ReaderException;

    /**
     * checks whether source has reached the end
     * @return true if reached, false otherwise
     */
    boolean isEndOfSource();

    /**
     * closes source stream
     * @throws ReaderException
     */
    void closeStream() throws ReaderException;

}