package net.yoonaxes.auth.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContentAPITest {

    @Test
    void getData() {
        assertNotNull(new ContentAPI("https://www.google.com/").getData());
    }
}