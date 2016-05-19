package comgmail.alexchebotov.formatter.reader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by protomint on 5/18/16.
 */
public interface IReader {

    /**
     * Read data from source by "bufferSize" portions
     * @param stream - stream from the source
     * @param bufferSize - size of the portion in bits
     * @return symbols by symbols extracted from the data portions
     * @throws IOException
     */
    byte[] read(final InputStream stream, int bufferSize) throws IOException;

}