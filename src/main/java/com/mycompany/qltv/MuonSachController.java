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
import Response.TextLimit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class MuonSachController implements Initializable {
   @FXML private TableView<Sach> DSSach;
   @FXML private TableColumn<Sach,String> MaSach;
   @FXML private TableColumn<Sach,String> TenSach;
   @FXML private TableColumn<Sach,String> TenTacGia;
   @FXML private TableColumn<Sach,String> MoTaSach;
   @FXML private TableColumn<Sach,String> PhatHanh;
   @FXML private TableColumn<Sach,String> NoiPhatHanh;
   @FXML private TableColumn<Sach,String> TinhTrang;
   @FXML private TableColumn<Sach,String> LoaiSach;
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
   @FXML private Button btYeuCauMuonSach;
   @FXML private Label US;
   @FXML private Button btTimKiem;
   @FXML private TextField txtTimKiem;
   @FXML private Hyperlink hpBack;
   App app=new App();
    public void BTTimKiem(ActionEvent event) throws IOException, SQLException{
        this.DSSach.getItems().clear();
        if(txtTimKiem.getText()!="")
        {
               loadDSTimKiem();
        }
        else
        {
            this.DSSach.getItems().clear();
            loadDSSach();
        }
   }
    public void BTYeuCau(ActionEvent event) throws SQLException{
        YeuCau_DAO a=new YeuCau_DAO();
        Muon_DAO b=new Muon_DAO();
        if(DSSach.getSelectionModel().getSelectedItem()!=null){
        if(DSSach.getSelectionModel().getSelectedItem().getTinhTrang().equals("Borrowed") || b.DemSLSach(DangNhapController.LayUser)>2)
            JOptionPane.showMessageDialog(null, "Sách đã được mượn hoặc bạn mượn quá 2 quyển sách");
        else{
            if(a.ThemYeuCau(DangNhapController.LayUser, DSSach.getSelectionModel().getSelectedItem().getMaSach() )==true){
                loadDSYeuCau();
                JOptionPane.showMessageDialog(null, "Thêm Yêu Cầu Thành Công,xin hãy chờ đợi kiểm duyệt");
            }
            else
                 JOptionPane.showMessageDialog(null, "Thêm Thất bại");
        }
        }
        else
            JOptionPane.showMessageDialog(null, "Chưa Chọn Sách ");
    }
    public void hpVeTrangChu(ActionEvent event) throws IOException{
        app.SwicthScene(event, "TrangChu");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        US.setText(DangNhapController.LayUser);
        this.DSSach.getItems().clear();
       try {
               loadDSSach();
       } catch (SQLException ex) {
           Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
       }
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
       btTimKiem.setOnAction((ActionEvent event)->{
            try {
                BTTimKiem(event);
            } catch (IOException ex) {
                Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
       });
       btYeuCauMuonSach.setOnAction((ActionEvent event)->{
            try {
                BTYeuCau(event);
            } catch (SQLException ex) {
                Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void loadDSSach() throws SQLException{
        this.MaSach.setCellValueFactory(new PropertyValueFactory<Sach,String>("MaSach"));
        this.TenSach.setCellValueFactory(new PropertyValueFactory<Sach,String>("TenSach"));
        this.TenTacGia.setCellValueFactory(new PropertyValueFactory<Sach,String>("TenTacGia"));
        this.MoTaSach.setCellValueFactory(new PropertyValueFactory<Sach,String>("MoTaSach"));
        this.PhatHanh.setCellValueFactory(new PropertyValueFactory<Sach,String>("PhatHanh"));
        this.NoiPhatHanh.setCellValueFactory(new PropertyValueFactory<Sach,String>("NoiPhatHanh"));
        this.TinhTrang.setCellValueFactory(new PropertyValueFactory<Sach,String>("TinhTrang"));
        this.LoaiSach.setCellValueFactory(new PropertyValueFactory<Sach,String>("LoaiSach"));
        Sach_DAO a=new Sach_DAO();
        DSSach.setItems(FXCollections.observableList(a.DanhSachSach()));
    }
    private void loadDSTimKiem() throws SQLException{
        this.MaSach.setCellValueFactory(new PropertyValueFactory<Sach,String>("MaSach"));
        this.TenSach.setCellValueFactory(new PropertyValueFactory<Sach,String>("TenSach"));
        this.TenTacGia.setCellValueFactory(new PropertyValueFactory<Sach,String>("TenTacGia"));
        this.MoTaSach.setCellValueFactory(new PropertyValueFactory<Sach,String>("MoTaSach"));
        this.PhatHanh.setCellValueFactory(new PropertyValueFactory<Sach,String>("PhatHanh"));
        this.NoiPhatHanh.setCellValueFactory(new PropertyValueFactory<Sach,String>("NoiPhatHanh"));
        this.TinhTrang.setCellValueFactory(new PropertyValueFactory<Sach,String>("TinhTrang"));
        this.LoaiSach.setCellValueFactory(new PropertyValueFactory<Sach,String>("LoaiSach"));
        Sach_DAO a=new Sach_DAO();
        DSSach.setItems(FXCollections.observableList(a.TimKiemSach(txtTimKiem.getText())));
    }
    private void loadDSYeuCau() throws SQLException{
        this.UserNameBangYeuCau.setCellValueFactory(new PropertyValueFactory<YeuCau,String>("UserName"));
        this.MaSachBangYeuCau.setCellValueFactory(new PropertyValueFactory<YeuCau,String>("MaSach"));
        YeuCau_DAO a=new YeuCau_DAO();
        tbYeuCau.setItems(FXCollections.observableList(a.DSYeuCau(DangNhapController.LayUser)));
    }
}
