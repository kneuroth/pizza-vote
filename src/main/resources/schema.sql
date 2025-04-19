CREATE TABLE entries
(
    id        int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name      varchar(255) NOT NULL,
    creator   varchar(255) NOT NULL,
    pizzaYear int          NOT NULL,
);

CREATE TABLE votes
(
    id      int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name    varchar(255) NOT NULL,
    entryId int          NOT NULL,
    FOREIGN KEY (entryId) REFERENCES entries (id)
);

