package comgmail.alexchebotov.formatter.Reader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by protomint on 5/18/16.
 */
public class FileReader implements IReader {

    public byte[] read(InputStream in, int bufSize) throws IOException {

        byte[] buf = new byte[bufSize];

        byte[] stopStream = new byte[0];

        int stopByte;

        stopByte = in.read(buf);

        if (stopByte <= 0) {

            buf = stopStream;

        }

        return buf;

    }

    public void closeStream(InputStream in) throws IOException {

        in.close();

    }

}
