package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class txt_exercici_03 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String resposta;
		do {
			FileWriter fitxer;
			PrintWriter dades;
			fitxer = new FileWriter("magatzem.txt", true);
			dades = new PrintWriter(fitxer);
			System.out.println("Introdueix el nom del producte:");
			String nom = scanner.nextLine();
			System.out.println("Introdueix la cuantitat d'aquest producte:");
			int quantitat = scanner.nextInt();
			System.out.println("Introdueix el preu d'aquest producte:");
			double preu = scanner.nextDouble();
			scanner.nextLine();
			dades.println(nom + "," + quantitat + "," + preu);
			dades.close();
			fitxer.close();
			System.out.println("Vols introduir un altre producte? s/n");
			resposta = scanner.nextLine();
		} while (resposta.equalsIgnoreCase("s"));
		llegirFitxer();
		scanner.close();
	}

	public static void llegirFitxer() throws IOException {
		FileReader fitxer;
		BufferedReader dades;
		fitxer = new FileReader("magatzem.txt");
		dades = new BufferedReader(fitxer);
		String linia;
		while ((linia = dades.readLine()) != null) {
			String[] parts = linia.split(",");
			String nom = parts[0];
			int quantitat = Integer.parseInt(parts[1]);
			double preu = Double.parseDouble(parts[2]);
			System.out.println("Nom: " + nom + ", Quantitat: " + quantitat + ", PVP: " + preu);
		}
		dades.close();
		fitxer.close();
	}
}
