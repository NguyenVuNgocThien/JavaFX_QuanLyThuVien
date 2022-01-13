/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import DTO.Muon;
import DAO.Muon_DAO;
import DTO.Tra;
import DAO.Tra_DAO;
import DAO.YeuCau_DAO;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class TraSachController implements Initializable {
   @FXML private TableView<Tra> DSTra;
   @FXML private TableColumn<Tra,String> IDTra;
   @FXML private TableColumn<Tra,String> UserName1;
   @FXML private TableColumn<Tra,String> MaSach1;
   @FXML private TableColumn<Tra,String> PhoneNumber1;
   @FXML private TableColumn<Tra,String> NgayTra1;
   @FXML private TableColumn<Tra,String> NgayMuon1;
   @FXML private TableColumn<Tra,String> TinhTrang;
   @FXML private TableView<Muon> DSMuon;
   @FXML private TableColumn<Muon,String> IDMuon;
   @FXML private TableColumn<Muon,String> UserName;
   @FXML private TableColumn<Muon,String> MaSach2;
   @FXML private TableColumn<Muon,String> PhoneNumber;
   @FXML private TableColumn<Muon,String> NgayTra;
   @FXML private TableColumn<Muon,String> NgayMuon;
   @FXML private Button btTraSach;
   @FXML private Hyperlink hpBack;
   App app=new App();
   public void hpVeTrangChu(ActionEvent event) throws IOException{
        app.SwicthScene(event, "TrangChu");
    }
   public void butTraSach(ActionEvent event) throws IOException,SQLException{
       LocalDate now=LocalDate.now();
       Tra_DAO a=new Tra_DAO();
       Muon_DAO b=new Muon_DAO();
            if(a.ThemTra(DangNhapController.LayUser, DSMuon.getSelectionModel().getSelectedItem().getMaSach(),DSMuon.getSelectionModel().getSelectedItem().getNgayMuon(),now.toString(),DSMuon.getSelectionModel().getSelectedItem().getPhoneNumber(),"Đã Trả")==true 
               && b.XoaMuon(DSMuon.getSelectionModel().getSelectedItem().getMaSach(),DangNhapController.LayUser)){
           JOptionPane.showMessageDialog(null, "Trả thành công");
           loadDSMuon();
           loadDSTra();
           
       }  
       else
           JOptionPane.showMessageDialog(null, "Trả Thất Bại");
       
       
                
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     this.DSTra.getItems().clear();
       try {
           loadDSTra();
       } catch (SQLException ex) {
           Logger.getLogger(TraSachController.class.getName()).log(Level.SEVERE, null, ex);
       }   
     this.DSMuon.getItems().clear();
       try {
           loadDSMuon();
       } catch (SQLException ex) {
           Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
       }
        btTraSach.setOnAction((ActionEvent event)->{
            try {
                butTraSach(event);
            } catch (SQLException ex) {
                Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
             Logger.getLogger(TraSachController.class.getName()).log(Level.SEVERE, null, ex);
         }
       });
    }
      private void loadDSMuon() throws SQLException{
        System.out.println(DangNhapController.LayUser);
        this.IDMuon.setCellValueFactory(new PropertyValueFactory<Muon,String>("IDMuon"));
        this.UserName.setCellValueFactory(new PropertyValueFactory<Muon,String>("UserName"));
        this.MaSach2.setCellValueFactory(new PropertyValueFactory<Muon,String>("MaSach"));
        this.PhoneNumber.setCellValueFactory(new PropertyValueFactory<Muon,String>("PhoneNumber"));
        this.NgayTra.setCellValueFactory(new PropertyValueFactory<Muon,String>("NgayTra"));
        this.NgayMuon.setCellValueFactory(new PropertyValueFactory<Muon,String>("NgayMuon"));
        Muon_DAO b=new Muon_DAO();
        DSMuon.setItems(FXCollections.observableList(b.DanhSachMuon(DangNhapController.LayUser)));
    
         }
        private void loadDSTra() throws SQLException{
        System.out.println(DangNhapController.LayUser);
        this.IDTra.setCellValueFactory(new PropertyValueFactory<Tra,String>("IDTra"));
        this.UserName1.setCellValueFactory(new PropertyValueFactory<Tra,String>("UserName"));
        this.MaSach1.setCellValueFactory(new PropertyValueFactory<Tra,String>("MaSach"));
        this.PhoneNumber1.setCellValueFactory(new PropertyValueFactory<Tra,String>("PhoneNumber"));
        this.NgayTra1.setCellValueFactory(new PropertyValueFactory<Tra,String>("NgayTra"));
        this.NgayMuon1.setCellValueFactory(new PropertyValueFactory<Tra,String>("NgayMuon"));
        this.TinhTrang.setCellValueFactory(new PropertyValueFactory<Tra,String>("TinhTrang"));
        Tra_DAO b=new Tra_DAO();
        DSTra.setItems(FXCollections.observableList(b.DanhSachTra(DangNhapController.LayUser)));
    
         }
}
