CREATE TABLE votes (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    entryId int,
    PRIMARY KEY (id)
);

INSERT INTO votes (name, entryId)
VALUES ( 'Whatever', 1);