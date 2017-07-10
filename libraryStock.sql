-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: libraryStock
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CategoryTable`
--

DROP TABLE IF EXISTS `CategoryTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CategoryTable` (
  `CategoryName` varchar(10) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CategoryTable`
--

LOCK TABLES `CategoryTable` WRITE;
/*!40000 ALTER TABLE `CategoryTable` DISABLE KEYS */;
INSERT INTO `CategoryTable` VALUES ('计算机'),('科学'),('文学'),('医学'),('艺术');
/*!40000 ALTER TABLE `CategoryTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adminTable`
--

DROP TABLE IF EXISTS `adminTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminTable` (
  `AdminName` varchar(14) CHARACTER SET utf8 NOT NULL,
  `Password` varchar(10) NOT NULL,
  `CardId` varchar(18) NOT NULL,
  `State` varchar(4) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminTable`
--

LOCK TABLES `adminTable` WRITE;
/*!40000 ALTER TABLE `adminTable` DISABLE KEYS */;
INSERT INTO `adminTable` VALUES ('admin','123','000001','激活');
/*!40000 ALTER TABLE `adminTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookInfo`
--

DROP TABLE IF EXISTS `bookInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookInfo` (
  `BookID` char(8) NOT NULL,
  `BookName` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Author` varchar(30) CHARACTER SET utf8 NOT NULL,
  `PublishingHouse` varchar(48) CHARACTER SET utf8 DEFAULT NULL,
  `Type` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `BookPrice` decimal(10,0) DEFAULT NULL,
  `CategoryName` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `ISBN` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookInfo`
--

LOCK TABLES `bookInfo` WRITE;
/*!40000 ALTER TABLE `bookInfo` DISABLE KEYS */;
INSERT INTO `bookInfo` VALUES ('000001','毛泽东传','(美)特里尔','人民大学出版社','可借',55,'文学','7519750190531'),('000002','Java语言与面向对象程序设计','张利锋孙丽杨晓玲','清华大学出版社','可借',55,'计算机','751975019753'),('000003','Dreamweaver网页设计与制作教程','王春风、李勇、唐拥政、卢静','清华大学出版社','可借',49,'计算机','751953570190537'),('000004','时间移民','刘慈欣','江苏文艺出版社','可借',53,'文学','51539531'),('000005','海子的诗','海子','中国书店出版社','可借',25,'科学','75197531510531'),('000006','舒婷的诗','舒婷','人民文学出版社','可借',20,'文学','75197513531'),('000007','余光中经典作品','余光中','当代世界出版社','可借',23,'文学','755310190531'),('000008','做最好的自己','李开复','人民出版社','可借',43,'文学','7519757519531'),('000009','细节决定成败','汪中求','新华出版社','可借',30,'文学','75197903195531'),('000010','人性的弱点全集','卡耐基','中国发展出版社','可借',15,'艺术','751519190531'),('000011','本草纲目','李时珍','中国书店出版社','可借',25,'医学','751953750531');
/*!40000 ALTER TABLE `bookInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrowBookInfo`
--

DROP TABLE IF EXISTS `borrowBookInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrowBookInfo` (
  `BorrowBookID` char(8) NOT NULL,
  `ReaderID` char(8) NOT NULL,
  `BorrowDate` datetime DEFAULT NULL,
  `ReturnDate` datetime DEFAULT NULL,
  `BorrowID` int(11) NOT NULL AUTO_INCREMENT,
  `StafferName` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`BorrowID`),
  KEY `fk_ReaderID` (`ReaderID`),
  CONSTRAINT `fk_ReaderID` FOREIGN KEY (`ReaderID`) REFERENCES `readerInfo` (`ReaderID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowBookInfo`
--

LOCK TABLES `borrowBookInfo` WRITE;
/*!40000 ALTER TABLE `borrowBookInfo` DISABLE KEYS */;
INSERT INTO `borrowBookInfo` VALUES ('000001','000001','2017-07-10 16:43:06',NULL,12,'admin');
/*!40000 ALTER TABLE `borrowBookInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departmentInfo`
--

DROP TABLE IF EXISTS `departmentInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departmentInfo` (
  `DeptID` char(8) NOT NULL,
  `DeptName` varchar(16) CHARACTER SET utf8 NOT NULL,
  `DeptFunc` varchar(20) CHARACTER SET utf8 NOT NULL,
  `DeptPhone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`DeptID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departmentInfo`
--

LOCK TABLES `departmentInfo` WRITE;
/*!40000 ALTER TABLE `departmentInfo` DISABLE KEYS */;
INSERT INTO `departmentInfo` VALUES ('01','管理部','管理各种事务','12345');
/*!40000 ALTER TABLE `departmentInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procurementInfo`
--

DROP TABLE IF EXISTS `procurementInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procurementInfo` (
  `ProcurementID` int(11) NOT NULL AUTO_INCREMENT,
  `ProviderID` char(8) NOT NULL,
  `StafferID` char(6) NOT NULL,
  `BookID` char(8) NOT NULL,
  `ProcurementDate` datetime DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `UnitPrice` decimal(10,0) DEFAULT NULL,
  `AllPrice` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ProcurementID`),
  KEY `fk_ProviderID` (`ProviderID`),
  CONSTRAINT `fk_ProviderID` FOREIGN KEY (`ProviderID`) REFERENCES `providerInfo` (`ProviderID`)
) ENGINE=InnoDB AUTO_INCREMENT=100006 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procurementInfo`
--

LOCK TABLES `procurementInfo` WRITE;
/*!40000 ALTER TABLE `procurementInfo` DISABLE KEYS */;
INSERT INTO `procurementInfo` VALUES (100005,'000001','000001','000002','2017-03-05 00:00:00',5,7,35);
/*!40000 ALTER TABLE `procurementInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `providerInfo`
--

DROP TABLE IF EXISTS `providerInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `providerInfo` (
  `ProviderID` char(8) NOT NULL,
  `ProviderName` varchar(30) CHARACTER SET utf8 NOT NULL,
  `ProviderAddress` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `PostCode` char(6) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ProviderID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `providerInfo`
--

LOCK TABLES `providerInfo` WRITE;
/*!40000 ALTER TABLE `providerInfo` DISABLE KEYS */;
INSERT INTO `providerInfo` VALUES ('000001','人民大学出版社','星河大街78号','343422','171084@qq.com','31973103573'),('000002','清华大学出版社','绿景书城343号','343422','172344@qq.com','3193455573'),('000003','江苏文艺出版社','寿望大街79号','343342','123444@qq.com','31342203573'),('000004','人民文学出版社','汇景广场99号','343432','172352344@qq.com','31352103573'),('000005','当代世界出版社','新世纪时代234号','398762','146354@qq.com','395313'),('000006','中国书店出版社','绿景书城389号','30752','194574@qq.com','9053103'),('000007','人民出版社','百纳旧街78235号','346345','62345@qq.com','319051353'),('000008','新华出版社','新城735号','347575','62345@qq.com','3197125343'),('000009','中国发展出版社','京盛大街72345号','34325','1305391@qq.com','31075953'),('000010','中国书店出版社','有条大街9527','353155','6275153@qq.com','3053193');
/*!40000 ALTER TABLE `providerInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseCarTable`
--

DROP TABLE IF EXISTS `purchaseCarTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseCarTable` (
  `ProcurementID` int(11) NOT NULL AUTO_INCREMENT,
  `ProviderID` char(8) NOT NULL,
  `StafferID` char(6) NOT NULL,
  `BookID` char(8) NOT NULL,
  `ProcurementDate` datetime DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  `UnitPrice` decimal(10,0) DEFAULT NULL,
  `AllPrice` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ProcurementID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseCarTable`
--

LOCK TABLES `purchaseCarTable` WRITE;
/*!40000 ALTER TABLE `purchaseCarTable` DISABLE KEYS */;
INSERT INTO `purchaseCarTable` VALUES (1,'000001','000001','000001','2017-07-10 02:05:21',2,55,110);
/*!40000 ALTER TABLE `purchaseCarTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readerInfo`
--

DROP TABLE IF EXISTS `readerInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `readerInfo` (
  `ReaderID` char(8) NOT NULL,
  `ReaderName` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Sex` varchar(2) CHARACTER SET utf8 NOT NULL,
  `IdentityID` char(18) NOT NULL,
  `CertificateDate` datetime DEFAULT NULL,
  `ReaderType` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  `Address` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `Password` varchar(10) DEFAULT NULL,
  `State` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ReaderID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readerInfo`
--

LOCK TABLES `readerInfo` WRITE;
/*!40000 ALTER TABLE `readerInfo` DISABLE KEYS */;
INSERT INTO `readerInfo` VALUES ('000001','小宇','男','35519010139','2017-07-09 20:14:15','学生','51531','广东广州','456','激活');
/*!40000 ALTER TABLE `readerInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `readerborrowview`
--

DROP TABLE IF EXISTS `readerborrowview`;
/*!50001 DROP VIEW IF EXISTS `readerborrowview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `readerborrowview` AS SELECT 
 1 AS `读者编号`,
 1 AS `借书时间`,
 1 AS `应还时间`,
 1 AS `图书编号`,
 1 AS `ISBN号`,
 1 AS `图书书名`,
 1 AS `作者`,
 1 AS `出版社`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `returnBookInfo`
--

DROP TABLE IF EXISTS `returnBookInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `returnBookInfo` (
  `ReturnBookID` char(8) NOT NULL,
  `ReturnID` int(11) NOT NULL AUTO_INCREMENT,
  `BorrowID` char(8) NOT NULL,
  `ReaderID` char(8) NOT NULL,
  `StorageID` char(8) NOT NULL,
  `StafferID` char(6) NOT NULL,
  `ReturnDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ReturnID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `returnBookInfo`
--

LOCK TABLES `returnBookInfo` WRITE;
/*!40000 ALTER TABLE `returnBookInfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `returnBookInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `returnbookview`
--

DROP TABLE IF EXISTS `returnbookview`;
/*!50001 DROP VIEW IF EXISTS `returnbookview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `returnbookview` AS SELECT 
 1 AS `ReaderName`,
 1 AS `BookID`,
 1 AS `ISBN`,
 1 AS `BookName`,
 1 AS `BorrowDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `stafferInfo`
--

DROP TABLE IF EXISTS `stafferInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stafferInfo` (
  `StafferID` char(6) NOT NULL,
  `DeptID` char(8) NOT NULL,
  `StafferName` varchar(8) CHARACTER SET utf8 NOT NULL,
  `Sex` varchar(2) CHARACTER SET utf8 NOT NULL,
  `IdentityID` char(18) NOT NULL,
  `Position` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  `Password` varchar(10) NOT NULL,
  `State` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`StafferID`),
  KEY `fk_DeptID` (`DeptID`),
  CONSTRAINT `fk_DeptID` FOREIGN KEY (`DeptID`) REFERENCES `departmentInfo` (`DeptID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stafferInfo`
--

LOCK TABLES `stafferInfo` WRITE;
/*!40000 ALTER TABLE `stafferInfo` DISABLE KEYS */;
INSERT INTO `stafferInfo` VALUES ('000001','01','admin','男','123456789','管理员','7303246','123','激活');
/*!40000 ALTER TABLE `stafferInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storageInfo`
--

DROP TABLE IF EXISTS `storageInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storageInfo` (
  `StorageID` int(11) NOT NULL AUTO_INCREMENT,
  `BookID` char(8) NOT NULL,
  `StafferID` varchar(18) NOT NULL,
  `StorageAddress` varchar(30) CHARACTER SET utf8 NOT NULL,
  `StorageDate` datetime DEFAULT NULL,
  `AllMount` int(11) DEFAULT NULL,
  `BorrowAmount` int(11) DEFAULT NULL,
  `UnitPrice` decimal(10,0) DEFAULT NULL,
  `AllPrice` decimal(10,0) DEFAULT NULL,
  `ProviderID` char(8) DEFAULT NULL,
  `State` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  `ISBN` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`StorageID`),
  KEY `fk_BookID` (`BookID`),
  CONSTRAINT `fk_BookID` FOREIGN KEY (`BookID`) REFERENCES `bookInfo` (`BookID`)
) ENGINE=InnoDB AUTO_INCREMENT=100014 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storageInfo`
--

LOCK TABLES `storageInfo` WRITE;
/*!40000 ALTER TABLE `storageInfo` DISABLE KEYS */;
INSERT INTO `storageInfo` VALUES (100000,'000001','000001','四楼232号','2017-07-09 20:03:13',1,1,55,55,'000001','借出','7519750190531'),(100001,'000002','000001','四楼111号','2017-07-09 20:03:13',1,1,75,75,'000002','可借','751975019753'),(100002,'000003','000001','五楼333号','2017-07-09 20:03:13',1,1,25,25,'000002','可借','751953570190537'),(100003,'000004','000001','五楼666号','2017-07-09 20:03:13',1,1,56,56,'000003','可借','51539531'),(100004,'000005','000001','八楼555号','2017-07-09 20:03:13',1,1,23,23,'000010','可借','75197531510531'),(100005,'000006','000001','七楼778号','2017-07-09 20:03:13',1,1,65,65,'000004','可借','75197513531'),(100006,'000007','000001','四楼444号','2017-07-09 20:03:13',1,1,86,86,'000005','可借','755310190531'),(100007,'000008','000001','六楼666号','2017-07-09 20:03:13',1,1,23,23,'000007','可借','7519757519531'),(100008,'000009','000001','三楼222号','2017-07-09 20:03:13',1,1,65,65,'000008','可借','75197903195531'),(100011,'000010','000001','九楼999号','2017-03-03 00:00:00',1,1,33,33,'000001','可借','3653476548'),(100013,'000011','000001','hhthth','2019-03-01 00:00:00',1,1,53,53,'11','可阅','31531953');
/*!40000 ALTER TABLE `storageInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `readerborrowview`
--

/*!50001 DROP VIEW IF EXISTS `readerborrowview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`rotamx`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `readerborrowview` AS select `borrowbookinfo`.`ReaderID` AS `读者编号`,`borrowbookinfo`.`BorrowDate` AS `借书时间`,((`borrowbookinfo`.`BorrowDate` + interval 1 day) + interval 2 month) AS `应还时间`,`storageinfo`.`BookID` AS `图书编号`,`bookinfo`.`ISBN` AS `ISBN号`,`bookinfo`.`BookName` AS `图书书名`,`bookinfo`.`Author` AS `作者`,`bookinfo`.`PublishingHouse` AS `出版社` from (((`borrowbookinfo` join `readerinfo` on((`borrowbookinfo`.`ReaderID` = `readerinfo`.`ReaderID`))) join `storageinfo` on((`borrowbookinfo`.`BorrowBookID` = `storageinfo`.`BookID`))) join `bookinfo` on((`storageinfo`.`ISBN` = `bookinfo`.`ISBN`))) where isnull(`borrowbookinfo`.`ReturnDate`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `returnbookview`
--

/*!50001 DROP VIEW IF EXISTS `returnbookview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`rotamx`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `returnbookview` AS select `readerinfo`.`ReaderName` AS `ReaderName`,`storageinfo`.`BookID` AS `BookID`,`storageinfo`.`ISBN` AS `ISBN`,`bookinfo`.`BookName` AS `BookName`,`borrowbookinfo`.`BorrowDate` AS `BorrowDate` from (((`readerinfo` join `storageinfo`) join `borrowbookinfo` on((`storageinfo`.`BookID` = `borrowbookinfo`.`BorrowBookID`))) join `bookinfo` on(((`storageinfo`.`ISBN` = `bookinfo`.`ISBN`) and (`readerinfo`.`ReaderID` = `borrowbookinfo`.`ReaderID`)))) where isnull(`borrowbookinfo`.`ReturnDate`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-10 17:42:11
