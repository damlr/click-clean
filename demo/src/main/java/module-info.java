module com.easycleanv3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.easycleanv3 to javafx.fxml;
    exports com.easycleanv3;
}
