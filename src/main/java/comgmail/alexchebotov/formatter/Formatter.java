package comgmail.alexchebotov.formatter;

import comgmail.alexchebotov.formatter.reader.IReader;
import comgmail.alexchebotov.formatter.writer.IWriter;


import java.util.HashMap;

/**
 * Handles streams and implements specific formatting rules over input data. Takes one character at a time
 */
class Formatter {

    private IReader reader;
    private IWriter writer;
    private HashMap<String, String> symbolDictionary;
    private String dataOutput;
    private char dataInput;
    private int tabCounter;
    private String tabSign;
    private String markDefault;

    /**
     * Class constructor
     * @param reader - stream of input data, File or String
     * @param writer - stream of output data, File or String
     */
    Formatter(final IReader reader, final IWriter writer) {

        this.reader = reader;
        this.writer = writer;
        this.symbolDictionary = new HashMap();  // describes specific formatting rules
        this.tabCounter = 0;    // counts how much times tabulation sign must be added
    }

    /**
     * Initialize set of formatting rules
     */
    void dictionaryInitialize() {

        this.symbolDictionary.put("{" , "{\n");
        this.symbolDictionary.put("}" , "\n");
        this.symbolDictionary.put(";" , ";\n");
        this.symbolDictionary.put("tab" , "    ");
    }

    /**
     * Handles streams and implements specific formatting rules over input data. Takes one character at a time
     * Return nothing
     * @throws FormatterException - all exceptions caught in the method gets inside FormatterException and goes ahead
     */
    void format() throws FormatterException {

        while (true) {
            try {
                dataOutput = "";
                dataInput = reader.read();
                if (reader.isEndOfSource()) {
                    reader.closeStream();
                    break;
                }
            } catch (Exception e) {
                throw new FormatterException(e);
            }
            markDefault = String.valueOf(dataInput);

            switch (dataInput) {
                case '{':
                    tabCounter++;
                    tabSign = new String(new char[tabCounter]).replace("\0", symbolDictionary.get("tab"));
                    dataOutput = symbolDictionary.get("{") + tabSign;
                    break;

                case ';':
                    dataOutput = symbolDictionary.get(";") + tabSign;
                    break;

                case '}':
                    tabCounter--;
                    tabSign = new String(new char[tabCounter]).replace("\0", symbolDictionary.get("tab"));
                    dataOutput = symbolDictionary.get("}") + tabSign + "}";
                    break;

                default:
                    dataOutput = markDefault;
                    break;
            }

            try {
                writer.write(dataOutput);
                //System.out.println(characterSet);
            } catch (Exception e) {
                throw new FormatterException(e);
            }
        }

        try {
            writer.closeStream();
        } catch (Exception e) {
            throw new FormatterException(e);
        }
    }
}
