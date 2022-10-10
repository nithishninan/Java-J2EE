/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.10-log : Database - edureka
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`edureka` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `edureka`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `Name` varchar(40) DEFAULT NULL,
  `DOB` varchar(10) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Emailid` varchar(40) DEFAULT NULL,
  `AccountType` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`Name`,`DOB`,`Address`,`Emailid`,`AccountType`) values ('Nithish','2001-10-17','Bellandur, Bangalore','nit@gmail.com','currentaccount'),('Vicky','2019-02-13','jp nagar','vicky@gmail.com','currentaccount');

/*Table structure for table `amount_transaction` */

DROP TABLE IF EXISTS `amount_transaction`;

CREATE TABLE `amount_transaction` (
  `Sl. No.` int(40) DEFAULT NULL,
  `Date` varchar(40) DEFAULT NULL,
  `Description` varchar(80) DEFAULT NULL,
  `Cheque No` int(80) DEFAULT NULL,
  `Withdraw` int(80) DEFAULT NULL,
  `Deposit` int(80) DEFAULT NULL,
  `Available Balance` int(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `amount_transaction` */

insert  into `amount_transaction`(`Sl. No.`,`Date`,`Description`,`Cheque No`,`Withdraw`,`Deposit`,`Available Balance`) values (1,'19-oct-2014','Deposit',0,0,1000,250000),(2,'21-oct-2014','Withdraw from ATM',0,5000,0,245000),(3,'29-oct-2014','Cheque transaction',253546,0,15000,260000);

/*Table structure for table `creditauthority` */

DROP TABLE IF EXISTS `creditauthority`;

CREATE TABLE `creditauthority` (
  `Name` varchar(40) DEFAULT NULL,
  `CardNo` varchar(40) DEFAULT NULL,
  `CVV` varchar(40) DEFAULT NULL,
  `Amount` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `creditauthority` */

insert  into `creditauthority`(`Name`,`CardNo`,`CVV`,`Amount`) values ('Nithish','AFDN3325','22452','2250000'),('Vicky','jldldksodjo','hh55555','55253'),('Vicky ghl','bklmo45','jlkhj','55253'),('Rocky','SQ45789','hh55555','4789225');

/*Table structure for table `user_pass` */

DROP TABLE IF EXISTS `user_pass`;

CREATE TABLE `user_pass` (
  `user id` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_pass` */

insert  into `user_pass`(`user id`,`password`) values ('nithish','nithish');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;