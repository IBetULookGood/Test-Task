create table users(
 id int generated by default as identity primary key,
  name varchar,
  password varchar,
    role varchar
);