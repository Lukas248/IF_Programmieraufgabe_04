package programmieraufgabe;

import java.io.*;
import java.util.ArrayList;

public class MedikamentenAnwendung {
  
    Medikamente medikament;
    File verzeichnis = new File("dateien/medikamente.txt");
    FileWriter eingabe;
    public ArrayList<Medikamente> medikamente = new ArrayList<>();

    public void anlegen(String name, String kategorie, double preis, int stueck) {

        
       
        

        medikament = new Medikamente(medikamente.size()  , name, kategorie, preis, stueck);

        medikamente.add(medikament);

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

        
        try (BufferedReader reader = new BufferedReader(new FileReader("dateien/medikamente.txt"))) {
            String zeile;
            while ((zeile = reader.readLine()) != null) {

                if(zeile.contains(id)) {

                    System.out.println(zeile);


                }


            }
          } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
          }

        

    }

    public void einkaufen(int id, int stueck) throws IOException {

        medikamente.get(id-1000).einkauf(stueck);

        for (Medikamente i : medikamente) {
            
            verzeichnis.delete();

            eingabe = new FileWriter(verzeichnis, true);
            eingabe.write("Id: "+ i.getId() + " ");
            eingabe.write("Name: " + i.getName()  + " ");
            eingabe.write("Kategorie: " + i.getKategorie()  + " ");
            eingabe.write("Preis: " + i.getPreis() + " € ");
            eingabe.write("Anzahl: " + i.getAnzahl() + " Stück \n");
            eingabe.flush();
            eingabe.close();

        }


    }


}

