package pokemon_edim;

public class RelacioEntrenadorPokemon {

	private int idEntrenador;
	private int idPokemon;
	
	RelacioEntrenadorPokemon (int idEntrenador, int idPokemon) {
		this.idEntrenador = idEntrenador;
		this.idPokemon = idPokemon;
	}
	
	public int getIdEntrenador() {
		return idEntrenador;
	}
	
	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}
	
	public int getIdPokemon() {
		return idPokemon;
	}
	
	public void setIdPokemon(int idPokemon) {
		this.idPokemon = idPokemon;
	}
	
	public static void mostrarInfo(RelacioEntrenadorPokemon relacio) {
		System.out.println("ID Entrenador: " + relacio.getIdEntrenador() + "ID Pokemon: " + relacio.getIdPokemon());	
	}
}
