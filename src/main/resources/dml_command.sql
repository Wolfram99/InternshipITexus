INSERT INTO cover_type (cover_type) VALUES ('������ ������� - ������������');
INSERT INTO cover_type (cover_type) VALUES ('������ ������� - �����');
INSERT INTO cover_type (cover_type) VALUES ('������ ������� - �� �������');
INSERT INTO cover_type (cover_type) VALUES ('������ ������� - ������������');
INSERT INTO cover_type (cover_type) VALUES ('������ ������� - ������������� ������');

INSERT INTO genres (genre) VALUES ('�����');
INSERT INTO genres (genre) VALUES ('�����');
INSERT INTO genres (genre) VALUES ('������');
INSERT INTO genres (genre) VALUES ('�����������');
INSERT INTO genres (genre) VALUES ('��������');
INSERT INTO genres (genre) VALUES ('�����');
INSERT INTO genres (genre) VALUES ('�����');
INSERT INTO genres (genre) VALUES ('�������');
INSERT INTO genres (genre) VALUES ('������� ����������');
INSERT INTO genres (genre) VALUES ('�������');

INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('���������','���������','������',1799);
INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('������','�����������','��������',1891);
INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('�������','����������','��������',1847);
INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('���������','���������','���������',1795);
INSERT INTO authors (name, patronymic, surname, birth_year) VALUES ('�������','����������','������',1809);

INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('������� ����� � �����','������� ����� � ����� - ������������� ������� ���������, �������� � �������� ���������.',3,3,16,1,1870);
INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('���� �� ���','����� �� ��� � ���������� ������� � ������, ���������� ����������� ����������� �����������. ������� �������� ������� �������� ������ 19 ����, �� ������� ���������� �� ��� ����.',4,10,224,5,1833);
INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('���������� �������','������� � ������ � ���������� ������� �������, ������� �������� �� �����, ����������� ������������� � ���� ������ �������� ���������.',1,3,15,2,1822);
INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('̸����� ����','������� ����� ����� �������� ������� � ����� �� ������ � ������ � �������� ������, ������ � ������ ������� ��������, ������� �������� ������. �� ����� ������ ���� �� �������� �������� � ���������� �� �����.',5,1,544,4,1842);
INSERT INTO books (name, short_description, author_id, genre_id, volume, cover_type_id, publication_year) VALUES ('�������','� ������� �������� ����� ��������������� � ���������������� �������������� �������, ������� ����� � ������. ����� � ����� ������������ ������, ��������� �������, ���������� � � ����������� ��������.',5,10,296,4,1842);