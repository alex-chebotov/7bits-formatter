package comgmail.alexchebotov.formatter.reader;

import java.io.IOException;

/**
 * Reads data from source (binary or text) by "bufferSize" portions and returns array of bytes
 */
public interface IReader {

    /**
     * Read data from source by "bufferSize" portions and return array of bytes
     * @param bufferSize - size of the portion in bytes
     * @return array of bytes extracted from the source
     * @throws IOException
     */
    byte[] read(int bufferSize) throws ReaderException;

}