# Worttrainer - Java Anwendung

## Übersicht

**Worttrainer** ist eine Java-Anwendung, die es Nutzern ermöglicht, ihre Vokabelkenntnisse zu verbessern, indem sie das Wort identifizieren, das einem Bild zugeordnet ist. Die Anwendung präsentiert ein Bild, und der Nutzer muss das richtige Wort eingeben, das zu diesem Bild passt. Die Anwendung verfolgt die Anzahl der richtigen und falschen Eingaben und speichert den Spielstand.

## Funktionen
- **Benutzeroberfläche**: Grafische Benutzeroberfläche (GUI) mit Bildanzeige und Texteingabe.
- **Wörter überprüfen**: Vergleich der Nutzereingaben mit den richtigen Wörtern.
- **Statistiken**: Verfolgung der Anzahl der Versuche und richtigen Eingaben.
- **Speichern und Laden**: Speichern und Laden des aktuellen Spielstands.



### Hauptklassen

1. **Controller**
    - Verwaltet die Interaktion zwischen Benutzeroberfläche und Modell.
    - Reagiert auf Benutzeraktionen (z. B. Eingabe von Wörtern, Speichern/Laden).

2. **WordTrainer**
    - Enthält die Spiel-Logik und das Vokabular (Wörter und Bilder).
    - Verfolgt die Anzahl der richtigen und falschen Versuche.
    - Ermöglicht das Speichern und Laden des Spielstands.

3. **WordImage**
    - Stellt ein Paar von Wort und zugehörigem Bild dar.

4. **Panel**
    - Verwaltet die Benutzeroberfläche.
    - Zeigt das Bild und die Eingabefelder an.
    - Zeigt die Statistiken (richtige und gesamte Versuche) an.

5. **Frame**
    - Erstellt das Hauptfenster der Anwendung.

## Installation und Ausführung

### Voraussetzungen
- Java Development Kit (JDK) 8 oder höher
- Gradle

### Schritte zur Ausführung

1. **Projekt klonen**:
   ```bash
   git clone https://github.com/TGM-HIT/sew9-2425-worttrainer-tenziTGM.git
   cd WortTrainer  

2. **Projekt kompilieren**
    ```bash
   javac -cp . Controller.java
   
3. **JSON Datei platzieren**
    ```JSON
   {
    "wordList": [
    {
    "word": "Hund",
    "wordUrl": "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg"
    },
    {
    "word": "Katze",
    "wordUrl": "https://www.alleycat.org/wp-content/uploads/2019/03/FELV-cat.jpg"
    },
    {
    "word": "Hai",
    "wordUrl": "https://www.wwf-junior.de/fileadmin/user_upload/Tiere/1440_WW1127425_Weisser_Hai__c__Mark_Carwardine_natureplcom.jpg"
    },
    }

        
   
## Erweiterung
Das Laden von Spielständen aus anderen Speicherformaten (z.B. XML) kann einfach erweitert werden. Dazu muss nur eine weitere Klasse, die das Interface PersistenceStrategy-Interface implementiert hinzugefügt werden und die entsprechende Funktionalität implementiert werden.

## Autor
- **Name:** Timo Enzi
- **Klasse:** 5AHIT
- **Datum:** 26.09.2024

