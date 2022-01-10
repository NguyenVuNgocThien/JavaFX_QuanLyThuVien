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
import java.time.LocalDate;
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
    @FXML private TextLimit txtPass;
    @FXML private TextLimit txtHoTen;
    @FXML private TextLimit txtSDT;
    @FXML private TextLimit txtGmail;
    @FXML private TextLimit txtTinhTrang;
    @FXML private RadioButton rdCNTT;
    @FXML private RadioButton rdKinhTe;
    @FXML private RadioButton rdXayDung;
    @FXML private DatePicker dtNgaySinh;
    @FXML private RadioButton rdNam;
    @FXML private RadioButton rdNu;
    @FXML private RadioButton rdGiangVien;
    @FXML private RadioButton rdSinhVien;
    @FXML private Button btDangKy;
    @FXML private Button TroVe;
    App app=new App();
    public int KTraGiaTriNull(){
        if(txtUserName.getText()=="" || txtPass.getText()=="" || txtHoTen.getText()=="" || txtGmail.getText()=="" || 
                txtTinhTrang.getText()==""  )
            return 1;
        else
            return 0;
    }
    public int DinhDangMail(String input){
        int KQ=0;
        int demKyTuDB=0;
        int demKhoangTrang=0;
        int size=input.length();
        int a=input.indexOf("@");
        String b="@ou.edu.vn";
        System.out.println(input.substring(a));
        for(int i=0;i<size;i++){
            if((Character.getType(input.charAt(i))==Character.CURRENCY_SYMBOL)==true)
                demKyTuDB++;
            else if(Character.isWhitespace(input.charAt(i)))
                demKhoangTrang++;
        }
        if(!input.substring(a).equals(b) || demKhoangTrang>0 || demKyTuDB>0)
            KQ=1;
        return KQ;
    }
    public int KTraRangBuocTenDocGia(String input){
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
    public int KTraRangBuocUserVaPass(String input){
        int KQ=0;
        int demKhoangTrang=0;
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
            else if(Character.isWhitespace(input.charAt(i)))
                demKhoangTrang++;
        }
        if(demKhoangTrang>0||demKySo==size || demKyTuDB==size || demKyTu==size || (demKySo+demKyTu==size && demKySo!=0) || (demKySo+demKyTuDB==size) || (demKyTu+demKyTuDB==size && demKyTuDB!=0))
            KQ=1;
        return KQ;
    }
    public int KTSDT(String input){
        int kq=0;
        int demKySo=0;
        int size=input.length();
        for(int i=0;i<size;i++)
        {
            if(Character.isDigit(input.charAt(i))==true  )
                demKySo++;
        }
        if(demKySo!=size || input.length()!=11 || input.charAt(0)!='0')
            kq=1;
        return kq;
    }
    public void butDangKy(ActionEvent event) throws  IOException{
        LocalDate now=LocalDate.now();
        java.sql.Date sqlDate =java.sql.Date.valueOf(dtNgaySinh.getValue());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate=sdf.format(sqlDate);
        if(KTraGiaTriNull()==1){
            JOptionPane.showMessageDialog(null, "Có giá trị còn trống");
        }
        else if(KTraRangBuocUserVaPass(txtUserName.getText())==1)
            JOptionPane.showMessageDialog(null, "UserName không đúng cú pháp");
        else if(KTraRangBuocUserVaPass(txtPass.getText())==1)
            JOptionPane.showMessageDialog(null, "Mật khẩu không đúng cú pháp");
        else if(KTraRangBuocTenDocGia(txtHoTen.getText())==1)
            JOptionPane.showMessageDialog(null, "Họ Tên không đúng cú pháp");
        else if(DinhDangMail(txtGmail.getText())==1)
            JOptionPane.showMessageDialog(null, "Sai định dạng mail");
        else if((now.getYear()-dtNgaySinh.getValue().getYear())<18)
            JOptionPane.showMessageDialog(null, "Chưa đủ 18 tuổi");
        else if(KTSDT(txtSDT.getText())==1 )
            JOptionPane.showMessageDialog(null, "SDT phải đủ 11 số và số 0 ở đầu SDT");
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
            if(rdCNTT.isSelected()==true && rdXayDung.isSelected()==false && rdKinhTe.isSelected()==false)
                b.setKhoa(rdCNTT.getText());
            else if(rdCNTT.isSelected()==false && rdXayDung.isSelected()==true && rdKinhTe.isSelected()==false)
                b.setKhoa(rdXayDung.getText());
            else if(rdCNTT.isSelected()==false && rdXayDung.isSelected()==false && rdKinhTe.isSelected()==true)
                b.setKhoa(rdKinhTe.getText());
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
                JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                app.SwicthScene(event,"DangNhap");
            }
            else
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
        }
        else
            JOptionPane.showMessageDialog(null, "Username bị trùng");
        }
        
    }
    public void btBack(ActionEvent event) throws IOException{
        app.SwicthScene(event, "DangNhap");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtUserName.setlimit(8);
        txtHoTen.setlimit(45);
        txtPass.setlimit(7);
        txtTinhTrang.setlimit(10);
        txtGmail.setlimit(50);
        txtSDT.setlimit(11);
        txtTinhTrang.setText("Enable");
        txtTinhTrang.setEditable(false);
    }    
    
}
