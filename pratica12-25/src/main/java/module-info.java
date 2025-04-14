module com.example.pratica1225 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.pratica1225 to javafx.fxml;
    exports com.example.pratica1225;
}