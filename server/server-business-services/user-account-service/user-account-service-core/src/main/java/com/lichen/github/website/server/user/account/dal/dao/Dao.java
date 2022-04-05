package com.lichen.github.website.server.user.account.dal.dao;


import com.lichen.github.website.server.common.dal.PersistentInstance;
import org.reactivestreams.Publisher;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * 通过静态代理的方式，调用{@link #embeddedRepo()}中的同样方法。
 *
 * 缺点：
 *      1. 不够灵活，每个方法都得实现一遍。
 *      2. springboot 版本升级或者r2dbc 接口改动都会导致这块发生改动。
 *
 * 以后会通过动态代理的方法实现。
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface Dao<T extends PersistentInstance<ID, ?>, ID extends Serializable> extends ReactiveCrudRepository<T, ID> {

    ReactiveCrudRepository<T, ID> embeddedRepo();

    @Override
    default <S extends T> Mono<S> save(S entity) {
        refreshId(entity);
        return embeddedRepo().save(entity);
    }

    @Override
    default <S extends T> Flux<S> saveAll(Iterable<S> entities) {
        entities.forEach(Dao::refreshId);
        return embeddedRepo().saveAll(entities);
    }

    @Override
    default <S extends T> Flux<S> saveAll(Publisher<S> entityStream) {
        if (entityStream instanceof Mono) {
            entityStream = ((Mono<S>) entityStream).map(Dao::refreshId);
        } else if (entityStream instanceof Flux) {
            entityStream = ((Flux<S>) entityStream).map(Dao::refreshId);
        }
        return embeddedRepo().saveAll(entityStream);
    }

    @Override
    default Mono<T> findById(ID id) {
        return embeddedRepo().findById(id);
    }

    @Override
    default Mono<T> findById(Publisher<ID> id) {
        return embeddedRepo().findById(id);
    }

    @Override
    default Mono<Boolean> existsById(ID id) {
        return embeddedRepo().existsById(id);
    }

    @Override
    default Mono<Boolean> existsById(Publisher<ID> id) {
        return embeddedRepo().existsById(id);
    }

    @Override
    default Flux<T> findAll() {
        return embeddedRepo().findAll();
    }

    @Override
    default Flux<T> findAllById(Iterable<ID> ids) {
        return embeddedRepo().findAllById(ids);
    }

    @Override
    default Flux<T> findAllById(Publisher<ID> idStream) {
        return embeddedRepo().findAllById(idStream);
    }

    @Override
    default Mono<Long> count() {
        return embeddedRepo().count();
    }

    @Override
    default Mono<Void> deleteById(ID id) {
        return embeddedRepo().deleteById(id);
    }

    @Override
    default Mono<Void> deleteById(Publisher<ID> id) {
        return embeddedRepo().deleteById(id);
    }

    @Override
    default Mono<Void> delete(T entity) {
        return embeddedRepo().delete(entity);
    }

    @Override
    default Mono<Void> deleteAll() {
        return embeddedRepo().deleteAll();
    }

    @Override
    default Mono<Void> deleteAll(Iterable<? extends T> entities) {
        return embeddedRepo().deleteAll(entities);
    }

    @Override
    default Mono<Void> deleteAll(Publisher<? extends T> entityStream) {
        return embeddedRepo().deleteAll(entityStream);
    }

    @Override
    default Mono<Void> deleteAllById(Iterable<? extends ID> ids) {
        return embeddedRepo().deleteAllById(ids);
    }

    static <T extends PersistentInstance<ID, ?>, ID extends Serializable> T refreshId(T persistentInstance) {
        if (persistentInstance.isNew() && Objects.isNull(persistentInstance.getId())) {
            persistentInstance.setId(persistentInstance.createNewId());
            persistentInstance.setNewInstance(true);
        }
        return persistentInstance;
    }
}
