package net.yoonaxes.auth.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.yoonaxes.auth.service.impl.AccountService;

/**
 * This is a manager of services.
 * @author yoonaxes
 */
@RequiredArgsConstructor
public class ServiceManager {

    @Getter
    private AccountService accountService = new AccountService();

}
