package com.lichen.github.website.server.common.business;

import java.io.Serializable;

public interface BusinessObject<ID extends Serializable> extends Serializable {

    ID getId();
}
