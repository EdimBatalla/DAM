package pokemon_edim;

public class Pocio extends Objecte {
	
	private int quantitatCura;
	
	//constructor
	 public Pocio( String nom, int quantitat, int quantitatCura, int preu) {
	        super(nom, quantitat, preu);
	        this.quantitatCura = quantitatCura;
	    }

	 
	 
	 @Override
	    public void aplicar(PokemonEntrenador pokemon) {
	        int novaVida = Math.min(pokemon.getVidaActual() + quantitatCura, pokemon.getVidaMaxima());
	        pokemon.setVidaActual(novaVida);
	        System.out.println(pokemon.getNom() + " s'ha curat fins a " + novaVida + " de vida.");
	 }
}
