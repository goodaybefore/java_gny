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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `bd_num` int NOT NULL AUTO_INCREMENT,
  `bd_title` varchar(100) DEFAULT NULL,
  `bd_contents` longtext,
  `bd_reg_date` datetime DEFAULT NULL,
  `bd_up_date` datetime DEFAULT NULL,
  `bd_type` varchar(10) DEFAULT NULL,
  `bd_me_id` varchar(20) NOT NULL,
  `bd_ori_num` int NOT NULL,
  `bd_del` varchar(2) DEFAULT NULL,
  `bd_del_date` datetime DEFAULT NULL,
  `bd_views` int NOT NULL DEFAULT '0',
  `bd_up` int NOT NULL DEFAULT '0',
  `bd_down` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`bd_num`),
  KEY `FK_board_TO_board_1` (`bd_ori_num`),
  CONSTRAINT `FK_board_TO_board_1` FOREIGN KEY (`bd_ori_num`) REFERENCES `board` (`bd_num`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'제목1','내용1','2022-01-06 17:19:22',NULL,'일반','qwe',1,'Y','2022-01-07 15:51:48',0,0,0),(2,'2022-01-07 제목1','내용1','2022-01-07 09:44:55',NULL,'일반','qwe',2,'Y','2022-01-10 09:38:32',0,0,0),(3,'2022-01-10 게시글','ㅇㅇ','2022-01-10 09:38:44',NULL,'일반','qwe',3,'N',NULL,0,0,0),(4,'글쓰기 등록','등록','2022-01-10 09:39:22',NULL,'일반','qwe',4,'N',NULL,0,0,0),(5,'수정된 게시글입니다.2','내용 수정2','2022-01-10 09:41:08','2022-01-10 13:06:00','일반','qwe',5,'Y','2022-01-14 11:03:46',0,0,0),(6,'13일 첫 게시글 테스트','13일 첫 게시글 테스트 내용','2022-01-13 13:04:03',NULL,'일반','qwe',6,'Y','2022-01-14 11:03:23',0,0,0),(7,'2번째 수정','내용 수정','2022-01-13 13:07:14','2022-01-13 17:30:19','일반','qwe',7,'Y','2022-01-14 10:49:13',0,0,0),(8,'첨부파일 작업 중','첨부파일 작업 중','2022-01-14 14:19:56',NULL,'일반','qwe',8,'N',NULL,0,0,0),(9,'첨부파일 작업 중2','첨부파일 작업 중2','2022-01-14 14:36:02',NULL,'일반','qwe',9,'N',NULL,0,0,0),(10,'qwe','qwe','2022-01-14 14:48:00',NULL,'일반','qwe',10,'N',NULL,0,0,0),(11,'qweqwe','qweqwe','2022-01-14 14:48:09',NULL,'일반','qwe',11,'N',NULL,0,0,0),(12,'첨부파일 추가','첨부파일 추가','2022-01-14 15:15:10',NULL,'일반','qwe',12,'N',NULL,0,0,0),(13,'17일 테스트1','17일 테스트1','2022-01-17 11:29:31','2022-01-17 16:36:51','일반','qwe',13,'N',NULL,0,0,0),(14,'첨부파일???','첨부파일???','2022-01-17 16:48:19','2022-01-18 09:34:52','일반','qwe',14,'Y','2022-01-18 09:48:48',0,0,0),(15,'18일 테스트1','18일 테스트1','2022-01-18 09:50:14',NULL,'일반','qwe',15,'Y','2022-01-18 09:50:33',0,0,0),(16,'t1','','2022-01-18 11:09:26',NULL,'일반','qwe',16,'N',NULL,0,0,0),(17,'t2','','2022-01-18 11:09:28',NULL,'일반','qwe',17,'N',NULL,0,0,0),(18,'t3','','2022-01-18 11:09:32',NULL,'일반','qwe',18,'N',NULL,0,0,0),(19,'t4','','2022-01-18 11:09:37',NULL,'일반','qwe',19,'N',NULL,0,0,0),(20,'t5','','2022-01-18 11:09:41',NULL,'일반','qwe',20,'N',NULL,0,0,0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-09 23:31:01