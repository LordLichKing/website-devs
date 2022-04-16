package com.lichen.github.website.server.common.dal.model;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.time.Instant;

public interface PersistentInstance<ID extends Serializable, UID extends Serializable> extends Persistable<ID>, Serializable {

    Instant getCreateTime();

    UID getCreateUserId();

    Instant getLastUpdateTime();

    UID getLastUpdateUserId();

    long getOccVersion();

    /**
     * 相较于JPA和Mybatis等框架，R2DBC需要通过{@link Persistable#isNew()}来判断是insert还是update操作。
     *
     * （目前本人尚未找到任何annotation或者其它机制可以代替此方法，故而先暂时这么实现）
     *
     * @param newInstance True: 代表新增操作。
     */
    void setNewInstance(boolean newInstance);

    void setId(ID id);

    ID createNewId();

    static <S extends PersistentInstance<? extends Serializable, ? extends Serializable>> S asNew(S instance) {
        instance.setNewInstance(true);
        return instance;
    }
}
