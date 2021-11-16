package net.yoonaxes.auth.data.account;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountPassword {

    @NonNull
    @Getter
    private String encrypted;

    @Getter
    private Integer strong = encrypted.length(); // TODO: Make Password Strong System

}
