/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import DAO.DocGia_DAO;
import DTO.DocGia;
import Response.TextLimit;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class DangKyController implements Initializable {

    @FXML private TextLimit txtUserName;
    @FXML private TextField txtPass;
    @FXML private TextLimit txtHoTen;
    @FXML private TextField txtSDT;
    @FXML private TextField txtGmail;
    @FXML private TextField txtTinhTrang;
    @FXML private TextField txtKhoa;
    @FXML private DatePicker dtNgaySinh;
    @FXML private RadioButton rdNam;
    @FXML private RadioButton rdNu;
    @FXML private RadioButton rdAdmin;
    @FXML private RadioButton rdGiangVien;
    @FXML private RadioButton rdSinhVien;
    @FXML private Button btDangKy;
    @FXML private Button TroVe;
    
    private int KTraGiaTriNull(){
        if(txtUserName.getText()=="" || txtPass.getText()=="" || txtHoTen.getText()=="" || txtGmail.getText()=="" || 
                txtTinhTrang.getText()=="" || txtKhoa.getText()=="" )
            return 1;
        else
            return 0;
    }
    private int DinhDangMail(){
        int KQ=0;
        int a=txtGmail.getText().indexOf("@");
        String b="@ou.edu.vn";
        System.out.println(txtGmail.getText().substring(a));
        if(!txtGmail.getText().substring(a).equals(b))
            KQ=1;
        return KQ;
    }
    
    private int KTraRangBuoc(String input){
        int KQ=0;
        int demKySo=0;
        int demKyTu=0;
        int demKyTuDB=0;
        int size=input.length();
        for(int i=0;i<size;i++){
            if(Character.isLetter(input.charAt(i))==true)
                demKyTu++;
            else if(Character.isDigit(input.charAt(i))==true)
                demKySo++;
            else if((Character.getType(input.charAt(i))==Character.CURRENCY_SYMBOL)==true)
                demKyTuDB++;
        }
        System.out.println(demKyTu);
        System.out.println(demKySo);
        System.out.println(demKyTuDB);
        if(demKySo==size || demKyTuDB==size || (demKySo+demKyTu==size && demKySo!=0) || (demKySo+demKyTuDB==size) || (demKyTu+demKyTuDB==size && demKyTuDB!=0))
            KQ=1;
        return KQ;
    }
    public void butDangKy(ActionEvent event) throws  IOException{
        java.sql.Date sqlDate =java.sql.Date.valueOf(dtNgaySinh.getValue());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate=sdf.format(sqlDate);
        if(KTraGiaTriNull()==1){
            JOptionPane.showMessageDialog(null, "Có giá trị còn trống");
        }
        else if(KTraRangBuoc(txtUserName.getText())==1)
            JOptionPane.showMessageDialog(null, "UserName không đúng cú pháp");
        else if(KTraRangBuoc(txtPass.getText())==1)
            JOptionPane.showMessageDialog(null, "Mật khẩu không đúng cú pháp");
        else if(KTraRangBuoc(txtHoTen.getText())==1)
            JOptionPane.showMessageDialog(null, "Họ Tên không đúng cú pháp");
        else if(DinhDangMail()==1)
            JOptionPane.showMessageDialog(null, "Sai định dạng mail");
        else {
        DocGia_DAO a=new DocGia_DAO();
        if(a.KiemTraTenDangNhap(txtUserName.getText())!=1){
            DocGia b=new DocGia();
            b.setUserName(txtUserName.getText());
            b.setPass(txtPass.getText());
            b.setTenDocGia(txtHoTen.getText());
            b.setSDT(txtSDT.getText());
            b.setGmail(txtGmail.getText());
            b.setTinhTrangThe(txtTinhTrang.getText());
            b.setKhoa(txtKhoa.getText());
            b.setNgaySinh(strDate);
            if(rdNam.isSelected()==true && rdNu.isSelected()==false)
                b.setGioiTinh(rdNam.getText());
            else
                b.setGioiTinh(rdNu.getText());
            if(rdGiangVien.isSelected()==true && rdSinhVien.isSelected()==false )
                b.setChucVu(rdGiangVien.getText());
            else if(rdGiangVien.isSelected()==false && rdSinhVien.isSelected()==true)
                b.setChucVu(rdSinhVien.getText());
            if(a.DangKy(b)==true){
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            }
            else
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
        else
            JOptionPane.showMessageDialog(null, "Username bị trùng");
        }
        
    }
    public void btBack(ActionEvent event) throws IOException{
        App.setRoot("DangNhap");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtUserName.setlimit(8);
        txtHoTen.setlimit(45);
        txtTinhTrang.setText("Enable");
        txtTinhTrang.setEditable(false);
    }    
    
}
