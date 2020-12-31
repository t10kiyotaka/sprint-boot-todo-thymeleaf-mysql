drop table if exists todo;
create table todo (
    id int not null primary key auto_increment,
    content varchar(100) not null,
    is_done tinyint(1) not null
);
