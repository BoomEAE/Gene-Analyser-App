/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.geneanalyzer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
/**
 * FXML Controller class
 *
 * @author ERIC -Yep-
 */
public class SequencesController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private ListView<DNASequence> listView;
    @FXML
    private Button loadBtn;
    @FXML
    private Button removeBtn;
    
    private final SequenceCollection sequenceCollection = App.getGlobalSequenceCollection();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateListView();
        listView.getSelectionModel().selectedItemProperty().addListener((ov, oldValue, newValue) -> {
            if(newValue != null){
                textArea.setText(newValue.getRawSequence());
            }else{
                textArea.clear();
            }
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
    private void changeLoadBtnColor(MouseEvent event) {
        loadBtn.setStyle("-fx-background-color: #002aff");
    }

    @FXML
    private void changeLoadBtnColorBack(MouseEvent event) {
        loadBtn.setStyle("-fx-background-color: #002070");
    }
    

    @FXML
    private void changeRemoveBtnColor(MouseEvent event) {
        removeBtn.setStyle("-fx-background-color: #002aff");
    }

    @FXML
    private void changeRemoveBtnColorBack(MouseEvent event) {
        removeBtn.setStyle("-fx-background-color: #002070");
    }

    @FXML
    private void loadSequenceFromFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load DNA File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Every supported formats", "*.txt", "*.rna", "*.fasta", "*.fastq", "*.gb"),
                new FileChooser.ExtensionFilter("File(*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("File(*.rna)", "*.rna"),
                new FileChooser.ExtensionFilter("File(*.fasta)", "*.fasta"),
                new FileChooser.ExtensionFilter("File(*.fastq)", "*.fastq"),
                new FileChooser.ExtensionFilter("File(*.gb)", "*.gb")
        );
        
        try{
            File selectedFile = fileChooser.showOpenDialog(loadBtn.getScene().getWindow());
            if(selectedFile != null){
                sequenceCollection.loadFile(selectedFile.toPath());
                updateListView();
            }
        }catch(Exception e){e.printStackTrace();}
    }

    @FXML
    private void removeSequence(ActionEvent event) {
        DNASequence selectedSequence = listView.getSelectionModel().getSelectedItem();
        if(selectedSequence != null){
            sequenceCollection.remove(selectedSequence.getId());
            updateListView();
        }
    }

    private void updateListView(){
        listView.getItems().setAll(sequenceCollection.all());
    }
}
