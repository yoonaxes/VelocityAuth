package net.yoonaxes.auth.service.impl;

import net.yoonaxes.auth.data.Account;
import net.yoonaxes.auth.service.Service;

import java.util.UUID;

public class AccountService extends Service<UUID, Account> {

    public Account create(String name, UUID uniqueId) {
        Account account = new Account();
        this.getMap().put(uniqueId, account);
        return account;
    }

    @Override
    protected void onRegister() {

    }
}
