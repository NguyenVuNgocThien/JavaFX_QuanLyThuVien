/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import DAO.Sach_DAO;
import DTO.Sach;
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
public class QuanLyKhoSachController implements Initializable {
    @FXML private TableView<Sach> DSSach;
   @FXML private TableColumn<Sach,String> MaSach;
   @FXML private TableColumn<Sach,String> TenSach;
   @FXML private TableColumn<Sach,String> TenTacGia;
   @FXML private TableColumn<Sach,String> MoTaSach;
   @FXML private TableColumn<Sach,String> PhatHanh;
   @FXML private TableColumn<Sach,String> NoiPhatHanh;
   @FXML private TableColumn<Sach,String> TinhTrang;
   @FXML private TableColumn<Sach,String> LoaiSach;
   @FXML private TextLimit txtMaSach;
   @FXML private TextLimit txtTenSach;
   @FXML private TextLimit txtTenTacGia;
   @FXML private TextField txtTT;
   @FXML private Button btThem;
   @FXML private Button btSua;
   @FXML private Button btXoa;
   @FXML private Hyperlink hpTrangChu;
   App app=new App();
   public int KTraGiaTriNull(){
        if(txtMaSach.getText()=="" || txtTenSach.getText()=="" || txtTenTacGia.getText()=="" || txtTT.getText()==""  )
            return 1;
        else
            return 0;
    }
   public int KTraRangBuocTenSach(String input){
        int KQ=0;
        int demKyTuDB=0;
        int size=input.length();
        for(int i=0;i<size;i++){if((Character.getType(input.charAt(i))==Character.CURRENCY_SYMBOL)==true)
                demKyTuDB++;
        }
        System.out.println(demKyTuDB);
        if(demKyTuDB>0)
            KQ=1;
        return KQ;
    }
   public int KTraRangBuocTenTacGia(String input){
        int KQ=0;
        int demKySo=0;
        int demKyTuDB=0;
        int size=input.length();
        for(int i=0;i<size;i++){
            if(Character.isDigit(input.charAt(i))==true)
                demKySo++;
            else if((Character.getType(input.charAt(i))==Character.CURRENCY_SYMBOL)==true)
                demKyTuDB++;
        }
        System.out.println(demKySo);
        System.out.println(demKyTuDB);
        if(demKySo>0||demKyTuDB>0)
            KQ=1;
        return KQ;
    }
   public int KTMaSach(String input){
        int kq=0;
        int demKySo=0;
        int size=input.length();
        for(int i=0;i<size;i++)
        {
            if(Character.isDigit(input.charAt(i))==true  )
                demKySo++;
        }
        if(demKySo!=size  )
            kq=1;
        return kq;
    }
   public void hpTC(ActionEvent event) throws IOException{
       app.SwicthScene(event, "TrangChuQuanLy");
   }
   public void butThem(ActionEvent event){
       Sach_DAO a=new Sach_DAO();
       if(KTraGiaTriNull()==0)
       {
           if(KTMaSach(txtMaSach.getText())==0){
               if(KTraRangBuocTenTacGia(txtTenTacGia.getText())==0){
                   if(KTraRangBuocTenSach(txtTenSach.getText())==0){
       if(a.KTMaSach(txtMaSach.getText())!=true ){
           Sach b=new Sach();
           b.setMaSach(txtMaSach.getText());
           b.setTenSach(txtTenSach.getText());
           b.setTinhTrang(txtTT.getText());
           b.setTenTacGia(txtTenTacGia.getText());
           if(a.ThemSach(b)==true)
           {
               JOptionPane.showMessageDialog(null, "Thêm thành công");
               try {
                   loadDSSach();
               } catch (SQLException ex) {
                   Logger.getLogger(QuanLyKhoSachController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           else
               JOptionPane.showMessageDialog(null, "Thêm thất bại");
       }
       else
           JOptionPane.showMessageDialog(null, "Mã Sách bị trùng hoặc tên sách bị trùng"); 
                   }else
                       JOptionPane.showMessageDialog(null, "Tên Sách không được có kí tự đb");
               }else
                   JOptionPane.showMessageDialog(null, "Tên Tác giả không được có số và kí tự đb");
           }else 
               JOptionPane.showMessageDialog(null, "Mã sách chỉ đc nhập số");
       }
       else
           JOptionPane.showMessageDialog(null, "Có Giá Trị còn trống");
   }
   public void butSua(ActionEvent event) throws SQLException{
       System.out.println(txtMaSach.getText() + DSSach.getSelectionModel().getSelectedItem().getMaSach());
       Sach_DAO a=new Sach_DAO();
       if(KTraGiaTriNull()==0)
       {
           if(KTMaSach(txtMaSach.getText())==0){
               if(KTraRangBuocTenTacGia(txtTenTacGia.getText())==0){
                   if(KTraRangBuocTenSach(txtTenSach.getText())==0){
           Sach b=new Sach();
           if(txtMaSach.getText().equals(DSSach.getSelectionModel().getSelectedItem().getMaSach())==false)
               JOptionPane.showMessageDialog(null, "Không được sửa Mã Sách");
           else{
               b.setMaSach(DSSach.getSelectionModel().getSelectedItem().getMaSach());
           b.setTenSach(txtTenSach.getText());
           b.setTinhTrang(DSSach.getSelectionModel().getSelectedItem().getTinhTrang());
           b.setTenTacGia(txtTenTacGia.getText());
           if(a.SuaSach(b)==true)
           {
               JOptionPane.showMessageDialog(null, "Sửa thành công");
               try {
                   loadDSSach();
               } catch (SQLException ex) {
                   Logger.getLogger(QuanLyKhoSachController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           else
               JOptionPane.showMessageDialog(null, "Sửa thất bại");}
                   }else
                       JOptionPane.showMessageDialog(null, "Tên Sách không được có kí tự đb");
               }else
                   JOptionPane.showMessageDialog(null, "Tên tác giả không được có số và kí tự đb");
           }else 
               JOptionPane.showMessageDialog(null, "Mã sách chỉ đc nhập số");
       }
       else
           JOptionPane.showMessageDialog(null, "Có Giá Trị còn trống");
   }
   public void butXoa(ActionEvent event) throws SQLException{
       Sach_DAO a=new Sach_DAO();
       if(a.XoaSach(DSSach.getSelectionModel().getSelectedItem().getMaSach())==true && !DSSach.getSelectionModel().getSelectedItem().getTinhTrang().equals("Borrowed")){
           JOptionPane.showMessageDialog(null, "Xóa Thành Công");
           loadDSSach();
       }
       else
           JOptionPane.showMessageDialog(null, "Xóa Thất Bại,Sách đang được mượn hoặc đang được yêu cầu mượn");
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTT.setText("Available");
        txtTT.setEditable(false);
        txtMaSach.setlimit(7);
        txtTenSach.setlimit(45);
        txtTenTacGia.setlimit(45);
        this.DSSach.getItems().clear();
       try {
               loadDSSach();
       } catch (SQLException ex) {
           Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
       }
       btThem.setOnAction((ActionEvent event)->{
           butThem(event);
       });
       btSua.setOnAction((ActionEvent event)->{
            try {
                butSua(event);
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyKhoSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
       });
       btXoa.setOnAction((ActionEvent event)->{
            try {
                butXoa(event);
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyKhoSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
       });
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
}
