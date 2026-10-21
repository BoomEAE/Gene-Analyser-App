module com.mycompany.geneanalyzer {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.geneanalyzer to javafx.fxml;
    exports com.mycompany.geneanalyzer;
}
