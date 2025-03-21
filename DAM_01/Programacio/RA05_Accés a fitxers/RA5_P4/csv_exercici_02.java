package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class csv_exercici_02 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int opcio;
		do {
			System.out.println("-----Menu Usuaris------");
			System.out.println("1. Registrar llibre.");
			System.out.println("2. Consluta llibres.");
			System.out.println("3. Sortir.");
			opcio = scanner.nextInt();
			scanner.nextLine();
			switch (opcio) {
			case 1:
				registrarLlibre(scanner);
				break;
			case 2:
				consultarLlibres();
				break;
			case 3:
				System.out.println("Sortint del programa...");
				break;
			default:
				System.out.println("Opció invàlida. Torna a intentar.");
			}

			System.out.println();
		} while (opcio != 3);
		scanner.close();
	}

	public static void registrarLlibre(Scanner scanner) throws IOException {
		FileWriter fitxer;
		PrintWriter dades;
		fitxer = new FileWriter("llibres.csv", true);
		dades = new PrintWriter(fitxer);
		String resposta;
		do {
			System.out.println("Introdueix el títol:");
			String titol = scanner.nextLine();
			System.out.println("Introdueix l'autor:");
			String autor = scanner.nextLine();
			System.out.println("Introdueix l'any de publicació");
			int anyPublicacio = scanner.nextInt();
			scanner.nextLine();
			dades.println(titol + "," + autor + "," + anyPublicacio);
			System.out.println("Vols introduir un altre llibre? s/n");
			resposta = scanner.nextLine();
		} while (resposta.equalsIgnoreCase("s"));
		dades.close();
		fitxer.close();
	}

	public static void consultarLlibres() throws IOException {
		FileReader fitxer;
		BufferedReader dades;
		fitxer = new FileReader("llibres.csv");
		dades = new BufferedReader(fitxer);
		String linia;
		dades.readLine();

		while ((linia = dades.readLine()) != null) {
			String[] parts = linia.split(",");
			String titol = parts[0].trim();
			String autor = parts[1].trim();
			int any = Integer.parseInt(parts[2].trim());
			System.out.println("Títol: " + titol + ", Autor: " + autor + ", Any publicació: " + any);
		}
		dades.close();
		fitxer.close();
	}
}
