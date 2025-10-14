package pokemon_edim;

public class Elixir extends Objecte {

	int quantitatUsos; //usos a restaurar
	
	//constructor
	public Elixir(String nom, int quantitat, int quantitatUsos, int preu) {
		super(nom, quantitat, preu);
		this.quantitatUsos = quantitatUsos;
}
	
	@Override
    public void aplicar(PokemonEntrenador pokemon) {
        // Exemple: restaura punts d'atac dels atacs (si tens aquest sistema implementat)
        System.out.println("S'han restaurat els usos dels atacs de " + pokemon.getNom() + ".");
	}	
}
