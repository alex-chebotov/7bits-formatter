package comgmail.alexchebotov.formatter.formatter;

import java.util.HashMap;

/**
 * Created by protomint on 5/18/16.
 */
public class Formatter implements IFormatter {

    private HashMap<String, String> symbolDictionary;


    public Formatter() {

        HashMap symbolDictionary = new HashMap();

        symbolDictionary.put("{", "\n");

    }




    public char[] format(char dataStreamInput) {


        symbolDictionary.put("{", "!");
        String value = symbolDictionary.get("{");
        System.out.println(value);



        char[]characterSet;
        char[] markTab = {' ' , ' ' , ' ' , ' '};
        char[] markCurly = {'{' , '\n'};
        char[] markEndOfLine = {';' , '\n'};
        char[] markDefault = {dataStreamInput};

        char character = dataStreamInput;

        switch (character) {

            case '{':
                characterSet = markCurly;
                break;

            case ';':
                characterSet = markEndOfLine;
                break;

            default:
                characterSet = markDefault;
                break;

        }

        return characterSet;

    }
}
