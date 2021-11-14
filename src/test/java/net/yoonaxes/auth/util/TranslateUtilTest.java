package net.yoonaxes.auth.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TranslateUtilTest {

    @Test
    void translateString() {
        assertNotNull(TranslateUtil.translateString("&1It's &2Example &3String"));
    }

    @Test
    void translateList() {
        assertNotNull(TranslateUtil.translateList(List.of("&4List one", "&5List two", "&6List three")));
    }

    @Test
    void translateArray() {
        assertNotNull(TranslateUtil.translateArray(new String[] { "&7Array one", "&8Array two", "&9Array three" }));
    }
}