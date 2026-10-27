/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.geneanalyzer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ERIC -Yep-
 */
public class AnalyzeController implements Initializable {

    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchToHome(ActionEvent event) throws IOException{
        App.setRoot("home");
    }

    @FXML
    private void switchToSequences(ActionEvent event) throws IOException{
        App.setRoot("sequences");
    }

    @FXML
    private void switchToResults(ActionEvent event) throws IOException{
        App.setRoot("results");
    }

    @FXML
    private void switchToCompare(ActionEvent event) throws IOException{
        App.setRoot("compare");
    }

    @FXML
    private void switchToSettings(ActionEvent event) throws IOException{
        App.setRoot("settings");
    }

    @FXML
    private void changeSaveBtnColorBack(MouseEvent event) {
        saveBtn.setStyle("-fx-background-color: #002070");
    }

    @FXML
    private void changeSaveBtnColor(MouseEvent event) {
        saveBtn.setStyle("-fx-background-color: #002aff");
    }

    @FXML
    private void changeClearBtnColorBack(MouseEvent event) {
        clearBtn.setStyle("-fx-background-color: #002070");
    }

    @FXML
    private void changeClearBtnColor(MouseEvent event) {
        clearBtn.setStyle("-fx-background-color: #002aff");
    }
    
}
