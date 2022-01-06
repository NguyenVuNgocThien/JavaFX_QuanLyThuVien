/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Muon;
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
public class Muon_DAOTest {
    private static Connection conn;
    private Muon_DAO m;
    public Muon_DAOTest() {
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
     * Test of DemSLSach method, of class Muon_DAO.
     */
    @Test
    public void testDemSLSach() throws Exception {
        System.out.println("DemSLSach");
        String UserName = "";
        Muon_DAO instance = new Muon_DAO();
        boolean expResult = true;
        boolean result=false;
        if(instance.DemSLSach("dhthanh")>0){
            result=true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of XoaYeuCau method, of class Muon_DAO.
     */
    @Test
    public void testXoaYeuCau() throws Exception {
        System.out.println("XoaYeuCau");
        String UserName = "thienn";
        String MaSach="458";
        Muon_DAO instance = new Muon_DAO();
        boolean expResult = true;
        boolean result = instance.XoaYeuCau(MaSach,UserName);
        assertEquals(expResult, result);
    }

    /**
     * Test of ThemMuon method, of class Muon_DAO.
     */
    @Test
    public void testThemMuon() throws Exception {
        System.out.println("ThemMuon");
        String UserName = "dhthanh";
        String MaSach = "456";
        String NgayMuon = "2021/12/8";
        String NgayTra = "2021/12/15";
        Muon_DAO instance = new Muon_DAO();
        boolean expResult = true;
        boolean result = instance.ThemMuon(UserName, MaSach, NgayMuon, NgayTra);
        assertEquals(expResult, result);
    }
    @Test
    public void testDanhSachMuon(){
        boolean result=false;
        m=new Muon_DAO();
        try {
            List<Muon> list=m.DanhSachMuon("dhthanh");
            if(list.size()>0)
                result=true;
        } catch (SQLException ex) {
            Logger.getLogger(Muon_DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(true, result);
    }
}
