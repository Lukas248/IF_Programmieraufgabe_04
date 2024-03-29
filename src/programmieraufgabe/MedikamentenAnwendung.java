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

        anzahl = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(verzeichnis))) {
            
            while ((reader.readLine()) != null) {

                
                anzahl++;


            }

            reader.close();

          } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei");
          }

        medikament = new Medikamente(anzahl, name, kategorie, preis, stueck);
        medikamente.add(medikament);
        verzeichnis.delete();

        neueDatei();

        

    }

    public void suchen(String kategorie) {

        
        try (BufferedReader reader = new BufferedReader(new FileReader(verzeichnis))) {
            String zeile;
            while ((zeile = reader.readLine()) != null) {

                if(zeile.contains("Id: "+kategorie)) {

                    System.out.println(zeile);

                }
                else if(zeile.contains("Name: "+kategorie)) {

                    System.out.println(zeile);

                }
                else if(zeile.contains("Kategorie: "+kategorie)) {

                    System.out.println(zeile);

                }


            }

            reader.close();

          } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei");
          }

        

    }

    

    public void einkaufen(int id, int stueck) throws IOException {

        for (int i = 0; i < medikamente.size(); i++) {
            if(medikamente.get(i).getId() == id) {

                medikamente.get(i).einkauf(stueck);
            }

        }
        verzeichnis.delete();
        neueDatei();

    }

    public void verkaufen(int id,  int stueck) throws IOException {

        for (int i = 0; i < medikamente.size(); i++) {

            if(medikamente.get(i).getId() == id) {

                medikamente.get(i).verkauf(stueck);
            }

        }
        verzeichnis.delete();
        neueDatei();

    }

    public void loeschen(int id) {

        
        for (int i = 0; i < medikamente.size(); i++) {

            if(medikamente.get(i).getId() == id) {

                medikamente.remove(i);

            }

        }

        verzeichnis.delete();
        neueDatei();

    }

    public void neueDatei() {

        try {

            eingabe = new FileWriter("dateien/medikamente.txt", true);

            for (Medikamente i : medikamente) {
            
                eingabe.write("Id: "+ i.getId() + " ");
                eingabe.write("Name: " + i.getName()  + " ");
                eingabe.write("Kategorie: " + i.getKategorie()  + " ");
                eingabe.write("Preis: " + i.getPreis() + " Euro ");
                eingabe.write("Anzahl: " + i.getAnzahl() + " Stueck \n");

    
            }

            eingabe.flush();
            eingabe.close();

        } catch (IOException e) {
            System.out.println("Es ist ein Fehler aufgetretten beim erstellen einer Datei");
        }

        

    }

    public void erstellen() {


        try (BufferedReader reader = new BufferedReader(new FileReader(verzeichnis))) {


            

                BufferedReader reader2 = new BufferedReader(new FileReader(verzeichnis));

                       
                while(reader.readLine()!=null) {

                    int id = 1001;
                    String name = "";
                    String kategorie = "";
                    double preis = 0;
                    int anzahl = 0;  

                    String[] woerter = reader2.readLine().split(" ");

                    for (int i = 0; i < woerter.length; i++) {

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

                        

                        
                    }

                    medikament = new Medikamente(id, name, kategorie, preis, anzahl);

                    medikamente.add(medikament);
   
                }

                reader2.close();
                reader.close();

          } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei");
          }

          
          

    }

    public void anzeigen() {

        try (BufferedReader reader = new BufferedReader(new FileReader(verzeichnis))) {
            String zeile;
            while ((zeile = reader.readLine()) != null) {

                System.out.println(zeile);


            }

            reader.close();

          } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei");
          }


    }


}