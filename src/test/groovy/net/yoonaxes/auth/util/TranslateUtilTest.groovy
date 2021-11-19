package net.yoonaxes.auth.util

import groovy.test.GroovyAssert
import org.junit.jupiter.api.Test

class TranslateUtilTest extends GroovyAssert {

    @Test
    void 'translate a String color codes' () {
        assertNotNull(TranslateUtil.translateString("&1It's &2Example &3String"))
    }

    @Test
    void 'translate a List String color codes' () {
        assertNotNull(TranslateUtil.translateList(List.of("&4List one", "&5List two", "&6List three")))
    }

    @Test
    void 'translate a String Array color codes' () {
        assertNotNull(TranslateUtil.translateArray(new String[] { "&7Array one", "&8Array two", "&9Array three" }))
    }
}