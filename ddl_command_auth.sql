
CREATE TABLE roles (
                       id serial not null primary key,
                       name VARCHAR not null UNIQUE
);


CREATE TABLE users_accounts (
                                id serial not null primary key,
                                username VARCHAR not null UNIQUE,
                                password VARCHAR not null,
                                roles_id int not null REFERENCES roles(id)
);