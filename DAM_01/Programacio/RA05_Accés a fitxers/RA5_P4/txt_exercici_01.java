package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class txt_exercici_01 {

	public static void main(String[] args) throws IOException {
		FileWriter fitxer;
		PrintWriter dades;
		fitxer = new FileWriter("tasques.txt");
		dades = new PrintWriter(fitxer);
		dades.println("despertarse");
		dades.println("esmorzar");
		dades.println("dormir");
		dades.close();
		fitxer.close();
		llegirFitxer();
	}

	public static void llegirFitxer() throws IOException {
		FileReader fitxer;
		BufferedReader dades;
		fitxer = new FileReader("tasques.txt");
		dades = new BufferedReader(fitxer);
		String linia;
		while ((linia = dades.readLine()) != null) {
			System.out.println(linia);
		}
		dades.close();
		fitxer.close();
	}
}
