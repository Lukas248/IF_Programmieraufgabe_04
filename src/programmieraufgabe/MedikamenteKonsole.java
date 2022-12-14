package paket_wochentage;

import java.util.Scanner;

public class MedikamenteKonsole {
	private static Medikamente medikament;
	public static void main(String[] args) {
		
		int sca;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Medikamente Menü");
		System.out.println("1. Ein neues Medikament anlegen");
		System.out.println("2. Ein Medikament suchen");
		System.out.println("3. Ein Medikament aus löschen");
		System.out.println("4. Das Programm beenden");

		System.out.println("Geben Sie die Zahl ein was Sie ausführen wollen.");
		sca = scanner.nextInt();
		switch (sca) {
		case 1:
			String sca1;
			int anza;
			double pre;
			System.out.println("Geben Sie den Name des Medikament");
			sca1 = scanner.nextLine();
			// Methode für Name
			System.out.println("Geben Sie den Kategorie des Medikament an");
			sca1 = scanner.nextLine();
			//Methode für Kategorie
			System.out.println("Geben Sie den Anzahl des Medikament an");
			anza = scanner.nextInt();
			//Methode für Anzahl
			System.out.println("Geben Sie den Anzahl des Medikament an");
			pre = scanner.nextDouble();
			//Methode für Preis
			medikament =  new Medikamente(null, null, 0, 0);
			break;
		case 2:
			String sca2;
			System.out.println("Geben Sie den Namen des Gesuchten Medikament");
			sca2 = scanner.nextLine();
			//Such Methode
			System.out.println("Ausgabe des Medikament");
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
			
		}
		
	}

}
