package com.lichen.github.website.server.user.account.controller;

import com.lichen.github.website.server.common.web.AbstractRestOperationController;
import com.lichen.github.website.server.common.web.RestOperationService;
import com.lichen.github.website.server.user.account.controller.model.AccountDto;
import com.lichen.github.website.server.user.account.controller.service.AccountOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController extends AbstractRestOperationController<AccountDto, String> {

    @Autowired
    private AccountOperationService accountOperationService;

    @Override
    public RestOperationService<AccountDto, ?, String> getRestOperationService() {
        return this.accountOperationService;
    }
}
