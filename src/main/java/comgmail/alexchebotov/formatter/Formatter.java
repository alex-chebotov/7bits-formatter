package comgmail.alexchebotov.formatter;

import java.util.HashMap;

/**
 * Created by protomint on 5/18/16.
 */
public class Formatter {

    HashMap<String, String> symbolDictionary  = new HashMap();
    String characterSet;
    int tabCounter = 0;
    String tabSign;

    public void dictionaryInitialize() {

        symbolDictionary.put("{" , "{\n");
        symbolDictionary.put("}" , "}\n");
        symbolDictionary.put(";" , ";\n");
        symbolDictionary.put("tab" , "    ");

    }

    public void dictionaryRemoveKey(String key) {

        symbolDictionary.remove(key);
    }

    public void dictionarySetKeyValue(String key, String value) {

        symbolDictionary.put(key , value);
    }

    public String format(char dataStreamInput) {

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
                characterSet = symbolDictionary.get("}").toString() + tabSign;
                break;

            default:
                characterSet = markDefault;
                break;

        }

        return characterSet;
    }
}
