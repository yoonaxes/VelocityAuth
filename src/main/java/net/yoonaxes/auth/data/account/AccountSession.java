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
    public long connectedTime;

    @NonNull
    @Getter
    @Setter
    public long loggedTime;

    public void setConnectedLoggedTime(long time) {
        this.connectedTime = time;
        this.loggedTime = time;
    }
}
