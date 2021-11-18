package net.yoonaxes.auth.data.account;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class AccountPassword {

    @NonNull
    @Getter
    @Setter
    private String encrypted;

    @Getter
    private Integer strong = -1; // TODO: Make Password Strong System

}
