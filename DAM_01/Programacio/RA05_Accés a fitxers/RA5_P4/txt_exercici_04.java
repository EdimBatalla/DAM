package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class txt_exercici_04 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int opcio;

		do {
			System.out.println("-----Menu Usuaris------");
			System.out.println("1. Registrar usuari.");
			System.out.println("2. Consluta usuaris.");
			System.out.println("3. Eliminar usuari.");
			System.out.println("4. Sortir.");
			opcio = scanner.nextInt();
			scanner.nextLine();

			switch (opcio) {
			case 1:
				registrarUsuari(scanner);
				break;
			case 2:
				llegirFitxer();
				break;
			case 3:
				eliminarUsuari(scanner);
				break;
			case 4:
				System.out.println("Sortint del programa...");
				break;
			default:
				System.out.println("Opció invàlida. Torna a intentar.");
			}
			System.out.println();
		} while (opcio != 4);
		scanner.close();
	}

	public static void registrarUsuari(Scanner scanner) throws IOException {
		FileWriter fitxer;
		PrintWriter dades;
		fitxer = new FileWriter("usuaris.txt", true);
		dades = new PrintWriter(fitxer);
		String resposta;
		do {
			System.out.println("Introdueix el nom:");
			String nom = scanner.nextLine();
			System.out.println("Introdueix l'edat:");
			int edat = scanner.nextInt();
			System.out.println("Introdueix l'estat de l'activitat: (True/False)");
			boolean actiu = scanner.nextBoolean();
			scanner.nextLine();
			dades.println(nom + "," + edat + "," + actiu);
			System.out.println("Vols introduir un altre usuari? s/n");
			resposta = scanner.nextLine();
		} while (resposta.equalsIgnoreCase("s"));
		dades.close();
		fitxer.close();
	}

	public static void llegirFitxer() throws IOException {
		FileReader fitxer;
		BufferedReader dades;
		fitxer = new FileReader("usuaris.txt");
		dades = new BufferedReader(fitxer);
		String linia;
		while ((linia = dades.readLine()) != null) {
			String[] parts = linia.split(",");
			String nom = parts[0];
			int edat = Integer.parseInt(parts[1]);
			boolean actiu = Boolean.parseBoolean(parts[2]);
			System.out.println("Nom: " + nom + ", Edat: " + edat + ", Actiu: " + actiu);
		}
		dades.close();
		fitxer.close();
	}

	public static void eliminarUsuari(Scanner scanner) throws IOException {
		FileReader fitxer;
		BufferedReader dades;
		FileWriter fitxerTemp;
		PrintWriter dadesTemp;
		fitxer = new FileReader("usuaris.txt");
		dades = new BufferedReader(fitxer);
		fitxerTemp = new FileWriter("usuarisTemp.txt");
		dadesTemp = new PrintWriter(fitxerTemp);
		System.out.println("Introdueix el nom de l'usuari que vols eliminar:");
		String nom = scanner.nextLine();
		boolean eliminat = false;
		String linia;
		while ((linia = dades.readLine()) != null) {
			String[] parts = linia.split(",");
			if (parts[0].equalsIgnoreCase(nom) && !Boolean.parseBoolean(parts[2])) {
				eliminat = true;
			} else {
				dadesTemp.println(linia);
			}
		}
		dades.close();
		fitxer.close();
		dadesTemp.close();
		fitxerTemp.close();
		if (eliminat) {
			File fitxerOriginal = new File("usuaris.txt");
			File fitxerNou = new File("usuarisTemp.txt");
			fitxerOriginal.delete();
			fitxerNou.renameTo(fitxerOriginal);
			System.out.println("Usuari eliminat correctament.");
		} else {
			System.out.println("No s'ha trobat l'usuari o l'usuari està actiu.");
		}
	}
}
