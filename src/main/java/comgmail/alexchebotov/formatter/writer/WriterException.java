package comgmail.alexchebotov.formatter.writer;

/**
 * All exceptions caught gets inside WriterException and goes ahead
 */
class WriterException extends Exception {

    WriterException(String string, final Throwable e) {
        super(string, e);
    }
}
