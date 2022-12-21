package programmieraufgabe;

import java.util.Scanner;

public class MedikamenteKonsole {
	public static void main(String[] args) {
		

		MedikamentenAnwendung anwendung = new MedikamentenAnwendung();
		

		int sca;
		String again = "z";
		Scanner scanner = new Scanner(System.in);
			while(again == "z"){

				System.out.println("Medikamente Menü");
				System.out.println("1. Ein neues Medikament anlegen");
				System.out.println("2. Ein Medikament suchen");
				System.out.println("3. Ein Medikament aus löschen");
				System.out.println("4. Das Programm beenden");

				System.out.println("Geben Sie die Zahl ein was Sie ausführen wollen.");
				sca = scanner.nextInt();
				switch (sca) {
					case 1:
						String name;
						int anzahl;
						double preis;
						String kategorie;
						String wiederhol = "y";

						while(wiederhol.equals("y")){
							System.out.println("Geben Sie den Name des Medikament");
							name = scanner.next();

							System.out.println("Geben Sie den Kategorie des Medikament an");
							kategorie = scanner.next();

							System.out.println("Geben Sie den Anzahl des Medikament an");
							anzahl = scanner.nextInt();

							System.out.println("Geben Sie den Preis des Medikament an");
							preis = scanner.nextDouble();
			
							anwendung.anlegen(name, kategorie, preis, anzahl);
							wiederhol = "w";	
							while(wiederhol == "w"){
								System.out.println("Wenn Sie ein weiteres Medikament eingeben wollen, dann geben Sie 'y' ein.");
								System.out.println("Wenn Sie kein Medikament weiter angeben wollen, dann geben Sie 'n' ein.");
								wiederhol = scanner.next();
								if((wiederhol.equals("y"))){
								}
								else if(wiederhol.equals("n")){
									wiederhol="b";
								}
								else{
									System.out.println("Falsche Eingabe.");
									System.out.println();
								}
							}			
						}
						break;
					case 2:
						String sca2;
						String medi;
						int id;
						int such;
						
						System.out.println("Unter was wollen Sie suchen?");
						System.out.println("1. Medikamenten-ID");
						System.out.println("2. Medikamenten-Name");
						such = scanner.nextInt();
						if(such == 1){
							System.out.println("Geben Sie die ID des Gesuchten Medikament");
							id = scanner.nextInt();
						}
						else if(such == 2){
							System.out.println("Geben Sie den Namen des Gesuchten Medikament");
							sca2 = scanner.next();
						}
						else{
							System.out.println("Falsche Eingabe.");
							System.out.println("Bitte geben Sie die Zahl '1' für die Medikamenten-ID suche,");
							System.out.println("Oder geben Sie die Zahl '2' für die Medikamenten-Name suche.");
						}
						
						//Such Methode
						System.out.println("Ausgabe des Medikament");
//						if(medi.isEmpty()){
//						System.out.println("Das Medikament wurde nicht gefunden.");
//						}
						break;
					case 3:
						System.out.println("Geben Sie den Namen des Medikament das Sie löschen wollen");
						// Such Methode
						if(true/*Objekt exisitiert*/) {
							String loeschen;
							System.out.println("Wenn Sie das Medikament wirklich löschen wollen geben Sie 'y' ein?");
							loeschen = scanner.nextLine();
							if(loeschen=="y") {
								//Methode löschen
								System.out.println("Das Medikament wurde jetzt gelöscht.");
							}
							else {
								System.out.println("Der Löschvorgang wurde abgebrochen.");
							}
						}
					case 4:
						System.out.println("Sie haben das Programm beendet.");
						System.out.println("Einen wunderschönen Tag noch.");
						again = "b";
						break;
			
			}
		}	
	}

}
