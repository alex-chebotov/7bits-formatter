package com.alexchebotov.Writer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by protomint on 5/16/16.
 */
public interface IWriter {

    void write(OutputStream out, byte[]dataStreamOutput) throws IOException;

}
