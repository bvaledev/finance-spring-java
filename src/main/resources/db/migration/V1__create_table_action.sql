create table transaction(
    id bigint not null auto_increment,
    title VARCHAR(50) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    release_type VARCHAR(50) NOT NULL,
    created_at DATETIME,
    PRIMARY KEY (id)
);

INSERT INTO transaction(
    title,amount,release_type,created_at
) VALUES('Curso Alura', 980.02, 'DEBIT', NOW());