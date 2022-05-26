DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `last_name` VARCHAR(40) DEFAULT NULL,
    `username` VARCHAR(40) DEFAULT NULL,
    `password` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`cost` INT(11) DEFAULT NULL,
`name` VARCHAR(40) DEFAULT NULL,
PRIMARY KEY(`id`)
);