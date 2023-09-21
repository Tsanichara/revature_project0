--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
DROP TABLE Orders if exists;
DROP TABLE Customer if exists;
DROP TABLE Product if exists;
CREATE TABLE Customer(
id INT PRIMARY KEY,
f_name varchar(100)
);


CREATE TABLE Product(
productId INT PRIMARY KEY,
productName varchar(150),
productPrice INT
);

CREATE TABLE Orders(
order_id int primary key,
customer_id int,
product_id int,
foreign key (customer_id) references Customer(id),
foreign key (product_id) references Product(productId));


INSERT INTO Product (productId, productName, productPrice) VALUES (1, 'Apple', 5);
INSERT INTO Product (productId, productName, productPrice) VALUES (2,  'Chair', 40);
INSERT INTO Product (productId, productName, productPrice) VALUES (3, 'TV', 200);

INSERT INTO Customer (id, f_name) VALUES (1, 'John Doe');
INSERT INTO Customer (id, f_name) VALUES (2, 'Random Person');

INSERT INTO Orders (order_id, customer_id, product_id) VALUES (1234, 1, 3);

