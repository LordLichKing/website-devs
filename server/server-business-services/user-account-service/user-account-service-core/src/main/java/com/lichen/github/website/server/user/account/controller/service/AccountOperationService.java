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
    public Mono<? extends AccountDto> doGet(String id) {
        return businessService.findById(id).map(this::unConvert);
    }

    @Override
    public Mono<? extends AccountDto> doPost(AccountDto dto) {
        return businessService.save(convert(dto)).map(this::unConvert);
    }

    @Override
    public AccountBo convert(AccountDto dto) {
        AccountBo accountBo = new AccountBo();
        accountBo.setId(dto.getId());
        accountBo.setUsername(dto.getUsername());
        return accountBo;
    }

    @Override
    public AccountDto unConvert(AccountBo bo) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(bo.getId());
        accountDto.setUsername(bo.getUsername());
        return accountDto;
    }
}
