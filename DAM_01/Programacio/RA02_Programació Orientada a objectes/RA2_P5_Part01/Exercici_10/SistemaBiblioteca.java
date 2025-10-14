package Exercici_10;

import java.util.ArrayList;

public class SistemaBiblioteca {
	private ArrayList<Biblioteca> biblioteques;
	private ArrayList<Usuari> usuaris;

	public SistemaBiblioteca() {
		this.biblioteques = new ArrayList<>();
		this.usuaris = new ArrayList<>();
	}

	public void afegirBiblioteca(Biblioteca biblio) {
		biblioteques.add(biblio);
	}

	public void afegirUsuari(Usuari usuari) {
		usuaris.add(usuari);
	}

	public void mostrarBiblioteques() {
		for (int i = 0; i < biblioteques.size(); i++) {
			System.out.println((i + 1) + ". " + biblioteques.get(i).getNom());
		}
	}

	public void mostrarUsuaris() {
		for (int i = 0; i < usuaris.size(); i++) {
			System.out.println((i + 1) + ". " + usuaris.get(i).getNom());
		}
	}

	public ArrayList<Biblioteca> getBiblioteques() {
		return biblioteques;
	}

	public ArrayList<Usuari> getUsuaris() {
		return usuaris;
	}

	public void buscarLlibreGlobal(String titol) {
		boolean trobat = false;
		for (Biblioteca biblio : biblioteques) {
			for (Llibre llibre : biblio.getLlibres()) {
				if (llibre.getTitol().equalsIgnoreCase(titol)) {
					System.out.println("Trobat a la biblioteca " + biblio.getNom() + ":");
					llibre.mostrarInfo();
					trobat = true;
				}
			}
		}
		if (!trobat) {
			System.out.println("No s'ha trobat el llibre a cap biblioteca.");
		}
	}
} 
