package comgmail.alexchebotov.formatter.writer;

/**
 * Takes bytes array and writes into specific file
 */
public interface IWriter {

    void write(String data) throws WriterException;

    void closeStream() throws WriterException;

}
