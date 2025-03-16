package com.example.pratica1225;

import java.io.*;
import java.util.Random;

public class GestoreCsv {
    private File fileAnalizzare;

    public GestoreCsv(File fileAnalizzare){
        this.fileAnalizzare=fileAnalizzare;
        System.out.println(fileAnalizzare.getPath());
    }

    public boolean controllaIncrementoCampi() throws RuntimeException{
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            String [] recordControllo=reader.readLine().split(";");
            return recordControllo.length>10;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Aggiungere, in coda ad ogni record, un campo chiamato "miovalore", contenente un numero casuale compreso tra 10<=X<=20 ed un campo per marcare la cancellazione logica;
    public void aggiungiCampi() throws RuntimeException{
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            if (controllaIncrementoCampi())
                throw new RuntimeException("Dati già elaborati");
            else {
                //Creo il nuovo file di appoggio
                File nuovoFile = new File("src/main/resources/com/example/pratica1225/dati/dortenzio1.csv");
                File vecchioFile = this.fileAnalizzare;
                nuovoFile.createNewFile();
                PrintWriter writerNuovo = new PrintWriter(new FileWriter(nuovoFile));

                //Leggo e stampo in nuovo file
                boolean isIntestazione=true;
                String next; //Dati ed Intestazione
                while ((next = reader.readLine()) != null) {
                    if (isIntestazione){
                        writerNuovo.println(next + "; " +"mio_parametro; " + "cancellazione_logica");
                        isIntestazione= false;
                    }else
                     writerNuovo.println(next + ";" + (new Random().nextInt(11) + 10) + ";" + true);
                }
                writerNuovo.flush();
                writerNuovo.close();

                //Rinominare il nuovo file dopo cancellare il vecchio
                vecchioFile.delete();
                nuovoFile.renameTo(new File("src/main/resources/com/example/pratica1225/dati/dortenzio.csv"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //contare il numero dei campi che compongono il record.
    public int contaCampi() throws RuntimeException{
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            String [] recordControllo=reader.readLine().split(";");
            return recordControllo.length;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //calcolare la lunghezza massima dei record presenti (avanzato: indicando anche la lunghezza massima di ogni campo);
    public int maxRecord() throws RuntimeException{
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            reader.readLine(); //Elimino l'intestazione dal conteggio

            int maxRecord=0;
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
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
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
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            String [] recordControllo=reader.readLine().split(";");
            //Creo il nuovo file di appoggio
            File nuovoFile = new File("src/main/resources/com/example/pratica1225/dati/dortenzio1.csv");
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
            nuovoFile.renameTo(new File("src/main/resources/com/example/pratica1225/dati/dortenzio.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Aggiungere un record in coda;
    public void aggiungiRecord (Record record) throws RuntimeException{
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            if (controllaIncrementoCampi() && !(record instanceof RecordAggiunte))
                throw new RuntimeException("Record inserito non corretto");
            else {
                PrintWriter writerNuovo = new PrintWriter(new FileWriter(this.fileAnalizzare, true));
                writerNuovo.println(record.toString());
                writerNuovo.flush();
                writerNuovo.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Visualizzare dei dati mostrando tre campi significativi a scelta;
    public String filtraCampi(int campo1, int campo2, int campo3) throws RuntimeException{
        String datiDaMostrare="";
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            String [] recordControllo=reader.readLine().split(";");
            if (campo1 < 0 || campo2 < 0 || campo3 < 0 || campo1 > recordControllo.length-1|| campo2 > recordControllo.length-1 || campo3 > recordControllo.length-1 )
                throw new RuntimeException("Campo non presente");
            else {
               String next;
               while ((next=reader.readLine())!=null){
                   String [] recordAttuale=next.split(";");
                   datiDaMostrare=datiDaMostrare+recordAttuale[campo1]+";"+recordAttuale[campo2]+";"+recordAttuale[campo3]+"\n";
               }
               return datiDaMostrare;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Ricercare un record per campo chiave a scelta (se esiste, utilizzare il campo che contiene dati univoci);
    //Nel nostro caso useremo il campo 3 che rappresenta il nome italiano del rifugio che dovrebbe essere univoco
    public int cercaRecord(String nomeItalianoRifugio) throws RuntimeException{
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            int numeroRecord=-1;
            String next;
            while ((next=reader.readLine())!=null){
                numeroRecord++;
                String [] recordAttuale=next.split(";");
                if (recordAttuale[2].equalsIgnoreCase(nomeItalianoRifugio))
                    return numeroRecord;
            }
            return -1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Modifica di un record
    public boolean modificaRecord(Record recordVecchio, Record recordNuovo) throws RuntimeException{
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            if (controllaIncrementoCampi() && !(recordNuovo instanceof RecordAggiunte)  && !(recordVecchio instanceof RecordAggiunte) )
                throw new RuntimeException("Record inseriti non corretti in relazione al csv");
            else {
                int pos=cercaRecord(recordVecchio.getNomeItaliano());
                if (pos==-1) {
                    throw new RuntimeException("Record non trovato");
                }  else{
                    //Creo il nuovo file di appoggio
                    File nuovoFile = new File("src/main/resources/com/example/pratica1225/dati/dortenzio1.csv");
                    File vecchioFile = this.fileAnalizzare;
                    nuovoFile.createNewFile();
                    PrintWriter writerNuovo = new PrintWriter(new FileWriter(nuovoFile));

                    //Leggo e stampo in nuovo file
                    int recordAnalizzati=-1;
                    String next; //Dati
                    while ((next = reader.readLine()) != null) {
                        if (recordAnalizzati==pos) {
                            writerNuovo.println(recordNuovo.toString());
                        }else{
                            writerNuovo.println(next);
                        }
                        recordAnalizzati++;
                    }
                    writerNuovo.flush();
                    writerNuovo.close();

                    //Rinominare il nuovo file dopo cancellare il vecchio
                    vecchioFile.delete();
                    nuovoFile.renameTo(new File("src/main/resources/com/example/pratica1225/dati/dortenzio.csv"));
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Cancella logicamente
    public boolean cancellaRecord(String recordDaCancellare) throws RuntimeException{
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            if (controllaIncrementoCampi())
                throw new RuntimeException("Cancellazione impossibile, ricordarsi di inserire i nuovi campi.");
            else {
                int pos=cercaRecord(recordDaCancellare);
                if (pos==-1) {
                    throw new RuntimeException("Record non trovato");
                }  else{
                    //Creo il nuovo file di appoggio
                    File nuovoFile = new File("src/main/resources/com/example/pratica1225/dati/dortenzio1.csv");
                    File vecchioFile = this.fileAnalizzare;
                    nuovoFile.createNewFile();
                    PrintWriter writerNuovo = new PrintWriter(new FileWriter(nuovoFile));

                    //Leggo e stampo in nuovo file
                    int recordAnalizzati=-1;
                    String next; //Dati
                    while ((next = reader.readLine()) != null) {
                        if (recordAnalizzati==pos) {
                            String [] record=next.split(";");
                            record[record.length-1]="false";
                            for (String campo : record){
                                if (!campo.equalsIgnoreCase("false"))
                                    writerNuovo.print(campo+";");
                                else
                                    writerNuovo.print(campo);
                            }
                            writerNuovo.println();
                        }else{
                            writerNuovo.println(next);
                        }
                        recordAnalizzati++;
                    }
                    writerNuovo.flush();
                    writerNuovo.close();

                    //Rinominare il nuovo file dopo cancellare il vecchio
                    vecchioFile.delete();
                    nuovoFile.renameTo(new File("src/main/resources/com/example/pratica1225/dati/dortenzio.csv"));
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Visualizza i campi visibili
    public String vediCampi() throws RuntimeException{
        String datiDaMostrare="";
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            if (controllaIncrementoCampi()) { //Controllo logico
                String next;
                boolean isIntestazione=true;
                while ((next=reader.readLine())!=null){
                    if (isIntestazione) {
                        datiDaMostrare = datiDaMostrare + next + "\n";
                        isIntestazione=false;
                    } else {
                        String[] recordAttuale = next.split(";");
                        if (Boolean.parseBoolean(recordAttuale[recordAttuale.length - 1]))
                            datiDaMostrare = datiDaMostrare + next + "\n";
                    }
                }
                return datiDaMostrare;
            } else { //Nessun controllo logico
                String next;
                while ((next=reader.readLine())!=null) datiDaMostrare=datiDaMostrare+next+"\n";
                return datiDaMostrare;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
