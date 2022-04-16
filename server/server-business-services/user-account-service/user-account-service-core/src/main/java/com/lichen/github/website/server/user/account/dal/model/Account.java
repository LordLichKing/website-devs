package com.lichen.github.website.server.user.account.dal.model;

import com.lichen.github.website.server.common.dal.model.UuidPersistentInstanceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("account")
public class Account extends UuidPersistentInstanceImpl<String> {

    @Getter
    @Setter
    @Column("username")
    private String username;

}
