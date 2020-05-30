DROP TABLE IF EXISTS users;
CREATE TABLE users (id bigint NOT NULL, role VARCHAR(255), name VARCHAR(255), password VARCHAR(255), primary key (id));
