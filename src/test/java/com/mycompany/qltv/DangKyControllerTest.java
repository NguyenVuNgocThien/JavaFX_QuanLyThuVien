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
public class DangKyControllerTest {
    
    private static Connection conn;
    public DangKyControllerTest() {
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
     * Test of DinhDangMail method, of class DangKyController.
     */
    @Test
    public void testDinhDangMail() {
        System.out.println("DinhDangMail");
        DangKyController instance = new DangKyController();
        int expResult = 0;
        int result = instance.DinhDangMail("thien@ou.edu.vn");
        assertEquals(expResult, result);
    }

    /**
     * Test of KTraRangBuoc method, of class DangKyController.
     */
    @Test
    public void testKTraRangBuoc() {
        System.out.println("KTraRangBuoc");
        String input = "thien321$";
        DangKyController instance = new DangKyController();
        int expResult = 0;
        int result = instance.KTraRangBuoc(input);
        assertEquals(expResult, result);
    }
}
