# Business Services

本目录存放了所有业务逻辑的micro-services。

所有数据库框架将采用spring data下的R2DBC, 目的是为了更好地适应Reactive的编程思想。

主业务数据库采用MySql DB。每个业务的微服务单独使用一个Schema, 用来隔离数据之间的依赖。