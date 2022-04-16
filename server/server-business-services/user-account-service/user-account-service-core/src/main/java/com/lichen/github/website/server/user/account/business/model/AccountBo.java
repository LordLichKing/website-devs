package com.lichen.github.website.server.user.account.business.model;

import com.lichen.github.website.server.common.business.BusinessObject;
import lombok.Data;

@Data
public class AccountBo implements BusinessObject<String> {

    private String id;

    private String username;
}
