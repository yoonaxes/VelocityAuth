package net.yoonaxes.auth.builder.shorts;

import lombok.experimental.UtilityClass;
import net.yoonaxes.auth.builder.MessageBuilder;

import java.util.List;

@UtilityClass
public class MB {

    public MessageBuilder of(String... messages) {
        return new MessageBuilder(messages);
    }

    public MessageBuilder of(List<String> stringList) {
        return new MessageBuilder(stringList);
    }
}
