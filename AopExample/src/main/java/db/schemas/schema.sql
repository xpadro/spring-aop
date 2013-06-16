drop table clients if exists;
drop table orders if exists;

create table clients (clientId integer identity primary key, name varchar(255));
create table orders (orderId integer identity primary key, description varchar(255));
