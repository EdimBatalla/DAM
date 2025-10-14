package pokemon_edim;

public class Pokeball extends Objecte {
	
	int ratio;
	
	//constructor
	public Pokeball(String nom, int quantitat, int ratio, int preu) {
        super(nom, quantitat, preu);
        this.ratio = ratio;
    }

	@Override
    public void aplicar(PokemonEntrenador pokemon) {
        // Normalment no s'aplica sobre un Pokémon propi, sinó per capturar
        System.out.println("Has llançat una Pokeball!");
    }
}

