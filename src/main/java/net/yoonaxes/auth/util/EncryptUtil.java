package net.yoonaxes.auth.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.Validate;

import static org.mindrot.jbcrypt.BCrypt.*;

@UtilityClass
public class EncryptUtil {

    private final Integer DEFAULT_LOG_ROUNDS = 12;

    public String encrypt(int log_rounds, String password) {
        Validate.notNull(password, "Password to encrypt can't be null.");
        Validate.isTrue(log_rounds > 10 && log_rounds < 30, "To encrypt LOG_ROUNDS value must be between 10 and 30.");

        return hashpw(password, gensalt(log_rounds));
    }

    public boolean check(String plain, String hashed) {
        Validate.notNull(plain, "Plain string to check can't be null.");
        Validate.notNull(hashed, "Hashed string to check can't be null.");

        return checkpw(plain, hashed);
    }

    public String encrypt(String password) {
        return encrypt(DEFAULT_LOG_ROUNDS, password);
    }
}
