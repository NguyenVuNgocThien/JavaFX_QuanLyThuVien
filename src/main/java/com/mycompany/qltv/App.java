/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qltv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Scene sc;
    private Stage st;
    private Parent rt;
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("DangNhap"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
     public void SwicthScene(ActionEvent event,String fxml) throws IOException{
        Parent rt=FXMLLoader.load(getClass().getResource(fxml+".fxml"));
        st=(Stage)((Node)event.getSource()).getScene().getWindow();
        sc=new Scene(rt);
        st.setScene(sc);
        st.show();
    }

    
}
