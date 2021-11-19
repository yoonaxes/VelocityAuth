package net.yoonaxes.auth.util

import groovy.test.GroovyAssert
import org.junit.jupiter.api.Test

import static net.yoonaxes.auth.util.EncryptUtil.*

class EncryptUtilTest extends GroovyAssert {

    final String password = getClass().getSimpleName() + getClass().getFields().length;

    @Test
    void 'encrypt password' () {
        assertNotNull(encrypt(10, password));
    }

    @Test
    void 'check encrypted password' () {
        assertTrue(check(password, EncryptUtil.encrypt(password)));
    }
}
