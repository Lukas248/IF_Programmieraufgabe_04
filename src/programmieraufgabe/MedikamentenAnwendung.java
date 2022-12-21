package programmieraufgabe;

import java.io.*;
import java.util.Scanner;

public class MedikamentenAnwendung {
  
    Medikamente medikament;
    File verzeichnis;

    public void anlegen(String name, String kategorie, double preis, int anzahl) {

        medikament = new Medikamente(name, kategorie, preis, anzahl);

        FileWriter eingabe;
        verzeichnis = new File("dateien/medikamente.txt");


        try {

            eingabe = new FileWriter(verzeichnis, true);
            eingabe.write("Id: "+ medikament.getId() + " ");
            eingabe.write("Name: " + medikament.getName()  + " ");
            eingabe.write("Kategorie: " + medikament.getKategorie()  + " ");
            eingabe.write("Preis: " + medikament.getPreis() + " € ");
            eingabe.write("Anzahl: " + medikament.getAnzahl() + " Stück \n");
            eingabe.flush();
            eingabe.close();

        }
        catch(IOException e) {



        }

    }

    public void suchen(String id) {

        if(verzeichnis.isDirectory()) {

            File[] dateien = verzeichnis.listFiles();

            for (File datei : dateien) {
            
                try {
                    Scanner dateiScanner = new Scanner(datei);
                    while (dateiScanner.hasNextLine()) {
                    String zeile = dateiScanner.nextLine();
                        if (zeile.contains(id)) {
                            System.out.println("Datei gefunden: " + datei.getName());
                            break;
                        }
                    }
                dateiScanner.close();

                } catch (FileNotFoundException e) {
                    System.out.println("Die Datei konnte nicht gefunden werden.");
                }
            }
      }

    else {

      System.out.println("Der angegebene Pfad ist kein Verzeichnis.");

    }

        

    }




}

