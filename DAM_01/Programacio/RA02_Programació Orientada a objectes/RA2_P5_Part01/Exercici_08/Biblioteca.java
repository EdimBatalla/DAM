package Exercici_08;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	Scanner scanner = new Scanner(System.in);
	ArrayList<Llibre> llibres = new ArrayList<Llibre>();

	public void llibresIntroduits(Llibre llibre) {
		llibres.add(llibre);
	}

	public void afegirLlibre() {
		String resposta;
		do {
			System.out.println("\nIntrodueix la informacio del llibre ");
			System.out.println("Títol: ");
			String titol = scanner.nextLine();
			System.out.println("Autor: ");
			String autor = scanner.nextLine();
			System.out.println("Any de la publicació:");
			int anyPublicacio = scanner.nextInt();
			scanner.nextLine();
			llibres.add(new Llibre(titol, autor, anyPublicacio));
			System.out.println("vols introduir un altre llibre? (s/n)");
			resposta = scanner.nextLine();
		} while (resposta.equalsIgnoreCase("s"));
	}

	public void mostrarLlibres() {
		System.out.println("\nLlista de llibre intorduïts:");
		for (Llibre llibre : llibres) {
			llibre.mostrarInfo();
		}
	}

	public void buscarLlibre() {
		System.out.println("\nIntrodueix el títol del llibre a buscar:");
		String titolBuscar = scanner.nextLine();
		boolean trobat = false;
		for (Llibre llibre : llibres) {
			if (titolBuscar.equalsIgnoreCase(llibre.getTitol())) {
				System.out.println("Llibre trobat:");
				llibre.mostrarInfo();
				trobat = true;
			}
		}
		if (trobat == false) {
			System.out.println("El llibre no s'ha trobat.");
		}
	}

	public Llibre prestarLlibre(String titol) {

		for (Llibre llibre : llibres) {
			if (llibre.getTitol().equalsIgnoreCase(titol)) {
				return llibre;
			}
		}
		return null;
	}
}
