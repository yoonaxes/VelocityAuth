package net.yoonaxes.auth.command;

public class ValidateException extends RuntimeException {

    public ValidateException(String message, boolean stackPrintTrace) {
        super(message, null, false, stackPrintTrace);
    }

    public ValidateException(String message) {
        this(message, false);
    }
}
