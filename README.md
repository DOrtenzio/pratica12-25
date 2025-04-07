# Progetto: Elaborazione Dati CSV con JavaFX

## Indice
1. [Fase di Preparazione](#1-fase-di-preparazione)
2. [Creazione del Progetto](#2-creazione-del-progetto)
3. [Struttura del CSV](#3-struttura-del-csv)
4. [Funzionalità da Implementare](#4-funzionalità-da-implementare)
   - [Aggiunta di Nuovi Campi](#a-aggiunta-di-nuovi-campi)
   - [Conteggio dei Campi](#b-conteggio-dei-campi)
   - [Calcolo della Lunghezza Massima dei Record](#c-calcolo-della-lunghezza-massima-dei-record)
   - [Uniformare la Dimensione dei Record](#d-uniformare-la-dimensione-dei-record)
   - [Aggiunta di un Nuovo Record](#e-aggiunta-di-un-nuovo-record)
   - [Visualizzazione dei Dati](#f-visualizzazione-dei-dati)
   - [Ricerca di un Record](#g-ricerca-di-un-record)
   - [Modifica di un Record](#h-modifica-di-un-record)
   - [Cancellazione Logica di un Record](#i-cancellazione-logica-di-un-record)
5. [Interfaccia Grafica](#5-interfaccia-grafica)
6. [Consegna](#6-consegna)

---

## 1. Fase di Preparazione
- **Collegati al sito**: [http://www.datiopen.it/it/catalogo-opendata/file-csv](http://www.datiopen.it/it/catalogo-opendata/file-csv)
- **Scegli un file CSV**: Aiutati con la ricerca, scaricalo e scegli un file diverso per ogni studente.
- **Indica il titolo nel file allegato**.
- **Rinomina il file**: Modifica il nome del file in `tuocognome.csv`.

## 2. Creazione del Progetto
- **Crea un progetto in JavaFX**.
- **Associa il progetto ad un repository GitHub** e consegna il link.

## 3. Struttura del CSV
Ogni file contiene:
- **Prima riga**: Intestazione del campo.
- **Righe successive**: Record contenenti i dati.

## 4. Funzionalità da Implementare
Implementa le seguenti funzioni ed effettua almeno un **commit/push** per ogni funzionalità descritta:

### a) Aggiunta di Nuovi Campi
- Aggiungi, in coda ad ogni record, un campo chiamato **"miovalore"** contenente un numero casuale compreso tra 10 e 20.
- Aggiungi un campo per marcare la **cancellazione logica** del record.

### b) Conteggio dei Campi
- Conta il numero di campi che compongono ogni record.

### c) Calcolo della Lunghezza Massima dei Record
- Calcola la lunghezza massima dei record presenti.
  - **Avanzato**: Indica anche la lunghezza massima di ogni campo.

### d) Uniformare la Dimensione dei Record
- Inserisci in ogni record il numero di spazi necessari a rendere fissa la dimensione di tutti i record, senza perdere informazioni.

### e) Aggiunta di un Nuovo Record
- Aggiungi un nuovo record in coda.

### f) Visualizzazione dei Dati
- Visualizza tre campi significativi a scelta tra i dati presenti nel file CSV.

### g) Ricerca di un Record
- Ricerca un record per un campo chiave a scelta (se esiste, utilizza il campo che contiene dati univoci).

### h) Modifica di un Record
- Modifica un record esistente.

### i) Cancellazione Logica di un Record
- Esegui una cancellazione logica di un record, utilizzando il campo per marcare la cancellazione.

## 5. Interfaccia Grafica
- Realizza l'interfaccia grafica che consenta l'interazione fluida con le funzionalità descritte.
- **Richiama le funzioni di servizio** dalle funzioni di gestione degli eventi.

---

## 6. Consegna
- Consegna il progetto con il repository GitHub linkato, contenente il codice JavaFX e il file CSV elaborato.
