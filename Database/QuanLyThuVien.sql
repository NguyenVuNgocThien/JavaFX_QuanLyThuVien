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
  `IDMuon` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muon`
--

LOCK TABLES `muon` WRITE;
/*!40000 ALTER TABLE `muon` DISABLE KEYS */;
INSERT INTO `muon` VALUES ('0bf85','0123654789','2021-12-15 00:00:00','2021-12-08 00:00:00','456','dhthanh'),('0d8e3','0123654789','2021-12-23 00:00:00','2021-12-02 00:00:00','098','hthinh'),('c71bf','0123654789','2021-12-29 00:00:00','2021-12-04 00:00:00','124','tan.th'),('f8f42','0123654789','2021-12-29 00:00:00','2021-12-01 00:00:00','123','tan.th');
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
INSERT INTO `quanlydocgia` VALUES ('dhthanh','55hh2','Duong Huu Thanh','1985-01-17 00:00:00','Giảng Viên','Enable','dhthanh@ou.edu.vn','Nam','0124569873','Công Nghệ Thông Tin'),('duyen.h','90d5a','Duyen Ha','2000-12-08 00:00:00','Sinh Viên','Enable','duyen@ou.edu.vn','Nữ','0123546987','Đào Tạo Đặc Biệt'),('hthinh','34dde','Hong Thinh','2000-09-08 00:00:00','Admin','Enable','thinh@ou.edu.vn','Nam','0145236987','Công Nghệ Thông Tin'),('tan.th','886a3','Tan Thanh','2001-12-15 00:00:00','Admin','Enable','tanth@ou.edu.vn','Nam','0123456789','Công Nghệ Thông Tin'),('thien.n','thien!2','ThienNguyen','2001-10-26 00:00:00','Sinh Viên','Enable','ngocthien@ou.edu.vn','Nam','0907879210','CNTT'),('tlam.tr','59afa','Truc Lam','2000-12-02 00:00:00','Sinh Viên','Disable','tlam@ou.edu.vn','Nữ','0213654789','Công Nghệ Thông Tin');
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
INSERT INTO `sach` VALUES ('098','Tuổi Trẻ Đáng Giá Bao Nhiêu','Rosie Nguyễn','Tuổi trẻ đáng giá bao nhiêu? được tác giả chia làm 3 phần: HỌC, LÀM, ĐI.','2018','NXB Trẻ','Available','Kỹ Năng Sống'),('123','Mắt Biếc','Nguyễn Nhật Ánh','Câu chuyện tình yêu của Hà Lan và Ngạn','2015','NXB Kim Đồng','Borrowed','Tình Cảm'),('124','Tôi tài giỏi, bạn cũng thế ','Adam Khoo','Nội dung của cuốn sách là những chia sẻ về các câu chuyện cũng như phương pháp học tập. Do chính tác giả đã trải nghiệm khi mới ở độ tuổi cấp 2.','1998','NXB TGM Books ','Available','Giáo Dục'),('345','Đừng Lựa Chọn An Nhàn Khi Còn Trẻ','Cảnh Thiên','Trong độ xuân xanh phơi phới ngày ấy, bạn không dám mạo hiểm, không dám nỗ lực để kiếm học bổng, không chịu tìm tòi những thử thách trong công việc,..','2019','NXB Thế Giới','Borrowed','Kỹ Năng Sống'),('456','Dế mèn phiêu lưu ký','Tô Hoài','Chuyến đi tìm vùng đất mới đầy khó khăn của dế mèn','2010','NXB Kim Đồng','Borrowed','Ngụ Ngôn'),('458','Tỷ Phú Bán Giày','Tony Hsieh','Tỷ Phú Bán Giày không phải là một cuốn sách dạy cách làm giàu tuần tự theo các bước 1 - 2 - 3,... cũng không hẳn là một cuốn sách chỉ dẫn bí quyết kinh doanh hay nghệ thuật quản lý.','2018','NXB Lao Động Xã Hội ','Available','Kinh Tế'),('521','tikinowCao Thủ IELTS Đuổi Theo Chín Chấm','Lê Minh Hà','Cao Thủ IELTS Đuổi Theo Chín Chấm là cuốn sách đầu tay của tác giả Lê Minh Hà – một chàng trai say mê môn Toán trong suốt những năm tháng ngồi trên ghế nhà trường','2020','NXB Thế Giới','Borrowed','Học '),('546','Mặc Kệ Thiên Hạ - Sống Như Người Nhật','Mari Tamagawa','Dành cho những ai muốn được sống là chính mình, cuộc đời của mình, tuổi trẻ của mình.','2017','NXB Hà Nội','Borrowed','Tâm Lý'),('976','Lối Sống Tối Giản Của Người Nhật','Sasaki Fumio','Lối sống tối giản là cách sống cắt giảm vật dụng xuống còn mức tối thiểu. Và cùng với cuộc sống ít đồ đạc, ta có thể để tâm nhiều hơn tới hạnh phúc','2017','NXB Lao Động','Available','Tâm Lý'),('999','Máy Tính Sát Thủ','Christian Grenier','Cuốn tiểu thuyết pha trộn các đặc trưng tiêu biểu của tiểu thuyết trinh thám bí ẩn cũng những diễn tiến truyện kể bất ngờ.','2011','NXB Thời Đại','Borrowed','Huyền Bí');
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tra`
--

DROP TABLE IF EXISTS `tra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tra` (
  `IDTra` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MaSach` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UserName` varchar(20) NOT NULL,
  `PhoneNumber` varchar(11) DEFAULT NULL,
  `NgayTra` datetime DEFAULT NULL,
  `NgayMuon` datetime DEFAULT NULL,
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-15 21:24:15
