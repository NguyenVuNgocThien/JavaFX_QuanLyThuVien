-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlythuvien
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
-- Table structure for table `quanlydocgia`
--

DROP TABLE IF EXISTS `quanlydocgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quanlydocgia` (
  `UserName` varchar(20) NOT NULL,
  `Pass` varchar(7) NOT NULL,
  `TenDocGia` varchar(45) NOT NULL,
  `NgaySinh` datetime NOT NULL,
  `ChucVu` varchar(20) NOT NULL,
  `TinhTrangThe` varchar(10) NOT NULL,
  `Gmail` varchar(50) NOT NULL,
  `GioiTinh` varchar(10) NOT NULL,
  `SDT` varchar(11) NOT NULL,
  `Khoa` varchar(50) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quanlydocgia`
--

LOCK TABLES `quanlydocgia` WRITE;
/*!40000 ALTER TABLE `quanlydocgia` DISABLE KEYS */;
INSERT INTO `quanlydocgia` VALUES ('dhthanh','55hh2','Duong Huu Thanh','1985-01-17 00:00:00','Giảng Viên','Enable','dhthanh@ou.edu.vn','Nam','0124569873','Công Nghệ Thông Tin'),('duyen.h','90d5a','Duyen Ha','2000-12-08 00:00:00','Sinh Viên','Enable','duyen@ou.edu.vn','Nữ','0123546987','Đào Tạo Đặc Biệt'),('hthinh','34dde','Hong Thinh','2000-09-08 00:00:00','Admin','Enable','thinh@ou.edu.vn','Nam','0145236987','Công Nghệ Thông Tin'),('tan.th','886a3','Tan Thanh','2001-12-15 00:00:00','Admin','Enable','tanth@ou.edu.vn','Nam','0123456789','Công Nghệ Thông Tin'),('thien','thien$2','Nguyễn Vũ Ngọc Thiện','2001-12-26 00:00:00','Sinh Viên','Enable','ngocthien3821@ou.edu.vn','Nam','0907879210','CNTT'),('thien.n','thien!2','ThienNguyen','2001-10-26 00:00:00','Sinh Viên','Enable','ngocthien@ou.edu.vn','Nam','0907879210','CNTT'),('tlam.tr','59afa','Truc Lam','2000-12-02 00:00:00','Sinh Viên','Disable','tlam@ou.edu.vn','Nữ','0213654789','Công Nghệ Thông Tin');
/*!40000 ALTER TABLE `quanlydocgia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-18 14:57:39
