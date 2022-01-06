/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
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
public class QuanLyMuonSachControllerTest {
    
    public QuanLyMuonSachControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of RangBuocNgayThangMuon method, of class QuanLyMuonSachController.
     */
    @Test
    public void testRangBuocNgayThangMuon() {
        System.out.println("RangBuocNgayThangMuon");
        LocalDate dt = LocalDate.of(2022, Month.JANUARY, 9);
        System.out.println(dt);
        QuanLyMuonSachController instance = new QuanLyMuonSachController();
        int expResult = 1;
        int result = instance.RangBuocNgayThangMuon(dt);
        assertEquals(expResult, result);
    }
    @Test
    public void testRangBuocNgayThangTra() {
        System.out.println("RangBuocNgayThangTra");
        LocalDate dtMuon = LocalDate.of(2022, Month.JANUARY, 9);
        LocalDate dtTra = LocalDate.of(2022, Month.JANUARY, 12);
        System.out.println(dtMuon);
        System.out.println(dtTra);
        QuanLyMuonSachController instance = new QuanLyMuonSachController();
        int expResult = 1;
        int result = instance.RangBuocNgayThangTra(dtMuon,dtTra);
        assertEquals(expResult, result);
    }
    
}
