/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import DAO.ConnectionClass;
import DAO.Muon_DAOTest;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
public class QuanLyKhoSachControllerTest {
    
    private static Connection conn;
    public QuanLyKhoSachControllerTest() {
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
     * Test of KTMaSach method, of class QuanLyKhoSachController.
     */
    @Test
    public void testKTMaSach() {
        System.out.println("KTMaSach");
        String input = "111";
        QuanLyKhoSachController instance = new QuanLyKhoSachController();
        int expResult = 0;
        int result = instance.KTMaSach(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testKTraRangBuocTenSach() {
        System.out.println("KTraRangBuocTenSach");
        String input = "Đi học 1 ";
        QuanLyKhoSachController instance = new QuanLyKhoSachController();
        int expResult = 0;
        int result = instance.KTraRangBuocTenSach(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of KTraRangBuocTenTacGia method, of class QuanLyKhoSachController.
     */
    @Test
    public void testKTraRangBuocTenTacGia() {
        System.out.println("KTraRangBuocTenTacGia");
        String input = "NVNV";
        QuanLyKhoSachController instance = new QuanLyKhoSachController();
        int expResult = 0;
        int result = instance.KTraRangBuocTenTacGia(input);
        assertEquals(expResult, result);
    }
    
}
