package programmieraufgabe;

public class Medikamente {
  private String name;
  private String kategorie;
  private double preis;
  private int anzahl;

  public Medikamente (String name, String kategorie, double preis, int anzahl) {
	  this.name = name;
	  this.kategorie = kategorie;
	  this.preis = preis;
	  this.anzahl = anzahl;
  }

   public void setName(String name) {

        this.name = name;

    }

    public void setPreis(double preis) {

        this.preis = preis;

    }

    public void setAnzahl(int anzahl) {

        this.anzahl = anzahl;

    }

    public void setKategorie(String kategorie) {

        this.kategorie = kategorie;

    }

    public String getName() {

      return name;

    }

    public double getPreis() {

      return preis;

    }

    public int getAnzahl() {

      return anzahl;

    }

    public int getKategorie() {

      return kategorie;

    }

    public void einkauf(int einkauf) {

      anzahl = anzahl + 1;

    }

    public void verkauf(int verkauf) {

      if(anzahl <= verkauf) {

        anzahl = anzahl - verkauf;

      }

    }

    public String getId() {
        return null;
    }

}
