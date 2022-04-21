package com.lichen.github.website.server.user.account.controller.service;

import com.lichen.github.website.server.common.web.RestOperationService;
import com.lichen.github.website.server.user.account.business.model.AccountBo;
import com.lichen.github.website.server.user.account.business.service.AccountBusinessService;
import com.lichen.github.website.server.user.account.controller.model.AccountDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountOperationService implements RestOperationService<AccountDto, AccountBo, String> {

    @Getter
    @Autowired
    private AccountBusinessService businessService;

    @Override
    public AccountBo convert(AccountDto dto) {
        AccountBo accountBo = new AccountBo();
        accountBo.setId(dto.getId());
        accountBo.setUsername(dto.getUsername());
        accountBo.setEmailAddress(dto.getEmailAddress());
        accountBo.setCellPhoneNumber(dto.getCellPhoneNumber());
        return accountBo;
    }

    @Override
    public AccountDto unConvert(AccountBo bo) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(bo.getId());
        accountDto.setUsername(bo.getUsername());
        accountDto.setEmailAddress(bo.getEmailAddress());
        accountDto.setCellPhoneNumber(bo.getCellPhoneNumber());
        return accountDto;
    }
}
