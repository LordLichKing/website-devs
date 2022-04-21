package com.lichen.github.website.server.user.account.dal.model;

import com.lichen.github.website.server.common.dal.model.UuidPersistentInstanceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("account")
public class Account extends UuidPersistentInstanceImpl<String> {

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("email_address")
    private String emailAddress;

    @Column("cell_phone_number")
    private String cellPhoneNumber;
}
