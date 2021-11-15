package net.yoonaxes.auth.data;

import lombok.RequiredArgsConstructor;
import net.yoonaxes.auth.data.account.AccountAddress;
import net.yoonaxes.auth.data.account.AccountPassword;
import net.yoonaxes.auth.data.account.AccountSession;

import java.util.UUID;

@RequiredArgsConstructor
public class Account {

    private String name;
    private UUID uniqueId;
    private AccountAddress address;
    private AccountPassword password;
    private AccountSession session;

}
