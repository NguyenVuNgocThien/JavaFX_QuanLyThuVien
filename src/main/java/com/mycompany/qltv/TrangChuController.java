/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class TrangChuController implements Initializable {

    @FXML private Hyperlink hpMuonSach;
    @FXML private Hyperlink hpTraSach;
    @FXML private Hyperlink hpVeDangNhap;
    App app=new App();
    public void clickMuonSach(ActionEvent event) throws IOException{
        app.SwicthScene(event, "MuonSach");
    }
    public void clickTraSach (ActionEvent event) throws IOException{
        app.SwicthScene(event, "TraSach");
    }
    public void clickVeDangNhap(ActionEvent event) throws IOException{
        app.SwicthScene(event, "DangNhap");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
