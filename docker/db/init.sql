drop table if exists book;
create table if not exists book
(
    id   serial primary key,
    title varchar(25) not null
    author varchar(25) not null
)