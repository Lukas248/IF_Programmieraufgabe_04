package programmieraufgabe;

public class Medikamente {

  private String name;
  private int id = 1000;
  private String kategorie;
  private double preis;
  private int anzahl;


  public Medikamente (int id, String name, String kategorie, double preis, int anzahl) {
	  this.name = name;
	  this.id = this.id + id;
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

    public String getKategorie() {

      return kategorie;

    }

    public void einkauf(int einkauf) {

      anzahl = anzahl + einkauf;

    }

    public void verkauf(int verkauf) {

      if(anzahl -  verkauf >= 0) {

        anzahl = anzahl - verkauf;

      }
      else {

        System.out.println("Es gibt nicht genügend Medikamente.");

      }

    }

    public int getId() {
        return id;
    }

}
