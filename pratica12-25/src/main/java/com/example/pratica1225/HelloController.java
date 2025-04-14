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

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class HelloController{
    private GestoreCsv gestoreCsv;

    @FXML
    private AnchorPane box1,box2,box3,infoAnch;
    @FXML
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    @FXML
    private Label prefLabel,infoLab;
    @FXML
    private VBox listVBox,prefVBox;

    public void setGestoreCsv(GestoreCsv gestoreCsv) {
        this.gestoreCsv = gestoreCsv;
        //Vista di tutti gli elementi (così per bellezza)
        prefVBox.getChildren().clear();
        Label label = new Label(gestoreCsv.vediCampi());
        label.setAlignment(Pos.TOP_LEFT);
        label.setPrefWidth(412.0);
        label.setWrapText(true);
        label.setFont(new Font("Tw Cen MT Condensed Extra Bold", 12.0));
        VBox.setVgrow(label, Priority.ALWAYS);
        prefVBox.getChildren().add(label);
    }

    @FXML
    public void initialize() {
        prefLabel.setText("BENVENUTO/A!");
        addNewRecordList("LISTA DEI METODI GIA' ATTUATI: ");
        entrataAnchor(box1,-300,0);
        entrataAnchor(box2,-300,0);
        entrataAnchor(box3,1300,0);
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
        b12.setOnMouseMoved(event -> b12.setStyle("-fx-border-color: #42f5a7; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
        b12.setOnMouseExited(event -> b12.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;"));
    }

    //METODI
    @FXML
    public void addCampi(){
        try {
            prefVBox.getChildren().clear();
            gestoreCsv.aggiungiCampi();
            prefLabel.setText("Campi aggiunti con successo");
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: e6ccb2;");
            pane.setPrefSize(251,424);
            prefVBox.getChildren().add(pane);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } finally {
            addNewRecordList("Aggiunta campi");
        }
    }

    @FXML
    public void contaCampi(){
        try {
            prefVBox.getChildren().clear();
            int temp=gestoreCsv.contaCampi();
            prefLabel.setText("Campi presenti per record : "+temp);
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: e6ccb2;");
            pane.setPrefSize(251,424);
            prefVBox.getChildren().add(pane);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } finally {
            addNewRecordList("Conta campi");
        }
    }

    @FXML
    public void maxRecord(){
        try {
            int temp=gestoreCsv.maxRecord();
            prefLabel.setText("Lunghezza massima di un record : "+temp);
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: e6ccb2;");
            pane.setPrefSize(251,424);
            prefVBox.getChildren().add(pane);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } finally {
            addNewRecordList("Max record");
        }
    }

    @FXML
    public void maxCampo(){
        try {
            //Creazione di richiesta in input
            prefVBox.getChildren().clear();
            prefVBox.getChildren().add(creaLabel("Inserire il numero del campo: "));
            TextField t1=creatextField();
            prefVBox.getChildren().add(t1);
            Button b=creaButton("Continua");
            b.setOnMouseClicked(e->{
                try {
                    //Esecuzione
                    prefLabel.setText("Lunghezza massima di un campo : "+gestoreCsv.lunghezzaMaxCampo(Integer.parseInt(t1.getText())));
                    prefVBox.getChildren().clear();
                } catch (Exception e1){
                    errorHelp(e1.getMessage());
                }
            });
            prefVBox.getChildren().add(b);
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: e6ccb2;");
            pane.setPrefSize(100,424);
            prefVBox.getChildren().add(pane);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e){
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        } finally {
            addNewRecordList("Max campo");
        }
    }

    @FXML
    public void filtraCampi(){
        try {
            //Creazione di richiesta in input
            prefLabel.setText("Filtraggio: ");
            prefVBox.getChildren().clear();
            prefVBox.getChildren().add(creaLabel("Inserire il numero del campo 1: "));
            TextField t1=creatextField();
            prefVBox.getChildren().add(t1);
            prefVBox.getChildren().add(creaLabel("Inserire il numero del campo 2: "));
            TextField t2=creatextField();
            prefVBox.getChildren().add(t2);
            prefVBox.getChildren().add(creaLabel("Inserire il numero del campo 3: "));
            TextField t3=creatextField();
            prefVBox.getChildren().add(t3);
            Button b=creaButton("Filtra");
            b.setOnMouseClicked(e->{
                try {
                    //Esecuzione
                    prefVBox.getChildren().clear();
                    Label label = new Label(gestoreCsv.filtraCampi(Integer.parseInt(t1.getText()),Integer.parseInt(t2.getText()),Integer.parseInt(t3.getText())));
                    label.setAlignment(Pos.TOP_LEFT);
                    label.setPrefWidth(412.0);
                    label.setWrapText(true);
                    label.setFont(new Font("Tw Cen MT Condensed Extra Bold", 12.0));
                    VBox.setVgrow(label, Priority.ALWAYS);
                    prefVBox.getChildren().add(label);
                } catch (Exception e1){
                    errorHelp(e1.getMessage());
                }
            });
            prefVBox.getChildren().add(b);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e){
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        } finally {
            addNewRecordList("Filtra");
        }
    }

    @FXML
    public void aggiungiRecord() {
        try {
            prefLabel.setText("Inserisci i dettagli del nuovo record:");
            prefVBox.getChildren().clear();

            // Creazione dei campi di input
            TextField comuneField = creatextField();
            TextField provinciaField = creatextField();
            TextField nomeItalianoField = creatextField();
            TextField nomeTedescoField = creatextField();
            TextField proprietaField = creatextField();
            TextField telefonoField = creatextField();
            TextField emailField = creatextField();
            TextField internetField = creatextField();
            TextField gruppoField = creatextField();
            TextField altitudineField = creatextField();

            // Aggiunta delle etichette e campi all'interfaccia
            prefVBox.getChildren().addAll(
                    creaLabel("Comune:"), comuneField,
                    creaLabel("Provincia:"), provinciaField,
                    creaLabel("Nome Italiano:"), nomeItalianoField,
                    creaLabel("Nome Tedesco:"), nomeTedescoField,
                    creaLabel("Proprietà:"), proprietaField,
                    creaLabel("Telefono:"), telefonoField,
                    creaLabel("Email:"), emailField,
                    creaLabel("Internet:"), internetField,
                    creaLabel("Gruppo:"), gruppoField,
                    creaLabel("Altitudine in metri:"), altitudineField
            );

            Button confermaButton = creaButton("Continua");
            confermaButton.setText("Aggiungi Record");
            confermaButton.setOnMouseClicked(e -> {
                try {
                    // Creazione del record
                    String comune = comuneField.getText();
                    String provincia = provinciaField.getText();
                    String nomeItaliano = nomeItalianoField.getText();
                    String nomeTedesco = nomeTedescoField.getText();
                    String proprieta = proprietaField.getText();
                    String telefono = telefonoField.getText();
                    String email = emailField.getText();
                    String internet = internetField.getText();
                    String gruppo = gruppoField.getText();
                    int altitudine = Integer.parseInt(altitudineField.getText());

                    Record nuovoRecord;
                    if (gestoreCsv.controllaIncrementoCampi()) {
                        nuovoRecord = new RecordAggiunte(comune, provincia, nomeItaliano, nomeTedesco, proprieta, telefono, email, internet, gruppo, altitudine);
                    } else {
                        nuovoRecord = new Record(comune, provincia, nomeItaliano, nomeTedesco, proprieta, telefono, email, internet, gruppo, altitudine);
                    }

                    gestoreCsv.aggiungiRecord(nuovoRecord);
                    prefVBox.getChildren().clear();
                    prefVBox.getChildren().add(creaLabel("Record aggiunto con successo."));
                } catch (NumberFormatException ex) {
                    errorHelp("Errore: L'altitudine deve essere un numero intero valido.");
                } catch (Exception ex) {
                    errorHelp(ex.getMessage());
                    System.err.println(ex.getMessage());
                }
            });

            prefVBox.getChildren().add(confermaButton);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e) {
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        } finally {
            addNewRecordList("Aggiungi");
        }
    }

    @FXML
    public void modificaRecord() {
        try {
            prefLabel.setText("Inserisci i dettagli del record da modificare e delle modifiche:");
            prefVBox.getChildren().clear();

            TextField nomeItalianoVecchioField = creatextField();
            prefVBox.getChildren().addAll(
                    creaLabel("Nome Italiano Vecchio:"), nomeItalianoVecchioField,
                    creaLabel("DATI NUOVI |V|")
            );

            TextField comuneField = creatextField();
            TextField provinciaField = creatextField();
            TextField nomeItalianoField = creatextField();
            TextField nomeTedescoField = creatextField();
            TextField proprietaField = creatextField();
            TextField telefonoField = creatextField();
            TextField emailField = creatextField();
            TextField internetField = creatextField();
            TextField gruppoField = creatextField();
            TextField altitudineField = creatextField();

            prefVBox.getChildren().addAll(
                    creaLabel("Comune:"), comuneField,
                    creaLabel("Provincia:"), provinciaField,
                    creaLabel("Nome Italiano:"), nomeItalianoField,
                    creaLabel("Nome Tedesco:"), nomeTedescoField,
                    creaLabel("Proprietà:"), proprietaField,
                    creaLabel("Telefono:"), telefonoField,
                    creaLabel("Email:"), emailField,
                    creaLabel("Internet:"), internetField,
                    creaLabel("Gruppo:"), gruppoField,
                    creaLabel("Altitudine in metri:"), altitudineField
            );

            Button confermaButton = creaButton("Continua");
            confermaButton.setText("Modifica Record");
            confermaButton.setOnMouseClicked(e -> {
                try {
                    Record recordVecchio = new Record("", "", nomeItalianoVecchioField.getText(), "", "", "", "", "", "", 0);

                    String comune = comuneField.getText();
                    String provincia = provinciaField.getText();
                    String nomeItaliano = nomeItalianoField.getText();
                    String nomeTedesco = nomeTedescoField.getText();
                    String proprieta = proprietaField.getText();
                    String telefono = telefonoField.getText();
                    String email = emailField.getText();
                    String internet = internetField.getText();
                    String gruppo = gruppoField.getText();
                    int altitudine = Integer.parseInt(altitudineField.getText());

                    Record nuovoRecord;
                    if (gestoreCsv.controllaIncrementoCampi()) {
                        nuovoRecord = new RecordAggiunte(comune, provincia, nomeItaliano, nomeTedesco, proprieta, telefono, email, internet, gruppo, altitudine);
                    } else {
                        nuovoRecord = new Record(comune, provincia, nomeItaliano, nomeTedesco, proprieta, telefono, email, internet, gruppo, altitudine);
                    }

                    if (gestoreCsv.modificaRecord(recordVecchio, nuovoRecord)) {
                        prefVBox.getChildren().clear();
                        prefVBox.getChildren().add(creaLabel("Record modificato con successo."));
                    } else {
                        prefVBox.getChildren().add(creaLabel("Errore nella modifica."));
                    }
                } catch (NumberFormatException ex) {
                    errorHelp("Errore: L'altitudine deve essere un numero intero valido.");
                } catch (Exception ex) {
                    errorHelp(ex.getMessage());
                    System.err.println(ex.getMessage());
                }
            });

            prefVBox.getChildren().add(confermaButton);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e) {
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        }  finally {
            addNewRecordList("Modifica");
        }
    }


    @FXML
    public void cerca(){
        try {
            //Creazione di richiesta in input
            prefLabel.setText("Ricerca : ");
            prefVBox.getChildren().clear();
            prefVBox.getChildren().add(creaLabel("Inserire il nome italiano del rifugio: "));
            TextField t1=creatextField();
            prefVBox.getChildren().add(t1);
            Button b=creaButton("Cerca");
            b.setOnMouseClicked(e->{
                try {
                    //Esecuzione
                    prefVBox.getChildren().clear();
                    int posizione = gestoreCsv.cercaRecord(t1.getText().trim());
                    if (posizione != -1)
                        prefVBox.getChildren().add(creaLabel("Record presente alla riga: "+posizione));
                    else
                        prefVBox.getChildren().add(creaLabel("Record non presente"));
                }  catch (Exception e1){
                    errorHelp(e1.getMessage());
                }
            });
            prefVBox.getChildren().add(b);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e){
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        }  finally {
            addNewRecordList("Cerca");
        }
    }
    @FXML
    public void cancella(){
        try {
            //Creazione di richiesta in input
            prefLabel.setText("Cancella : ");
            prefVBox.getChildren().clear();
            prefVBox.getChildren().add(creaLabel("Inserire il nome italiano del rifugio: "));
            TextField t1=creatextField();
            prefVBox.getChildren().add(t1);
            Button b=creaButton("Cancella");
            b.setOnMouseClicked(e->{
                try {
                    //Esecuzione
                    prefVBox.getChildren().clear();
                    if (gestoreCsv.cancellaRecord(t1.getText().trim()))
                        prefVBox.getChildren().add(creaLabel("Cancellato!"));
                    else
                        errorHelp("Errore di cancellazione");
                } catch (Exception e1){
                    errorHelp(e1.getMessage());
                }
            });
            prefVBox.getChildren().add(b);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (Exception e){
            errorHelp(e.getMessage());
            System.err.println(e.getMessage());
        } finally {
            addNewRecordList("Cancella");
        }
    }

    @FXML
    public void vedi(){
        try {
            prefLabel.setText("Vedi tutti i campi : ");
            prefVBox.getChildren().clear();

            Label label = new Label(gestoreCsv.vediCampi());
            label.setAlignment(Pos.TOP_LEFT);
            label.setPrefWidth(412.0);
            label.setWrapText(true);
            label.setFont(new Font("Tw Cen MT Condensed Extra Bold", 12.0));
            VBox.setVgrow(label, Priority.ALWAYS);
            prefVBox.getChildren().add(label);
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } finally {
            addNewRecordList("Vedi campi");
        }
    }

    @FXML
    public void spaziamento(){
        try {
            prefVBox.getChildren().clear();
            gestoreCsv.spaziamentoFisso();
            prefLabel.setText("Campi spaziati con successo");
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } finally {
            addNewRecordList("Spazia campi");
        }
    }

    @FXML
    public void creaHTML(){
        try {
            prefVBox.getChildren().clear();
            gestoreCsv.creahtml();
            prefLabel.setText("HTML creato con successo");
            if (Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File("pratica12-25/src/main/resources/com/example/pratica1225/dati/index.html"));
            }
        } catch (RuntimeException e) {
            errorHelp(e.getMessage());
        } catch (IOException e) {
            errorHelp(e.getMessage());
        } finally {
            addNewRecordList("HTML");
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
    private void errorHelp(String err) {
        infoLab.setText(err);
        infoAnch.setVisible(true);
        entrataAnchor(infoAnch, 1300, 0);

        // Crea una animazione per il ritardo di 3 secondi
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            entrataAnchor(infoAnch, 0, 1300);
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(1.5), event1 -> {
                infoAnch.setVisible(false);
            }));
            timeline1.setCycleCount(1);
            timeline1.play();
        }));

        timeline.setCycleCount(1); // Esegui solo una volta
        timeline.play(); // Avvia l'animazione
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

    private Button creaButton(String msg) {
        Button button = new Button(msg);
        button.setId("b1");
        button.setPrefSize(103.0, 25.0);
        button.setStyle("-fx-border-color: #bd8e60; -fx-background-color: e6ccb2; -fx-border-radius: 13 0; -fx-background-radius: 12 0;");
        button.setFont(new Font("Tw Cen MT Condensed Extra Bold", 13.0));

        return button;
    }

    private TextField creatextField() {
        TextField textField = new TextField();
        textField.setStyle("-fx-background-color: e6ccb2; -fx-border-color: #b59f8a;");
        textField.setPrefSize(300.0, 25.0);
        return textField;
    }
}