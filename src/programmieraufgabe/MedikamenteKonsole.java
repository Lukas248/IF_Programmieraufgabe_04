package programmieraufgabe;

import java.io.IOException;
import java.util.Scanner;

public class MedikamenteKonsole {
	public static void main(String[] args) {
		
		MedikamentenAnwendung anwendung = new MedikamentenAnwendung();
		String name;
		int anzahl;
		double preis;
		String kategorie;
		int auswahl;
		boolean wiederholen = true;
		//Damit die schleifen überhaubt sich wiederholen können
		boolean wiederholen2 = true;
		boolean fehler = true;
		int id;

		anwendung.erstellen();

		try (Scanner scanner = new Scanner(System.in)) {

			while(wiederholen2){


				
				System.out.println("----------------Medikamente Menü----------------");
				System.out.println("1. Ein neues Medikament anlegen");
				System.out.println("2. Ein Medikament suchen");
				System.out.println("3. Ein Medikament löschen");
				System.out.println("4. Medikamente verkaufen oder einkaufen");
				System.out.println("5. Das Programm beenden");
				System.out.println("Geben Sie die Zahl ein was Sie ausführen wollen.");
				System.out.println("------------------------------------------------");
				auswahl = scanner.nextInt();

				switch (auswahl) {
					case 1:
						
						while(fehler){
							

							System.out.println("Geben Sie den Name des Medikament");
							name = scanner.next();

							System.out.println("Geben Sie den Kategorie des Medikament an");
							kategorie = scanner.next();

							System.out.println("Geben Sie den Anzahl des Medikament an");
							anzahl = scanner.nextInt();

							System.out.println("Geben Sie den Preis des Medikament an");
							preis = scanner.nextDouble();

							anwendung.anlegen(name, kategorie, preis, anzahl);
							
							

							while(fehler) {

								System.out.println("Wenn Sie ein weiteres Medikament eingeben wollen, dann geben Sie 'y' ein.");
								System.out.println("Wenn Sie kein Medikament weiter angeben wollen, dann geben Sie 'n' ein.");
								
								if(scanner.nextLine().equals("y")){

									wiederholen = true;
									fehler = false;

								}
								else if(scanner.nextLine().equals("n")){
									wiederholen =false;
									fehler = false;
								}
								else{
									System.out.println("Falsche Eingabe.");
									System.out.println();
									fehler = true;
								}

							}

									
						}
						break;
					case 2:
						
						
						while(wiederholen) {

							System.out.println("Unter was wollen Sie suchen?");
							System.out.println("1. Medikamenten-ID");
							System.out.println("2. Medikamenten-Name");
							System.out.println("3. Medikamenten-Katgeorie");
							System.out.println("4. Alle Medikamente suchen");

							auswahl = scanner.nextInt();

							if(auswahl == 1){
								System.out.println("Geben Sie die ID des Gesuchten Medikament");
								id = scanner.nextInt();
								anwendung.suchen(id, null, null);
								fehler = true;
							}

							else if(auswahl == 2){
								System.out.println("Geben Sie den Namen des Gesuchten Medikament");
								name = scanner.next();
								anwendung.suchen(0, name, null);
								fehler = true;
							}
							else if(auswahl == 3){
								System.out.println("Geben Sie den Kategorie des Gesuchten Medikament");
								kategorie = scanner.next();
								anwendung.suchen(0, null, kategorie);
								fehler = true;
							}
							else if(auswahl == 4) {

								anwendung.anzeigen();
								fehler = true;

							}

							else {
								System.out.println("Falsche Eingabe.");
								fehler = false;
							}

							while(fehler) {
								
								System.out.println("Wollen Sie ein weiteres Medikament suchen, dann geben Sie 'y' ein.");
								System.out.println("Wenn Sie kein Medikament weiter suchen wollen, dann geben Sie 'n' ein.");
								
								if(scanner.nextLine().equals("y")){

									wiederholen = true;
									fehler = false;

								}
								else if(scanner.nextLine().equals("n")){
									wiederholen=false;
									fehler = false;
								}
								else{
									System.out.println("Falsche Eingabe.");
									fehler = true;
								}

							}
						}
						
						break;
					case 3:

						while(fehler) {

							System.out.println("Geben Sie die Id des Medikament das Sie löschen wollen");
							auswahl = scanner.nextInt();
							anwendung.loeschen(auswahl);
							System.out.println("Das Medikament wurde gelöscht werden!");
							fehler = false;
							

						}

						break;

					case 4:
						
						while (fehler) {

							System.out.println("1. Medikamenten verkaufen");
							System.out.println("2. Medikamenten einkaufen");

							auswahl = scanner.nextInt();

							while(fehler) {

								System.out.println("Geben Sie die Id des Medikament ein!");
								id = scanner.nextInt();
								
								if(auswahl == 1) {

									System.out.println("Wie viele Medikamente möchten Sie verkaufen?");
									anzahl = scanner.nextInt(); 
									try {
										anwendung.verkaufen(id,anzahl);
										fehler = false;
									} catch (NumberFormatException e) {
										fehler = true;
										e.printStackTrace();
									} catch (IOException e) {
										fehler = true;
										e.printStackTrace();
									}

									

								}
								else if(auswahl == 2) {

									System.out.println("Wie viele Medikamente möchten Sie einkaufen?");
									anzahl = scanner.nextInt(); 
									try {
										anwendung.einkaufen(id,anzahl);
										fehler = false;
									} catch (NumberFormatException e) {
										fehler = true;
										e.printStackTrace();
									} catch (IOException e) {
										fehler = true;
										e.printStackTrace();
									}

								}
								else {

									System.out.println("Es ist ein Fehler aufgetretten!");
									fehler = true;

								}


							}

						}

						

						break;
	
					case 5:
						System.out.println("Sie haben das Programm beendet.");
						System.out.println("Einen wunderschönen Tag noch.");
						wiederholen2 = false;
						break;
						
			}			
		
			}
		}	
	}

}
