DROP TABLE IF EXISTS shops;
CREATE TABLE shops (id bigint NOT NULL, name VARCHAR(255), address VARCHAR(255), user_id bigint REFERENCES users(id), primary key (id));
