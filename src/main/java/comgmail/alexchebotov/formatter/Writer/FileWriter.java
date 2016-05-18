package comgmail.alexchebotov.formatter.Writer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by protomint on 5/18/16.
 */
public class FileWriter implements IWriter {


    public void write(OutputStream out, byte[] dataStreamOutput) throws IOException {


        out.write(dataStreamOutput);

    }

    public void closeStream(OutputStream out) throws IOException {

        out.close();

    }

}
