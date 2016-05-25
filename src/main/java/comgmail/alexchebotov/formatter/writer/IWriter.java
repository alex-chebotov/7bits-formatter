package comgmail.alexchebotov.formatter.writer;

/**
 * Takes a string and writes into destination object
 */
public interface IWriter {

    /**
     * Takes string and writes into destination object
     * @param data to write
     * @throws WriterException
     */
    void write(String data) throws WriterException;

    /**
     * closes source stream
     * @throws WriterException
     */
    void closeStream() throws WriterException;

}
