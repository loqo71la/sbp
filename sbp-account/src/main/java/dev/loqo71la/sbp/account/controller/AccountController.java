package dev.loqo71la.sbp.account.controller;

import dev.loqo71la.sbp.account.model.Account;
import dev.loqo71la.sbp.account.service.AccountService;
import dev.loqo71la.sbp.base.controller.BaseController;
import dev.loqo71la.sbp.base.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages the http request for accounts.
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController extends BaseController<Account> {

    /**
     * Auto-injects a proper account service.
     */
    @Autowired
    private AccountService accountService;

    /**
     * Gets the account service.
     *
     * @return the account service.
     */
    @Override
    protected CrudService<Account> getService() {
        return accountService;
    }
}
