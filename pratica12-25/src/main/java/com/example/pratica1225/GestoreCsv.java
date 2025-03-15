package com.example.pratica1225;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GestoreCsv {
    private File fileAnalizzare;

    public GestoreCsv(File fileAnalizzare){
        this.fileAnalizzare=fileAnalizzare;
    }

    //Aggiungere, in coda ad ogni record, un campo chiamato "miovalore", contenente un numero casuale compreso tra 10<=X<=20 ed un campo per marcare la cancellazione logica;
    public void aggiungiCampi() throws RuntimeException{
        try {
            BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare));
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
                for (String campo: recordControllo) {//Intestazione
                    writerNuovo.print(campo);
                    if (!campo.equalsIgnoreCase(recordControllo[recordControllo.length-1]))
                        writerNuovo.print(";");
                }
                writerNuovo.println();
                String next; //Dati
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

    //contare il numero dei campi che compongono il record.
    public int contaCampi() throws RuntimeException{
        try {
            BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare));
            String [] recordControllo=reader.readLine().split(";");
            return recordControllo.length;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //calcolare la lunghezza massima dei record presenti (avanzato: indicando anche la lunghezza massima di ogni campo);
    public int maxRecord() throws RuntimeException{
        try {
            BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare));
            int maxRecord=0;
            String [] recordControllo=reader.readLine().split(";"); //Elimino l'intestazione dal conteggio e conto il numero di campi
            String next;
            while ((next = reader.readLine()) != null){
                if (next.length()>maxRecord)
                    maxRecord=next.length();
            }
            return maxRecord;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int lunghezzaMaxCampo(int numCampo) throws ArrayIndexOutOfBoundsException{
        try {
            BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare));
            int maxCampo=0;
            String [] recordControllo=reader.readLine().split(";"); //Elimino l'intestazione dal conteggio e conto il numero di campi
            if (recordControllo.length<numCampo || numCampo<0)
                throw new ArrayIndexOutOfBoundsException("Campo non trovabile");
            else{
                String next;
                while ((next = reader.readLine()) != null){
                    String [] recordAttuale=next.split(";");
                    if (maxCampo<recordAttuale[numCampo].length())
                        maxCampo=recordAttuale[numCampo].length();
                }
                return maxCampo;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //inserire in ogni record un numero di spazi necessari a rendere fissa la dimensione di tutti i record, senza perdere informazioni.
    public void spaziamentoFisso() throws RuntimeException{
        try {
            BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare));
            String [] recordControllo=reader.readLine().split(";");
            //Creo il nuovo file di appoggio
            File nuovoFile = new File("src/main/java/com/example/pratica1225/dati/dortenzio1.csv");
            File vecchioFile = this.fileAnalizzare;
            nuovoFile.createNewFile();
            PrintWriter writerNuovo = new PrintWriter(new FileWriter(nuovoFile));

            //Cerco dimensione max per ogni campo
            int [] dimMaxCampi=new int[recordControllo.length];
            for (int i=0;i< dimMaxCampi.length;i++){
                dimMaxCampi[i]=lunghezzaMaxCampo(i);
            }

            //Leggo e stampo in nuovo file
            String next;
            while ((next = reader.readLine()) != null){
                String [] recordAttuale=next.split(";");
                for (int i=0;i<recordAttuale.length;i++){
                    if (recordAttuale[i].length()<dimMaxCampi[i]){
                        for (int p=0;p<(dimMaxCampi[i]-recordAttuale[i].length());p++){
                            recordAttuale[i]=recordAttuale[i]+" ";
                        }
                    }
                    writerNuovo.print(recordAttuale[i]);
                    if (i<recordAttuale.length-1)
                        writerNuovo.print(";");
                }
            }
            writerNuovo.flush();
            writerNuovo.close();

            //Rinominare il nuovo file dopo cancellare il vecchio
            vecchioFile.delete();
            nuovoFile.renameTo(new File("src/main/java/com/example/pratica1225/dati/dortenzio.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Aggiungere un record in coda;
    public void aggiungiRecord (Record record) throws RuntimeException{
        try {
            BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare));
            String [] recordControllo=reader.readLine().split(";");
            if (recordControllo.length>10 && record instanceof RecordAggiunte)
                throw new RuntimeException("Record inserito non corretto");
            else {
                PrintWriter writerNuovo = new PrintWriter(new FileWriter("src/main/java/com/example/pratica1225/dati/dortenzio.csv", true));
                writerNuovo.println(record.toString());
                writerNuovo.flush();
                writerNuovo.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Visualizzare dei dati mostrando tre campi significativi a scelta;
    public String filtraCampi(int campo1, int campo2, int capo3){
        //TODO: COMPLETARE ED AGGIUNGERE ALTRI DUE METODI OLTRE CHE UNA LOGICA DI TEST ALMENO TESTUALE
        return null;
    }
}
