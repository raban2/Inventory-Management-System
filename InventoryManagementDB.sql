/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 8.0.36 : Database - supermarketemployeedb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`supermarketemployeedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `supermarketemployeedb`;

/*Table structure for table `bill` */

DROP TABLE IF EXISTS `bill`;

CREATE TABLE `bill` (
  `billNo` int NOT NULL,
  `productId` int NOT NULL,
  `customerId` int NOT NULL,
  `purchaseDate` varchar(20) NOT NULL,
  `purchQuantity` int NOT NULL,
  `discount` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`billNo`),
  KEY `productId` (`productId`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`ProductId`),
  CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `bill` */

insert  into `bill`(`billNo`,`productId`,`customerId`,`purchaseDate`,`purchQuantity`,`discount`,`amount`) values 
(1,103,1,'2024-3-17',1,8000,300000),
(2,100,7,'',2,1000,69000),
(3,102,7,'',2,800,60800),
(5,104,7,'',2,1600,378400),
(10,101,47,'',2,2000,52000),
(11,105,47,'',2,2000,62000),
(13,102,54,'',2,222,61378),
(14,100,55,'',12,10,419990);

/*Table structure for table `cashier` */

DROP TABLE IF EXISTS `cashier`;

CREATE TABLE `cashier` (
  `cashierId` int NOT NULL,
  `Cashier_Name` varchar(20) NOT NULL,
  `Mobile_Number` varchar(15) NOT NULL,
  `Address` varchar(20) NOT NULL,
  `Email_ID` varchar(100) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`cashierId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `cashier` */

insert  into `cashier`(`cashierId`,`Cashier_Name`,`Mobile_Number`,`Address`,`Email_ID`,`Password`) values 
(1,'Jagdam Kathariya','9828448899','Imadol','Jagdam','Jagdam.7$');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customerId` int NOT NULL AUTO_INCREMENT,
  `customerName` varchar(100) NOT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

insert  into `customer`(`customerId`,`customerName`) values 
(1,'Raban Kathariya'),
(2,'Jagdam Kathariya'),
(3,'Shovit Kathariya'),
(4,'Shovit Kathariya'),
(5,'misah '),
(6,'misah '),
(7,'Jaya'),
(8,'Raban'),
(9,'Raban'),
(10,'Jagdam'),
(11,'12'),
(12,'rABAN'),
(13,'Raban'),
(14,'1'),
(15,'Shovit'),
(16,'Raban'),
(17,'Raban'),
(18,'Raban'),
(19,'Raban'),
(20,'Raban'),
(21,'raban'),
(22,'Raban'),
(23,'Jakc'),
(24,'Jakc'),
(25,'Jakc'),
(26,'Jakc'),
(27,'Shovit '),
(28,'Rupesh'),
(29,'Promish'),
(30,'Jaya'),
(31,'Jaya'),
(32,'Jaya'),
(33,'Jaya'),
(34,'Jaya'),
(35,'Jaya'),
(36,'Jaya'),
(37,'Misa'),
(38,''),
(39,'2'),
(40,'Java'),
(41,'Jaya'),
(42,'Jaya'),
(43,'jaya'),
(44,'Jaya'),
(45,'asdas'),
(46,'asdas'),
(47,'adad'),
(48,'Jaya'),
(49,'Jaya'),
(50,'Jaya'),
(51,'Jaya'),
(52,'adad'),
(53,'adad'),
(54,'dasda'),
(55,'adada');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `empId` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `employee` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `ProductId` int NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(100) NOT NULL,
  `Available` int NOT NULL,
  `Mrp` int NOT NULL,
  PRIMARY KEY (`ProductId`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `product` */

insert  into `product`(`ProductId`,`ProductName`,`Available`,`Mrp`) values 
(100,'Lenovo',9,35000),
(101,'Compaq',18,27000),
(102,'Dell',10,30800),
(103,'Acer',9,308000),
(104,'Toshiba',9,190000),
(105,'Sony Vio',14,32000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
