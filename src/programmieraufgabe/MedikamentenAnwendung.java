package programmieraufgabe;

import java.io.*;
import java.util.ArrayList;

public class MedikamentenAnwendung {
  
    private Medikamente medikament;
    private File verzeichnis = new File("dateien/medikamente.txt");
    private FileWriter eingabe;
    private ArrayList<Medikamente> medikamente = new ArrayList<>();
    private int anzahl;

    public void anlegen(String name, String kategorie, double preis, int stueck) {

        try (BufferedReader reader = new BufferedReader(new FileReader(verzeichnis))) {
            
            while ((reader.readLine()) != null) {

                
                anzahl++;


            }
          } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
          }

        medikament = new Medikamente(anzahl, name, kategorie, preis, stueck);
        medikamente.add(medikament);

        try {

            neueDatei();

        }
        catch(IOException e) {

            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());

        }

    }

    public void suchen(String id) {

        
        try (BufferedReader reader = new BufferedReader(new FileReader(verzeichnis))) {
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
        verzeichnis.delete();
        neueDatei();

    }

    public void verkaufen(int id,  int stueck) throws IOException {

        medikamente.get(id-1000).verkauf(stueck);
        verzeichnis.delete();
        neueDatei();

    }

    public void loeschen(int id) throws IOException {

        medikamente.remove(id-1000);
        verzeichnis.delete();
        neueDatei();

    }

    public void neueDatei() throws IOException {

        eingabe = new FileWriter(verzeichnis, true);

        for (Medikamente i : medikamente) {
            
            eingabe.write("Id: "+ i.getId() + " ");
            eingabe.write("Name: " + i.getName()  + " ");
            eingabe.write("Kategorie: " + i.getKategorie()  + " ");
            eingabe.write("Preis: " + i.getPreis() + " Euro ");
            eingabe.write("Anzahl: " + i.getAnzahl() + " Stueck \n");
            eingabe.flush();
            eingabe.close();

        }

    }

    public void erstellen() {

        try (BufferedReader reader = new BufferedReader(new FileReader(verzeichnis))) {

            
                BufferedReader reader2 = new BufferedReader(new FileReader(verzeichnis));

                int id = 1001;
                String name = "";
                String kategorie = "";
                double preis = 0;
                int anzahl = 0;         
 
                while(reader.readLine()!=null) {

                    String[] woerter = reader2.readLine().split(" ");

                    for (int i = 0; i < woerter.length; i++) {

                        System.out.println(woerter[i]);

                        if(woerter[i].equals("Id:")) {

                            id = Integer.parseInt(woerter[i+1]) - 1000;

                        }
                        else if(woerter[i].equals("Name:")) {

                            name = woerter[i+1];

                        }
                        else if(woerter[i].equals("Kategorie:")) {

                            kategorie = woerter[i+1];

                        }
                        else if(woerter[i].equals("Preis:")) {

                            preis = Double.parseDouble(woerter[i+1]);

                        }
                        else if(woerter[i].equals("Anzahl:")) {

                            anzahl = Integer.parseInt(woerter[i+1]);

                        }

                        medikament = new Medikamente(id, name, kategorie, preis, anzahl);

                        medikamente.add(medikament);

                        
                    }
   
                }

                reader2.close();
            
          } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
          }


          

    }


}

