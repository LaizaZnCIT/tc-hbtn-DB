-- TABLE
CREATE TABLE Aluno (id  integer, email varchar(255), matricula varchar(255), nascimento datetime, nomeCompleto varchar(255), primary key (id));
CREATE TABLE Curso (id  integer, nome varchar(255), sigla varchar(255), primary key (id));
CREATE TABLE endereco (id  integer, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), primary key (id));
CREATE TABLE MaterialCurso (id  integer, url varchar(255), primary key (id));
CREATE TABLE professor (id  integer, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id));
CREATE TABLE telefone (id  integer, DDD varchar(255), numero varchar(255), primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
