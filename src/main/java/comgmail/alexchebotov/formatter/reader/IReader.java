package comgmail.alexchebotov.formatter.reader;

import java.io.IOException;

/**
 * Created by protomint on 5/18/16.
 */
public interface IReader {

    /**
     * Read data from source by "bufferSize" portions
     * @param bufferSize - size of the portion in bits
     * @return symbols by symbols extracted from the data portions
     * @throws IOException
     */
    byte[] read(int bufferSize) throws IOException;

}