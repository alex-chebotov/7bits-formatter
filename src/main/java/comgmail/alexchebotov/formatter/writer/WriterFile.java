package comgmail.alexchebotov.formatter.writer;

import java.io.*;

/**
 * Takes bytes array and writes into specific file
 */
public class WriterFile implements IWriter {

    Writer stream;

    /**
     * Create OutputStream object
     * @param fileOut - a file provided by "handler" which "writer" write data into
     * @return OutputStream stream object
     * @throws WriterException
     */
    public void createStream(final File fileOut) throws WriterException {

        try {

            this.stream = new OutputStreamWriter(new FileOutputStream(fileOut), "utf-8");

        } catch (IOException e) {

            throw new WriterException(e);

        }
    }


    public void write(String data) throws WriterException {

        try {

            this.stream.write(data);

        } catch (IOException e) {

            throw new WriterException(e);

        }
    }

    public void closeStream() throws WriterException {

        try {

            this.stream.close();

        } catch (IOException e) {

            throw new WriterException(e);
        }
    }
}
