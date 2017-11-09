-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: interviewdb
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'SQL'),(2,'Database Design'),(3,'CSS'),(4,'JavaScript'),(5,'Java'),(6,'C#');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flashcard`
--

DROP TABLE IF EXISTS `flashcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flashcard` (
  `flashcardId` int(11) NOT NULL,
  `question` varchar(500) NOT NULL,
  `answer` varchar(500) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`flashcardId`),
  KEY `fk_flashcard_category_idx` (`categoryId`),
  CONSTRAINT `fk_flashcard_category` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flashcard`
--

LOCK TABLES `flashcard` WRITE;
/*!40000 ALTER TABLE `flashcard` DISABLE KEYS */;
INSERT INTO `flashcard` VALUES (1,'What does UNION do?','UNION merges the contents of two compatible tables into one table. UNION omits duplicates; UNION ALL does not.',1),(2,'How would you SELECT all the even-numbered results from a table?','Select * from table where id % 2 = 0;',1),(3,'What is the difference between the WHERE and HAVING clauses?','When GROUP BY is not used, they’re basically the same. However, if GROUP BY is used, WHERE filters the selection before groups are made. HAVING filters them after groups are made.',1),(4,'If no JOIN type is specified, what is the default JOIN type?','INNER JOIN.',1),(5,'What is the difference between an INNER and FULL (OUTER) JOIN?','INNER JOINS return all rows for which there is a match in both tables. FULL OUTER JOINS return all rows for which there is a match in either table.',1),(6,'Why do we generally normalize databases?','We normalize databases to minimize duplicate data, simplify queries, and avoid insert/update/delete anomalies.',2),(7,'Why might someone denormalize their database? ','To improve performance by eliminating some of the required joins.',2),(8,'What is first normal form?','A database relation is in first normal form if the domain of each attribute contains only atomic, or indivisible, values, and the value of each attribute contains only a single value. For example, if a single “telephone_number” field contains two numbers within it, it’s violating first normal form.',2),(9,'What is cardinality?','In terms of databases, this refers to whether a relationship is one-to-one, one-to-many, or many-to-many.',2),(10,'What is CSS?','Cascading style sheets. They provide a mechanism for changing the appearance of HTML and XML elements.',3),(11,'How are comments written in CSS?','They are added with /* */.',3),(12,'What are the different types of CSS?','Embedded, inline, and linked/external.',3),(13,'What are the different roles of HTTP?','Server and client. The client initiates conversation. The server replies.',4),(14,'Describe GET.','The simplest type of HTTP request method. Browsers use this method when the user clicks a link or types a URL. It instructs the server to transmit data identified by the URL to the client.',4),(15,'What is the default connection type used by HTTP?','Persistent.',4),(16,'Can we call servlet destroy() from service()?','As you know, destroy() is part of servlet life cycle methods, it is used to kill the servlet instance. Servlet Engine is used to call destroy(). In case, if you call destroy method from service(), it just execute the code written in the destroy(), but it wont kill the servlet instance. destroy() will be called before killing the servlet instance by servlet engine.',5),(17,'Can a class in java be private?','We can not declare top level class as private. Java allows only public and default modifier for top level classes in java. Inner classes can be private.',5),(18,'What is Object Oriented Programming?','Object Oriented Programming (OOP) is a programming paradigm where the complete software operates as a bunch of objects talking to each other. An object is a collection of data and methods that operate on its data.',6),(19,'What is encapsulation?','Encapsulation is referred to one of the following two notions: 1) Data hiding: A language feature to restrict access to members of an object. For example, private and protected members in C++. 2) Bundling of data and methods together: Data and methods that operate on that data are bundled together.',6);
/*!40000 ALTER TABLE `flashcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs` (
  `jobId` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`jobId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,'Database Administrator'),(2,'Web Developer'),(3,'Software Developer');
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs_category_lnk`
--

DROP TABLE IF EXISTS `jobs_category_lnk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs_category_lnk` (
  `jobsId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`jobsId`,`categoryId`),
  KEY `fk_jobs_has_category_category1_idx` (`categoryId`),
  KEY `fk_jobs_has_category_jobs1_idx` (`jobsId`),
  CONSTRAINT `fk_jobs_has_category_category1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`categoryId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jobs_has_category_jobs1` FOREIGN KEY (`jobsId`) REFERENCES `jobs` (`jobId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs_category_lnk`
--

LOCK TABLES `jobs_category_lnk` WRITE;
/*!40000 ALTER TABLE `jobs_category_lnk` DISABLE KEYS */;
INSERT INTO `jobs_category_lnk` VALUES (1,1),(1,2),(2,3),(2,4),(3,5),(3,6);
/*!40000 ALTER TABLE `jobs_category_lnk` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-08 18:32:07
