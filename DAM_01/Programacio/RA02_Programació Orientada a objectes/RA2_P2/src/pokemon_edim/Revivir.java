package pokemon_edim;

public class Revivir extends Objecte {
	
	int quantitatVida;
	
	//constructor
	public Revivir(String nom, int quantitat, int quantitatVida, int preu) {
        super(nom, quantitat, preu);
        this.quantitatVida = quantitatVida;
    }

	@Override
    public void aplicar(PokemonEntrenador pokemon) {
        if (pokemon.getVidaActual() <= 0) {
            pokemon.setVidaActual(pokemon.getVidaMaxima() / 2);
            System.out.println(pokemon.getNom() + " ha estat revifat amb la meitat de vida.");
        } else {
            System.out.println(pokemon.getNom() + " no està KO. El revivir no s'ha utilitzat.");
        }
    }
	
}
