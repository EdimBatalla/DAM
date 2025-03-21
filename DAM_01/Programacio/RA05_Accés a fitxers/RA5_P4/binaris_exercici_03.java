package p1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class binaris_exercici_03 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String nomFitxer = "nomsDeJugadors.bin";
		String nomFitxerDos = "puntuacionsJugadors.bin";
		String resposta;
		do {
			System.out.println("Introdueix el nom del jugador");
			String nom = scanner.nextLine();
			System.out.println("Introdueix la nova puntuació");
			int puntuacio = scanner.nextInt();
			scanner.nextLine();
			FileOutputStream fitxer;
			DataOutputStream dades;
			fitxer = new FileOutputStream(nomFitxer, true);
			dades = new DataOutputStream(fitxer);
			FileOutputStream fitxerDos;
			DataOutputStream dadesDos;
			fitxerDos = new FileOutputStream(nomFitxerDos, true);
			dadesDos = new DataOutputStream(fitxerDos);
			dades.writeUTF(nom);
			dadesDos.writeInt(puntuacio);
			dades.close();
			fitxer.close();
			dadesDos.close();
			fitxerDos.close();
			System.out.println("Vols introduir un altre puntuació? s/n");
			resposta = scanner.nextLine();
		} while (resposta.equalsIgnoreCase("s"));
		llegirFitxer();
		scanner.close();
	}

	public static void llegirFitxer() throws IOException {
		String nomFitxer = "nomsDeJugadors.bin";
		String nomFitxerDos = "puntuacionsJugadors.bin";
		FileInputStream fitxer;
		DataInputStream dades;
		fitxer = new FileInputStream(nomFitxer);
		dades = new DataInputStream(fitxer);
		FileInputStream fitxerDos;
		DataInputStream dadesDos;
		fitxerDos = new FileInputStream(nomFitxerDos);
		dadesDos = new DataInputStream(fitxerDos);
		System.out.println("Les puntuacions guardades són:");
		while (dades.available() > 0) {
			String nom = dades.readUTF();
			int puntuacio = dadesDos.readInt();
			System.out.println(nom + ": " + puntuacio);
		}
		dades.close();
		fitxer.close();
		dadesDos.close();
		fitxerDos.close();
	}
}
