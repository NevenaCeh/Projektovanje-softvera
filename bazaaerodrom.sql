/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.6.17 : Database - seminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `seminarski`;

/*Table structure for table `avion` */

DROP TABLE IF EXISTS `avion`;

CREATE TABLE `avion` (
  `sifraAviona` int(5) NOT NULL,
  `nazivAviona` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`sifraAviona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `avion` */

insert  into `avion`(`sifraAviona`,`nazivAviona`) values (1,'Boing 747'),(2,'Boing 737'),(3,'MD-11F'),(4,'MQ-4C');

/*Table structure for table `let` */

DROP TABLE IF EXISTS `let`;

CREATE TABLE `let` (
  `rbLeta` int(10) NOT NULL AUTO_INCREMENT,
  `datumPolaska` date DEFAULT NULL,
  `mestoIdDestinacija` int(5) DEFAULT NULL,
  `sifraAVK` int(10) DEFAULT NULL,
  `sifraAviona` int(5) DEFAULT NULL,
  `sat` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`rbLeta`),
  KEY `mestoIdDestinacija` (`mestoIdDestinacija`),
  KEY `sifraAVK` (`sifraAVK`),
  KEY `sifraAviona` (`sifraAviona`),
  CONSTRAINT `let_ibfk_2` FOREIGN KEY (`mestoIdDestinacija`) REFERENCES `mesto` (`mestoId`),
  CONSTRAINT `let_ibfk_3` FOREIGN KEY (`sifraAVK`) REFERENCES `partner` (`sifraAVK`),
  CONSTRAINT `let_ibfk_4` FOREIGN KEY (`sifraAviona`) REFERENCES `avion` (`sifraAviona`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `let` */

insert  into `let`(`rbLeta`,`datumPolaska`,`mestoIdDestinacija`,`sifraAVK`,`sifraAviona`,`sat`) values (1,'2016-07-01',3,564,2,'20:15'),(2,'2016-08-20',2,1,1,'16:00'),(4,'2016-08-18',3,1,1,'15:00'),(5,'2016-04-16',5,1,2,'08:00'),(6,'2016-08-08',4,15987,2,'17:00'),(7,'2016-10-18',1,1,1,'18:10'),(10,'2016-06-23',3,55,1,'18:10'),(11,'2016-11-28',3,1,2,'14:00'),(12,'2017-01-20',5,564,1,'14:00'),(13,'2016-08-08',3,123,3,'08:15');

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `mestoId` int(5) NOT NULL,
  `ptt` bigint(20) NOT NULL,
  `naziv` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mestoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mesto` */

insert  into `mesto`(`mestoId`,`ptt`,`naziv`) values (1,11000,'Pariz'),(2,22222,'Madrid'),(3,33333,'Moskva'),(4,44444,'Prag'),(5,55555,'Zagreb');

/*Table structure for table `partner` */

DROP TABLE IF EXISTS `partner`;

CREATE TABLE `partner` (
  `sifraAVK` int(10) NOT NULL,
  `nazivAVK` varchar(20) DEFAULT NULL,
  `ziroRacun` varchar(18) DEFAULT NULL,
  `datumSklapanjaPartnerstva` date DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `telefon` varchar(20) DEFAULT NULL,
  `ulica` varchar(20) DEFAULT NULL,
  `broj` varchar(8) DEFAULT NULL,
  `mestoId` int(5) DEFAULT NULL,
  PRIMARY KEY (`sifraAVK`),
  KEY `partner_ibfk_1` (`mestoId`),
  CONSTRAINT `partner_ibfk_1` FOREIGN KEY (`mestoId`) REFERENCES `mesto` (`mestoId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `partner` */

insert  into `partner`(`sifraAVK`,`nazivAVK`,`ziroRacun`,`datumSklapanjaPartnerstva`,`email`,`telefon`,`ulica`,`broj`,`mestoId`) values (1,'AirSerbia','777777777777777777','2016-04-20','airSerbia@mejl.com','0123456789','Kralja Aleksandra','55',1),(55,'Swiftair','123456789123456789','2014-06-19','mejl','011555555','mile mikica','1',1),(123,'Mediteranean Air','123456789123456789','2016-06-20','bajaga.music.rs','0112123313','ulica','11b',1),(555,'Turkish Airlines','123456789123123456','2015-06-16','@','5555555','mile','5',1),(564,'WizzAir','981987987987987987','2016-06-25','main@wizz.com','0900 232 321','Narodnih heroja','28',1),(15987,'Lufthansa','987654321369852147','2016-06-25','lufthansa@mejl.com','058247','Cehov most','15',4);

/*Table structure for table `putnik` */

DROP TABLE IF EXISTS `putnik`;

CREATE TABLE `putnik` (
  `brojPasosa` varchar(10) NOT NULL,
  `ime` varchar(20) DEFAULT NULL,
  `prezime` varchar(20) DEFAULT NULL,
  `jmbg` varchar(13) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `telefon` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`brojPasosa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `putnik` */

insert  into `putnik`(`brojPasosa`,`ime`,`prezime`,`jmbg`,`email`,`telefon`) values ('123456789','Ana','Reb','3009993715257','anabanana@gmail.com','0116606475'),('555555','Nina','Tacovic','1234567891234','mau@mau.com','01122333'),('7777','pero','peric','7894561237894','pero@pperp.com','123456789'),('852','Zdravko','Colic','1597862547852','cola@gmail.com','011875478'),('852963','Verica','Ceh','2209964715285','cehverica@gmail.com','0641232735'),('875','Nevena','Ceh','789','@','543'),('888','Petar','Petrovic','789','mejl@mejl','123'),('987','Dino','Merlin','dino@hari','dino@dino.com','8456456');

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `brojRezervacije` int(10) NOT NULL,
  `rbLeta` int(10) NOT NULL,
  `brojPasosa` varchar(10) NOT NULL,
  `datumRezervacije` date DEFAULT NULL,
  `status` varchar(19) DEFAULT NULL,
  `zapisaoId` int(10) DEFAULT NULL,
  PRIMARY KEY (`brojRezervacije`,`rbLeta`,`brojPasosa`),
  KEY `rbLeta` (`rbLeta`),
  KEY `brojPasosa` (`brojPasosa`),
  KEY `zapisaoId` (`zapisaoId`),
  CONSTRAINT `rezervacija_ibfk_3` FOREIGN KEY (`zapisaoId`) REFERENCES `sluzbenik` (`sluzbenikId`),
  CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`rbLeta`) REFERENCES `let` (`rbLeta`),
  CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`brojPasosa`) REFERENCES `putnik` (`brojPasosa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`brojRezervacije`,`rbLeta`,`brojPasosa`,`datumRezervacije`,`status`,`zapisaoId`) values (1,2,'555555','2000-05-05','potvrdjena',2),(2,4,'852','2016-06-24','potvrdjena',3),(4,6,'852963','2016-06-25','potvrdjena',2),(5,10,'852','2016-06-25','potvrdjena',1),(6,6,'852','2016-06-25','nije potvrdjena',4),(7,7,'852963','2016-06-25','nije potvrdjena',2),(8,7,'875','2016-06-25','potvrdjena',3),(9,4,'875','2016-06-26','nije potvrdjena',1),(10,4,'852963','2016-06-26','potvrdjena',3),(11,6,'7777','2016-06-26','nije potvrdjena',4),(13,11,'852','2016-06-27','nije potvrdjena',1),(14,11,'875','2016-06-27','nije potvrdjena',1),(15,12,'852','2016-06-27','potvrdjena',1),(16,5,'852','2016-06-27','potvrdjena',1);

/*Table structure for table `sluzbenik` */

DROP TABLE IF EXISTS `sluzbenik`;

CREATE TABLE `sluzbenik` (
  `sluzbenikId` int(10) NOT NULL,
  `ime` varchar(20) DEFAULT NULL,
  `prezime` varchar(20) DEFAULT NULL,
  `korisnickoIme` varchar(20) DEFAULT NULL,
  `korisnickaSifra` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sluzbenikId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sluzbenik` */

insert  into `sluzbenik`(`sluzbenikId`,`ime`,`prezime`,`korisnickoIme`,`korisnickaSifra`) values (1,'Nevena','Ceh','necaceh','neca1820'),(2,'Igor','Milosevic','igorm','saga123'),(3,'Marija','Nikolic','nikolicm','nikolicka'),(4,'Jovana','Milosavljevic','milosavljevicj','pokahontas');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
