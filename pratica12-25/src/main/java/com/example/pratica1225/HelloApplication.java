package com.example.pratica1225;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        HelloController controller=fxmlLoader.getController();
        controller.setGestoreCsv(new GestoreCsv(new File("pratica12-25/src/main/resources/com/example/pratica1225/dati/dortenzio.csv")));

        Scene scene = new Scene(fxmlLoader.load(), 900, 570);
        stage.setTitle("GESTORE CSV");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}