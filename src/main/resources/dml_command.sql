INSERT INTO cover_type (cover_type) VALUES ('Мягкий переплёт - термоклеевой');
INSERT INTO cover_type (cover_type) VALUES ('Мягкий переплёт - скоба');
INSERT INTO cover_type (cover_type) VALUES ('Мягкий переплёт - на пружине');
INSERT INTO cover_type (cover_type) VALUES ('Твёрдый переплёт - цельнокрытая');
INSERT INTO cover_type (cover_type) VALUES ('Твёрдый переплёт - обыкновенного крытья');

INSERT INTO genres (genre) VALUES ('Драма');
INSERT INTO genres (genre) VALUES ('Проза');
INSERT INTO genres (genre) VALUES ('Поэзия');
INSERT INTO genres (genre) VALUES ('Приключения');
INSERT INTO genres (genre) VALUES ('Детектив');
INSERT INTO genres (genre) VALUES ('Роман');
INSERT INTO genres (genre) VALUES ('Ужасы');
INSERT INTO genres (genre) VALUES ('Триллер');
INSERT INTO genres (genre) VALUES ('Научная фантастика');
INSERT INTO genres (genre) VALUES ('Комедия');

INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('Александр','Сергеевич','Пушкин',1799);
INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('Михаил','Афанасьевич','Булгаков',1891);
INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('Николай','Алексеевич','Некрасов',1847);
INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('Александр','Сергеевич','Грибоедов',1795);
INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('Николай','Васильевич','Гоголь',1809);

INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('Дедушка Мазай и зайцы','Дедушка Мазай и зайцы - стихотворение Николая Некрасова, вошедшее в школьную программу.',3,3,16,1,1870);
INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('Горе от ума','«Горе от ума» – знаменитая комедия в стихах, написанная Александром Сергеевичем Грибоедовым. Комедия обличает русское общество начала 19 века, но остаётся актуальной по сей день.',4,10,224,5,1833);
INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('Кавказский пленник','Рассказ о смелом и находчивом русском офицере, успешно бежавшем из плена, многократно переиздавался и стал частью школьной программы.',1,3,15,2,1822);
INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('Мёртвые души','Главный герой— Павел Иванович Чичиков — ездит от имения к имению в глубинке России, скупая у хозяев мертвых крестьян, которые числятся живыми. Он хочет выдать себя за богатого человека и заработать на афере.',5,1,544,4,1842);
INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('Ревизор','В комедии «Ревизор» сюжет разворачивается в коррумпированном провинциальном городке, которых много и сейчас. Яркие и порой утрированные образы, созданные автором, существуют и в современном обществе.',5,10,296,4,1842);