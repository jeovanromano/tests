CREATE schema h2_bb AUTHORIZATION sa;

CREATE TABLE category (
	category_id INTEGER PRIMARY KEY,
	name 		VARCHAR(50)
);

CREATE TABLE product (
	product_id INTEGER PRIMARY KEY,
	name VARCHAR(20),
	category_id INTEGER
);