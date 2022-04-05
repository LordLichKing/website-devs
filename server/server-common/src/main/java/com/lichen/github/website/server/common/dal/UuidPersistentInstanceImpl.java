package com.lichen.github.website.server.common.dal;

import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.UUID;

public class UuidPersistentInstanceImpl<UID extends Serializable> extends PersistentInstanceImpl<String, UID> {

    @Override
    @Transient
    public String createNewId() {
        return UUID.randomUUID().toString();
    }
}
