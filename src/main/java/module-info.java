module com.example.dmiprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dmiprojekt to javafx.fxml;
    exports com.example.dmiprojekt;
}