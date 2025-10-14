package pokemon_edim;

public class Pokemon {

	private int idPokemon;
	private String nom;
	private String tipus;
	private int nivell;
	private int vidaActual;
	private int vidaMaxima;
	private int atac;
	private int defensa;
	private Atac[] atacsPokemon = new Atac[4];
	
	//constructor
	public Pokemon(int idPokemon, String nom, String tipus, int nivell, int vidaMaxima, int atac, int defensa) {
		this.idPokemon = idPokemon;
		this.nom = nom;
		this.tipus = tipus;
		this.nivell = nivell;
		this.vidaMaxima = vidaMaxima;
		this.vidaActual = vidaMaxima; // Vida plena
		this.atac = atac;
		this.defensa = defensa;
		this.atacsPokemon = new Atac[4];
	}

	//Constructor per capturas
	public Pokemon(int idPokemon, String nom, String tipus, int nivell, int vidaActual, int vidaMaxima, int atac, int defensa) {
		this.idPokemon = idPokemon;
		this.nom = nom;
		this.tipus = tipus;
		this.nivell = nivell;
		this.vidaActual = vidaActual;     // Es conserva la vidaActual del pokemon salvatje
		this.vidaMaxima = vidaMaxima;
		this.atac = atac;
		this.defensa = defensa;
		this.atacsPokemon = new Atac[4];
	}
	
	public int getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(int idPokemon) {
		this.idPokemon = idPokemon;
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

	public int getNivell() {
		return nivell;
	}

	public void setNivell(int nivell) {
		this.nivell = nivell;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}
	
	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}

	public int getAtac() {
		return atac;
	}

	public void setAtac(int atac) {
		this.atac = atac;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	public Atac[] getAtacsPokemon() {
		return atacsPokemon;
	}
	
	public void setAtacsPokemon(Atac[] atacs) {
		this.atacsPokemon = atacs;
	}
	
	public static void mostrarInfo(Pokemon pokemon) {
	    System.out.println("ID: " + pokemon.getIdPokemon());
	    System.out.println("Nom: " + pokemon.getNom());
	    System.out.println("Tipus: " + pokemon.getTipus());
	    System.out.println("Nivell: " + pokemon.getNivell());
	    System.out.println("Vida: " + pokemon.getVidaMaxima());
	    System.out.println("Atac: " + pokemon.getAtac());
	    System.out.println("Defensa: " + pokemon.getDefensa());
	}
	
	public static void mostrarInfoBatalla(Pokemon pokemon) {
	    System.out.println(pokemon.getNom() + " - Nivell: " + pokemon.getNivell());
	}
	
	public static void mostrarAtacs(Pokemon pokemon) {
	    Atac[] atacs = pokemon.getAtacsPokemon();

	    System.out.println("\nAtacs assignats al Pokémon: " + pokemon.getNom());

	    for (int i = 0; i < atacs.length; i++) {
	        Atac att = atacs[i];
	        if (att != null) {
	            System.out.println("	" + (i + 1) + ". " + att.getNom() + " [Potencia:" + att.getPotencia() + " | Precisio:" + att.getPrecisio() + " | Tipus:" + att.getTipus() + " | PPs:" + att.getUsosActuals() + "/" + att.getUsosMaxims() + "]");
	        }
	    }
	}
	
	public void pujarNivell() {
		setNivell(this.getNivell() + 1);
		setVidaMaxima(this.getVidaMaxima() + 3);
		setVidaActual(this.getVidaMaxima());
		setAtac(this.getAtac() + 2);
		setDefensa(this.getDefensa() + 2);
	}
	
	public void ordenarPotenciaAtacs() {
		for (int i=0; i<atacsPokemon.length; i++) {
			for (int j=i+1; j<atacsPokemon.length; j++) {
				if (atacsPokemon[i].getPotencia() < atacsPokemon[j].getPotencia()) {
					Atac atacTemp = atacsPokemon[i];
					atacsPokemon[i] = atacsPokemon[j];
					atacsPokemon[j] = atacTemp;
				}
			}
			
		}
	}
	
}