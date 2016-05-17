package com.alexchebotov.Formatter;

/**
 * Created by protomint on 5/17/16.
 */
public class Formatter implements IFormatter {

    public byte[] format(byte[] dataStreamInput) {

        String tab = "";


        StringBuffer sb = new StringBuffer();


        for (byte character : dataStreamInput) {


            if (character == '{') {

                tab = tab + "    ";

                sb.append("{\n" + tab);

            } else if (character == ';') {

                sb.append(";\n" + tab);

            } else if (character == '}') {

                int index = sb.length();
                tab = tab.substring(0, tab.length() - 4);
                sb.append("\n" + tab);
                sb.append("}");

            } else if (character == 0) {


            } else {

                sb.append(((char) character));

            }

        }

        String dataStreamOutputString = sb.toString();

        byte[] dataStreamOutput = dataStreamOutputString.getBytes();

        return dataStreamOutput;
    }

}
