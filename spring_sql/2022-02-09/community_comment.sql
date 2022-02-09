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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `co_num` int NOT NULL AUTO_INCREMENT,
  `co_bd_num` int NOT NULL,
  `co_me_id` varchar(20) NOT NULL,
  `co_reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `co_del` varchar(2) NOT NULL DEFAULT 'N',
  `co_ori_num` int NOT NULL,
  `co_contents` longtext NOT NULL,
  PRIMARY KEY (`co_num`),
  KEY `co_bd_num_idx` (`co_bd_num`),
  KEY `co_me_id_idx` (`co_me_id`),
  CONSTRAINT `co_bd_num` FOREIGN KEY (`co_bd_num`) REFERENCES `board` (`bd_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `co_me_id` FOREIGN KEY (`co_me_id`) REFERENCES `member` (`me_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,47,'qwer','2022-01-24 11:03:13','Y',1,'dd'),(2,47,'qwer','2022-01-24 11:06:51','N',2,'ddddd'),(3,47,'qwer','2022-01-24 11:07:08','N',3,'qwerqwer'),(4,47,'qwer','2022-01-24 11:09:01','N',4,'test1'),(5,47,'qwer','2022-01-24 11:12:28','N',5,'test2'),(6,47,'qwer','2022-01-24 14:25:01','N',6,'qwerqwerwerfsdfzds'),(7,47,'qwer','2022-01-24 15:25:51','N',7,'댓1'),(8,47,'qwer','2022-01-24 15:25:56','N',8,'댓224'),(9,47,'qwer','2022-01-24 15:26:05','N',9,'댓3'),(10,47,'qwer','2022-01-24 15:26:11','N',10,'댓44'),(11,47,'qwer','2022-01-24 15:26:18','N',11,'댓5678\n'),(12,48,'qwer','2022-01-26 14:12:16','N',12,'gogo대끌'),(13,48,'qwer','2022-01-26 14:43:18','N',13,'22222대끌'),(14,48,'qwer','2022-01-26 15:34:31','N',14,'댓글 한뻔떠'),(15,48,'qwer','2022-01-26 15:37:19','N',15,'3:37 댓글\n'),(16,48,'qwer','2022-01-26 15:37:52','N',16,'refresh test'),(17,48,'qwer','2022-01-26 15:38:03','N',17,'refresh test2'),(18,48,'qwer','2022-01-26 15:38:14','N',18,'refresh3'),(19,48,'qwer','2022-01-26 15:38:35','N',19,'refresh4찐임ㅎ'),(20,48,'qwer','2022-01-26 15:38:48','N',20,'refresh5 \"Wls\"'),(21,48,'qwer','2022-01-26 15:39:28','N',21,'진짜 refresh ... 모든걸했따'),(22,48,'qwer','2022-01-27 12:08:01','N',22,''),(23,48,'qwer','2022-01-27 12:08:03','N',23,''),(24,48,'qwer','2022-01-27 12:09:10','N',24,''),(25,48,'qwer','2022-01-27 12:12:15','N',25,''),(26,48,'qwer','2022-01-27 12:16:06','N',26,'333sdfa'),(27,48,'qwer','2022-01-27 12:16:49','N',27,'즉시반영이 왜 안되는거지'),(28,48,'qwer','2022-01-27 12:23:12','N',28,'댓글222'),(29,48,'qwer','2022-01-27 12:40:03','N',29,'새로고침되냐'),(30,48,'qwer','2022-01-27 12:40:30','N',30,'안되는그같은데'),(31,48,'qwer','2022-01-27 12:41:18','N',31,'ㅇㄻㄴㅇㄹ'),(32,48,'qwer','2022-01-27 12:42:02','N',32,'button-comment에 click이벤트 등록'),(33,48,'qwer','2022-01-27 12:42:13','N',33,'button-comment에 click이벤트 등록2'),(34,48,'qwer','2022-01-27 12:43:01','N',34,'ㅇㅇ'),(35,48,'qwer','2022-01-27 12:48:16','N',35,'음...'),(36,48,'qwer','2022-01-27 12:50:20','Y',36,'다시'),(37,48,'qwer','2022-01-27 12:53:08','Y',37,'ㅇㅇ'),(38,42,'qwer','2022-01-27 14:13:39','N',38,'dd'),(42,47,'qwer','2022-02-03 13:01:04','N',11,'eeee');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
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
