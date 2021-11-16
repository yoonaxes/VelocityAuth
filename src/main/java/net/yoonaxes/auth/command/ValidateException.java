package net.yoonaxes.auth.command;

public class ValidateException extends RuntimeException {

    public ValidateException(String message) {
        super(message, null, false, false);
    }
}
