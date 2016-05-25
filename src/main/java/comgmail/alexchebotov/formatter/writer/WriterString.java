package comgmail.alexchebotov.formatter.writer;

/**
 * Created by protomint on 5/18/16.
 */
public class WriterString implements IWriter {

    StringBuilder stringBuilder = new StringBuilder();

    public void write(String data) throws WriterException {

        stringBuilder.append(data);

    }

    public String getData() {

        return stringBuilder.toString();

    }

    public void closeStream() throws WriterException {

    }

}
