package net.yoonaxes.auth.util;

import lombok.experimental.UtilityClass;
import net.yoonaxes.auth.feature.chat.ChatColor;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TranslateUtil {

    public String translateString(String string) {
        Validate.notNull(string, "A string to color translate can't be null.");

        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public List<String> translateList(List<String> stringList) {
        Validate.notNull(stringList, "A stringList to color translate can't be null.");

        return stringList.stream()
                .map(TranslateUtil::translateString)
                .collect(Collectors.toList());
    }

    public String[] translateArray(String[] array) {
        Validate.notNull(array, "A array to color translate can't be null.");

        return Arrays.stream(array)
                .map(TranslateUtil::translateString)
                .toArray(String[]::new);
    }
}
