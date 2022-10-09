CREATE TABLE if not exists task
(
id serial primary key,
description text not null,
dateofcreation date not null,
deadline date not null,
status bool not null
);