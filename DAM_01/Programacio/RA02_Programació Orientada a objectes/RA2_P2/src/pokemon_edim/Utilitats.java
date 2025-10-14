package pokemon_edim;

import java.util.ArrayList;
import java.util.Random;

public class Utilitats {
	
	public static Pokemon buscarPokemonsPerId(ArrayList<Pokemon> llista, int id) {
	   
		for (Pokemon poke : llista) {
	        if (poke.getIdPokemon() == id) {
	            return poke;
	        }
	    }
	    return null;
	}
	
	public static int random() {
		Random random = new Random();
		return random.nextInt(101);
	}
	
	public static int randomZeroUno() {
		Random random = new Random();
		return random.nextInt(2);
	}
	
}