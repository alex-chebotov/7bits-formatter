package comgmail.alexchebotov.formatter.Formatter;

/**
 * Created by protomint on 5/18/16.
 */
public class Formatter implements IFormatter {

    public char[] format(char dataStreamInput) {

        char[]characterSet;
        char[] markCurly = {'{' , '\n' , ' ' , ' ' , ' ' , ' '};
        char[] markEndOfLine = {';' , '\n'};
        char[] markDefault = {dataStreamInput};

        char character = dataStreamInput;

        switch (character) {

            case '{':
                characterSet = markCurly;
//                System.out.println(mark);
                break;

            case ';':
                characterSet = markEndOfLine;
//                System.out.println(mark);
                break;

            default:
                characterSet = markDefault;
                break;

        }

        //System.out.println(mark);

        return characterSet;

    }
}
