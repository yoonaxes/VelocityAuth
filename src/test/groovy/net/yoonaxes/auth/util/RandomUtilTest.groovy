package net.yoonaxes.auth.util

import groovy.test.GroovyAssert
import org.junit.jupiter.api.Test

class RandomUtilTest extends GroovyAssert {

    @Test
    void 'generate random String' () {
        assertNotNull(RandomUtil.randomString(8, true, true))
    }

    @Test
    void 'generate random Integer' () {
        int random = RandomUtil.randomInteger(1, 1000)
        assertTrue(random > 0 && random <= 1000)
    }

    @Test
    void 'generate random Double' () {
        double random = RandomUtil.randomDouble(1D, 1000D)
        assertTrue(random > 0D && random <= 1000D)
    }

    @Test
    void 'generate random Float' () {
        float random = RandomUtil.randomFloat(1F, 1000F)
        assertTrue(random > 0F && random <= 1000F)
    }
}
