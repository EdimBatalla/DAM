package pokemon_edim;

public class Medalla {

	private int idMedalla;
	private String nom;
	private	String tipus;
	private boolean aconseguida;
	
	//constructor
	public Medalla(int idMedalla, String nom, String tipus, boolean aconseguida) {
	    this.idMedalla = idMedalla;
	    this.nom = nom;
	    this.tipus = tipus;
	    this.aconseguida = aconseguida;
}

	public int getIdMedalla() {
		return idMedalla;
	}

	public void setIdMedalla(int idMedalla) {
		this.idMedalla = idMedalla;
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

	public boolean isAconseguida() {
		return aconseguida;
	}

	public void setAconseguida(boolean aconseguida) {
		this.aconseguida = aconseguida;
	}
	
	
}