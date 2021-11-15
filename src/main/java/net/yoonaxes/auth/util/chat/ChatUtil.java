package net.yoonaxes.auth.util.chat;

import com.velocitypowered.api.command.CommandSource;
import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;
import net.yoonaxes.auth.util.TranslateUtil;

@UtilityClass
public class ChatUtil {

    public void sendMessage(CommandSource source, String... messages) {
        for(String message : TranslateUtil.translateArray(messages))
            source.sendMessage(Component.text(message));
    }
}
