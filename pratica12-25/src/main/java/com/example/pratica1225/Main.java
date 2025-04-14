package com.example.pratica1225;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GestoreCsv gestore = new GestoreCsv(new File("pratica12-25/src/main/resources/com/example/pratica1225/dati/dortenzio.csv"));
        int scelta=0;

        do {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Aggiungi campi ");
                System.out.println("2. Conta campi");
                System.out.println("3. Lunghezza massima dei record");
                System.out.println("4. Lunghezza massima di un campo");
                System.out.println("5. Aggiungi record");
                System.out.println("6. Visualizza tre campi");
                System.out.println("7. Cerca record");
                System.out.println("8. Modifica record");
                System.out.println("9. Cancella logicamente un record");
                System.out.println("10. Visualizza campi visibili");
                System.out.println("11. Spaziamento fisso");
                System.out.println("12. Crea Html");
                System.out.println("0. Esci");
                System.out.print("Scelta: ");
                scelta =Integer.parseInt(in.nextLine());

                switch (scelta) {
                    case 1:
                        gestore.aggiungiCampi();
                        System.out.println("Campi aggiunti con successo.");
                        break;
                    case 2:
                        System.out.println("Numero di campi: " + gestore.contaCampi());
                        break;
                    case 3:
                        System.out.println("Lunghezza massima di un record: " + gestore.maxRecord());
                        break;
                    case 4:
                        System.out.print("Inserisci numero campo: ");
                        int numCampo = Integer.parseInt(in.nextLine());
                        System.out.println("Lunghezza massima del campo: " + gestore.lunghezzaMaxCampo(numCampo));
                        break;
                    case 5:
                        Record nuovoRecord;
                        System.out.println("Inserisci i dettagli del nuovo record:");
                        System.out.print("Comune: ");
                        String comune = in.nextLine();
                        System.out.print("Provincia: ");
                        String provincia = in.nextLine();
                        System.out.print("Nome Italiano: ");
                        String nomeItaliano = in.nextLine();
                        System.out.print("Nome Tedesco: ");
                        String nomeTedesco = in.nextLine();
                        System.out.print("Proprietà: ");
                        String proprieta = in.nextLine();
                        System.out.print("Telefono: ");
                        String telefono = in.nextLine();
                        System.out.print("Email: ");
                        String email = in.nextLine();
                        System.out.print("Internet: ");
                        String internet = in.nextLine();
                        System.out.print("Gruppo: ");
                        String gruppo = in.nextLine();
                        System.out.print("Altitudine in metri: ");
                        int altitudine = Integer.parseInt(in.nextLine());

                        if (gestore.controllaIncrementoCampi()) //Ci servono 12 campi
                            nuovoRecord = new RecordAggiunte(comune, provincia, nomeItaliano, nomeTedesco, proprieta, telefono, email, internet, gruppo, altitudine);
                        else //Ci servono 10 campi originali
                            nuovoRecord = new Record(comune, provincia, nomeItaliano, nomeTedesco, proprieta, telefono, email, internet, gruppo, altitudine);

                        gestore.aggiungiRecord(nuovoRecord);
                        System.out.println("Record aggiunto con successo.");
                        break;
                    case 6:
                        System.out.print("Inserisci tre campi da visualizzare (indice 0-based): ");
                        int c1 = Integer.parseInt(in.next()), c2 = Integer.parseInt(in.next()), c3 = Integer.parseInt(in.next());
                        System.out.println("Dati filtrati:\n" + gestore.filtraCampi(c1, c2, c3));
                        break;
                    case 7:
                        System.out.print("Inserisci nome italiano del rifugio: ");
                        String nomeRifugio = in.nextLine();
                        int posizione = gestore.cercaRecord(nomeRifugio);
                        if (posizione != -1)
                            System.out.println("Record trovato alla riga: " + posizione);
                        else
                            System.out.println("Record non trovato.");
                        break;
                    case 8:
                        System.out.println("Inserisci i dettagli del record da modificare:");
                        System.out.print("Nome Italiano: ");
                        Record recordVecchio = new Record("", "",  in.nextLine(), "", "", "", "", "", "", 0);

                        System.out.println("Inserisci i nuovi dettagli del record:");
                        Record nuovoRecord1;

                        System.out.println("Inserisci i dettagli del nuovo record:");
                        System.out.print("Comune: ");
                        String comune1 = in.nextLine();
                        System.out.print("Provincia: ");
                        String provincia1 = in.nextLine();
                        System.out.print("Nome Italiano: ");
                        String nomeItaliano1 = in.nextLine();
                        System.out.print("Nome Tedesco: ");
                        String nomeTedesco1 = in.nextLine();
                        System.out.print("Proprietà: ");
                        String proprieta1 = in.nextLine();
                        System.out.print("Telefono: ");
                        String telefono1 = in.nextLine();
                        System.out.print("Email: ");
                        String email1 = in.nextLine();
                        System.out.print("Internet: ");
                        String internet1 = in.nextLine();
                        System.out.print("Gruppo: ");
                        String gruppo1 = in.nextLine();
                        System.out.print("Altitudine in metri: ");
                        int altitudine1 = Integer.parseInt(in.nextLine());

                        if (gestore.controllaIncrementoCampi()) //Ci servono 12 campi
                            nuovoRecord1 = new RecordAggiunte(comune1, provincia1, nomeItaliano1, nomeTedesco1, proprieta1, telefono1, email1, internet1, gruppo1, altitudine1);
                        else //Ci servono 10 campi originali
                            nuovoRecord1 = new Record(comune1, provincia1, nomeItaliano1, nomeTedesco1, proprieta1, telefono1, email1, internet1, gruppo1, altitudine1);
                        if (gestore.modificaRecord(recordVecchio,nuovoRecord1))
                            System.out.println("Record modificato con successo.");
                        else
                            System.out.println("Errore nella modifica.");

                        break;
                    case 9:
                        System.out.print("Inserisci il nome italiano del record da cancellare: ");
                        String recordDaCancellare = in.nextLine();
                        if (gestore.cancellaRecord(recordDaCancellare))
                            System.out.println("Record cancellato logicamente con successo.");
                        else
                            System.out.println("Errore nella cancellazione.");
                        break;
                    case 10:
                        System.out.println("Campi visibili:\n" + gestore.vediCampi());
                        break;
                    case 11:
                        gestore.spaziamentoFisso();
                        System.out.println("Attendi caro");
                        System.out.println("Spaziamento fisso:\n" + gestore.vediCampi());
                        break;
                    case 12:
                        System.out.println("Attendi caro");
                        gestore.creahtml();
                        System.out.println("Fatto");
                        break;
                    case 0:
                        System.out.println("Ciaoooo");
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                }
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        } while (scelta!=0);
        in.close();
    }
}
