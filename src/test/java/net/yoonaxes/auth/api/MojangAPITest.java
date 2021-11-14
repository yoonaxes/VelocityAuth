package net.yoonaxes.auth.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MojangAPITest {

    String id = "c1ef23e8278d4a88a4b312cd68442235";
    String username = "yoonaxes";

    MojangAPI mojangAPI = new MojangAPI();

    @Test
    void getId() {
        assertEquals(mojangAPI.getId(username), id);
    }

    @Test
    void isPremiumAccount() {
        assertTrue(mojangAPI.isPremiumAccount(username));
    }
}