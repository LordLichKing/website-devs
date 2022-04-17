package com.lichen.github.website.server.user.account.business.service;

import com.lichen.github.website.server.common.business.BusinessService;
import com.lichen.github.website.server.user.account.business.model.AccountBo;
import com.lichen.github.website.server.user.account.dal.dao.AccountDao;
import com.lichen.github.website.server.user.account.dal.model.Account;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountBusinessService implements BusinessService<AccountBo, Account, String> {

    @Getter
    @Autowired
    private AccountDao dao;

    @Override
    public Mono<? extends AccountBo> findById(String id) {
        return dao.findById(id).map(this::unConvert);
    }

    @Override
    public Mono<? extends AccountBo> save(AccountBo bo) {
        return dao.save(convert(bo)).map(this::unConvert);
    }

    @Override
    public Account convert(AccountBo bo) {
        Account account = new Account();
        account.setId(bo.getId());
        account.setUsername(bo.getUsername());
        return account;
    }

    @Override
    public AccountBo unConvert(Account po) {
        AccountBo bo = new AccountBo();
        bo.setId(po.getId());
        bo.setUsername(po.getUsername());
        return bo;
    }

}
