package dev.loqo71la.bp.controller;

import dev.loqo71la.bp.common.contant.RouteConstant;
import dev.loqo71la.bp.dto.AccountDto;
import dev.loqo71la.bp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages the http request for accounts.
 */
@RestController
@RequestMapping(RouteConstant.ACCOUNT_URL)
public class AccountController extends BaseController<AccountDto> {

    /**
     * Auto-injects a proper service.
     *
     * @param accountService CrudService implementation for accounts.
     */
    @Autowired
    public void setService(AccountService accountService) {
        super.service = accountService;
    }
}
