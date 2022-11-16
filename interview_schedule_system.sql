-- MySQL dump 10.13  Distrib 5.7.32, for Win64 (x86_64)
--
-- Host: localhost    Database: interview_schedule_system
-- ------------------------------------------------------
-- Server version	5.7.32-log

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
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `department_code` varchar(2) NOT NULL,
  `department_name` varchar(255) NOT NULL,
  `is_deleted` int(11) NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_89g8qie2y696a3tarmty43sq9` (`department_code`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'2021-06-11 14:14:23','01','テスト',0,'2021-06-11 14:14:23'),(2,'2021-06-11 14:14:52','02','テスト２',0,'2021-06-11 14:14:52'),(3,'2021-06-11 14:15:29','3','テスト３',1,'2021-06-14 11:49:54'),(4,'2021-06-11 14:39:21','04','テスト４',0,'2021-06-11 14:39:21'),(5,'2021-06-11 14:40:23','あ５','テスト５',1,'2021-06-14 11:49:35'),(6,'2021-06-11 14:52:20','09','テスト９',0,'2021-06-11 20:23:48'),(7,'2021-06-11 15:50:32','07','テスト７',0,'2021-06-11 15:50:32'),(8,'2021-06-11 20:25:46','11','営業部',0,'2021-06-14 11:36:18'),(9,'2021-06-11 20:27:35','15','システム部',0,'2021-06-11 20:27:35');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_flag` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `employee_code` varchar(4) NOT NULL,
  `employee_name` varchar(255) NOT NULL,
  `is_deleted` int(11) NOT NULL,
  `password` varchar(64) NOT NULL,
  `updated_at` datetime NOT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_etqhw9qqnad1kyjq3ks1glw8x` (`employee_code`),
  KEY `FKgy4qe3dnqrm3ktd76sxp7n4c2` (`department_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,0,'2021-06-15 13:25:00','0001','あああ',0,'43238450C7D4D929E14D6A12A84941D44C26FBDC11D2769C6F8CE54979D26EBC','2021-06-15 13:25:00',9),(2,1,'2021-06-15 13:28:33','0002','いいいいい',0,'FD5183647082E50E0C0AAD032DC608CE591D147E49123664EB194FA385B35862','2021-06-15 13:28:33',8),(3,1,'2021-06-15 18:01:33','0013','うううお',0,'87F2A490C19FD63A5A4AE74AE38B37B4DF66983A20D39DFEC3EB1FD01EEABC82','2021-06-16 12:29:54',2),(4,0,'2021-06-15 18:03:55','0004','ええええあ',0,'71A66C5F969BF2C29AFD47EE34954D062738ECBEAF70B45C5B98BB70809964DC','2021-06-16 12:25:11',7),(5,0,'2021-06-16 13:20:11','0005','おおおおお',1,'A3F91A2B3620E79024D75962DE8C5D649B0A1C38B4BA96E469B43B41A220E77D','2021-06-16 13:20:22',1),(6,1,'2021-06-16 13:20:52','0006','あいうえお',0,'E31E981B0908B73A22A13501F95C3A39A0200B26B262FCED10EE20E5F007DAA4','2021-06-16 13:20:52',6);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aspiration_situation` int(11) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `first_interview_date` date DEFAULT NULL,
  `first_interview_format` int(11) DEFAULT NULL,
  `first_interview_id` varchar(255) DEFAULT NULL,
  `first_interview_password` varchar(255) DEFAULT NULL,
  `first_interview_scheduled_date` date DEFAULT NULL,
  `first_interview_scheduled_time` time DEFAULT NULL,
  `first_interview_time` time DEFAULT NULL,
  `first_interview_tool` varchar(255) DEFAULT NULL,
  `first_interview_url` varchar(255) DEFAULT NULL,
  `interview_situation` int(11) DEFAULT NULL,
  `introduce_date` date DEFAULT NULL,
  `is_deleted` int(11) NOT NULL,
  `number_of_interviews` int(11) DEFAULT NULL,
  `ordering_company` varchar(255) NOT NULL,
  `pass_fail_status` int(11) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `project_overview` longtext NOT NULL,
  `project_title` varchar(255) NOT NULL,
  `second_interview_date` date DEFAULT NULL,
  `second_interview_format` int(11) DEFAULT NULL,
  `second_interview_id` varchar(255) DEFAULT NULL,
  `second_interview_password` varchar(255) DEFAULT NULL,
  `second_interview_scheduled_date` date DEFAULT NULL,
  `second_interview_scheduled_time` time DEFAULT NULL,
  `second_interview_time` time DEFAULT NULL,
  `second_interview_tool` varchar(255) DEFAULT NULL,
  `second_interview_url` varchar(255) DEFAULT NULL,
  `supplement` longtext NOT NULL,
  `updated_at` datetime NOT NULL,
  `vendor` varchar(255) DEFAULT NULL,
  `employee_id` int(11) NOT NULL,
  `sales_employee_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk1xoduufw1mu7ywao2xg90g3f` (`employee_id`),
  KEY `FKsyvd73osd0is9qabalyxl5wu` (`sales_employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,NULL,'2021-06-17 17:53:33',NULL,NULL,'','',NULL,NULL,NULL,'','',NULL,'2021-06-17',0,NULL,'上位会社１',NULL,'',NULL,'','案件名１',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-17 17:53:33','ベンダー１',1,6),(2,NULL,'2021-06-17 18:13:37',NULL,NULL,'','',NULL,NULL,NULL,'','',NULL,'2021-06-17',0,NULL,'上位会社2',NULL,'',NULL,'','案件名2',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-17 18:13:37','',6,6),(3,NULL,'2021-06-17 18:13:56',NULL,NULL,'','',NULL,'20:13:00',NULL,'','',NULL,'2021-06-17',0,NULL,'上位会社2',NULL,'',NULL,'','案件名2',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-17 18:13:56','',6,6),(4,1,'2021-06-17 18:19:57','2021-06-26',1,'id1','password1','2021-06-25','23:19:00','23:20:00','一次面談ツール2','url1',2,'2021-06-16',0,2,'上位会社4',1,'場所4',10,'案件概要４\r\n案件概要４の2行目','案件名4',NULL,NULL,'','',NULL,NULL,NULL,'','','補足４','2021-06-17 18:19:57','ベンダー4',4,3),(5,NULL,'2021-06-17 19:24:07',NULL,NULL,'','',NULL,NULL,NULL,'','',NULL,'2021-06-17',0,NULL,'上位会社5',NULL,'',NULL,'','案件名5',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-17 19:24:07','',1,6),(6,NULL,'2021-06-17 19:25:33',NULL,NULL,'','',NULL,NULL,NULL,'','',NULL,'2021-06-17',0,NULL,'上位会社５',NULL,'',NULL,'','案件名６',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-17 19:25:33','',2,6),(7,NULL,'2021-06-17 19:27:39',NULL,NULL,'','',NULL,NULL,NULL,'','',NULL,'2021-06-17',0,NULL,'上位会社7',NULL,'',NULL,'','案件名7',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-17 19:27:39','',3,6),(8,1,'2021-06-18 13:38:11','2021-06-24',2,'id1','pass1','2021-06-25','14:41:00','15:42:00','一次面談ツールはzoom','url1',1,'2021-06-19',0,1,'上位会社8更新',1,'場所８',2,'案件概要８','案件名8更新','2021-06-19',2,'id2','password2','2021-06-19','14:43:00','16:41:00','二次面談ツールはgoogle meet','url2','補足８','2021-06-18 14:42:05','ベンダー８',1,4),(9,1,'2021-06-18 18:31:25','2021-06-07',2,'','','2021-06-07','17:00:00','17:00:00','Microsoft Teams','https://teams.microsoft.com/l/meetup-join/19%3ameeting_MTU1YjM2NzgtZmZjMi00ZGJkLTgxZjYtNDI1ODc1NzFhYmU2%40thread.v2/0?context=%7b%22Tid%22%3a%22e7c3bdae-4fcd-48cd-b7f7-980d1e36da73%22%2c%22Oid%22%3a%229c793c7b-1a80-4d61-bd3a-bbb6d51957fc%22%7d',3,'2021-06-18',0,2,'コムチュア',1,'品川',2,'計画システムの更改\r\nDBをクラウド上での管理に変える\r\n２０２０年６月：要件定義\r\n７～８月：設計\r\n９～１０月：製造・単体テスト\r\n１１～１２月：結合テスト、ユーザーテスト\r\n１月：ユーザーテスト、移行\r\n２０２１年２月：本番稼働開始','カーリースシステム更改','2021-06-17',2,'','','2021-06-17','14:30:00','14:30:00','Microsoft Teams','https://teams.microsoft.com/l/meetup-join/19%3ameeting_MGY4Njk1NWItNGVkOS00NWZiLTk4YjgtNDE2N2M0NjM5NjQ2%40thread.v2/0?context=%7b%22Tid%22%3a%22e7c3bdae-4fcd-48cd-b7f7-980d1e36da73%22%2c%22Oid%22%3a%229c793c7b-1a80-4d61-bd3a-bbb6d51957fc%22%7d','＜営業さんからの連携情報＞\r\nリース会社案件でリクエストきました。\r\n１、面談スケジュールを幅広でください。\r\n日中、業後なるべく多く\r\n２、AWS上での開発になるが、AWSかんれんについても\r\n意欲的に勉強してほしい\r\n３、ウォーターフォールというよりもラフで\r\nアジャイルチックな進め方になる','2021-06-18 18:31:25','ＳＣＳＫ',2,3);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-18 18:52:26
