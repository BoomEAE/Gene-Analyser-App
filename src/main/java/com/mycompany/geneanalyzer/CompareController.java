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
 * @author ERIC -Yep-
 */
public class CompareController implements Initializable {


    @FXML
    private ComboBox<DNASequence> comboBox1;
    @FXML
    private ComboBox<DNASequence> comboBox2;
    @FXML
    private Label amountALbl1;
    @FXML
    private Label amountADiffLbl;
    @FXML
    private Label amountALbl2;
    @FXML
    private Label amountTLbl1;
    @FXML
    private Label amountTDiffLbl;
    @FXML
    private Label amountTLbl2;
    @FXML
    private Label amountCLbl1;
    @FXML
    private Label amountCDiffLbl;
    @FXML
    private Label amountCLbl2;
    @FXML
    private Label amountGLbl1;
    @FXML
    private Label amountGDiffLbl;
    @FXML
    private Label amountGLbl2;
    @FXML
    private Label amountGCLbl1;
    @FXML
    private Label amountGCDiffLbl;
    @FXML
    private Label amountGCLbl2;
    @FXML
    private Label percentageALbl1;
    @FXML
    private Label percentageADiffLbl;
    @FXML
    private Label percentageALbl2;
    @FXML
    private Label percentageTLbl1;
    @FXML
    private Label percentageTDiffLbl;
    @FXML
    private Label percentageTLbl2;
    @FXML
    private Label percentageCLbl1;
    @FXML
    private Label percentageCDiffLbl;
    @FXML
    private Label percentageCLbl2;
    @FXML
    private Label percentageGLbl1;
    @FXML
    private Label percentageGDiffLbl;
    @FXML
    private Label percentageGLbl2;
    
    private final SequenceCollection sequenceCollection = App.getGlobalSequenceCollection();
    private DNASequence dnaSequence1 = null;
    private DNASequence dnaSequence2 = null;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Add the items to the comboboxes
        updateComboBoxes();
        
        //We update the 1st sequence
        comboBox1.getSelectionModel().selectedItemProperty().addListener((ov, oldSequence, newSequence) -> {
            dnaSequence1 = newSequence;
        });
        
        //We update the 2nd sequence
        comboBox2.getSelectionModel().selectedItemProperty().addListener((ov, oldSequence, newSequence) -> {
            dnaSequence2 = newSequence;
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
    private void switchToResults(ActionEvent event) throws IOException{
        App.setRoot("results");
    }

    @FXML
    private void switchToSettings(ActionEvent event) throws IOException{
        App.setRoot("settings");
    }

    @FXML
    private void setOnCompare(ActionEvent event) {
        
        SequenceComparator sequenceComparator = new SequenceComparator();
        boolean isSequence1Valid = false;
        boolean isSequence2Valid = false;
        
        //Check that both are valid, and not null
        if(dnaSequence1 != null && dnaSequence2 != null){
            isSequence1Valid = (new SequenceValidator()).isValidSequence(dnaSequence1.getRawSequence());
            isSequence2Valid = (new SequenceValidator()).isValidSequence(dnaSequence2.getRawSequence());
        }
        
        //Display the diffrences
        if(isSequence1Valid && isSequence2Valid){
            amountADiffLbl.setText("" + sequenceComparator.getBaseADifference(dnaSequence1, dnaSequence2));
            amountTDiffLbl.setText("" + sequenceComparator.getBaseTDifference(dnaSequence1, dnaSequence2));
            amountCDiffLbl.setText("" + sequenceComparator.getBaseCDifference(dnaSequence1, dnaSequence2));
            amountGDiffLbl.setText("" + sequenceComparator.getBaseGDifference(dnaSequence1, dnaSequence2));
            amountGCDiffLbl.setText("" + sequenceComparator.compare(dnaSequence1, dnaSequence2));
            percentageADiffLbl.setText("" + sequenceComparator.getPercentageADifference(dnaSequence1, dnaSequence2));
            percentageTDiffLbl.setText("" + sequenceComparator.getPercentageTDifference(dnaSequence1, dnaSequence2));
            percentageCDiffLbl.setText("" + sequenceComparator.getPercentageCDifference(dnaSequence1, dnaSequence2));
            percentageGDiffLbl.setText("" + sequenceComparator.getPercentageGDifference(dnaSequence1, dnaSequence2));
        }else{
            amountADiffLbl.setText("N/A");
            amountTDiffLbl.setText("N/A");
            amountCDiffLbl.setText("N/A");
            amountGDiffLbl.setText("N/A");
            amountGCDiffLbl.setText("N/A");
            percentageADiffLbl.setText("N/A");
            percentageTDiffLbl.setText("N/A");
            percentageCDiffLbl.setText("N/A");
            percentageGDiffLbl.setText("N/A");
        }
        
        
        
        
        //Set the data from 1st sequence into their appropriate label
        if(isSequence1Valid){
            NucleotideComposition nucleotideComposition = new NucleotideComposition(dnaSequence1);
            amountALbl1.setText("" + nucleotideComposition.getACount());
            amountTLbl1.setText("" + nucleotideComposition.getTCount());
            amountCLbl1.setText("" + nucleotideComposition.getCCount());
            amountGLbl1.setText("" + nucleotideComposition.getGCount());
            amountGCLbl1.setText("" + ((new SequenceAnalyzer()).analyze(dnaSequence1)).getGcContent());
            percentageALbl1.setText(nucleotideComposition.getAPercentage()+"%");
            percentageTLbl1.setText(nucleotideComposition.getTPercentage()+"%");
            percentageCLbl1.setText(nucleotideComposition.getCPercentage()+"%");
            percentageGLbl1.setText(nucleotideComposition.getGPercentage()+"%");
        }else{
            amountALbl1.setText("N/A");
            amountTLbl1.setText("N/A");
            amountCLbl1.setText("N/A");
            amountGLbl1.setText("N/A");
            amountGCLbl1.setText("N/A");
            percentageALbl1.setText("N/A");
            percentageTLbl1.setText("N/A");
            percentageCLbl1.setText("N/A");
            percentageGLbl1.setText("N/A");
        }
        
        //Set the data from 2nd sequence into their appropriate label
        if(isSequence2Valid){
            NucleotideComposition nucleotideComposition = new NucleotideComposition(dnaSequence2);
            amountALbl2.setText("" + nucleotideComposition.getACount());
            amountTLbl2.setText("" + nucleotideComposition.getTCount());
            amountCLbl2.setText("" + nucleotideComposition.getCCount());
            amountGLbl2.setText("" + nucleotideComposition.getGCount());
            amountGCLbl2.setText("" + ((new SequenceAnalyzer()).analyze(dnaSequence1)).getGcContent());
            percentageALbl2.setText(nucleotideComposition.getAPercentage()+"%");
            percentageTLbl2.setText(nucleotideComposition.getTPercentage()+"%");
            percentageCLbl2.setText(nucleotideComposition.getCPercentage()+"%");
            percentageGLbl2.setText(nucleotideComposition.getGPercentage()+"%");
        }else{
            amountALbl2.setText("N/A");
            amountTLbl2.setText("N/A");
            amountCLbl2.setText("N/A");
            amountGLbl2.setText("N/A");
            amountGCLbl2.setText("N/A");
            percentageALbl2.setText("N/A");
            percentageTLbl2.setText("N/A");
            percentageCLbl2.setText("N/A");
            percentageGLbl2.setText("N/A");
        }
    }
    
    private void updateComboBoxes(){
        //Go through the whole list, and add every single individual sequences to the combobox
        for(DNASequence sequence : sequenceCollection.all()){
            comboBox1.getItems().add(sequence);
            comboBox2.getItems().add(sequence);
        }
    }

}
