CREATE TABLE cover_type (
    id serial not null primary key,
    cover_type VARCHAR(50) not null UNIQUE
);

CREATE TABLE genres (
    id serial not null primary key,
    genre VARCHAR(50) not null UNIQUE
);

CREATE TABLE authors(
    id serial not null primary key,
    name VARCHAR(50) not null,
    patronymic VARCHAR(50),
    surname VARCHAR(50) not null,
    birth_year int
);

CREATE TABLE Books(
      id serial not null primary key,
      name VARCHAR(50) not null,
      short_description VARCHAR(255),
      author_id int not null REFERENCES authors(id),
      genre_id int not null REFERENCES genres(id),
      publication_year int,
      volume int not null,
      cover_type_id int not null REFERENCES cover_type(id)
);



