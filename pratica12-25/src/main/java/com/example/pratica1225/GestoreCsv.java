package com.example.pratica1225;

import java.io.*;

public class GestoreCsv {
    private PrintWriter writer;
    private BufferedReader reader;
    private File fileAnalizzare;

    public GestoreCsv(File fileAnalizzare){
        try {
            this.fileAnalizzare=fileAnalizzare;
            this.writer=new PrintWriter(new FileWriter(this.fileAnalizzare));
            this.reader=new BufferedReader(new FileReader(this.fileAnalizzare));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void aggiungiCampi(){

    }
}
