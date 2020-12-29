drop table if exists todo;
create table todo (
    id int not null primary key,
    content varchar(100) not null,
    is_done boolean not null
);
