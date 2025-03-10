module com.example.pratica1225 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pratica1225 to javafx.fxml;
    exports com.example.pratica1225;
}