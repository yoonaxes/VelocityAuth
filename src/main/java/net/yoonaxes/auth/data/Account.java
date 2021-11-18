package net.yoonaxes.auth.data;

import lombok.*;
import net.yoonaxes.auth.data.account.*;

import java.util.UUID;

@AllArgsConstructor
public class Account {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private UUID uniqueId;

    @Getter
    @Setter
    private Type type;

    @Getter
    private AccountAddress address;

    @Getter
    private AccountPassword password;

    @Getter
    private AccountSession session;

    public enum Type {
        CRACKED,
        PREMIUM;

        public boolean isPremium() {
            return this == PREMIUM;
        }
    }
}
