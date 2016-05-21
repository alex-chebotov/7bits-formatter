package comgmail.alexchebotov.formatter.reader;

import java.io.*;

/**
 * Reads data from File source by "bufferSize" portions and returns array of bytes
 */
public class ReaderFile implements IReader {

    private InputStream stream;
    private File source;

    /**
     * Create InputStream object
     * @throws FileNotFoundException
     */
    public void createStream(final File source) throws FileNotFoundException {

        this.source = source;
        this.stream = new FileInputStream(source);

    }

    /**
     * Read data from source by "bufferSize" portions
     * @param bufferSize - size of the portion in bytes, not null and equals or greater than 1
     * @return symbols by symbols extracted from the data portions
     * @throws IOException
     */
    public byte[] read(int bufferSize) throws ReaderException {

        byte[] buffer = new byte[bufferSize];

        int stopByte;

        try {

            stopByte = this.stream.read(buffer);

            if (stopByte == -1) {

                this.stream.close();
                throw new IOException();

            }

        } catch (IOException e) {

            ReaderException exception = new ReaderException(e);
            throw exception;

        } finally {

            System.out.println("Hi");
            return buffer;

        }



    }

    /**
     * Close stream source
     * @throws IOException
     */
    public void closeStream() throws IOException {

        this.stream.close();

    }

}
