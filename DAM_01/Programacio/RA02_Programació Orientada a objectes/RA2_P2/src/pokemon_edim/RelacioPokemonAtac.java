package pokemon_edim;
public class RelacioPokemonAtac {

	private int idPokemon;
	private int idAtac;
	
	//constructor
	
	public RelacioPokemonAtac(int idPokemon, int idAtac) {
        this.idPokemon = idPokemon;
        this.idAtac = idAtac;
    }

	public int getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(int idPokemon) {
		this.idPokemon = idPokemon;
	}

	public int getIdAtac() {
		return idAtac;
	}

	public void setIdAtac(int idAtac) {
		this.idAtac = idAtac;
	}
	
	public static void mostrarInfo(RelacioPokemonAtac relacio) {
		System.out.println("ID Pokemon: " + relacio.getIdPokemon() + " ID Atac: " + relacio.getIdAtac());
	}
	
}
