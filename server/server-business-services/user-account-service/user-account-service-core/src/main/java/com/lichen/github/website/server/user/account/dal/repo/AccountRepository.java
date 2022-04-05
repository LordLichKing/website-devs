package com.lichen.github.website.server.user.account.dal.repo;

import com.lichen.github.website.server.user.account.dal.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, String> {
}
