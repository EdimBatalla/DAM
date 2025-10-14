//1. Gimnasos:
//Crear la classe Gimnas, que representarà cada gimnàs del joc. Cada gimnàs
//tindrà els següents atributs:
//
//■ idGimnas: Identificador únic del gimnàs.
//■ nom: Nom del gimnàs.
//■ tipus: Tipus especialitzat del gimnàs (Foc, Aigua, Planta, etc.).
//■ idEntrenador: Identificador de l'entrenador líder del gimnàs.
//■ nivellBase: Nivell base del gimnàs, que augmentarà
package pokemon_edim;

public class Gimnas {
	
	private int idGimnas;
	private String nom;
	private	String tipus;
	private int idEntrenador;
	private int nivellBase;
	
		
	public Gimnas(int idGimnas, String nom, String tipus, int idEntrenador, int nivellBase) {
		this.idGimnas = idGimnas;
		this.nom = nom;
		this.tipus = tipus;
		this.idEntrenador = idEntrenador;
		this.nivellBase = nivellBase;
	}

	public int getIdGimnas() {
		return idGimnas;
	}

	public void setIdGimnas(int idGimnas) {
		this.idGimnas = idGimnas;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public int getNivellBase() {
		return nivellBase;
	}

	public void setNivellBase(int nivellBase) {
		this.nivellBase = nivellBase;
	}
	
	public static void mostrarInfo(Gimnas gimnas) {
	    System.out.println("ID: " + gimnas.getIdGimnas());
	    System.out.println("Nom: " + gimnas.getNom());
	    System.out.println("Tipus: " + gimnas.getTipus());
	    System.out.println("ID Entrenador: " + gimnas.getIdEntrenador());
	    System.out.println("Nivell Base: " + gimnas.getNivellBase());
	}
}