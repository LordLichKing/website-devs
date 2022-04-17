package com.lichen.github.website.server.common.web;

import java.io.Serializable;

public interface DataTransferObject<ID extends Serializable> extends Serializable {

    ID getId();
}
