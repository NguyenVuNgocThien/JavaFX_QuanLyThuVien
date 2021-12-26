/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import DAO.DocGia_DAO;
import Response.TextLimit;
import java.awt.Frame;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author dell
 */
public class DangNhapController implements Initializable {

    @FXML private TextLimit txtUserName;
    @FXML private TextField txtPass;
    @FXML private RadioButton rdQL; 
    @FXML private RadioButton rdND;
    @FXML private Button btDangNhap;
    @FXML private Button btDangKy;
    public static String LayUser;
    App app=new App();
   
    public void BTclickDangNhap(ActionEvent event) throws IOException, SQLException{
        DocGia_DAO a=new DocGia_DAO();
        String UserName=this.txtUserName.getText();
        String Pass=this.txtPass.getText();
        boolean b=this.rdQL.isSelected();
        if(Pass==""){
            JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu");
        }
        else if(UserName==""){
            JOptionPane.showMessageDialog(null, "Chưa nhập user");
        }
        else if(rdQL.isSelected()==false && rdND.isSelected()==false)
        {
                JOptionPane.showMessageDialog(null, "Chua chon quyen dang nhap");
        }
        else if(a.DangNhap_DAO(UserName,Pass)==0 )
            JOptionPane.showMessageDialog(null, "Sai User hoặc mật khẩu");
        else if(a.DangNhap_DAO(UserName,Pass)==1 && rdQL.isSelected()==true)
        {
            app.SwicthScene(event, "QuanLyDocGia");
        }
        else if(a.DangNhap_DAO(UserName,Pass)==2 && rdND.isSelected()==true){
            LayUser=txtUserName.getText();
            app.SwicthScene(event, "TrangChu");
            
        }
            
    }
   
    
    public void BTclickDangKy(ActionEvent event) throws IOException{
        app.SwicthScene(event, "DangKy");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtUserName.setlimit(20);
    }    
    
    
}
