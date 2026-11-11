module derick.dnadataclasses {
    requires javafx.controls;
    requires javafx.fxml;

    opens derick.dnadataclasses to javafx.fxml;
    exports derick.dnadataclasses;
}
