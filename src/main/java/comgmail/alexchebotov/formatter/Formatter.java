package comgmail.alexchebotov.formatter;

import java.util.HashMap;

/**
 * Implements specific formatting rules over input data. Takes one character at a time
 */
public class Formatter {

    private HashMap<String, String> symbolDictionary  = new HashMap();
    private String characterSet;
    private int tabCounter = 0;
    private String tabSign;

    /**
     * Initialize set of formatting rules
     */
    public void dictionaryInitialize() {

        symbolDictionary.put("{" , "{\n");
        symbolDictionary.put("}" , "\n");
        symbolDictionary.put(";" , ";\n");
        symbolDictionary.put("tab" , "    ");

    }

//    public void dictionarySetKeyValue(String key, String value) {
//
//        symbolDictionary.put(key , value);
//    }

    /**
     * Takes one character at a time and return string object
     * @param dataStreamInput - char
     * @return - string
     */
    public String format(final char dataStreamInput) {

        char character = dataStreamInput;
        String markDefault = String.valueOf(dataStreamInput);

        switch (character) {

            case '{':
                tabCounter++;
                tabSign = new String(new char[tabCounter]).replace("\0", symbolDictionary.get("tab").toString());
                characterSet = symbolDictionary.get("{").toString() + tabSign;
                break;

            case ';':
                characterSet = symbolDictionary.get(";").toString() + tabSign;
                break;

            case '}':
                tabCounter--;
                tabSign = new String(new char[tabCounter]).replace("\0", symbolDictionary.get("tab").toString());
                characterSet = symbolDictionary.get("}").toString() + tabSign + "}";
                break;

            default:
                characterSet = markDefault;
                break;

        }

        return characterSet;

    }
}
