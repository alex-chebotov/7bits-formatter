package com.alexchebotov.Formatter;

/**
 * Created by protomint on 5/17/16.
 */
public class Formatter implements IFormatter {

    public byte[] format(byte[] dataStreamInput) {

        String tab = "";

        // int stack = 0;

        StringBuffer sb = new StringBuffer();


        for (byte character : dataStreamInput) {

            // System.out.println(character);

            if (character == '{') {

                tab = tab + "    ";

                sb.append("{\n" + tab);
                //stack = 0;
                // sb.append("{\n");
                // int index = sb.length();
                // sb.setLength(index + 4);

            } else if (character == ';') {

                sb.append(";\n" + tab);
                //stack = 0;
                // sb.append("{\n");
                // int index = sb.length();
                // sb.setLength(index + 4);

            } else if (character == '}') {

                int index = sb.length();
                // System.out.println(index);
                tab = tab.substring(0, tab.length() - 4);
                sb.append("\n" + tab);
                //sb.insert(index - 4, "}");
                sb.append("}");
                // System.out.println(index);
                //stack = 0;

            } else if (character == 0) {

                //stack = stack + 1;

            } else {

                sb.append(((char) character));
                //stack = 0;

            }

        }

        String dataStreamOutputString = sb.toString();

        byte[] dataStreamOutput = dataStreamOutputString.getBytes();

        // System.out.println("Hi4!");

        System.out.println(dataStreamOutputString);

        return dataStreamOutput;
    }

}
