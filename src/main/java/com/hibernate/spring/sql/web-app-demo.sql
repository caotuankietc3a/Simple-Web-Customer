-- Active: 1661462119629@@127.0.0.1@3306@web_customer_tracker

CREATE USER
    'student-spring-hibernate' @'localhost' IDENTIFIED BY 'student-spring-hibernate';

GRANT
    ALL PRIVILEGES ON *.* TO 'student-spring-hibernate' @'localhost';

CREATE DATABASE IF NOT EXISTS web_customer_tracker;

DROP TABLE Customer;

CREATE TABLE
    Customer (
        id INT(11) AUTO_INCREMENT NOT NULL,
        name VARCHAR(45) DEFAULT NULL,
        email VARCHAR(45) UNIQUE DEFAULT NULL,
        PRIMARY KEY (id)
    );

CREATE TABLE
    User (
        id INT(11) NOT NULL AUTO_INCREMENT,
        name VARCHAR(45) NOT NULL UNIQUE,
        password VARCHAR(64) NOT NULL,
        active BOOLEAN NOT NULL,
        roles VARCHAR(128) NOT NULL,
        PRIMARY KEY(id)
    );

INSERT INTO
    `User`(name, password, active, roles)
VALUES ('kiet', '170102', 1, 'USER');

INSERT INTO
    `User`(name, password, active, roles)
VALUES ('admin', 'admin', 1, 'ADMIN');

INSERT INTO
    `Customer`(name, email)
VALUES (
        'CTK',
        'caotuankietc3a@gmail.com'
    );

INSERT INTO
    `Customer`(name, email)
VALUES (
        'CHK',
        'caohoangkietc3a@gmail.com'
    );

INSERT INTO `Customer`(name,email) VALUES('LTPL','ltpl@gmail.com');

INSERT INTO `Customer`(name,email) VALUES('TTQ','ttq@gmail.com');

INSERT INTO `Customer`(name,email) VALUES('Q','q@gmail.com');
