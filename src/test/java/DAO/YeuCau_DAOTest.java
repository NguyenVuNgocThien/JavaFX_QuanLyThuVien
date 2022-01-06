/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.YeuCau;
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
public class YeuCau_DAOTest {
    private static Connection conn;
    private YeuCau_DAO yc;
    public YeuCau_DAOTest() {
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
     * Test of ThemYeuCau method, of class YeuCau_DAO.
     */
    @Test
    public void testThemYeuCau() throws Exception {
        System.out.println("ThemYeuCau");
        String UserName = "thienn";
        String MaSach = "458";
        YeuCau_DAO instance = new YeuCau_DAO();
        boolean expResult = true;
        boolean result = instance.ThemYeuCau(UserName, MaSach);
        assertEquals(expResult, result);
    }
    @Test
    public void testDSYeuCau(){
        boolean result=false;
        yc=new YeuCau_DAO();
        try {
            List<YeuCau> list=yc.DSYeuCau("thienn");
            if(list.size()>0)
                result=true;
        } catch (SQLException ex) {
            Logger.getLogger(YeuCau_DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(true, result);
    }
}
