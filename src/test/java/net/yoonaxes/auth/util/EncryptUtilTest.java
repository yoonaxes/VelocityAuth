package net.yoonaxes.auth.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptUtilTest {

    final String password = getClass().getSimpleName() + getClass().getFields().length;

    @Test
    void encrypt() {
        assertNotNull(EncryptUtil.encrypt(12, password));
    }

    @Test
    void check() {
        assertTrue(EncryptUtil.check(password, EncryptUtil.encrypt(password)));
    }
}