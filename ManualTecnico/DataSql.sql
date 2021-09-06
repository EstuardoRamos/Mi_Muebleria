CREATE SCHEMA Proyecto1;

CREATE USER 'root2'@'localhost' IDENTIFIED BY 'root12345';
GRANT SELECT, INSERT, DELETE, UPDATE ON Proyecto1.* TO 'root2'@'localhost';
-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: Proyecto1
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

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
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clientes` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `NIT` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Municipio` varchar(45) DEFAULT NULL,
  `Departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCliente`,`NIT`),
  UNIQUE KEY `NIT_UNIQUE` (`NIT`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (1,'Carlos','12345678','11 calle zona 2','Quetzaltenango','Quetzaltenago'),(4,'Pedro','12345679','Ciudad',NULL,NULL);
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mueble`
--

DROP TABLE IF EXISTS `Mueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Mueble` (
  `Nombre` varchar(50) NOT NULL,
  `Precio` float NOT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mueble`
--

LOCK TABLES `Mueble` WRITE;
/*!40000 ALTER TABLE `Mueble` DISABLE KEYS */;
INSERT INTO `Mueble` VALUES ('Mesa antigua',300),('Mesa normal',100.5),('Mesa normal nueva',200),('Mesa redonda rustica',350.5),('Mesa tradicional cuadrada',305.25);
/*!40000 ALTER TABLE `Mueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mueble_ensamblado`
--

DROP TABLE IF EXISTS `Mueble_ensamblado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Mueble_ensamblado` (
  `id_ensamble` int NOT NULL AUTO_INCREMENT,
  `Nombre_mueble` varchar(50) NOT NULL,
  `Nombre_user` varchar(45) NOT NULL,
  `Fecha_ensamble` date NOT NULL,
  `Precio_costo` float NOT NULL,
  PRIMARY KEY (`id_ensamble`),
  KEY `fk_Ensambles_1_idx` (`Nombre_mueble`),
  KEY `fk_Ensambles_2_idx` (`Nombre_user`),
  CONSTRAINT `fk_Ensambles_1` FOREIGN KEY (`Nombre_mueble`) REFERENCES `Mueble` (`Nombre`),
  CONSTRAINT `fk_Ensambles_2` FOREIGN KEY (`Nombre_user`) REFERENCES `user` (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mueble_ensamblado`
--

LOCK TABLES `Mueble_ensamblado` WRITE;
/*!40000 ALTER TABLE `Mueble_ensamblado` DISABLE KEYS */;
/*!40000 ALTER TABLE `Mueble_ensamblado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PIEZA`
--

DROP TABLE IF EXISTS `PIEZA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PIEZA` (
  `id_pieza` int NOT NULL AUTO_INCREMENT,
  `nombre_pieza` varchar(25) NOT NULL,
  `precio_pieza` float NOT NULL,
  PRIMARY KEY (`id_pieza`,`nombre_pieza`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PIEZA`
--

LOCK TABLES `PIEZA` WRITE;
/*!40000 ALTER TABLE `PIEZA` DISABLE KEYS */;
INSERT INTO `PIEZA` VALUES (1,'Pata rustica larga',25.63),(2,'Plancha ancha',15.65),(7,'Plancha gruesa',45.1),(9,'Plancha gruesa',40.5),(10,'Base de asiento',15.58),(11,'Base',10),(13,'Respaldo liso',18.56),(14,'Base',10),(15,'Respaldo liso',18.56),(16,'Base de asiento',15.58),(17,'Base de asiento',15.58),(18,'Plancha ancha',15.65),(19,'Plancha ancha',15.65),(20,'Plancha ancha',15.65),(23,'Base',10),(24,'Base',10),(25,'Pata rustica larga',25.63),(26,'Pata rustica larga',25.63),(27,'Pata rustica larga',25.63),(29,'Pata rustica larga',25.63),(32,'Base de asiento',15.58),(33,'Base de asiento',15.58);
/*!40000 ALTER TABLE `PIEZA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pieza`
--

DROP TABLE IF EXISTS `Pieza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pieza` (
  `Tipo_pieza` varchar(50) NOT NULL,
  `Precio_pieza` float NOT NULL,
  PRIMARY KEY (`Tipo_pieza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pieza`
--

LOCK TABLES `Pieza` WRITE;
/*!40000 ALTER TABLE `Pieza` DISABLE KEYS */;
INSERT INTO `Pieza` VALUES ('Pata antigua',35),('Pata redonda',40.65),('Placha antigua',55.25),('Plancha redonda',60);
/*!40000 ALTER TABLE `Pieza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pieza_ensamble`
--

DROP TABLE IF EXISTS `Pieza_ensamble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pieza_ensamble` (
  `Nombre_mueble` varchar(50) NOT NULL,
  `Nombre_pieza` varchar(50) NOT NULL,
  `Cantidad_pieza` int NOT NULL,
  PRIMARY KEY (`Nombre_mueble`,`Nombre_pieza`),
  KEY `fk_Pieza_ensamble_1_idx` (`Nombre_mueble`),
  KEY `fk_Pieza_ensamble_2_idx` (`Nombre_pieza`),
  CONSTRAINT `fk_Pieza_ensamble_1` FOREIGN KEY (`Nombre_mueble`) REFERENCES `Mueble` (`Nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Pieza_ensamble_2` FOREIGN KEY (`Nombre_pieza`) REFERENCES `Pieza` (`Tipo_pieza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pieza_ensamble`
--

LOCK TABLES `Pieza_ensamble` WRITE;
/*!40000 ALTER TABLE `Pieza_ensamble` DISABLE KEYS */;
INSERT INTO `Pieza_ensamble` VALUES ('Mesa antigua','Pata antigua',4),('Mesa redonda rustica','Plancha redonda',1);
/*!40000 ALTER TABLE `Pieza_ensamble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muebles_venta`
--

DROP TABLE IF EXISTS `muebles_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muebles_venta` (
  `id_mueble` int NOT NULL AUTO_INCREMENT,
  `nombre_mueble` varchar(45) NOT NULL,
  `precio_mueble` float NOT NULL,
  PRIMARY KEY (`id_mueble`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muebles_venta`
--

LOCK TABLES `muebles_venta` WRITE;
/*!40000 ALTER TABLE `muebles_venta` DISABLE KEYS */;
INSERT INTO `muebles_venta` VALUES (1,'Mesa simple',250.25),(2,'Mesa redonda',200.45),(3,'Mesa antigua',300);
/*!40000 ALTER TABLE `muebles_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Contra` varchar(45) NOT NULL,
  `TipoStr` varchar(45) NOT NULL,
  `TipoInt` int NOT NULL,
  PRIMARY KEY (`id`,`Nombre`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,'Maria','54321','Fabrica',1),(12,'Luna','12345','Ventas',2),(13,'Luis','12345','Fabrica',1),(14,'Pedro','123456','Finaciero',3),(15,'Melisa','123456','Finaciero',3),(16,'Jose','654321','Punto de venta',2),(17,'Diana','444444','Fabrica',1),(18,'Karina','112233','Fabrica',1),(20,'LuisCArlo','4444555','Finaciero',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-06 15:45:04
