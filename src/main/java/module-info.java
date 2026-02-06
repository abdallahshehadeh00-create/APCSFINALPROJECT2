module com.example.csproject2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csproject2 to javafx.fxml;
    exports com.example.csproject2;
}