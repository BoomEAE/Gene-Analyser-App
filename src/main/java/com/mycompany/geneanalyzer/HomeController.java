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

/**
 * FXML Controller class
 *
 * @author GeneAnalyzer
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToAnalyze(ActionEvent event) throws IOException{
        App.setRoot("analyze");
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

}
