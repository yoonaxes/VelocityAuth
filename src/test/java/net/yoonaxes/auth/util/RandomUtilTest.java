package net.yoonaxes.auth.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilTest {

    @Test
    void randomString() {
        int length = 8;
        assertTrue(RandomUtil.randomString(length, true, true).length() == length);
    }

    @Test
    void randomInteger() {
        int random = RandomUtil.randomInteger(1, 1000);
        assertEquals(RandomUtil.randomInteger(random, random), random);
        assertTrue(random > 0 && random <= 1000);
    }

    @Test
    void randomDouble() {
        double random = RandomUtil.randomDouble(1D, 1000D);
        assertEquals(RandomUtil.randomDouble(random, random), random);
        assertTrue(random > 0D && random <= 1000D);
    }

    @Test
    void randomFloat() {
        float random = RandomUtil.randomFloat(1F, 1000F);
        assertEquals(RandomUtil.randomFloat(random, random), random);
        assertTrue(random > 0F && random <= 1000F);
    }
}