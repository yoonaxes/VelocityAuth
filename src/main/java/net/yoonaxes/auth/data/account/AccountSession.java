package net.yoonaxes.auth.data.account;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class AccountSession {

    @NonNull
    @Getter
    @Setter
    private Long loggedTime;

    public boolean isLogged() {
        return getLoggedTime() > 0L;
    }
}
