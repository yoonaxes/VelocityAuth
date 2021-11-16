package net.yoonaxes.auth.data;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.yoonaxes.auth.data.account.AccountAddress;
import net.yoonaxes.auth.data.account.AccountPassword;
import net.yoonaxes.auth.data.account.AccountSession;

import java.util.UUID;

@RequiredArgsConstructor
public class Account {

    @NonNull
    @Getter
    @Setter
    private String name;

    @NonNull
    @Getter
    private UUID uniqueId;

    @NonNull
    @Getter
    private Type type;

    @NonNull
    @Getter
    private AccountAddress address;

    @NonNull
    @Getter
    @Setter
    private AccountPassword password;

    @NonNull
    @Getter
    @Setter
    private AccountSession session;

    public enum Type {
        CRACKED,
        PREMIUM;

        public boolean isPremium() {
            return this == PREMIUM;
        }
    }
}
