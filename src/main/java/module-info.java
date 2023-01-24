module com.example.dynamicnodes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dynamicnodes to javafx.fxml;
    exports com.example.dynamicnodes;
}