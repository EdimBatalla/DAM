package p1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class binaris_exercici_02 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String nomFitxer = "puntuacions.bin";
		System.out.println("Introdueix la nova puntuació");
		int puntuacio = scanner.nextInt();

		FileOutputStream fitxer;
		DataOutputStream dades;
		fitxer = new FileOutputStream(nomFitxer, true);
		dades = new DataOutputStream(fitxer);
		dades.writeInt(puntuacio);
		dades.close();
		fitxer.close();
		llegirFitxer();
		scanner.close();
	}

	public static void llegirFitxer() throws IOException {
		String nomFitxer = "puntuacions.bin";
		FileInputStream fitxer;
		DataInputStream dades;
		fitxer = new FileInputStream(nomFitxer);
		dades = new DataInputStream(fitxer);
		System.out.println("Les puntuacions guardades són:");

		while (dades.available() > 0) {
			int puntuacio = dades.readInt();
			System.out.println(puntuacio);
		}
		dades.close();
		fitxer.close();
	}
}
