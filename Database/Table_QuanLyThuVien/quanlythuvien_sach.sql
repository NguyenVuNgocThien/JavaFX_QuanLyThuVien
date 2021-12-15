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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-15 21:21:23
