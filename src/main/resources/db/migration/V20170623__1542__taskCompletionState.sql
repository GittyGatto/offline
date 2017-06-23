ALTER TABLE task ADD percentageCompleted
smallint
not null
constraint defaultValue
DEFAULT 0;