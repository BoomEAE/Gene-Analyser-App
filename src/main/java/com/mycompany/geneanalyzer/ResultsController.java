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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Eric Andre Evsei
 */
public class ResultsController implements Initializable {

    @FXML
    private ComboBox<DNASequence> comboBox;
    @FXML
    private Label amountALbl;
    @FXML
    private Label amountTLbl;
    @FXML
    private Label amountCLbl;
    @FXML
    private Label amountGLbl;
    @FXML
    private Label gcContentLbl;
    @FXML
    private Label percentageALbl;
    @FXML
    private Label percentageTLbl;
    @FXML
    private Label percentageCLbl;
    @FXML
    private Label percentageGLbl;

    private final SequenceCollection sequenceCollection = App.getGlobalSequenceCollection();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Add the items to the combobox
        updateComboBox();
        
        comboBox.getSelectionModel().selectedItemProperty().addListener((ov, oldSequence, newSequence) -> {
            updateDataDisplays(newSequence);
        });
        
    }    

    @FXML
    private void switchToHome(ActionEvent event) throws IOException{
        App.setRoot("home");
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
    private void switchToCompare(ActionEvent event) throws IOException{
        App.setRoot("compare");
    }

    @FXML
    private void switchToSettings(ActionEvent event) throws IOException{
        App.setRoot("settings");
    }    
    
    private void updateComboBox(){
        //Go through the whole list, and add every single individual sequences to the combobox
        for(DNASequence sequence : sequenceCollection.all()){
            comboBox.getItems().add(sequence);
        }
    }
    
    private void updateDataDisplays(DNASequence rawSequence){
        SequenceValidator sequenceValidator = new SequenceValidator();
        boolean isSequenceValid = false;
        
        //Check if the sequence is indeed valid
        if(rawSequence != null){
            isSequenceValid = sequenceValidator.isValidSequence(rawSequence.getRawSequence());
        }
        
        //Set data if the sequence is a valid DNA sequence
        if(isSequenceValid){
            SequenceAnalyzer sequenceAnalyzer = new SequenceAnalyzer();
            AnalysisResult analysisResult = sequenceAnalyzer.analyze(rawSequence);
            amountALbl.setText("" + analysisResult.getNucleotideComposition().getACount());
            amountTLbl.setText("" + analysisResult.getNucleotideComposition().getTCount());
            amountCLbl.setText("" + analysisResult.getNucleotideComposition().getCCount());
            amountGLbl.setText("" + analysisResult.getNucleotideComposition().getGCount());
            gcContentLbl.setText("" + analysisResult.getGcContent());
            percentageALbl.setText("" + analysisResult.getNucleotideComposition().getAPercentage());
            percentageTLbl.setText("" + analysisResult.getNucleotideComposition().getTPercentage());
            percentageCLbl.setText("" + analysisResult.getNucleotideComposition().getCPercentage());
            percentageGLbl.setText("" + analysisResult.getNucleotideComposition().getGPercentage());
        }else{
            amountALbl.setText("N/A");
            amountTLbl.setText("N/A");
            amountCLbl.setText("N/A");
            amountGLbl.setText("N/A");
            gcContentLbl.setText("N/A");
            percentageALbl.setText("N/A");
            percentageTLbl.setText("N/A");
            percentageCLbl.setText("N/A");
            percentageGLbl.setText("N/A");
        }
        
        
    }
}
