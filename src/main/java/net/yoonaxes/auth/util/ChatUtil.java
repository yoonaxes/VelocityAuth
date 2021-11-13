package net.yoonaxes.auth.util;

import com.velocitypowered.api.command.CommandSource;
import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;

@UtilityClass
public class ChatUtil {

    public void sendMessage(CommandSource source, String... messages) {
        for(String message : TranslateUtil.translateArray(messages))
            source.sendMessage(Component.text(message));
    }
}
