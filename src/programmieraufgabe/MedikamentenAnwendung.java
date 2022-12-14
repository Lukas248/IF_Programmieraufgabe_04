package programmieraufgabe;

public class MedikamentenAnwendung {
  
    Medikamente medikament;

    public void anlegen(String name, String kategorie, double preis, int anzahl) {

        medikament = new Medikamente(name, kategorie, preis, anzahl);

    }


}

