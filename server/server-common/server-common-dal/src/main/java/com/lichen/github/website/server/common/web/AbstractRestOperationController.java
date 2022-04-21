package com.lichen.github.website.server.common.web;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.Serializable;

public abstract class AbstractRestOperationController<T extends DataTransferObject<I>, I extends Serializable> implements RestOperationController<T, I> {

    @Override
    public Mono<? extends T> get(I id, ServerWebExchange exchange) {
        return getRestOperationService().doGet(id);
    }

    @Override
    public Mono<? extends T> post(Mono<T> entity, ServerWebExchange exchange) {
        return entity.flatMap(e -> getRestOperationService().doPost(e));
    }
}
