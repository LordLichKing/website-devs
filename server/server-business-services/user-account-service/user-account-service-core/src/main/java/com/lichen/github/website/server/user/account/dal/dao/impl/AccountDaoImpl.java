package com.lichen.github.website.server.user.account.dal.dao.impl;

import com.lichen.github.website.server.user.account.dal.dao.AccountDao;
import com.lichen.github.website.server.user.account.dal.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountRepository embeddedRepo() {
        return this.accountRepository;
    }
}
