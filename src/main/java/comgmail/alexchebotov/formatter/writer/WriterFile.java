package comgmail.alexchebotov.formatter.writer;

import java.io.*;

/**
 * Takes a string and writes into specific file
 */
public class WriterFile implements IWriter {

    private Writer stream;

    /**
     * Create/open stream of destination file
     * @param destination - a file to write data into
     * @throws WriterException - any exception will be caught and passed a caller
     */
    public void createStream(final File destination) throws WriterException {
        try {
            this.stream = new OutputStreamWriter(new FileOutputStream(destination), "utf-8");
        } catch (IOException e) {
            throw new WriterException("", e);
        }
    }

    /**
     * Takes a string and writes into the destination. Returns nothing
     * @param data to write
     * @throws WriterException - any exception will be caught and passed a caller
     */
    public void write(final String data) throws WriterException {

        try {
            this.stream.write(data);
        } catch (IOException e) {
            throw new WriterException("", e);
        }
    }

    /**
     * Closes stream destination
     * @throws WriterException - any exception will be caught and passed a caller
     */
    public void closeStream() throws WriterException {

        try {
            this.stream.close();
        } catch (IOException e) {
            throw new WriterException("", e);
        }
    }
}
