package com.example.pratica1225;

import javafx.animation.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.util.*;


public class HelloController{
    private GestoreCsv gestoreCsv;

    @FXML
    private AnchorPane box1,box2,box3;
    @FXML
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;

    public void setGestoreCsv(GestoreCsv gestoreCsv) {
        this.gestoreCsv = gestoreCsv;
    }

    @FXML
    public void initialize() {
        entrataAnchor(box1,-300,0);
        entrataAnchor(box2,-300,0);
        entrataAnchor(box3,1300,900);
        b1.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b2.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b2.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b3.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b3.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b4.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b4.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b10.setOnMouseMoved(event -> b10.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b10.setOnMouseExited(event -> b10.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b11.setOnMouseMoved(event -> b11.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b11.setOnMouseExited(event -> b11.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));

    }

    @FXML
    private void entrataAnchor(AnchorPane anchorPane, int xIn, int xFin) {
        anchorPane.setTranslateX(xIn);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), anchorPane);
        translateTransition.setFromX(xIn);
        translateTransition.setToX(xFin);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }
}