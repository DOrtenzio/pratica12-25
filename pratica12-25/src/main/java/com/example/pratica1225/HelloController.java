package com.example.pratica1225;

import javafx.animation.*;
import javafx.fxml.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.util.*;

import java.util.concurrent.TimeUnit;


public class HelloController{
    private GestoreCsv gestoreCsv;

    @FXML
    private AnchorPane box1,box2,box3,infoAnch;
    @FXML
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    @FXML
    private Label prefLabel,infoLab;
    @FXML
    private VBox listVBox,prefVBox;

    public void setGestoreCsv(GestoreCsv gestoreCsv) {
        this.gestoreCsv = gestoreCsv;
    }

    @FXML
    public void initialize() {
        prefLabel.setText("BENVENUTO/A!");
        addNewRecordList("LISTA DEI METODI GIA' ATTUATI: ");
        entrataAnchor(box1,-300,0);
        entrataAnchor(box2,-300,0);
        entrataAnchor(box3,1300,900);
        b1.setOnMouseMoved(event -> b1.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b1.setOnMouseExited(event -> b1.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b2.setOnMouseMoved(event -> b2.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b2.setOnMouseExited(event -> b2.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b3.setOnMouseMoved(event -> b3.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b3.setOnMouseExited(event -> b3.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b4.setOnMouseMoved(event -> b4.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b4.setOnMouseExited(event -> b4.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b5.setOnMouseMoved(event -> b5.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b5.setOnMouseExited(event -> b5.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b6.setOnMouseMoved(event -> b6.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b6.setOnMouseExited(event -> b6.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b7.setOnMouseMoved(event -> b7.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b7.setOnMouseExited(event -> b7.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b8.setOnMouseMoved(event -> b8.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b8.setOnMouseExited(event -> b8.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b9.setOnMouseMoved(event -> b9.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b9.setOnMouseExited(event -> b9.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b10.setOnMouseMoved(event -> b10.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b10.setOnMouseExited(event -> b10.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b11.setOnMouseMoved(event -> b11.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b11.setOnMouseExited(event -> b11.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
    }

    //METODI
    @FXML
    public void addCampi(){
        try {
            prefVBox.getChildren().clear();
            gestoreCsv.aggiungiCampi();
            prefLabel.setText("Campi aggiunti con successo");
            addNewRecordList("Aggiunta campi");
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        }
    }

    @FXML
    public void contaCampi(){
        try {
            prefVBox.getChildren().clear();
            int temp=gestoreCsv.contaCampi();
            prefLabel.setText("Campi presenti per record : "+temp);
            addNewRecordList("Conta campi");
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        }
    }

    @FXML
    public void maxRecord(){
        try {
            int temp=gestoreCsv.maxRecord();
            prefLabel.setText("Lunghezza massima di un record : "+temp);
            addNewRecordList("Max record");
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        }
    }

    @FXML
    public void maxCampo(){
        try {
            //Creazione di richiesta in input
            prefVBox.getChildren().clear();
            prefVBox.getChildren().add(creaLabel("Inserire il numero del campo: "));
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            TextField t1=creatextField();
            prefVBox.getChildren().add(t1);
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            Button b=creaButton();
            b.setOnMouseClicked(e->{
                //Esecuzione
                prefLabel.setText("Lunghezza massima di un campo : "+gestoreCsv.lunghezzaMaxCampo(Integer.parseInt(t1.getText())));
                addNewRecordList("Max campo");
                prefVBox.getChildren().clear();
            });
            prefVBox.getChildren().add(b);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e){
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void filtraCampi(){
        try {
            //Creazione di richiesta in input
            prefLabel.setText("Filtraggio: ");
            prefVBox.getChildren().clear();
            prefVBox.getChildren().add(creaLabel("Inserire il numero del campo 1: "));
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            TextField t1=creatextField();
            prefVBox.getChildren().add(t1);
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            prefVBox.getChildren().add(creaLabel("Inserire il numero del campo 2: "));
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            TextField t2=creatextField();
            prefVBox.getChildren().add(t2);
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            prefVBox.getChildren().add(creaLabel("Inserire il numero del campo 3: "));
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            TextField t3=creatextField();
            prefVBox.getChildren().add(t3);
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            Button b=creaButton();
            b.setOnMouseClicked(e->{
                //Esecuzione
                prefVBox.getChildren().clear();
                prefVBox.getChildren().add(creaLabel(gestoreCsv.filtraCampi(Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText()))));
                addNewRecordList("Filtra");
            });
            prefVBox.getChildren().add(b);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e){
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void cerca(){
        try {
            //Creazione di richiesta in input
            prefLabel.setText("Ricerca : ");
            prefVBox.getChildren().clear();
            prefVBox.getChildren().add(creaLabel("Inserire il nome italiano del rifugio: "));
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            TextField t1=creatextField();
            prefVBox.getChildren().add(t1);
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            Button b=creaButton();
            b.setOnMouseClicked(e->{
                //Esecuzione
                addNewRecordList("Cerca");
                prefVBox.getChildren().clear();
                int posizione = gestoreCsv.cercaRecord(t1.getText().trim());
                if (posizione != -1)
                    prefVBox.getChildren().add(creaLabel("Record presente alla riga: "+posizione));
                else
                    prefVBox.getChildren().add(creaLabel("Record non presente"));
            });
            prefVBox.getChildren().add(b);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e){
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        }
    }
    @FXML
    public void cancella(){
        try {
            //Creazione di richiesta in input
            prefLabel.setText("Cancella : ");
            prefVBox.getChildren().clear();
            prefVBox.getChildren().add(creaLabel("Inserire il nome italiano del rifugio: "));
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            TextField t1=creatextField();
            prefVBox.getChildren().add(t1);
            prefVBox.getChildren().add(creaPaneSpaziatrice());
            Button b=creaButton();
            b.setOnMouseClicked(e->{
                //Esecuzione
                addNewRecordList("Cancella");
                prefVBox.getChildren().clear();
                if (gestoreCsv.cancellaRecord(t1.getText().trim()))
                    prefVBox.getChildren().add(creaLabel("Cancellato!"));
                else
                    errorHelp("Errore di cancellazione");
            });
            prefVBox.getChildren().add(b);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e){
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void vedi(){
        try {
            prefLabel.setText("Vedi tutti i campi : ");
            prefVBox.getChildren().clear();
            prefVBox.getChildren().add(creaLabel(gestoreCsv.vediCampi()));
            addNewRecordList("Vedi campi");
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        }
    }

    @FXML
    public void spaziamento(){
        try {
            prefVBox.getChildren().clear();
            gestoreCsv.spaziamentoFisso();
            prefLabel.setText("Campi spaziati con successo");
            addNewRecordList("Spazia campi");
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        }
    }

    //UTILITA'
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

    @FXML
    private void errorHelp(String err){
        infoLab.setText(err);
        infoAnch.setVisible(true);
        entrataAnchor(infoAnch,1300,900);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            entrataAnchor(infoAnch,900,1300);
            infoAnch.setVisible(false);
        }
    }

    @FXML
    private void addNewRecordList(String msg){
        Label label = new Label(msg);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setPrefSize(317.0, 16.0);
        label.setWrapText(true);
        label.setFont(new Font("Tw Cen MT Condensed Extra Bold", 12.0));
        listVBox.getChildren().add(label);
    }

    private Label creaLabel(String msg){
        Label label = new Label(msg);
        label.setAlignment(Pos.TOP_LEFT);
        label.setPrefSize(422, 17.0);
        label.setWrapText(true);
        label.setFont(new Font("Tw Cen MT Condensed Extra Bold", 12.0));
        return label;
    }

    public static Button creaButton() {
        Button button = new Button("Aggiungi campi");
        button.setId("b1");
        button.setPrefSize(103.0, 25.0);
        button.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;");
        button.setFont(new Font("Tw Cen MT Condensed Extra Bold", 13.0));

        return button;
    }

    public static TextField creatextField() {
        TextField textField = new TextField();
        textField.setStyle("-fx-background-color: e6ccb2; -fx-border-color: #b59f8a;");

        return textField;
    }

    public static Pane creaPaneSpaziatrice() {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: e6ccb2;");
        pane.setPrefHeight(25.0);

        return pane;
    }
}