package net.yoonaxes.auth.service.impl;

import net.yoonaxes.auth.data.Account;
import net.yoonaxes.auth.data.account.AccountAddress;
import net.yoonaxes.auth.data.account.AccountPassword;
import net.yoonaxes.auth.data.account.AccountSession;
import net.yoonaxes.auth.service.Service;

import java.util.UUID;

public class AccountService extends Service<UUID, Account> {

    public Account create(String name, UUID uniqueId, Account.Type type, String address, String password, boolean autoLogin) {
        Account account = new Account(
                name, uniqueId, type,
                new AccountAddress(address, address),
                new AccountPassword(password),
                new AccountSession(autoLogin ? System.currentTimeMillis() : 0L)
        );
        this.getMap().put(uniqueId, account);
        return account;
    }

    public Account create(String name, UUID uniqueId, String address) {
        return create(name, uniqueId, Account.Type.PREMIUM, address, "#", true);
    }

    public Account find(String name) {
        return this.getMap().values().stream()
                .filter(account -> account.getName().equalsIgnoreCase(name))
                .findAny().orElse(null);
    }

    @Override
    protected void onRegister() {}
}
