package net.yoonaxes.auth.security.encryption;

import net.yoonaxes.auth.util.EncryptUtil;

public class EncryptionSecurity {

    private int log_rounds;

    public EncryptionSecurity(int log_rounds) {
        this.log_rounds = log_rounds;
    }

    public String encrypt(String password) {
        return EncryptUtil.encrypt(log_rounds, password);
    }

    public boolean check(String plain, String password) {
        return EncryptUtil.check(plain, password);
    }
}
