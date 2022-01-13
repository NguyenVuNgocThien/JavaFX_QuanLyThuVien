/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Tra;
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
 * @author Administrator
 */
public class Tra_DAOTest {
    private static Connection conn;
    private Tra_DAO m;
    public Tra_DAOTest() {
    }
    
    @BeforeEach
    public void setUp() {
         try {
            conn=ConnectionClass.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(Muon_DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterEach
    public void tearDown() {
     try {
            ConnectionClass.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(Muon_DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of DanhSachTra method, of class Tra_DAO.
     */
    @Test
    public void testDanhSachTra() throws Exception {
        System.out.println("DanhSachTra");
        String UserName = "";
        Tra_DAO instance = new Tra_DAO();
        List<Tra> expResult = null;
        List<Tra> result = instance.DanhSachTra(UserName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ThemTra method, of class Tra_DAO.
     */
    @Test
    public void testThemTra() throws Exception {
        System.out.println("ThemTra");
        String UserName = "hthinh";
        String MaSach = "098";
        String NgayMuon = "2021/12/02";
        String NgayTra = "2021/12/23";
        String PhoneNumber = "0123456789";
        String TinhTrang = "Đã Trả";
        Tra_DAO instance = new Tra_DAO();
        boolean expResult = true;
        boolean result = instance.ThemTra(UserName, MaSach, NgayMuon, NgayTra, PhoneNumber, TinhTrang);
        assertEquals(expResult, result);
        
        
    }
    
}
