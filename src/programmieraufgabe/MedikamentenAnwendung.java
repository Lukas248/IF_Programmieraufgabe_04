package programmieraufgabe;

import java.io.*;

public class MedikamentenAnwendung {
  
    Medikamente medikament;

    public void anlegen(String name, String kategorie, double preis, int anzahl) {

        medikament = new Medikamente(name, kategorie, preis, anzahl);

        FileWriter eingabe;
        File datei = new File("/dateien/medikamente.txt");

        try {

            eingabe = new FileWriter(datei, true);
            eingabe.write("Id: "+ medikament.getId());
            eingabe.write("Name: " + medikament.getName());
            eingabe.write("Kategorie: " + medikament.getKategorie());
            eingabe.write("Preis: " + medikament.getPreis() + " €");
            eingabe.write("Anzahl: " + medikament.getAnzahl() + " Stück");
            eingabe.write(System.getProperty("line.separator"));
            eingabe.flush();
            eingabe.close();

        }
        catch(IOException e) {



        }

    }


}

