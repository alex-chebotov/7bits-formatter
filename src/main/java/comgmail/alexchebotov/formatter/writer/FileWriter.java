package comgmail.alexchebotov.formatter.writer;

import java.io.*;

/**
 * Takes bytes array and writes into specific file
 */
public class FileWriter implements IWriter {

    OutputStream stream;

    /**
     * Create OutputStream object
     * @param fileOut - a file provided by "handler" which "writer" write data into
     * @return OutputStream stream object
     * @throws FileNotFoundException
     */
    public void createStream(final File fileOut) throws FileNotFoundException {

        this.stream = new FileOutputStream(fileOut);
    }


    public void write(byte[] dataStreamOutput) throws IOException {

        this.stream.write(dataStreamOutput);

    }

    public void closeStream() throws IOException {

        this.stream.close();

    }

}
