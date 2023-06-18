create table if not exists customer (
  id SERIAL PRIMARY KEY,
  name varchar(255) not null,
  email varchar(255) not null,
  password varchar(255) not null,
  mongo_id varchar(255),
  unique (email),
  unique (mongo_id),
  unique (name)
);
