/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Sach;
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
public class Sach_DAOTest {
    private static Connection conn;
    private Sach_DAO s;
    public Sach_DAOTest() {
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
     * Test of DanhSachSach method, of class Sach_DAO.
     */
    @Test
    public void testDanhSachSach()  {
        boolean result=false;
        s=new Sach_DAO();
        try {
            List<Sach> list =s.DanhSachSach();
            if(list.size()>0)
                result=true;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(true, result);
    }

    /**
     * Test of TimKiemSach method, of class Sach_DAO.
     */
    @Test
    public void testTimKiemSach() throws Exception {
        boolean result=false;
        s=new Sach_DAO();
        try {
            List<Sach> list =s.TimKiemSach("458");
            if(list.size()>0)
                result=true;
        } catch (SQLException ex) {
            Logger.getLogger(Sach_DAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(true, result);
    }
    
}
