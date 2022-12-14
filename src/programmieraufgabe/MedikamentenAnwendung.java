package programmieraufgabe;

import java.io.*;

public class MedikamentenAnwendung {
  
    Medikamente medikament;

    public void anlegen(String name, String kategorie, double preis, int anzahl) {

        medikament = new Medikamente(name, kategorie, preis, anzahl);

        try (InputStream eingabe = new FileInputStream(new File("./dateien/medikamente.txt"))) {

            int zeichen;
            while((zeichen = eingabe.read()) != -1) {

                System.out.print(zeichen);

            }

        }
        catch(IOException e) {



        }

    }


}

