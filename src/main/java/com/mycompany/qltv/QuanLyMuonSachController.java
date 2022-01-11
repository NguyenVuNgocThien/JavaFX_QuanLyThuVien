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
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
   @FXML private Hyperlink hpBack;
   public void hpBack(ActionEvent event) throws IOException
   {
       App app=new App();
       app.SwicthScene(event, "QuanLyDocGia");
   }
   public int RangBuocNgayThangMuon(LocalDate dt){
       int kq=0;
       LocalDate now=LocalDate.now();
       LocalDate NgayMuon=dt;
       System.out.println(now.getDayOfMonth());
       System.out.println(NgayMuon.getDayOfMonth());
       if(NgayMuon.getDayOfMonth()>now.getDayOfMonth() && NgayMuon.getMonthValue()>=now.getMonthValue() && NgayMuon.getYear()>=now.getYear())
           kq=1;
       return kq;
   }
   public int RangBuocNgayThangTra(LocalDate dtMuon,LocalDate dtTra){
       int kq=0;
       LocalDate NgayTra=dtTra;
       LocalDate NgayMuon=dtMuon;
       System.out.println(NgayTra.getDayOfMonth());
       System.out.println(NgayMuon.getDayOfMonth());
       if(NgayMuon.getDayOfMonth()<NgayTra.getDayOfMonth() && NgayMuon.getMonthValue()<=NgayTra.getMonthValue() && NgayMuon.getYear()<=NgayTra.getYear())
           kq=1;
       return kq;
   }
   public void btAccess(ActionEvent event) throws SQLException{
       Sach_DAO s=new Sach_DAO();
       if(tbYeuCau.getSelectionModel().getSelectedItem()!=null){
       if(dtNgayMuon.getValue()==null||dtNgayTra.getValue()==null)
           JOptionPane.showMessageDialog(null, "Chưa nhập ngày trả hoặc ngày mượn");
       else{
       if(RangBuocNgayThangMuon(dtNgayMuon.getValue())==0)
           JOptionPane.showMessageDialog(null, "Ngày mượn nhỏ hơn ngày hiện tại");
       else if(RangBuocNgayThangTra(dtNgayMuon.getValue(),dtNgayTra.getValue())==0)
                JOptionPane.showMessageDialog(null, "Ngày trả phải lớn hơn ngày mượn");
       else
       {
       Date sqlDate1=Date.valueOf(dtNgayMuon.getValue());
       SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String NgayMuon=sdf1.format(sqlDate1);
       Date sqlDate2=Date.valueOf(dtNgayTra.getValue());
       SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String NgayTra=sdf2.format(sqlDate2);
       Muon_DAO a=new Muon_DAO();
       if(a.ThemMuon(QuanLyDocGiaController.LayUser, tbYeuCau.getSelectionModel().getSelectedItem().getMaSach(), NgayMuon, NgayTra)==true 
               && a.XoaYeuCau(tbYeuCau.getSelectionModel().getSelectedItem().getMaSach(),QuanLyDocGiaController.LayUser)){
           JOptionPane.showMessageDialog(null, "Access thành công");
           s.CapNhatSachDangMuon(tbYeuCau.getSelectionModel().getSelectedItem().getMaSach());
           loadDSMuon();
           loadDSYeuCau();
       }
       else
           JOptionPane.showMessageDialog(null, "Access Thất Bại");
       }
       }}
       else
           JOptionPane.showMessageDialog(null, "Chưa chọn yêu cầu cần thêm");
   }
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
       btAccess.setOnAction((ActionEvent event)->{
            try {
                btAccess(event);
            } catch (SQLException ex) {
                Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
       });
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
