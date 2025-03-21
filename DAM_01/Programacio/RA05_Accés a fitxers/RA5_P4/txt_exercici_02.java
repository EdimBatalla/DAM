package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class txt_exercici_02 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String resposta;
		do {
			FileWriter fitxer;
			PrintWriter dades;
			fitxer = new FileWriter("alumnes.txt", true);
			dades = new PrintWriter(fitxer);

			System.out.println("Introdueix el nom d'un alumne:");
			String alumne = scanner.nextLine();
			dades.println(alumne);
			dades.close();
			fitxer.close();
			System.out.println("Vols introduir un altre alumne? s/n");
			resposta = scanner.nextLine();
		} while (resposta.equalsIgnoreCase("s"));
		llegirFitxer();
		scanner.close();
	}

	public static void llegirFitxer() throws IOException {
		FileReader fitxer;
		BufferedReader dades;
		fitxer = new FileReader("alumnes.txt");
		dades = new BufferedReader(fitxer);
		String linia;
		int comptador = 0;
		System.out.println("\nLlista d'alumnes:");
		while ((linia = dades.readLine()) != null) {
			System.out.println(linia);
			comptador++;
		}

		System.out.println("\nNúmero total d'alumnes: " + comptador);
		dades.close();
		fitxer.close();
	}
}
