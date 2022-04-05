/**
 * <pre>
 *  在创建这层dao的时候，其实本人一直在纠结。
 *
 *  一般在JPA框架中，repositories就可以算作是DAO层。但是在R2DBC中，ReactiveCrudRepository有很多的限制。
 *  因此我在这里加了一层，用来处理一些在CRUD之前的预处理。
 *
 *  这里的实现方式是通过新的接口继承原来的Repository，并对其做一层装饰。
 * </pre>
 */
package com.lichen.github.website.server.user.account.dal.dao;