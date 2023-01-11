package programmieraufgabe;

import java.io.IOException;
import java.util.Scanner;

public class MedikamenteKonsole {
	public static void main(String[] args) {
		
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
				
				System.out.println("Medikamente Menü");
				System.out.println("1. Ein neues Medikament anlegen");
				System.out.println("2. Ein Medikament suchen");
				System.out.println("3. Ein Medikament aus löschen");
				System.out.println("4. Das Programm beenden");
				System.out.println("Geben Sie die Zahl ein was Sie ausführen wollen.");
				auswahl = scanner.nextInt();
				
				switch (auswahl) {
					case 1:
						
						while(wiederhol){
							fehler=true;
							MedikamentenAnwendung anwendungw = new MedikamentenAnwendung();

							System.out.println("Geben Sie den Name des Medikament");
							name = scanner.next();

							System.out.println("Geben Sie den Kategorie des Medikament an");
							kategorie = scanner.next();

							System.out.println("Geben Sie den Anzahl des Medikament an");
							anzahl = scanner.nextInt();

							System.out.println("Geben Sie den Preis des Medikament an");
							preis = scanner.nextDouble();

							anwendungw.anlegen(name, kategorie, preis, anzahl);
							
							

							while(fehler) {

								System.out.println("Wenn Sie ein weiteres Medikament eingeben wollen, dann geben Sie 'y' ein.");
								System.out.println("Wenn Sie kein Medikament weiter angeben wollen, dann geben Sie 'n' ein.");
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

							System.out.println("Unter was wollen Sie suchen?");
							System.out.println("1. Medikamenten-ID");
							System.out.println("2. Medikamenten-Name");
							System.out.println("3. Medikamenten-Katgeorie");

							such = scanner.nextInt();

							if(such == 1){
								System.out.println("Geben Sie die ID des Gesuchten Medikament");
								id = scanner.next();
								anwendung.suchen(id);
								fehler = true;
							}

							else if(such == 2){
								System.out.println("Geben Sie den Namen des Gesuchten Medikament");
								id = scanner.next();
								anwendung.suchen(id);
								fehler = true;
							}
							else if(such == 3){
								System.out.println("Geben Sie den Kategorie des Gesuchten Medikament");
								id = scanner.next();
								anwendung.suchen(id);
								fehler = true;
							}

							else{
								System.out.println("Falsche Eingabe.");
								
							}

							while(fehler) {
								
								System.out.println("Wollen Sie ein weiteres Medikament suchen, dann geben Sie 'y' ein.");
								System.out.println("Wenn Sie kein Medikament weiter suchen wollen, dann geben Sie 'n' ein.");
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

							System.out.println("Geben Sie die Id des Medikament das Sie löschen wollen");
							try {
								anwendung.loeschen(scanner.nextInt());
								System.out.println("Das Medikament wurde gelöscht werden!");
								fehler = false;
							} catch (IOException e) {
								System.out.println("Das Medikament konnte nicht gelöscht werden!");
								e.printStackTrace();
								fehler = true;
							}

						}

						break;
					case 4:
						System.out.println("Sie haben das Programm beendet.");
						System.out.println("Einen wunderschönen Tag noch.");
						wiederhol2 = false;
						break;
			
			}
		}
		}	
	}

}
