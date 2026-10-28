/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.geneanalyzer;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ERIC -Yep-
 */
public class AnalyzeController implements Initializable {


    @FXML
    private TextField sequenceField;
    @FXML
    private TextField idField;
    @FXML
    private ComboBox<SequenceCollection.Format> fileFormatSlector;
    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    private SequenceCollection.Format fileFormatSelected;
    private final SequenceReader reader = new SequenceReader();
    private List<DNASequence> cleanSequence;

    /**

     * Initializes the controller class.

     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Add all possible file formats to the comboBox
        fileFormatSlector.getItems().addAll(SequenceCollection.Format.values());
        
        //Listen for any changes in regards to the comboBox and store the new file format selected by the user
        fileFormatSlector.valueProperty().addListener((ov, oldFormat, newFormat) -> {fileFormatSelected = newFormat;});
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
    
    @FXML
    private void saveSequence(ActionEvent event) {
        
        try{
            //Make sure that the user typed a sequence and selected a format
            if(sequenceField.getText() != null && fileFormatSelected != null){
                //Get the raw sequence and parse it
                cleanSequence = reader.read(sequenceField.getText());
               
                //If the user inputed a specific id then set it as that
                if(idField.getText() != null){cleanSequence.get(0).setId(idField.getText());}

                //So we can write the sequence with its extension as well
                SequenceWriter writer = fileFormatSelected.writer();
                String fileExtension = writer.extension();

                //Setup FileChooser so that the user can name it, and save the file where they want to save it
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save DNA Sequence");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(fileFormatSelected.name() + " File(*." + fileExtension + ")", "*." + fileExtension));

                //Get the file location
                File file = fileChooser.showSaveDialog(saveBtn.getScene().getWindow());

                //If the location as been selected (just in case they decide to click cancel)
                //we write the file with its content at the chosen location
                if(file != null){
                    String fileContent = writer.writeAll(cleanSequence);
                    Files.writeString(file.toPath(), fileContent);
                }
            }
        }catch(Exception e){e.printStackTrace();}
    }
    
    @FXML
    private void clearField(ActionEvent event){
        sequenceField.clear();
        idField.clear();
        fileFormatSlector.setValue(null);
    }
}
