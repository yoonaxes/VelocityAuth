package net.yoonaxes.auth.util.chat;

import com.velocitypowered.api.command.CommandSource;
import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;
import net.yoonaxes.auth.util.TranslateUtil;
import org.apache.commons.lang3.Validate;

@UtilityClass
public class ChatUtil {

    public void sendMessage(CommandSource source, String... messages) {
        Validate.notNull(source, "A source value can't be null.");
        Validate.notNull(messages, "A messages value can't be null.");

        for(String message : TranslateUtil.translateArray(messages))
            source.sendMessage(Component.text(message));
    }
}
