package com.lichen.github.website.server.user.account.dal.dao;

import com.lichen.github.website.server.common.dal.Dao;
import com.lichen.github.website.server.user.account.dal.model.Account;
import com.lichen.github.website.server.user.account.dal.repo.AccountRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AccountDao extends Dao<Account, String> {

    @Override
    AccountRepository embeddedRepo();
}
