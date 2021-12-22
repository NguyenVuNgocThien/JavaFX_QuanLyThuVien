/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import DAO.Muon_DAO;
import DAO.Sach_DAO;
import DAO.YeuCau_DAO;
import DTO.Muon;
import DTO.Sach;
import DTO.YeuCau;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class QuanLyMuonSachController implements Initializable {
   
   @FXML private TableView<Muon> DSMuon;
   @FXML private TableColumn<Muon,String> IDMuon;
   @FXML private TableColumn<Muon,String> UserName;
   @FXML private TableColumn<Muon,String> MaSach2;
   @FXML private TableColumn<Muon,String> PhoneNumber;
   @FXML private TableColumn<Muon,String> NgayTra;
   @FXML private TableColumn<Muon,String> NgayMuon;
   @FXML private TableView<YeuCau> tbYeuCau;
   @FXML private TableColumn<YeuCau,String> UserNameBangYeuCau;
   @FXML private TableColumn<YeuCau,String> MaSachBangYeuCau;
   @FXML private DatePicker dtNgayTra;
   @FXML private DatePicker dtNgayMuon;
   @FXML private Button btAccess;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.DSMuon.getItems().clear();
       try {
           loadDSMuon();
       } catch (SQLException ex) {
           Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
       }
       this.tbYeuCau.getItems().clear();
       try {
           loadDSYeuCau();
       } catch (SQLException ex) {
           Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }    
    private void loadDSMuon() throws SQLException{
        System.out.println(QuanLyDocGiaController.LayUser);
        this.IDMuon.setCellValueFactory(new PropertyValueFactory<Muon,String>("IDMuon"));
        this.UserName.setCellValueFactory(new PropertyValueFactory<Muon,String>("UserName"));
        this.MaSach2.setCellValueFactory(new PropertyValueFactory<Muon,String>("MaSach"));
        this.PhoneNumber.setCellValueFactory(new PropertyValueFactory<Muon,String>("PhoneNumber"));
        this.NgayTra.setCellValueFactory(new PropertyValueFactory<Muon,String>("NgayTra"));
        this.NgayMuon.setCellValueFactory(new PropertyValueFactory<Muon,String>("NgayMuon"));
        Muon_DAO b=new Muon_DAO();
        DSMuon.setItems(FXCollections.observableList(b.DanhSachMuon(QuanLyDocGiaController.LayUser)));
        
    }
    private void loadDSYeuCau() throws SQLException{
        this.UserNameBangYeuCau.setCellValueFactory(new PropertyValueFactory<YeuCau,String>("UserName"));
        this.MaSachBangYeuCau.setCellValueFactory(new PropertyValueFactory<YeuCau,String>("MaSach"));
        YeuCau_DAO a=new YeuCau_DAO();
        tbYeuCau.setItems(FXCollections.observableList(a.DSYeuCau(QuanLyDocGiaController.LayUser)));
    }
}
