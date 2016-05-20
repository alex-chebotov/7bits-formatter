package comgmail.alexchebotov.formatter.writer;

import java.io.IOException;

/**
 * Created by protomint on 5/18/16.
 */
public interface IWriter {

    void write(byte[] dataStreamOutput) throws IOException;

}
