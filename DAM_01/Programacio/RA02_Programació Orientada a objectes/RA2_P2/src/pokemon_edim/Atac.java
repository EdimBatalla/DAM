package pokemon_edim;

public class Atac {

	private int idAtac;
	private String nom;
	private String tipus;
	private int potencia;
	private int precisio;
	private int usosMaxims;
	private int usosActuals;
	
	//constructor
	
	public Atac(int idAtac, String nom, String tipus, int potencia, int precisio, int usosMaxims) {
		this.idAtac = idAtac;
		this.nom = nom;
		this.tipus = tipus;
		this.potencia = potencia;
		this.precisio = precisio;
		this.usosMaxims = usosMaxims;
		this.usosActuals = usosMaxims; // Inicialitzem els usos actuals amb els usos màxims
	}

	public int getIdAtac() {
		return idAtac;
	}

	public void setIdAtac(int idAtac) {
		this.idAtac = idAtac;
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

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getPrecisio() {
		return precisio;
	}

	public void setPrecisio(int precisio) {
		this.precisio = precisio;
	}

	public int getUsosMaxims() {
		return usosMaxims;
	}

	public void setUsosMaxims(int usosMaxims) {
		this.usosMaxims = usosMaxims;
	}
	
	public int getUsosActuals() {
		return usosActuals;
	}

	public void setUsosActuals(int usosActuals) {
		this.usosActuals = usosActuals;
	}
	
	public static void mostrarInfo(Atac atac) {
		System.out.println("ID: " + atac.getIdAtac() + " Nom: " + atac.getNom() + " Tipus: " + atac.getTipus() + " Potencia: " + atac.getPotencia() + " Precisio: " + atac.getPrecisio() + " Usos Maxims: " + atac.getUsosMaxims());
	}		
	
	public void usar() {
		if (usosActuals > 0) {
			usosActuals--;
		}
	}
}