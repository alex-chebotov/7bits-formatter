package comgmail.alexchebotov.formatter.writer;

import java.io.IOException;

/**
 * Takes bytes array and writes into specific file
 */
public interface IWriter {

    void write(byte[] dataStreamOutput) throws IOException;

}
