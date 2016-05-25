package comgmail.alexchebotov.formatter;

/**
 * All exceptions caught gets inside FormatterException and goes ahead
 */
class FormatterException extends Exception {

    FormatterException(final Throwable e) {
        super(e);
    }
}
