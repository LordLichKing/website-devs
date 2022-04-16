package com.lichen.github.website.server.common.dal.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


public abstract class PersistentInstanceImpl<ID extends Serializable, UID extends Serializable> implements PersistentInstance<ID, UID> {

    @Getter
    @Setter
    @Id
    @Column("id")
    private ID id;

    @Getter
    @Setter
    @Column("create_time")
    private Instant createTime;

    @Getter
    @Setter
    @Column("create_user_id")
    private UID createUserId;

    @Getter
    @Setter
    @Column("last_update_time")
    private Instant lastUpdateTime;

    @Getter
    @Setter
    @Column("last_update_user_id")
    private UID lastUpdateUserId;

    @Getter
    @Setter
    @Version
    @Column("occ_version")
    private long occVersion;

    @Transient
    private boolean newInstance;

    @Override
    @Transient
    public boolean isNew() {
        return this.newInstance || Objects.isNull(this.id);
    }

    @Override
    public void setNewInstance(boolean newInstance) {
        this.newInstance = newInstance;
    }
}
