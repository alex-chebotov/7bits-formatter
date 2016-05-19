package comgmail.alexchebotov.formatter.Writer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by protomint on 5/18/16.
 */
public interface IWriter {

    void write(OutputStream stream, byte[] dataStreamOutput) throws IOException;

}
