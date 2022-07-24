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

INSERT INTO transaction(category_id, title, amount, release_type, transaction_date, created_at)
VALUES (3, 'Café da manhã', 110.80, 'DEBIT', '2022-07-23', NOW());
INSERT INTO transaction(category_id,  title, amount, release_type, transaction_date, created_at)
VALUES (4, 'Ir academia', 12.25, 'DEBIT', '2022-07-23', NOW());
VALUES (4, 'Ir Supermercado', 22.25, 'CREDIT', '2022-01-23', NOW());
INSERT INTO transaction(category_id,  title, amount, release_type, transaction_date, created_at)
VALUES (3, 'Supermercado', 580.25, 'CREDIT', '2022-01-23', NOW());
VALUES (4, 'Ir Casa', 32.25, 'CREDIT', '2022-03-23', NOW());
INSERT INTO transaction(category_id,  title, amount, release_type, transaction_date, created_at)
VALUES (3, 'Torta', 83.54, 'CREDIT', '2022-03-23', NOW());
INSERT INTO transaction(category_id,  title, amount, release_type, transaction_date, created_at)
VALUES (3, 'Pregos', 2, 'DEBIT', '2022-03-23', NOW());
INSERT INTO transaction(category_id,  title, amount, release_type, transaction_date, created_at)
VALUES (3, 'Pregos', 150, 'DEBIT', '2022-03-23', NOW());