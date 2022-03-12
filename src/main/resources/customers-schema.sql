DROP TABLE IF EXISTS customers;

CREATE TABLE customers(
id BIGINT GENERATED BY DEFAULT AS IDENTITY,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
email_address VARCHAR(254) NOT NULL,
post_code VARCHAR(8) NOT NULL,
PRIMARY KEY (id)
);