package comgmail.alexchebotov.formatter.Writer;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by protomint on 5/18/16.
 */
public class FileWriter implements IWriter {


    /**
     * Create OutputStream object
     * @param fileOut - a file provided by "Handler" which "Writer" write data into
     * @return OutputStream stream object
     * @throws FileNotFoundException
     */
    public OutputStream createStream(final File fileOut) throws FileNotFoundException {

        return new FileOutputStream(fileOut);
    }


    public void write(OutputStream stream, byte[] dataStreamOutput) throws IOException {

        stream.write(dataStreamOutput);

    }

    public void closeStream(OutputStream stream) throws IOException {

        stream.close();

    }

}
