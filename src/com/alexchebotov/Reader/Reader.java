package com.alexchebotov.Reader;

import java.io.*;

/**
 * Created by protomint on 5/16/16.
 */
public class Reader implements IReader {

/*    private static File fileIn;

    private static InputStream fileStream;


    public Reader(File file) throws FileNotFoundException {

        fileIn = file;

        InputStream fileStream = new FileInputStream(fileIn);

    }*/

    public byte[] read(InputStream in, int bufSize) throws IOException {

        byte[] buf = new byte[bufSize];

        byte[] stopStream = new byte[0];

        int stopByte;

        stopByte = in.read(buf);

        // System.out.println("Hi!");
        // System.out.println(stopByte);

        if (stopByte <= 0) {

            buf = stopStream;

        }

        return buf;

    }


    public void closeStream(InputStream in) throws IOException {

        in.close();

    }




    // Path file = Paths.get("/home/protomint/JavaProjects/7bits/7bits-checkstyle.xml");

/*    public byte[] read(File fileIn, byte[] buf) throws IOException {

*//*        InputStream fileStream = new FileInputStream(fileIn);

        java.io.Reader fileReader = new InputStreamReader(fileStream, "utf-8");

        BufferedReader reader = new BufferedReader(fileReader);

        return reader.readLine();*//*



*//*        Path file = Paths.get("/home/protomint/JavaProjects/7bits/7bits-checkstyle.xml");

        try (InputStream in = Files.newInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            String line = null;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);

                break;
            }

        } catch (IOException x) {

            System.err.println(x);
        }*//*


*//*        Path file = Paths.get("/home/protomint/JavaProjects/7bits/7bits-checkstyle.xml");

        try (InputStream in = Files.newInputStream(file);

             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            int character;

            while ((character = reader.read()) != -1) {

                System.out.println((char) character);

                break;
            }

        } catch (IOException x) {

            System.err.println(x);
        }*//*


        // File fileIn = new File("/home/protomint/JavaProjects/7bits/7bits-checkstyle.xml");



        InputStream fileStream = new FileInputStream(fileIn);

        java.io.Reader fileReader = new InputStreamReader(fileStream, "utf-8");

        BufferedReader reader = new BufferedReader(fileReader);



        return reader.read

    }




*//*    public void close() {

    }*//*

}*/

}