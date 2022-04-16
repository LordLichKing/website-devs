package com.lichen.github.website.server.common.web;

import com.lichen.github.website.server.common.business.BusinessObject;
import com.lichen.github.website.server.common.business.BusinessService;
import reactor.core.publisher.Mono;

import java.io.Serializable;

/**
 * 主要负责转换用户传过来的数据，做一些校验的工作。
 *
 * @param <D>
 * @param <B>
 */
public interface RestOperationService<D extends DataTransferObject<I>, B extends BusinessObject<?>, I extends Serializable> {

    Mono<? extends D> doGet(I id);

    Mono<? extends D> doPost(D dto);

    BusinessService<B, ?, I> getBusinessService();

    B convert(D dto);

    D unConvert(B bo);
}
