create database HotelBooking;
use HotelBooking;

CREATE TABLE Hotel
(
    `id`            int         NOT NULL AUTO_INCREMENT,
    `apartmentName` varchar(45) NOT NULL,
    `roomCount`     int         NOT NULL DEFAULT '1',
    `price`         int         NOT NULL,
    `isBooked`      bool        NOT NULL DEFAULT FALSE,

    PRIMARY KEY (`id`)
);

CREATE TABLE USER
(
    `id`           int         NOT NULL AUTO_INCREMENT,
    `userName`     varchar(45) unique,
    `userPassword` varchar(45) NOT NULL,
    `userRole`     int         NOT NULL DEFAULT '0',
    `idApartment`  int,

    PRIMARY KEY (`id`),
    KEY `FK_Apartment` (`idApartment`),
    CONSTRAINT `FK_Apartment` FOREIGN KEY (`idApartment`) REFERENCES `Hotel` (`id`)
);

INSERT INTO HotelBooking.Hotel (`apartmentName`, `roomCount`, `price`, `isBooked`)
VALUES ('Room1', '1', '250', FALSE);

INSERT INTO HotelBooking.Hotel (`apartmentName`, `roomCount`, `price`, `isBooked`)
VALUES ('Room2', '2', '500', FALSE);

INSERT INTO HotelBooking.Hotel (`apartmentName`, `roomCount`, `price`, `isBooked`)
VALUES ('Room3', '3', '750', FALSE);

INSERT INTO HotelBooking.Hotel (`apartmentName`, `roomCount`, `price`, `isBooked`)
VALUES ('Room4', '4', '1000', FALSE);

INSERT INTO HotelBooking.USER (`userName`, `userPassword`, `userRole`)
VALUES ('admin', 'admin', '1');