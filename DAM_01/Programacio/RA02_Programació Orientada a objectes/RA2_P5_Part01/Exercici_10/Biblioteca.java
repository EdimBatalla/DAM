package Exercici_10;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	private String nom;
	Scanner scanner = new Scanner(System.in);
	ArrayList<Llibre> llibres = new ArrayList<Llibre>();

	public Biblioteca(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

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
		System.out.println("\nLlista de llibres de la biblioteca " + nom + ":");
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
		if (!trobat) {
			System.out.println("El llibre no s'ha trobat.");
		}
	}

	public Llibre prestarLlibre(String titol) {
		for (int i = 0; i < llibres.size(); i++) {
			Llibre llibre = llibres.get(i);
			if (llibre.getTitol().equalsIgnoreCase(titol)) {
				llibres.remove(i);
				return llibre;
			}
		}
		return null;
	}

	public void retornarLlibre(Llibre llibre) {
		llibres.add(llibre);
		System.out.println("El llibre " + llibre.getTitol() + " ha estat retornat a la biblioteca " + nom + ".");
	}

	public ArrayList<Llibre> getLlibres() {
		return llibres;
	}


	public String toString() {
		return "Biblioteca: " + nom;
	}
} 