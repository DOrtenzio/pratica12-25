package com.example.pratica1225;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GestoreCsv {
    private ArrayList<Record> records;
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

    public void aggiungiCampi() throws RuntimeException{
        try {
            String [] recordControllo=reader.readLine().split(";");
            if (recordControllo.length>10)
                throw new RuntimeException("Dati già elaborati");
            else {
                //Creo il nuovo file di appoggio
                File nuovoFile = new File("src/main/java/com/example/pratica1225/dati/dortenzio1.csv");
                File vecchioFile = this.fileAnalizzare;
                nuovoFile.createNewFile();
                PrintWriter writerNuovo = new PrintWriter(new FileWriter(nuovoFile));

                //Leggo e stampo in nuovo file
                String next;
                while ((next = reader.readLine()) != null)
                    writerNuovo.println(next + ";" + (new Random().nextInt(11) + 10) + ";" + true);
                writerNuovo.flush();
                writerNuovo.close();

                //Rinominare il nuovo file dopo cancellare il vecchio
                vecchioFile.delete();
                nuovoFile.renameTo(new File("src/main/java/com/example/pratica1225/dati/dortenzio.csv"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
