module com.mycompany.geneanalyzer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.geneanalyzer to javafx.fxml;
    exports com.mycompany.geneanalyzer;
}
