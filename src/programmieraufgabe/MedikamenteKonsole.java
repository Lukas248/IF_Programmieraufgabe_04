package programmieraufgabe;

import java.io.IOException;
import java.util.Scanner;

public class MedikamenteKonsole {
	public static void main(String[] args) throws IOException {
		
		MedikamentenAnwendung anwendung = new MedikamentenAnwendung();
		String a;
		String name;
		int anzahl;
		double preis;
		String kategorie;
		int auswahl;
		boolean wiederhol = true;
		boolean wiederhol2 = true;
		boolean fehler = true;

		anwendung.erstellen();

		try (Scanner scanner = new Scanner(System.in)) {
			while(wiederhol2){
				
				wiederhol = true;
				fehler = true;
				
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
						
						while(wiederhol){
							fehler=true;
							System.out.println("---------------------------------");
							System.out.println("Geben Sie den Name des Medikament");
							System.out.println("---------------------------------");
							name = scanner.next();

							System.out.println("-----------------------------------------");
							System.out.println("Geben Sie den Kategorie des Medikament an");
							System.out.println("-----------------------------------------");
							kategorie = scanner.next();

							System.out.println("--------------------------------------");
							System.out.println("Geben Sie den Anzahl des Medikament an");
							System.out.println("--------------------------------------");
							anzahl = scanner.nextInt();

							System.out.println("-------------------------------------");
							System.out.println("Geben Sie den Preis des Medikament an");
							System.out.println("-------------------------------------");
							preis = scanner.nextDouble();

							anwendung.anlegen(name, kategorie, preis, anzahl);
							
							

							while(fehler) {
								System.out.println("-------------------------------------------------------------------------");
								System.out.println("Wenn Sie ein weiteres Medikament eingeben wollen, dann geben Sie 'y' ein.");
								System.out.println("Wenn Sie kein Medikament weiter angeben wollen, dann geben Sie 'n' ein.");
								System.out.println("-------------------------------------------------------------------------");

								a = scanner.next();
								if(a.equals("y")){

									wiederhol = true;
									fehler = false;

								}
								else if(a.equals("n")){
									wiederhol=false;
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
						String id;
						int such;
						
						while(wiederhol) {

							System.out.println("----------------Unter was wollen Sie suchen?----------------");
							System.out.println("1. Medikamenten-ID");
							System.out.println("2. Medikamenten-Name");
							System.out.println("3. Medikamenten-Katgeorie");
							System.out.println("4. Alle Medikamente suchen");
							System.out.println("------------------------------------------------------------");

							such = scanner.nextInt();
							System.out.println("---------------------------------------");

							if(such == 1){
								
								System.out.println("-----------------------------------------");
								System.out.println("Geben Sie die ID des Gesuchten Medikament");
								System.out.println("-----------------------------------------");
								id = scanner.next();
								anwendung.suchen(id, "id");
								fehler = true;
							}

							else if(such == 2){
								System.out.println("--------------------------------------------");
								System.out.println("Geben Sie den Namen des Gesuchten Medikament");
								System.out.println("--------------------------------------------");
								id = scanner.next();
								anwendung.suchen(id, "name");
								fehler = true;
							}
							else if(such == 3){
								System.out.println("------------------------------------------------");
								System.out.println("Geben Sie den Kategorie des Gesuchten Medikament");
								System.out.println("------------------------------------------------");
								id = scanner.next();
								anwendung.suchen(id, "kategorie");
								fehler = true;
							}
							else if(such == 4) {

								anwendung.suchen(null, "alle");
								fehler = true;

							}

							else {
								System.out.println("Falsche Eingabe.");
								fehler = false;
							}

							while(fehler) {
								System.out.println("----------------------------------------------------------------------");								
								System.out.println("Wollen Sie ein weiteres Medikament suchen, dann geben Sie 'y' ein.");
								System.out.println("Wenn Sie kein Medikament weiter suchen wollen, dann geben Sie 'n' ein.");		
								System.out.println("----------------------------------------------------------------------");								
								a = scanner.next();
								if(a.equals("y")){

									wiederhol = true;
									fehler = false;

								}
								else if(a.equals("n")){
									wiederhol=false;
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
					case 3:

						while(fehler) {
							System.out.println("------------------------------------------------------");
							System.out.println("Geben Sie die Id des Medikament das Sie löschen wollen");
							System.out.println("------------------------------------------------------");
							such = scanner.nextInt();
							anwendung.loeschen(such);
							System.out.println("Das Medikament wurde gelöscht werden!");
							fehler = false;
							

						}

						break;

					case 4:
						
						while (fehler) {
							System.out.println("-------------------------");
							System.out.println("1. Medikamenten verkaufen");
							System.out.println("2. Medikamenten einkaufen");
							System.out.println("-------------------------");
							auswahl=scanner.nextInt();
							if(auswahl == 1){
								System.out.println("---------------------------------------------------------");
								System.out.println("Geben Sie die Id des Medikament das Sie reduzieren wollen");
								System.out.println("---------------------------------------------------------");
								such=scanner.nextInt();
								System.out.println("---------------------------------------");
								System.out.println("Geben Sie die Stückzahl des Verkauf an.");
								System.out.println("---------------------------------------");
								anzahl=scanner.nextInt();
								anwendung.verkaufen(such, anzahl);
								fehler = false;
							}	
							else if(auswahl == 2){
								System.out.println("------------------------------------------------------");
								System.out.println("Geben Sie die Id des Medikament das Sie erhöhen wollen");
								System.out.println("------------------------------------------------------");
								such=scanner.nextInt();							

								System.out.println("---------------------------------------");
								System.out.println("Geben Sie die Stückzahl des Einkauf an.");
								System.out.println("---------------------------------------");
								anzahl=scanner.nextInt();

								anwendung.einkaufen(such, anzahl);
								fehler = false;
							}
							else{
								System.out.println("Falsche Eingabe");
							}

						}

						break;
	
					case 5:
						System.out.println("Sie haben das Programm beendet.");
						System.out.println("Einen wunderschönen Tag noch.");
						System.out.println("----------------------------------------------------------------------------------------------");
						wiederhol2 = false;
						break;
			
			}
		}
		}	
	}

}