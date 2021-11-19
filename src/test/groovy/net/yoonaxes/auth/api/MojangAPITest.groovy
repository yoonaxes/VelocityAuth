package net.yoonaxes.auth.api

import groovy.test.GroovyAssert
import org.junit.jupiter.api.Test

class MojangAPITest extends GroovyAssert {

    var id = "c1ef23e8278d4a88a4b312cd68442235"
    var username = "yoonaxes"

    @Test
    void 'get premium id by username' () {
        assertEquals(new MojangAPI().getId(username), id)
    }

    @Test
    void 'check username is premium account' () {
        assertTrue(new MojangAPI().isPremiumAccount(username))
    }
}
