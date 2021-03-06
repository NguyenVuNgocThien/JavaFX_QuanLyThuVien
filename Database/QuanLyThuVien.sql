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
-- Table structure for table `muon`
--

DROP TABLE IF EXISTS `muon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muon` (
  `IDMuon` int NOT NULL AUTO_INCREMENT,
  `PhoneNumber` varchar(11) DEFAULT NULL,
  `NgayTra` datetime DEFAULT NULL,
  `NgayMuon` datetime DEFAULT NULL,
  `MaSach` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UserName` varchar(20) NOT NULL,
  PRIMARY KEY (`IDMuon`,`MaSach`,`UserName`),
  KEY `MaSach` (`MaSach`),
  KEY `UserName` (`UserName`),
  CONSTRAINT `muon_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`),
  CONSTRAINT `muon_ibfk_2` FOREIGN KEY (`UserName`) REFERENCES `quanlydocgia` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muon`
--

LOCK TABLES `muon` WRITE;
/*!40000 ALTER TABLE `muon` DISABLE KEYS */;
INSERT INTO `muon` VALUES (1,'0123654789','2021-12-15 00:00:00','2021-12-08 00:00:00','456','dhthanh'),(2,'0123654789','2021-12-23 00:00:00','2021-12-02 00:00:00','098','hthinh'),(3,'0123654789','2021-12-29 00:00:00','2021-12-04 00:00:00','124','tan.th'),(4,'0123654789','2021-12-29 00:00:00','2021-12-01 00:00:00','123','tan.th');
/*!40000 ALTER TABLE `muon` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `quanlydocgia` VALUES ('dhthanh','55hh2','Duong Huu Thanh','1985-01-17 00:00:00','Gi???ng Vi??n','Enable','dhthanh@ou.edu.vn','Nam','0124569873','C??ng Ngh??? Th??ng Tin'),('duyen.h','90d5a','Duyen Ha','2000-12-08 00:00:00','Sinh Vi??n','Enable','duyen@ou.edu.vn','N???','0123546987','????o T???o ?????c Bi???t'),('hthinh','34dde','Hong Thinh','2000-09-08 00:00:00','Admin','Enable','thinh@ou.edu.vn','Nam','0145236987','C??ng Ngh??? Th??ng Tin'),('tan.th','886a3','Tan Thanh','2001-12-15 00:00:00','Admin','Enable','tanth@ou.edu.vn','Nam','0123456789','C??ng Ngh??? Th??ng Tin'),('thien','thien$2','Nguy???n V?? Ng???c Thi???n','2001-12-26 00:00:00','Sinh Vi??n','Enable','ngocthien3821@ou.edu.vn','Nam','0907879210','CNTT'),('thien.n','thien!2','ThienNguyen','2001-10-26 00:00:00','Sinh Vi??n','Enable','ngocthien@ou.edu.vn','Nam','0907879210','CNTT'),('tlam.tr','59afa','Truc Lam','2000-12-02 00:00:00','Sinh Vi??n','Disable','tlam@ou.edu.vn','N???','0213654789','C??ng Ngh??? Th??ng Tin');
/*!40000 ALTER TABLE `quanlydocgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sach` (
  `MaSach` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TenSach` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TenTacGia` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MoTaSach` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `PhatHanh` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NoiPhatHanh` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TinhTrang` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LoaiSach` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`MaSach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES ('098','Tu???i Tr??? ????ng Gi?? Bao Nhi??u','Rosie Nguy???n','Tu???i tr??? ????ng gi?? bao nhi??u? ???????c t??c gi??? chia l??m 3 ph???n: H???C, L??M, ??I.','2018','NXB Tr???','Available','K??? N??ng S???ng'),('123','M????t Bi????c','Nguy????n Nh???t ??nh','C??u chuy????n ti??nh y??u cu??a Ha?? Lan va?? Nga??n','2015','NXB Kim ??????ng','Borrowed','Ti??nh Ca??m'),('124','T??i t??i gi???i, b???n c??ng th??? ','Adam Khoo','N???i dung c???a cu???n s??ch l?? nh???ng chia s??? v??? c??c c??u chuy???n c??ng nh?? ph????ng ph??p h???c t???p. Do ch??nh t??c gi??? ???? tr???i nghi???m khi m???i ??? ????? tu???i c???p 2.','1998','NXB TGM Books ','Available','Gi??o D???c'),('345','?????ng L???a Ch???n An Nh??n Khi C??n Tr???','C???nh Thi??n','Trong ????? xu??n xanh ph??i ph???i ng??y ???y, b???n kh??ng d??m m???o hi???m, kh??ng d??m n??? l???c ????? ki???m h???c b???ng, kh??ng ch???u t??m t??i nh???ng th??? th??ch trong c??ng vi???c,..','2019','NXB Th??? Gi???i','Borrowed','K??? N??ng S???ng'),('456','D???? me??n phi??u l??u ky??','T?? Hoa??i','Chuy????n ??i ti??m vu??ng ??????t m????i ??????y kho?? kh??n cu??a d???? me??n','2010','NXB Kim ??????ng','Borrowed','Ngu?? Ng??n'),('458','T??? Ph?? B??n Gi??y','Tony Hsieh','T??? Ph?? B??n Gi??y kh??ng ph???i l?? m???t cu???n s??ch d???y c??ch l??m gi??u tu???n t??? theo c??c b?????c 1 - 2 - 3,... c??ng kh??ng h???n l?? m???t cu???n s??ch ch??? d???n b?? quy???t kinh doanh hay ngh??? thu???t qu???n l??.','2018','NXB Lao ?????ng X?? H???i ','Available','Kinh T???'),('521','tikinowCao Th??? IELTS ??u???i Theo Ch??n Ch???m','L?? Minh H??','Cao Th??? IELTS ??u???i Theo Ch??n Ch???m l?? cu???n s??ch ?????u tay c???a t??c gi??? L?? Minh H?? ??? m???t ch??ng trai say m?? m??n To??n trong su???t nh???ng n??m th??ng ng???i tr??n gh??? nh?? tr?????ng','2020','NXB Th??? Gi???i','Borrowed','H???c '),('546','M???c K??? Thi??n H??? - S???ng Nh?? Ng?????i Nh???t','Mari Tamagawa','D??nh cho nh???ng ai mu???n ???????c s???ng l?? ch??nh m??nh, cu???c ?????i c???a m??nh, tu???i tr??? c???a m??nh.','2017','NXB H?? N???i','Borrowed','T??m L??'),('976','L???i S???ng T???i Gi???n C???a Ng?????i Nh???t','Sasaki Fumio','L???i s???ng t???i gi???n l?? c??ch s???ng c???t gi???m v???t d???ng xu???ng c??n m???c t???i thi???u. V?? c??ng v???i cu???c s???ng ??t ????? ?????c, ta c?? th??? ????? t??m nhi???u h??n t???i h???nh ph??c','2017','NXB Lao ?????ng','Available','T??m L??'),('999','M??y T??nh S??t Th???','Christian Grenier','Cu???n ti???u thuy???t pha tr???n c??c ?????c tr??ng ti??u bi???u c???a ti???u thuy???t trinh th??m b?? ???n c??ng nh???ng di???n ti???n truy???n k??? b???t ng???.','2011','NXB Th???i ?????i','Borrowed','Huy???n B??');
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tra`
--

DROP TABLE IF EXISTS `tra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tra` (
  `IDTra` int NOT NULL AUTO_INCREMENT,
  `MaSach` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UserName` varchar(20) NOT NULL,
  `PhoneNumber` varchar(11) DEFAULT NULL,
  `NgayTra` datetime DEFAULT NULL,
  `NgayMuon` datetime DEFAULT NULL,
  `TinhTrang` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`IDTra`,`MaSach`,`UserName`),
  KEY `MaSach` (`MaSach`),
  KEY `UserName` (`UserName`),
  CONSTRAINT `tra_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`),
  CONSTRAINT `tra_ibfk_2` FOREIGN KEY (`UserName`) REFERENCES `quanlydocgia` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tra`
--

LOCK TABLES `tra` WRITE;
/*!40000 ALTER TABLE `tra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yeucau`
--

DROP TABLE IF EXISTS `yeucau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `yeucau` (
  `IDYeuCau` int NOT NULL AUTO_INCREMENT,
  `MaSach` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UserName` varchar(20) NOT NULL,
  PRIMARY KEY (`IDYeuCau`,`MaSach`,`UserName`),
  KEY `MaSach` (`MaSach`),
  KEY `UserName` (`UserName`),
  CONSTRAINT `yeucau_ibfk_1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`),
  CONSTRAINT `yeucau_ibfk_2` FOREIGN KEY (`UserName`) REFERENCES `quanlydocgia` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yeucau`
--

LOCK TABLES `yeucau` WRITE;
/*!40000 ALTER TABLE `yeucau` DISABLE KEYS */;
INSERT INTO `yeucau` VALUES (1,'098','dhthanh'),(2,'124','dhthanh');
/*!40000 ALTER TABLE `yeucau` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-22 20:26:56
