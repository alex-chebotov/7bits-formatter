package comgmail.alexchebotov.formatter.reader;

/**
 * Reads data from a source
 */
public interface IReader {

    /**
     * Reads data from a source and returns one character at a time
     * @return a character extracted from the source
     */
    char read() throws ReaderException;

    boolean isEndOfSource();

    void closeStream() throws ReaderException;

}