package comgmail.alexchebotov.formatter.writer;

/**
 * Takes strings, concatenates them and writes into another string
 */
public class WriterString implements IWriter {

    private StringBuilder stringBuilder = new StringBuilder();

    /**
     * Takes strings, concatenates them with high efficient way
     * @param data to write
     * @throws WriterException - any exception will be caught and passed a caller
     */
    public void write(final String data) throws WriterException {
        stringBuilder.append(data);
    }

    /**
     * Return concateneted strings
     * @return string
     */
    public String getData() throws WriterException {
        try {
            return stringBuilder.toString();
        } catch (Exception e) {
            throw new WriterException("Cannot return: " + stringBuilder.toString(), e);
        }

    }

    /**
     * Closes stream destination
     * @throws WriterException - any exception will be caught and passed a caller
     */
    public void closeStream() throws WriterException {
    }
}
