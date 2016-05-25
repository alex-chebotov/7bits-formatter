package comgmail.alexchebotov.formatter.reader;

/**
 * All exceptions caught gets inside ReaderException and goes ahead
 */
class ReaderException extends Exception {

    ReaderException(String string, final Throwable e) {
        super(string, e);
    }
}
