DROP TABLE IF EXISTS CREDIT_CARD;
DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE CREDIT_CARD
(
    id        SERIAL PRIMARY KEY,
    bank_name VARCHAR(255) NOT NULL,
    number    INTEGER      NOT NULL,
    user_id   INTEGER      NOT NULL,
    FOREIGN KEY (user_id) references USERS (id) on delete cascade
);
INSERT INTO USERS (name)
VALUES ('Vasya'),
       ('Petya');

INSERT INTO CREDIT_CARD (bank_name, number, user_id)
VALUES ('Sber', 12345678, 1),
       ('VTB', 98754612, 1),
       ('Alfa', 564981257, 2);