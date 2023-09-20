--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
DROP TABLE Customer if exists;
DROP TABLE Product if exists;
CREATE TABLE Customer(
id INT PRIMARY KEY,
f_name varchar(100)
)


CREATE TABLE Product(
productId INT PRIMARY KEY,
productName varchar(150),
productPrice INT
)

