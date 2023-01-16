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
		boolean wiederholen;
		boolean fehler;
		int id;

		anwendung.erstellen();

		
		try (Scanner scanner = new Scanner(System.in)) {

			do {

				wiederholen = true;
				fehler = false;
				
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
						
						do {
							System.out.println("---------------------------------------------------");
							System.out.println("Geben Sie den Name des Medikament");
							name = scanner.next();

							System.out.println("Geben Sie den Kategorie des Medikament an");
							kategorie = scanner.next();

							System.out.println("Geben Sie den Anzahl des Medikament an");
							anzahl = scanner.nextInt();

							System.out.println("Geben Sie den Preis des Medikament an");
							preis = scanner.nextDouble();

							anwendung.anlegen(name, kategorie, preis, anzahl);
							
							

							do {
								System.out.println("-----------------------------------------------------------------------");
								System.out.println("Wenn Sie ein weiteres Medikament eingeben wollen, dann geben Sie 0 ein.");
								System.out.println("Wenn Sie kein Medikament weiter angeben wollen, dann geben Sie 1 ein.");
								System.out.println("-----------------------------------------------------------------------");
								
								auswahl = scanner.nextInt();

								if(auswahl == 0){

									wiederholen = true;
									fehler = false;

								}
								else if(auswahl == 1){
									wiederholen =false;
									fehler = false;
								}
								else{
									System.out.println("---------------------------");
									System.out.println("Falsche Eingabe.");
									System.out.println();
									fehler = true;
								}

							}while(fehler);

									
						}while(wiederholen);

						wiederholen = true;
						break;

					case 2:
						
						
						do {


							do {
								System.out.println("-----------------------------");
								System.out.println("Unter was wollen Sie suchen?");
								System.out.println("1. Medikamenten-ID");
								System.out.println("2. Medikamenten-Name");
								System.out.println("3. Medikamenten-Katgeorie");
								System.out.println("4. Alle Medikamente suchen");
								System.out.println("5. Zurück");
								System.out.println("-----------------------------");
								auswahl = scanner.nextInt();

								if(auswahl == 1){
									System.out.println("-----------------------------------------");
									System.out.println("Geben Sie die ID des Gesuchten Medikament");
									String eingabe = scanner.next();
									System.out.println("------------------------------------------------");
									anwendung.suchen(eingabe);
									
								}

								else if(auswahl == 2){		
									System.out.println("--------------------------------------------");
									System.out.println("Geben Sie den Namen des Gesuchten Medikament");
									name = scanner.next();
									System.out.println("------------------------------------------------");
									anwendung.suchen(name);
									
								}
								else if(auswahl == 3){

									System.out.println("------------------------------------------------");
									System.out.println("Geben Sie den Kategorie des Gesuchten Medikament");
									kategorie = scanner.next();
									System.out.println("------------------------------------------------");
									anwendung.suchen( kategorie);
									
								}
								else if(auswahl == 4) {
									
									System.out.println("------------------------------------------------");
									anwendung.anzeigen();
									fehler = false;

								}
								else if(auswahl == 5) {
									
									fehler = false;

								}
								else {
									System.out.println("Falsche Eingabe.");
									fehler = true;
								}

							}while(fehler);

							do {
								
								try {
								
									System.out.println("--------------------------------------------------------------------");
									System.out.println("Wollen Sie ein weiteres Medikament suchen, dann geben Sie 0 ein.");
									System.out.println("Wenn Sie kein Medikament weiter suchen wollen, dann geben Sie 1 ein.");
									
									System.out.println("--------------------------------------------------------------------");
									auswahl = scanner.nextInt();

									if(auswahl == 0){

										wiederholen = true;
										fehler = false;

									}
									else if(auswahl == 1){

										wiederholen=false;
										fehler = false;

									}
									else {

										System.out.println("Falsche Eingabe.");
										fehler = true;

									}

								}catch(NumberFormatException e) {

									System.out.println("Falsche Eingabe.");
									fehler = true;

								}

							}while(fehler);

						}while(wiederholen);
						
						wiederholen = true;
						break;
					case 3:

						try {

							
							System.out.println("------------------------------------------------------");
							System.out.println("Geben Sie die Id des Medikament das Sie löschen wollen");
							System.out.println("------------------------------------------------------");
							id = scanner.nextInt();
							name=Integer.toString(id);
							anwendung.suchen(name);

							System.out.println("----------------------------------------------------------------------");
							System.out.println("Sind Sie sicher Sie möchten das Medikament löschen?");
							System.out.println("Wenn Sie das Medikament löschen wollen, dann geben Sie die 0 ein");
							System.out.println("Wenn Sie das Medikament NICHT löschen wollen, dann geben Sie die 1 ein");
							System.out.println("----------------------------------------------------------------------");

							auswahl = scanner.nextInt();
							if(auswahl == 0){
								anwendung.loeschen(id);
								System.out.println("-------------------------------------------------------");
								System.out.println("Das Medikament wurde gelöscht!");
								System.out.println("-------------------------------------------------------");

								fehler = false;
							}
							else if(auswahl == 1){
								System.out.println("-------------------------------------------------------");
								System.out.println("Der Prozess wurde abgebrochen!");
								System.out.println("-------------------------------------------------------");
								fehler = false;
							}
							

						}catch(NumberFormatException e) {

							fehler = true;
							System.out.println("Es ist ein Fehler aufgetretten!");

						}
						wiederholen = true;
						break;

					case 4:
						
						do {

							try {

								System.out.println("-------------------------");
								System.out.println("1. Medikamenten verkaufen");
								System.out.println("2. Medikamenten einkaufen");
								System.out.println("-------------------------");
						
								auswahl = scanner.nextInt();

								System.out.println("------------------------------------");
								System.out.println("Geben Sie die Id des Medikament ein!");
								System.out.println("------------------------------------");

								id = scanner.nextInt();
								name = Integer.toString(id);
								if(auswahl == 1) {

									System.out.println("--------------------------------------------");
									System.out.println("Wie viele Medikamente möchten Sie verkaufen?");
									System.out.println("--------------------------------------------");
									anzahl = scanner.nextInt(); 
									anwendung.verkaufen(id,anzahl);
									System.out.println("--------------------------------------------");
									anwendung.suchen(name);

									fehler = false;
								
									

								}
								else if(auswahl == 2) {

									System.out.println("--------------------------------------------");
									System.out.println("Wie viele Medikamente möchten Sie einkaufen?");
									System.out.println("--------------------------------------------");
									anzahl = scanner.nextInt(); 
									anwendung.einkaufen(id,anzahl);
									System.out.println("--------------------------------------------");
									anwendung.suchen(name);

								}
								else {

									System.out.println("Es ist ein Fehler aufgetretten!");
									fehler = true;

								}

							}catch(IOException e) {

								System.out.println("Es ist ein Fehler aufgetretten!");
								fehler = true;

							}

						}while(fehler);

						wiederholen = true;

						break;
	
					case 5:
						System.out.println("Sie haben das Programm beendet.");
						System.out.println("Einen wunderschönen Tag noch.");							
						System.out.println("-----------------------------------------------");

						wiederholen = false;
						break;
			
				}

			}while(wiederholen);
		}	
	}
}
