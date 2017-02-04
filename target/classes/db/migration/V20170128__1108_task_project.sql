create table project (
id bigserial primary key,
name varchar(80) not null
);

create table task (
id bigserial primary key,
name varchar(80) not null,
project_id int8 not null
);

alter table task add constraint fk_task_project foreign key (project_id) references project (id);

insert into project (name) values ('prototype');
insert into task (name, project_id) values ('make it work', 1);
insert into task (name, project_id) values ('make it right', 1);
insert into task (name, project_id) values ('make it fast', 1);