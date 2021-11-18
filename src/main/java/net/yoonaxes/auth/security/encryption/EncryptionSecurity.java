package net.yoonaxes.auth.security.encryption;

import net.yoonaxes.auth.util.EncryptUtil;

public class EncryptionSecurity {

    private final Integer log_rounds = 12; //TODO: Make configurable (Fix NullPointerException)

    public String encrypt(String password) {
        return EncryptUtil.encrypt(log_rounds, password);
    }

    public boolean check(String plain, String password) {
        return EncryptUtil.check(plain, password);
    }
}
