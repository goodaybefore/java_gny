-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: community
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `me_id` varchar(20) NOT NULL,
  `me_pw` varchar(255) DEFAULT NULL,
  `me_name` varchar(30) DEFAULT NULL,
  `me_gender` varchar(6) DEFAULT NULL,
  `me_birth` date DEFAULT NULL,
  `me_address` varchar(100) DEFAULT NULL,
  `me_phone` varchar(13) DEFAULT NULL,
  `me_authority` varchar(10) NOT NULL DEFAULT '회원',
  `me_email` varchar(100) NOT NULL DEFAULT '',
  `me_session_id` varchar(255) DEFAULT NULL,
  `me_session_limit` datetime DEFAULT NULL,
  PRIMARY KEY (`me_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('34','$2a$10$c4RxiQyQAQ7/6hkQ/QaTxucl3G/S0eLQIlA5xIEkvtw9mDeHhF0O2','ttt','male','2022-01-01',' ','010-7894-6514','회원','goodaybefore@gmail.com',NULL,NULL),('abc123','$2a$10$uz3Z7KyGkib1UDJzjl3E1.8iFszkQZM9vD2xXhJ5VIICYn3jhZBeG','홍길동','male','2000-10-10','충북 청주시 서원구 사직대로 109 청주그린','011-1234-5678','회원','goodaybefore@gmail.com',NULL,NULL),('asd','$2a$10$tWEl5jJDPKzoYKBJ6MG9puUUyY957EO6Ybx7lh8XRZ9An1ZECndl.','asd','male','2000-10-10',' ','011-1234-5678','관리자','goodaybefore@gmail.com',NULL,NULL),('bbb','$2a$10$.MBxrIRqKE9MPH358lUfA.QfVM0gU3fSM0S0nAPQ.y6yTUI0LvIaS','bbb','male','2022-01-05','','010-6325-5721','회원','goodaybefore@gmail.com',NULL,NULL),('erwerqwer','$2a$10$GLg3TeW3xJ//1tyjJyIac.NU3M6ZktY507V1TsgA9j4Eo62MbUnxq','graty','male','2022-01-05',' ','011-1111-2222','회원','goodaybefore@gmail.com',NULL,NULL),('mmm','$2a$10$qlSMZxGQnLFZ3z9vAOOEA.D47jVk5LVlL7i0YvhOkTaNsYOWXOLBG','mmm','female','2022-01-05',' ','010-6325-5721','회원','goodaybefore@gmail.com',NULL,NULL),('nnnnn','$2a$10$Zj31ER15u/yZyJ3yvBySreMbBOsNv7bkw2AlkVbk/DDvX9CldEqjG','nnn','male','2022-01-05',' ','010-6325-5721','회원','goodaybefore@gmail.com',NULL,NULL),('qwe','$2a$10$FvIs.y3sgIDT0sGo5r.R/.piQvkE4NiB8sk7fGb8IjDKw2UuO521C','홍길동','male','2000-10-10','충북 청주시 서원구 사직대로 109 청주그린','011-1234-5678','슈퍼 관리자','goodaybefore@gmail.com','none','2022-02-07 16:36:36'),('qwe123','$2a$10$WWGKumq27tzYlO8BYcZ5UOIx/vpQAl6g7pzfHf.NMBIFcv/wvBAIu','qwe123','male','2000-10-10','충북 청주시 서원구 사직대로 109 청주그린','011-1234-5678','회원','goodaybefore@gmail.com',NULL,NULL),('qweqwe','$2a$10$eM3gNwOCpHZcezbp4sbP6eAzK.fKxIvIBLeAMb7EuEEWLMhHRAQhi','qweqwe','female','2000-10-10','충북 청주시 서원구 사직대로 109 청주그린','011-1234-5678','회원','goodaybefore@gmail.com',NULL,NULL),('qwer','$2a$10$woowEuo9fu9AsOuRktb2gu7v8f1/AGQNgGxWh4ipMSvDhOLpw5DbK','qwerty','male','2022-01-06',' ','011-1111-2222','회원','goodaybefore@gmail.com',NULL,NULL),('zxc','$2a$10$80kZkODJIq.Sk16c8ipfTOCfsXOJgfi8lijf635rYviuPDHL0i4hy','zxc','female','2022-01-24','충북 청주시 서원구 사직대로 109 청주그린','011-1234-5678','회원','goodaybefore@gmail.com',NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-09 23:31:02
