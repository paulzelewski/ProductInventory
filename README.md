# ProductInventory
Simple inventory manager with mySql db.

Load ConnectorJ into your project library.

Create in your project dir and setup a db.properties file like below

# MySQL DB parameters
user=your_login
password=your_password
url=jdbc:mysql://localhost:3306/your_db_name
serverTimezone=UTC

SQL command to create db:

create table products(
id int unsigned NOT NULL,
product varchar(255) NOT NULL,
price decimal(7,2) NOT NULL,
quantity int unsigned NOT NULL,
primary key (id)
);

Have a fun!
