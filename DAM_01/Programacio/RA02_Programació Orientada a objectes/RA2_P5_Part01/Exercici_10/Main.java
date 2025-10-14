package Exercici_10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		SistemaBiblioteca sistema = new SistemaBiblioteca();

		int opcio;
		Usuari usuari = null;

		do {
			System.out.println("Menú Sistema de Biblioteques:");
			System.out.println("\n1. Gestionar Biblioteques");
			System.out.println("2. Gestionar Usuaris");
			System.out.println("3. Gestionar Llibres");
			System.out.println("4. Gestionar Préstecs");
			System.out.println("5. Sortir");
			System.out.println("Selecciona una opció:");
			opcio = scanner.nextInt();
			scanner.nextLine();

			switch (opcio) {

			case 1:
				do {
					System.out.println("Gestor de Biblioteques:");
					System.out.println("\n1. Afegir Biblioteca");
					System.out.println("2. Mostrar Biblioteques");
					System.out.println("3. Sortir");
					System.out.println("Selecciona una opció:");
					opcio = scanner.nextInt();
					scanner.nextLine();

					switch (opcio) {
					case 1:
						System.out.println("Introdueix el nom de la biblioteca:");
						String nomBiblio = scanner.nextLine();
						sistema.afegirBiblioteca(new Biblioteca(nomBiblio));
						System.out.println("Biblioteca afegida.");
						break;
					case 2:
						sistema.mostrarBiblioteques();
						break;
					case 3:
						System.out.println("\nSortint del programa...");
						break;
					default:
						System.out.println("\nOpció incorrecta.");
						break;
					}
				} while (opcio != 3);
				break;

			case 2:
				do {
					System.out.println("Gestor d'Usuaris:");
					System.out.println("\n1. Afegir Usuari");
					System.out.println("2. Mostrar Usuaris");
					System.out.println("3. Consultar llibres prestats d’un usuari");
					System.out.println("4. Sortir");
					System.out.println("Selecciona una opció:");
					opcio = scanner.nextInt();
					scanner.nextLine();

					switch (opcio) {
					case 1:
						System.out.println("Introdueix el nom del usuari:");
						String nom = scanner.nextLine();
						System.out.println("Introdueix l'edat del usuari:");
						int edat = scanner.nextInt();
						scanner.nextLine();
						usuari = new Usuari(nom, edat);
						sistema.afegirUsuari(usuari);
						break;
					case 2:
						sistema.mostrarUsuaris();
						break;
					case 3:
						sistema.mostrarUsuaris();
						System.out.println("Selecciona el número de l’usuari:");
						int indexUsuari = scanner.nextInt() - 1;
						scanner.nextLine();

						if (indexUsuari >= 0 && indexUsuari < sistema.getUsuaris().size()) {
							Usuari usuariSel = sistema.getUsuaris().get(indexUsuari);
							ArrayList<Llibre> prestats = usuariSel.getLlibresPrestats();

							System.out.println("L’usuari \"" + usuariSel.getNom() + "\" té " + prestats.size() + " llibres en préstec.");
							if (prestats.size() > 0) {
								System.out.println("Títols en préstec:");
								for (Llibre l : prestats) {
									System.out.println("- " + l.getTitol());
								}
							}
						} else {
							System.out.println("Índex d’usuari no vàlid.");
						}
						break;
					case 4:
						System.out.println("\nSortint del gestor d’usuaris...");
						break;
					default:
						System.out.println("\nOpció incorrecta.");
						break;
					}
				} while (opcio != 4);
				break;

			case 3:
				do {
					System.out.println("Gestor de Llibres:");
					System.out.println("\n1. Afegir Llibre");
					System.out.println("2. Mostrar Llibres");
					System.out.println("3. Buscar Llibre");
					System.out.println("4. Sortir");
					System.out.println("Selecciona una opció:");
					opcio = scanner.nextInt();
					scanner.nextLine();

					switch (opcio) {
					case 1:
						sistema.mostrarBiblioteques();
						System.out.println("Selecciona el numero de la biblioteca on afegir el llibre:");
						int indexBiblio = scanner.nextInt() - 1;
						scanner.nextLine();

						if (indexBiblio >= 0 && indexBiblio < sistema.getBiblioteques().size()) {
							sistema.getBiblioteques().get(indexBiblio).afegirLlibre();
						}
						break;
					case 2:
						for (int i = 0; i < sistema.getBiblioteques().size(); i++) {
							System.out.println("Biblioteca " + (i + 1) + ":");
							sistema.getBiblioteques().get(i).mostrarLlibres();
						}
						Llibre.comptarLlibres();
						break;
					case 3:
						System.out.println("Introdueix el títol a buscar:");
						String titol = scanner.nextLine();
						sistema.buscarLlibreGlobal(titol);
						break;
					case 4:
						System.out.println("\nSortint del gestor de llibres...");
						break;
					default:
						System.out.println("\nOpció incorrecta.");
						break;
					}
				} while (opcio != 4);
				break;

			case 4:
				do {
					System.out.println("Gestor de Préstecs:");
					System.out.println("\n1. Prestar Llibre");
					System.out.println("2. Retornar Llibre");
					System.out.println("3. Sortir");
					System.out.println("Selecciona una opció:");
					opcio = scanner.nextInt();
					scanner.nextLine();

					switch (opcio) {
					case 1:
						sistema.mostrarBiblioteques();
						System.out.println("Selecciona el número de la biblioteca:");
						int indexBiblio = scanner.nextInt() - 1;
						scanner.nextLine();

						sistema.mostrarUsuaris();
						System.out.println("Selecciona el número de l'usuari:");
						int indexUsuari = scanner.nextInt() - 1;
						scanner.nextLine();

						if (indexBiblio >= 0 && indexBiblio < sistema.getBiblioteques().size() &&
							indexUsuari >= 0 && indexUsuari < sistema.getUsuaris().size()) {
							
							Biblioteca biblioSel = sistema.getBiblioteques().get(indexBiblio);
							Usuari usuariSel = sistema.getUsuaris().get(indexUsuari);

							System.out.println("Introdueix el títol del llibre desitjat:");
							String titol = scanner.nextLine();
							Llibre llibre = biblioSel.prestarLlibre(titol);
							if (llibre != null) {
								usuariSel.afegirLlibrePrestats(llibre);
							} else {
								System.out.println("El llibre no s'ha trobat en aquesta biblioteca.");
							}
						}
						break;

					case 2:
						sistema.mostrarUsuaris();
						System.out.println("Selecciona el número de l'usuari:");
						indexUsuari = scanner.nextInt() - 1;
						scanner.nextLine();

						if (indexUsuari >= 0 && indexUsuari < sistema.getUsuaris().size()) {
							Usuari usuariSel = sistema.getUsuaris().get(indexUsuari);

							System.out.println("Introdueix el títol del llibre a retornar:");
							String titol = scanner.nextLine();
							Llibre llibre = usuariSel.retornarLlibre(titol);

							if (llibre != null) {
								sistema.mostrarBiblioteques();
								System.out.println("Selecciona la biblioteca on retornar-lo:");
								indexBiblio = scanner.nextInt() - 1;
								scanner.nextLine();

								if (indexBiblio >= 0 && indexBiblio < sistema.getBiblioteques().size()) {
									sistema.getBiblioteques().get(indexBiblio).retornarLlibre(llibre);
								}
							} else {
								System.out.println("Aquest usuari no té aquest llibre.");
							}
						}
						break;
					case 3:
						System.out.println("\nSortint del gestor de préstecs...");
						break;
					default:
						System.out.println("\nOpció incorrecta.");
						break;
					}
				} while (opcio != 3);
				break;

			case 5:
				System.out.println("\nSortint del programa...");
				break;
			default:
				System.out.println("\nOpció incorrecta.");
				break;
			}
		} while (opcio != 5);

		scanner.close();
	}
}