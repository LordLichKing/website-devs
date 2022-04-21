package com.lichen.github.website.server.common.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.Serializable;

public interface RestOperationController<T extends DataTransferObject<I>, I extends Serializable> {

    @GetMapping("/{id}")
    Mono<? extends T> get(@PathVariable I id, ServerWebExchange exchange);

    @PostMapping
    Mono<? extends T> post(@RequestBody Mono<T> entity, ServerWebExchange exchange);

    RestOperationService<T, ?, I> getRestOperationService();
}
