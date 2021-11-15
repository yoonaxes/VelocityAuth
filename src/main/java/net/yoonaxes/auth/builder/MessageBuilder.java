package net.yoonaxes.auth.builder;

import com.velocitypowered.api.command.CommandSource;
import lombok.NonNull;
import net.kyori.adventure.text.Component;
import net.yoonaxes.auth.AuthPlugin;
import net.yoonaxes.auth.util.TranslateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.List;

public class MessageBuilder {

    private final static String PREFIX = AuthPlugin.getAuth().getConfigurationManager().getLanguageConfiguration().prefix;

    @NonNull
    private String[] messages;

    public MessageBuilder(String... messages) {
        this.messages = messages;
    }

    public MessageBuilder(List<String> stringList) {
        this (stringList.toArray(String[]::new));
    }

    public MessageBuilder withVariable(String variable, Object replacement) {
        Validate.notNull(variable, "A variable value can't be null.");
        Validate.notNull(replacement, "A replacement value can't be null.");

        for(int i = 0; i < messages.length; ++i) {
            messages[i] = StringUtils.replace(
                    messages[i],
                    "${" + variable.toUpperCase() + "}",
                    replacement instanceof String
                            ? (String) replacement
                            : String.valueOf(replacement)
            );
        }
        return this;
    }

    public void send(CommandSource source) {
        Validate.notNull(source, "A source value can't be null.");

        for (String message : messages) {
            message = StringUtils.replace(message, "{$}", PREFIX);
            message = TranslateUtil.translateString(message);
            source.sendMessage(Component.text(message));
        }
    }
}
