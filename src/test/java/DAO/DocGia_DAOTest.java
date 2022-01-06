/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DocGia;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dell
 */
public class DocGia_DAOTest {
    private static Connection conn;
    private static DocGia_DAO dg;
    public DocGia_DAOTest() {
    }

   
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        conn=ConnectionClass.getConn();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown()  {
        try {
            ConnectionClass.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * Test of DangNhap_DAO method, of class DocGia_DAO.
     */
    @org.junit.jupiter.api.Test
    public void testDangNhap_DAO() throws Exception {
        boolean result=false;
        System.out.println("DangNhap_DAO");
        String UserName = "dhthanh";
        String Pass = "55hh2";
        DocGia_DAO instance = new DocGia_DAO();
        boolean expResult = true;
        if( instance.DangNhap_DAO(UserName, Pass)!=0){
            result=true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of DangKy method, of class DocGia_DAO.
     */
    @org.junit.jupiter.api.Test
    public void testDangKy() {
        System.out.println("DangKy");
        DocGia dg = new DocGia();
        dg.setChucVu("Sinh Viên");
        dg.setUserName("thiennggg");
        dg.setPass("1Thien$");
        dg.setGioiTinh("Nam");
        dg.setGmail("thien@ou.edu.vn");
        dg.setKhoa("CNTT");
        dg.setNgaySinh("2001/10/26");
        dg.setSDT("09082");
        dg.setTenDocGia("Nguyễn Vũ Ngọc Thiện");
        dg.setTinhTrangThe("Enable");
        DocGia_DAO instance = new DocGia_DAO();
        boolean expResult = true;
        boolean result = instance.DangKy(dg);
        assertEquals(expResult, result);
    }

    /**
     * Test of KiemTraTenDangNhap method, of class DocGia_DAO.
     */
    @org.junit.jupiter.api.Test
    public void testKiemTraTenDangNhap() {
        System.out.println("KiemTraTenDangNhap");
        String UserName = "";
        DocGia_DAO instance = new DocGia_DAO();
        int expResult = 0;
        int result = instance.KiemTraTenDangNhap(UserName);
        assertEquals(expResult, result);
    }

    /**
     * Test of XoaThanhVien method, of class DocGia_DAO.
     */
    @org.junit.jupiter.api.Test
    public void testXoaThanhVien() {
        System.out.println("XoaThanhVien");
        String UserName = "thien";
        DocGia_DAO instance = new DocGia_DAO();
        boolean expResult = true;
        boolean result = instance.XoaThanhVien(UserName);
        assertEquals(expResult, result);
    }
    @Test
    public void testDSDocGia(){
        boolean expResult=true;
        boolean result=false;
        dg=new DocGia_DAO();
        try {
            List<DocGia> list=dg.DanhSachDocGia();
            if(list.size()>0)
                result=true;
        } catch (SQLException ex) {
            Logger.getLogger(DocGia_DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(expResult, result);
    }
}
