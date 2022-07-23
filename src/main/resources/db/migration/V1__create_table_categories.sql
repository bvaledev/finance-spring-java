create table category
(
  id               bigint not null auto_increment,
  title            VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO category(title) VALUES ('Sem Categoria');
INSERT INTO category(title) VALUES ('Educação');
INSERT INTO category(title) VALUES ('Alimentação');
INSERT INTO category(title) VALUES ('Transporte');
INSERT INTO category(title) VALUES ('Finânciamento');
INSERT INTO category(title) VALUES ('Impostos');
INSERT INTO category(title) VALUES ('Lazer');
INSERT INTO category(title) VALUES ('Saúde');
INSERT INTO category(title) VALUES ('Outros');
