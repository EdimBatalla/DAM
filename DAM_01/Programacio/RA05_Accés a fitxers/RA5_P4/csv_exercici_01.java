package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class csv_exercici_01 {
	public static void main(String[] args) throws IOException {
		FileWriter fitxer;
		PrintWriter dades;
		fitxer = new FileWriter("noms.csv");
		dades = new PrintWriter(fitxer);
		dades.println("Marc");
		dades.println("Pere");
		dades.println("Andreu");
		dades.close();
		fitxer.close();
		llegir();
	}

	public static void llegir() throws IOException {
		FileReader fitxer;
		BufferedReader dades;
		fitxer = new FileReader("noms.csv");
		dades = new BufferedReader(fitxer);
		String linia = dades.readLine();
		while (linia != null) {
			System.out.println(linia);
			linia = dades.readLine();
		}
		dades.close();
		fitxer.close();
	}
}
