package comgmail.alexchebotov.formatter;

import comgmail.alexchebotov.formatter.reader.IReader;
import comgmail.alexchebotov.formatter.reader.ReaderException;
import comgmail.alexchebotov.formatter.writer.IWriter;
import comgmail.alexchebotov.formatter.writer.WriterException;

import java.util.HashMap;

/**
 * Implements specific formatting rules over input data. Takes one character at a time
 */
public class Formatter {

    private IReader reader;
    private IWriter writer;
    private HashMap<String, String> symbolDictionary;
    private String dataOutput;
    private char dataInput;
    private int tabCounter;
    private String tabSign;
    String markDefault;


    public Formatter(IReader reader, IWriter writer) {

        this.reader = reader;
        this.writer = writer;
        this.symbolDictionary = new HashMap();
        this.tabCounter = 0;

    }

    /**
     * Initialize set of formatting rules
     */
    public void dictionaryInitialize() {

        this.symbolDictionary.put("{" , "{\n");
        this.symbolDictionary.put("}" , "\n");
        this.symbolDictionary.put(";" , ";\n");
        this.symbolDictionary.put("tab" , "    ");

    }


    public void format() throws FormatterException {

        while (true) {

            try {

                dataOutput = "";

                dataInput = reader.read();

                if (reader.isEndOfSource()) {

                    reader.closeStream();
                    break;
                }

            } catch (ReaderException e) {

                throw new FormatterException(e);

            }

            markDefault = String.valueOf(dataInput);

            switch (dataInput) {

                case '{':
                    tabCounter++;
                    tabSign = new String(new char[tabCounter]).replace("\0", symbolDictionary.get("tab").toString());
                    dataOutput = symbolDictionary.get("{").toString() + tabSign;
                    break;

                case ';':
                    dataOutput = symbolDictionary.get(";").toString() + tabSign;
                    break;

                case '}':
                    tabCounter--;
                    tabSign = new String(new char[tabCounter]).replace("\0", symbolDictionary.get("tab").toString());
                    dataOutput = symbolDictionary.get("}").toString() + tabSign + "}";
                    break;

                default:
                    dataOutput = markDefault;
                    break;

            }

            try {

                writer.write(dataOutput);
                //System.out.println(characterSet);

            } catch (WriterException e) {

                throw new FormatterException(e);

            }
        }

        try {

            writer.closeStream();

        } catch (WriterException e) {

            throw new FormatterException(e);
        }
    }
}
