package com.lichen.github.website.server.user.account.controller.model;

import com.lichen.github.website.server.common.web.DataTransferObject;
import lombok.Data;

@Data
public class AccountDto implements DataTransferObject<String> {

    private String id;

    private String username;

    private String emailAddress;

    private String cellPhoneNumber;
}
