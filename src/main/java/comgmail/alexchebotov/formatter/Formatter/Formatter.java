package comgmail.alexchebotov.formatter.Formatter;

/**
 * Created by protomint on 5/18/16.
 */
public class Formatter implements IFormatter {

    public char format(char dataStreamInput) {

        char character = dataStreamInput;
        char mark;

        switch (character) {

            case '{':
                mark = '{' + '\\' + 'n';
//                System.out.println(mark);
                break;

            case ';':
                mark = '\\' + 'n';
//                System.out.println(mark);
                break;

            default:
                mark = character;
                break;

        }

        //System.out.println(mark);

        return mark;

    }
}
