/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import DAO.ConnectionClass;
import DAO.DocGia_DAO;
import DTO.DocGia;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

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
   @FXML private Button btXoa;
   @FXML private Button btQLMuon;
   @FXML private Button btQLTra;
   public static String LayUser;
   public static String LaySDT;
   App app=new App();
   @FXML private Hyperlink hpVeTrangChu;
   public void hpVeTranChu(ActionEvent event) throws IOException
   {
       app.SwicthScene(event, "TrangChuQuanLy");
   }
   public void btXoaThanhVien(ActionEvent event) throws SQLException{
       DocGia_DAO a=new DocGia_DAO();
       if(DSDocGia.getSelectionModel().getSelectedItem()!=null){
       if(DSDocGia.getSelectionModel().getSelectedItem().getUserName()!="Disable" )
       {
           JOptionPane.showMessageDialog(null, "Thẻ chưa hết hạn,Không được xóa thành viên");
       }
       else
       {
           if(a.XoaThanhVien(DSDocGia.getSelectionModel().getSelectedItem().getUserName())==true)
           {
               JOptionPane.showMessageDialog(null, "Xóa Thành Công");
               loadDSDocGia();
           }
           else
               JOptionPane.showMessageDialog(null, "Xóa Thất Bại");
       }}
       else
           JOptionPane.showMessageDialog(null, "Chưa chọn người dùng");
   }
   public void btQuanLyMuonSach(ActionEvent event) throws IOException{
       if(DSDocGia.getSelectionModel().getSelectedItem()!=null){
       LayUser=DocGia_DAO.dsUS.get(DSDocGia.getSelectionModel().getSelectedIndex());
       LaySDT=DSDocGia.getSelectionModel().getSelectedItem().getSDT();
       app.SwicthScene(event, "QuanLyMuonSach");
       }
       else
           JOptionPane.showMessageDialog(null, "Chưa chọn người dùng");
   }
   @Override
   public void initialize  (URL url,ResourceBundle rb){
       this.DSDocGia.getItems().clear();
       try {
           loadDSDocGia();
       } catch (SQLException ex) {
           Logger.getLogger(QuanLyDocGiaController.class.getName()).log(Level.SEVERE, null, ex);
       }
       btXoa.setOnAction((ActionEvent event)->{
           try {
               btXoaThanhVien(event);
           } catch (SQLException ex) {
               Logger.getLogger(QuanLyDocGiaController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
           
     
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
