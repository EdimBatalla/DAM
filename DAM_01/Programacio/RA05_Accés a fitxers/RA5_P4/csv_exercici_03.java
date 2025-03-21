package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class csv_exercici_03 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int opcio;
		do {
			System.out.println("-----Menu Usuaris------");
			System.out.println("1. Afegir estudiants.");
			System.out.println("2. Mostrar estudiants.");
			System.out.println("3. Mostrar quants estudiants han aprovat i quants han suspès.");
			System.out.println("4. Eliminar estudiant.");
			System.out.println("5. Modifical nota d'un mòdul.");
			System.out.println("6. Sortir.");
			opcio = scanner.nextInt();
			scanner.nextLine();
			switch (opcio) {
			case 1:
				afegirEstudiants(scanner);
				break;
			case 2:
				mostrarEstudiants();
				break;
			case 3:
				mostrarAprovats();
				break;
			case 4:
				eliminarEstudiants(scanner);
				break;
			case 5:
				modificarNota(scanner);
				break;
			case 6:
				System.out.println("Sortint del programa...");
				break;
			default:
				System.out.println("Opció invàlida. Torna a intentar.");
			}
			System.out.println();
		} while (opcio != 6);
		scanner.close();
	}

	public static void afegirEstudiants(Scanner scanner) throws IOException {
		FileWriter fitxer;
		PrintWriter dades;
		fitxer = new FileWriter("estudiants.csv", true);
		dades = new PrintWriter(fitxer);
		String resposta;
		do {
			System.out.println("Introdueix el nom del estudiant:");
			String nom = scanner.nextLine();
			System.out.println("Introdueix el cognom del estudiant:");
			String cognom = scanner.nextLine();
			System.out.println("Introdueix la nota del estudiant:");
			double nota = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Introdueix el mòdul:");
			String modul = scanner.nextLine();
			System.out.println("Introdueix si ha aprovat (true/false):");
			boolean aprovat = scanner.nextBoolean();
			scanner.nextLine();
			dades.println(nom + "," + cognom + "," + nota + "," + modul + "," + aprovat);
			System.out.println("Vols introduir un altre estudiant? s/n");
			resposta = scanner.nextLine();
		} while (resposta.equalsIgnoreCase("s"));
		dades.close();
		fitxer.close();
	}

	public static void mostrarEstudiants() throws IOException {
		FileReader fitxer;
		BufferedReader dades;
		fitxer = new FileReader("estudiants.csv");
		dades = new BufferedReader(fitxer);
		String linia;
		while ((linia = dades.readLine()) != null) {
			String[] camps = linia.split(",");
			System.out.println("Nom: " + camps[0] + " Cognom: " + camps[1] + " Nota: " + camps[2] + " Mòdul: "
					+ camps[3] + " Aprovat: " + camps[4]);
		}
		dades.close();
		fitxer.close();
	}

	public static void mostrarAprovats() throws IOException {
		FileReader fitxer;
		BufferedReader dades;
		fitxer = new FileReader("estudiants.csv");
		dades = new BufferedReader(fitxer);
		String linia;
		int aprovats = 0;
		int suspesos = 0;
		while ((linia = dades.readLine()) != null) {
			String[] camps = linia.split(",");
			if (camps[4].equalsIgnoreCase("true")) {
				aprovats++;
			} else {
				suspesos++;
			}
		}
		System.out.println("Estudiants aprovats: " + aprovats);
		System.out.println("Estudiants suspesos: " + suspesos);
		dades.close();
		fitxer.close();
	}

	public static void eliminarEstudiants(Scanner scanner) throws IOException {
		System.out.println("Introdueix el nom de l'estudiant que vols eliminar:");
		String nom = scanner.nextLine();
		System.out.println("Introdueix el cognom de l'estudiant que vols eliminar:");
		String cognom = scanner.nextLine();
		FileReader fitxer;
		BufferedReader dades;
		FileWriter fitxerTemp;
		PrintWriter dadesTemp;
		fitxer = new FileReader("estudiants.csv");
		dades = new BufferedReader(fitxer);
		fitxerTemp = new FileWriter("estudiantsTemp.csv");
		dadesTemp = new PrintWriter(fitxerTemp);
		boolean eliminat = false;
		String linia;
		while ((linia = dades.readLine()) != null) {
			String[] camps = linia.split(",");
			if (camps[0].equalsIgnoreCase(nom) && camps[1].equalsIgnoreCase(cognom)) {
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
			File fitxerOriginal = new File("estudiants.csv");
			File fitxerNou = new File("estudiantsTemp.csv");
			fitxerOriginal.delete();
			fitxerNou.renameTo(fitxerOriginal);
			System.out.println("Estudiant eliminat correctament.");
		} else {
			System.out.println("No s'ha trobat l'estudiant.");
		}
	}

	public static void modificarNota(Scanner scanner) throws IOException {
		System.out.println("Introdueix el nom del estudiant del qual vols modificar una nota:");
		String nom = scanner.nextLine();
		System.out.println("Introdueix el cognom de l'estudiant del qual vols modificar una nota:");
		String cognom = scanner.nextLine();
		System.out.println("Introdueix el mòdul del qual vols modificar la nota:");
		String modul = scanner.nextLine();
		System.out.println("Introdueix el nou valor de la nota:");
		double novaNota = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Introdueix si ha aprovat (true/false):");
		boolean aprovat = scanner.nextBoolean();
		scanner.nextLine();
		FileReader fitxer = new FileReader("estudiants.csv");
		BufferedReader dades = new BufferedReader(fitxer);
		FileWriter fitxerTemp = new FileWriter("estudiantsTemp.csv");
		PrintWriter dadesTemp = new PrintWriter(fitxerTemp);
		boolean modificat = false;
		String linia;
		while ((linia = dades.readLine()) != null) {
			String[] camps = linia.split(",");
			if (camps[0].equalsIgnoreCase(nom) && camps[1].equalsIgnoreCase(cognom)
					&& camps[3].equalsIgnoreCase(modul)) {
				dadesTemp.println(nom + "," + cognom + "," + novaNota + "," + modul + "," + aprovat);
				modificat = true;
			} else {
				dadesTemp.println(linia);
			}
		}
		dades.close();
		fitxer.close();
		dadesTemp.close();
		fitxerTemp.close();
		if (modificat) {
			File fitxerOriginal = new File("estudiants.csv");
			File fitxerNou = new File("estudiantsTemp.csv");
			fitxerOriginal.delete();
			fitxerNou.renameTo(fitxerOriginal);
			System.out.println("La nota s'ha modificat correctament.");
		} else {
			System.out.println("No s'ha trobat l'estudiant o el mòdul indicat.");
		}
	}
}
