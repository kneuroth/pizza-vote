CREATE TABLE entries (
     id int NOT NULL AUTO_INCREMENT,
     name varchar(255) NOT NULL,
     creator varchar(255) NOT NULL,
     pizzaYear int NOT NULL,
     PRIMARY KEY (id)
);

CREATE TABLE votes (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    entryId int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (entryId) REFERENCES entries(id)
);

