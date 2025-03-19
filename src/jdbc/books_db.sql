CREATE DATABASE  IF NOT EXISTS `books_db`;
USE `books_db`;

DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `books` WRITE;
INSERT INTO `books` VALUES (1,'ABC',1937),(2,'Huset Højbo',1967),(3,'De små synger',1962);
UNLOCK TABLES;
