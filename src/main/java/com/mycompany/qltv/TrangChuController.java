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
    public void clickMuonSach(ActionEvent event) throws IOException{
        App.setRoot("MuonSach");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
