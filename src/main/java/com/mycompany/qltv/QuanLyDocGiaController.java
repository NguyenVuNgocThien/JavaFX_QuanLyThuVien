/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import DAO.ConnectionClass;
import DAO.DocGia_DAO;
import DTO.DocGia;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class QuanLyDocGiaController implements Initializable  {
   @FXML private TableView<DocGia> DSDocGia;
   @FXML private TableColumn<DocGia,String> TenDocGia;
   @FXML private TableColumn<DocGia,String> NgaySinh;
   @FXML private TableColumn<DocGia,String> ChucVu;
   @FXML private TableColumn<DocGia,String> TinhTrangThe;
   @FXML private TableColumn<DocGia,String> Gmail;
   @FXML private TableColumn<DocGia,String> GioiTinh;
   @FXML private TableColumn<DocGia,String> SDT;
   @FXML private TableColumn<DocGia,String> Khoa;
   @Override
   public void initialize  (URL url,ResourceBundle rb){
       this.DSDocGia.getItems().clear();
       try {
           loadDSDocGia();
       } catch (SQLException ex) {
           Logger.getLogger(QuanLyDocGiaController.class.getName()).log(Level.SEVERE, null, ex);
       }
     
           
     
   }
    private void loadDSDocGia() throws SQLException  {
      
        this.TenDocGia.setCellValueFactory(new PropertyValueFactory<DocGia,String>("TenDocGia"));
        this.NgaySinh.setCellValueFactory(new PropertyValueFactory<DocGia,String>("NgaySinh"));
        this.ChucVu.setCellValueFactory(new PropertyValueFactory<DocGia,String>("ChucVu"));
        this.TinhTrangThe.setCellValueFactory(new PropertyValueFactory<DocGia,String>("TinhTrangThe"));
        this.Gmail.setCellValueFactory(new PropertyValueFactory<DocGia,String>("Gmail"));
        this.GioiTinh.setCellValueFactory(new PropertyValueFactory<DocGia,String>("GioiTinh"));
        this.SDT.setCellValueFactory(new PropertyValueFactory<DocGia,String>("SDT"));
        this.Khoa.setCellValueFactory(new PropertyValueFactory<DocGia,String>("Khoa"));
        DocGia_DAO a=new DocGia_DAO();
        DSDocGia.setItems(FXCollections.observableList(a.DanhSachDocGia()));
      
    }

}
