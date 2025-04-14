package com.example.pratica1225;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Random;

public class GestoreCsv {
    private File fileAnalizzare;

    public GestoreCsv(File fileAnalizzare){
        this.fileAnalizzare=fileAnalizzare;
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
        //Creo il nuovo file di appoggio
        File vecchioFile = this.fileAnalizzare;
        File nuovoFile = new File("pratica12-25/src/main/resources/com/example/pratica1225/dati/dortenzio1.csv");

        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            if (controllaIncrementoCampi())
                throw new RuntimeException("Dati già elaborati");
            else {
                PrintWriter writerNuovo = new PrintWriter(new FileWriter(nuovoFile));

                //Leggo e stampo in nuovo file
                boolean isIntestazione=true;
                String next; //Dati e intestazione
                while ((next = reader.readLine()) != null) {
                    if (isIntestazione){
                        writerNuovo.println(next + "; " +"mio_parametro; " + "cancellazione_logica");
                        isIntestazione= false;
                    }else
                     writerNuovo.println(next + ";" + (new Random().nextInt(11) + 10) + ";" + true);
                }
                writerNuovo.flush();
                writerNuovo.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Sostituisce il file originale con il nuovo
        if (!vecchioFile.delete()) {
            throw new RuntimeException("Errore nella cancellazione del file originale");
        }
        if (!nuovoFile.renameTo(vecchioFile)) {
            throw new RuntimeException("Errore nel rinominare il nuovo file come quello originale");
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
    public void spaziamentoFisso() throws RuntimeException {
        File vecchioFile = this.fileAnalizzare;
        File nuovoFile = new File("pratica12-25/src/main/resources/com/example/pratica1225/dati/dortenzio1_temp.csv");
        int[] dimMaxCampi;

        try (BufferedReader reader = new BufferedReader(new FileReader(vecchioFile))) {
            String primaRiga = reader.readLine();
            if (primaRiga == null) return; // File vuoto, niente da fare
            String[] recordControllo = primaRiga.split(";");

            // Determina la lunghezza massima per ogni campo
            dimMaxCampi = new int[recordControllo.length];
            for (int i = 0; i < dimMaxCampi.length; i++) {
                dimMaxCampi[i] = lunghezzaMaxCampo(i);
            }
        } catch (IOException e) {
            throw new RuntimeException("Errore nella lettura del file originale", e);
        }

        // Ora leggiamo e scriviamo in un nuovo file
        try (BufferedReader reader = new BufferedReader(new FileReader(vecchioFile));
             PrintWriter writerNuovo = new PrintWriter(new FileWriter(nuovoFile))) {

            String next;
            while ((next = reader.readLine()) != null) {
                String[] recordAttuale = next.split(";");
                for (int i = 0; i < recordAttuale.length; i++) {
                    String campo = recordAttuale[i];

                    // Aggiungo spazi fino a raggiungere la dimensione massima
                    while (campo.length() < dimMaxCampi[i]) {
                        campo += " ";
                    }

                    writerNuovo.print(campo);
                    if (i < recordAttuale.length - 1) //No ; alla fine
                        writerNuovo.print(";");
                }
                writerNuovo.println();
            }

        } catch (IOException e) {
            throw new RuntimeException("Errore durante la scrittura del nuovo file", e);
        }

        // Sostituisce il file originale con il nuovo
        if (!vecchioFile.delete()) {
            throw new RuntimeException("Errore nella cancellazione del file originale");
        }
        if (!nuovoFile.renameTo(vecchioFile)) {
            throw new RuntimeException("Errore nel rinominare il nuovo file come quello originale");
        }
    }


    //Aggiungere un record in coda;
    public void aggiungiRecord (Record record) throws RuntimeException{
        try (PrintWriter writerNuovo = new PrintWriter(new FileWriter(this.fileAnalizzare, true))){
            if (controllaIncrementoCampi() && !(record instanceof RecordAggiunte))
                throw new RuntimeException("Record inserito non corretto");
            else {
                writerNuovo.println(record.toString());
                writerNuovo.flush();
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
                datiDaMostrare+=datiDaMostrare+recordControllo[campo1]+";"+recordControllo[campo2]+";"+recordControllo[campo3];
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
                if (recordAttuale[2].trim().equalsIgnoreCase(nomeItalianoRifugio.trim()))
                    return numeroRecord;
            }
            return -1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Modifica di un record
    public boolean modificaRecord(Record recordVecchio, Record recordNuovo) throws RuntimeException{
        //Creo il nuovo file di appoggio
        File vecchioFile = this.fileAnalizzare;
        File nuovoFile = new File("pratica12-25/src/main/resources/com/example/pratica1225/dati/dortenzio1.csv");

        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            if (controllaIncrementoCampi() && !(recordNuovo instanceof RecordAggiunte)  && !(recordVecchio instanceof RecordAggiunte) )
                throw new RuntimeException("Record inseriti non corretti in relazione al csv");
            else {
                int pos=cercaRecord(recordVecchio.getNomeItaliano());
                if (pos==-1) {
                    throw new RuntimeException("Record non trovato");
                }  else{
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
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Sostituisce il file originale con il nuovo
        if (!vecchioFile.delete()) {
            throw new RuntimeException("Errore nella cancellazione del file originale");
        }
        if (!nuovoFile.renameTo(vecchioFile)) {
            throw new RuntimeException("Errore nel rinominare il nuovo file come quello originale");
        }
        return true;
    }

    //Cancella logicamente
    public boolean cancellaRecord(String recordDaCancellare) throws RuntimeException{
        //Creo il nuovo file di appoggio
        File vecchioFile = this.fileAnalizzare;
        File nuovoFile = new File("pratica12-25/src/main/resources/com/example/pratica1225/dati/dortenzio1.csv");
        try (BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare))){
            if (!controllaIncrementoCampi())
                throw new RuntimeException("Cancellazione impossibile, ricordarsi di inserire i nuovi campi.");
            else {
                int pos=cercaRecord(recordDaCancellare);
                if (pos==-1) {
                    throw new RuntimeException("Record non trovato");
                }  else{
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
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Sostituisce il file originale con il nuovo
        if (!vecchioFile.delete()) {
            throw new RuntimeException("Errore nella cancellazione del file originale");
        }
        if (!nuovoFile.renameTo(vecchioFile)) {
            throw new RuntimeException("Errore nel rinominare il nuovo file come quello originale");
        }
        return true;
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
                        if (Boolean.parseBoolean(recordAttuale[recordAttuale.length-1].trim()))
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

    //Crea html che visualizzi il file
    public void creahtml(){
        try(BufferedReader reader=new BufferedReader(new FileReader(this.fileAnalizzare)); PrintWriter writer=new PrintWriter(new FileWriter("pratica12-25/src/main/resources/com/example/pratica1225/dati/index.html",false))){
            writer.print("<!DOCTYPE html>\n<html lang=\"it\">\n<head>\n<title>CSV VISUALIZZATO</title>\n" +
                    "<style>\n" +
                    "body {\n" +
                    "    font-family: Arial, sans-serif;\n" +
                    "    background-color: #f4f4f4;\n" +
                    "    justify-content: center;\n" +
                    "}\n" +
                    "</style>\n" +
                    "</head>\n<body>\n<h1>Tabella dei valori contenuti</h1>\n<h6>A seguire si ritrova il contenuto del file csv.</h6>\n");
            writer.print("<table>\n<tr>\n");
            //Intestazione
            String intestazione=reader.readLine();
            for (String campoIntestazione : intestazione.split(";")) writer.println("<th>"+campoIntestazione.trim()+"</th>");
            writer.println("</tr>");
            //Corpo
            String next;
            while ((next= reader.readLine())!=null) {
                writer.println("<tr>");
                for (String campoCorpo : next.split(";")) writer.println("<td>"+campoCorpo.trim()+"</td>");
                writer.println("</tr>");
            }
            writer.println("</table>\n</body>\n</html>");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}