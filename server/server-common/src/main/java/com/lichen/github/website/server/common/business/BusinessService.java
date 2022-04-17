package com.lichen.github.website.server.common.business;

import com.lichen.github.website.server.common.dal.Dao;
import com.lichen.github.website.server.common.dal.model.PersistentInstance;
import reactor.core.publisher.Mono;

import java.io.Serializable;

/**
 * 主要负责处理业务逻辑部分以及事务。
 *
 * @param <B>
 * @param <P>
 */
public interface BusinessService<B extends BusinessObject<?>, P extends PersistentInstance<?, ?>, I extends Serializable>{

    Mono<? extends B> findById(I id);

    Mono<? extends B> save(B bo);

    Dao<P, ?> getDao();

    P convert(B bo);

    B unConvert(P po);
}
