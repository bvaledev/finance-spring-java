create table transaction(
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    release_type VARCHAR(50) NOT NULL,
    created_at DATETIME,
    PRIMARY KEY (id)
);

INSERT INTO transaction VALUES(1, 'Curso Alura', 980.02, 'DEBIT', NOW());