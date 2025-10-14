package Exercici_09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();

		Llibre llibre0 = new Llibre("El Hobbit", "J.R.R. Tolkien", 1930);
		Llibre llibre1 = new Llibre("La Comunidad del Anillo", "J.R.R. Tolkien", 1954);
		Llibre llibre2 = new Llibre("Las dos Torres", "J.R.R. Tolkien", 1954);
		Llibre llibre3 = new Llibre("El retorno del Rey", "J.R.R. Tolkien", 1955);

		biblioteca.llibresIntroduits(llibre0);
		biblioteca.llibresIntroduits(llibre1);
		biblioteca.llibresIntroduits(llibre2);
		biblioteca.llibresIntroduits(llibre3);

		int opcio;
		Usuari usuari = null;

		do {
			System.out.println("Gestor de Llibres:");
			System.out.println("\n1. Afegir llibre");
			System.out.println("2. Mostrar llibres");
			System.out.println("3. Buscar llibre");
			System.out.println("4. Afegir usuari");
			System.out.println("5. Prestar llibre");
			System.out.println("6. Retornar llibre");
			System.out.println("7. Sortir");
			System.out.println("Selecciona una opció:");
			opcio = scanner.nextInt();
			scanner.nextLine();

			switch (opcio) {
			case 1:
				biblioteca.afegirLlibre();
				break;
			case 2:
				biblioteca.mostrarLlibres();
				Llibre.comptarLlibres();
				break;
			case 3:
				biblioteca.buscarLlibre();
				break;
			case 4:
				System.out.println("Introdueix el nom del usuari:");
				String nom = scanner.nextLine();
				System.out.println("Introdueix l'edat del usuari:");
				int edat = scanner.nextInt();
				scanner.nextLine();
				usuari = new Usuari(nom, edat);
				break;
			case 5:
				if (usuari == null) {
					System.out.println("Abans de prestar llibres, s'ha de crear un usuari.");
				} else {
					System.out.println("Introdueix el titol del llibre desitjat:");
					String titolDesitjat = scanner.nextLine();
					Llibre llibrePrestat = biblioteca.prestarLlibre(titolDesitjat);
					if (llibrePrestat != null) {
						usuari.afegirLlibrePrestats(llibrePrestat);
					} else {
						System.out.println("El llibre no s'ha trobat.");
					}
				}
				break;
			case 6:
				if (usuari == null) {
					System.out.println("No hi ha cap usuari creat per retornar llibres.");
				} else {
					System.out.println("Introdueix el titol del llibre que vols retornar:");
					String titolRetornar = scanner.nextLine();
					Llibre llibreRetornat = usuari.retornarLlibre(titolRetornar);
					if (llibreRetornat != null) {
						biblioteca.retornarLlibre(llibreRetornat);
					} else {
						System.out.println("No tens aquest llibre en la llista de prestats.");
					}
				}
				break;
			case 7:
				System.out.println("\nSortint del programa...");
				break;
			default:
				System.out.println("\nOpció incorrecta.");
				break;
			}
		} while (opcio != 7);

		scanner.close();
	}
}