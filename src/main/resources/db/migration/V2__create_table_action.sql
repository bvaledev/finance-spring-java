create table transaction
(
  id               bigint not null auto_increment,
  title            VARCHAR(50) NOT NULL,
  amount           DECIMAL(15, 2) NOT NULL,
  release_type     VARCHAR(50) NOT NULL,
  transaction_date DATE NOT NULL,
  created_at       DATETIME NOT NULL,
  category_id      BIGINT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (category_id) REFERENCES category(id)
);

--1 ('Educação');
--2 ('Alimentação');
--3 ('Transporte');
--4 ('Finânciamento');
--5 ('Impostos');
--6 ('Lazer');
--7 ('Saúde');
--8 ('Outros');

INSERT INTO transaction(category_id, title, amount, release_type, transaction_date, created_at)
VALUES (2, 'Café da manhã', 110.80, 'DEBIT', '2022-07-23', NOW());
INSERT INTO transaction(category_id,  title, amount, release_type, transaction_date, created_at)
VALUES (3, 'Ir academia', 12.25, 'DEBIT', '2022-07-23', NOW());
VALUES (3, 'Ir Supermercado', 22.25, 'DEBIT', '2022-07-23', NOW());
INSERT INTO transaction(category_id,  title, amount, release_type, transaction_date, created_at)
VALUES (2, 'Supermercado', 580.25, 'DEBIT', '2022-07-23', NOW());
VALUES (3, 'Ir Casa', 32.25, 'DEBIT', '2022-07-23', NOW());
INSERT INTO transaction(category_id,  title, amount, release_type, transaction_date, created_at)
VALUES (2, 'Torta', 83.54, 'DEBIT', '2022-07-23', NOW());