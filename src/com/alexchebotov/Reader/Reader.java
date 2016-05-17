package com.alexchebotov.Reader;

import java.io.*;

/**
 * Created by protomint on 5/16/16.
 */
public class Reader implements IReader {

    public byte[] read(InputStream in, int bufSize) throws IOException {

        byte[] buf = new byte[bufSize];

        byte[] stopStream = new byte[0];

        int stopByte;

        stopByte = in.read(buf);

        if (stopByte <= 0) {

            buf = stopStream;

        }

        return buf;

    }

    public void closeStream(InputStream in) throws IOException {

        in.close();

    }

}