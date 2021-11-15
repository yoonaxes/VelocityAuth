package net.yoonaxes.auth.service.impl;

import net.yoonaxes.auth.data.Account;
import net.yoonaxes.auth.service.Service;

import java.util.UUID;

public class AccountService extends Service<UUID, Account> {

    public Account create(String name, UUID uniqueId, Account.Type type) {
        Account account = new Account(name, uniqueId, type);
        this.getMap().put(uniqueId, account);
        return account;
    }

    public Account find(String name) {
        return this.getMap().values().stream()
                .filter(account -> account.getName().equalsIgnoreCase(name))
                .findAny().orElse(null);
    }

    @Override
    protected void onRegister() {}
}
