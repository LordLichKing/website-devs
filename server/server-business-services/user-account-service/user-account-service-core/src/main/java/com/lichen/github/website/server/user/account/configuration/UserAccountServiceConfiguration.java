package com.lichen.github.website.server.user.account.configuration;

import com.lichen.github.website.server.common.dal.setup.EnableR2dbcConnectionPool;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
@EnableR2dbcConnectionPool("spring.server.dal.r2dbc")
public class UserAccountServiceConfiguration {


}
