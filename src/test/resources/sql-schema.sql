drop database ims;

CREATE DATABASE IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `last_name` VARCHAR(40) DEFAULT NULL,
    `username` VARCHAR(40) DEFAULT NULL,
    `password` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `ims`.`items` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`cost` INT(100) DEFAULT NULL,
`name` VARCHAR(40) DEFAULT NULL,
PRIMARY KEY (`id`)
);

drop table if exists `ims`.`orders`;
create table orders(
ID int not null AUTO_INCREMENT,
customerID int not null,
cost double not null,
primary key (orderID),
foreign key(customerID) references customers(id) on delete cascade on update cascade
);