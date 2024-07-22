create table ebook
(
    id bigint not null  AUTO_INCREMENT,
    title varchar(255) not null,
    author varchar(255) not null,
    summary CLOB,
    primary key (id)
);