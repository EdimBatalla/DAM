
package Exercici_08;

import java.util.ArrayList;

public class Usuari {

	private String nom;
	private int edat;
	private ArrayList<Llibre> llibresPrestats;

	public Usuari (String nom, int edat) {
		this.nom = nom;
		this.edat = edat;
		this.llibresPrestats = new ArrayList<Llibre>();
	}
	
	public String getNom() { return nom; }
	public void setNom (String nom) { this.nom = nom; }
	public int getEdat() { return edat; }
	public void setEdat (int edat) { this.edat = edat; }
	public ArrayList<Llibre> getLlibresPrestats() { return llibresPrestats; }
	public void setLlibresPrestats (ArrayList<Llibre> llibresPrestats) { this.llibresPrestats = llibresPrestats; }
	
	 public void afegirLlibrePrestats(Llibre llibre) {
	        llibresPrestats.add(llibre);
	        System.out.println("S'ha afegit el llibre \"" + llibre.getTitol() + "\" als llibres prestats de " + nom);
	    }
}
