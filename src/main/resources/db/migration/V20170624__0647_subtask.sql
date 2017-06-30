alter table task add parent_id bigint NULL references task (id);

insert into
  task (project_id, parent_id, name)
  select project_id, id, 'badger' from task where name = 'make it work'
  union all
  select project_id, id, 'lynx' from task where name = 'make it work'
  union all
  select project_id, id, 'ocelot' from task where name = 'make it work';