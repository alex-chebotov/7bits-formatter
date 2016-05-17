package com.alexchebotov.Reader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by protomint on 5/16/16.
 */
public interface IReader {

    byte[] read(InputStream in, int bufSize) throws IOException;

}
