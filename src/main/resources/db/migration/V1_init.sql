DROP TABLE users IF EXISTS;
DROP sequence IF EXISTS hibernate_sequence;
CREATE sequence hibernate_sequence START WITH 1 INCREMENT BY 1;
CREATE TABLE users (id bigint NOT NULL, role VARCHAR(255), name varchar(255), primary key (id));
