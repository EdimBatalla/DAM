package pokemon_edim;

public class Objecte {

	private String nom;
	private	String tipus;
	private int quantitat;
	private int preu;
	
	// constructor
	public Objecte(String nom, int quantitat, int preu) {
        this.nom = nom;
        this.quantitat = quantitat;
        this.preu = preu;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public int getPreu() {
		return preu;
	}

	public void setPreu(int preu) {
		this.preu = preu;
	}
	
	
}
