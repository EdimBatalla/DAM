//Subclasse: BatallaEntrenament (hereta de Batalla)
//○ Atributs addicionals:
//■ probabilitatCaptura: double → Probabilitat de capturar el
//Pokémon salvatge.
//■ probabilitatFugida: double → Probabilitat de poder fugir d’una
//batalla. // OPCIONAL
//○ Mètodes addicionals:
//■ capturarPokemon(): Permet intentar capturar el Pokémon amb
//una probabilitat d'èxit.
//■ fugir(): Permet al jugador escapar-se de la batalla si ho vol.
//■ generarPokemonAleatori(): Genera un Pokémon salvatge d'acord
//amb la zona del mapa on es troba el jugador.

package pokemon_edim;

import java.util.ArrayList;
import java.util.Random;

public class BatallaEntrenament extends Batalla {

	private double probCaptura;
	private double probFugida;

	// constructor
	public BatallaEntrenament(Entrenador jugador, Pokemon pokemonJugador, Pokemon pokemonRival,double[][] efectivitats) {
		super(jugador, pokemonJugador, pokemonRival, efectivitats);
		this.probCaptura = 0;
		this.probFugida = 0;
	}

	public double getProbabilitatCaptura() {
		return probCaptura;
	}

	public void setProbabilitatCaptura(double probabilitatCaptura) {
		this.probCaptura = probabilitatCaptura;
	}

	public double getProbabilitatFugida() {
		return probFugida;
	}

	public void setProbabilitatFugida(double probabilitatFugida) {
		this.probFugida = probabilitatFugida;
	}

	@Override
	public boolean capturarPokemon() {
		int vidaActual = getPokemonRival().getVidaActual();
		int vidaMax = getPokemonRival().getVidaMaxima();
		double probCapturar = 100 - (vidaActual * 100 / vidaMax);
		
		int random = Utilitats.random();
		System.out.println("Probabilitat de captura: " + probCapturar + "%");
		
		if (random <= probCapturar) {
			return true;
		} else {
			System.out.println("No has pogut capturar el Pokémon salvatge!");
			return false;
		}		
		}

	@Override
	public void fugir() {
		int probInicial = 45;
		int probFugir = probInicial + (getNumTurn() * 5);
		System.out.println("Probabilitat de fugida: " + probFugir + "%");

		if (Utilitats.random() < probFugir) {
			System.out.println("Has pogut fugir de la batalla!");
			Joc.menuJoc();
		} else {
			System.out.println("No has pogut fugir de la batalla!");
			tornRival();

		}

	}

	public static Pokemon generarPokemonAleatori(ArrayList<Pokemon> pokemons, String tipus) {
		ArrayList<Pokemon> pokemonsFiltrats = new ArrayList<>();
		int[] idsLlegendaris = { 144, 145, 146, 150, 151 };

		for (Pokemon poke : pokemons) {
			if (poke.getTipus().equalsIgnoreCase(tipus)) {
				boolean llegendari = false;
				for (int i = 0; i < idsLlegendaris.length; i++) {
					if (poke.getIdPokemon() == idsLlegendaris[i]) {
						llegendari = true;
						break;
					}
				}
				if (!llegendari) {
					pokemonsFiltrats.add(poke);
				}
			}
		}
		Random random = new Random();
		return pokemonsFiltrats.get(random.nextInt(pokemonsFiltrats.size()));
	}

	public static void ajustarNivellPokemon(Pokemon pokemonRival, Pokemon[] pokemonJugador) {
		int sumaNivells = 0;
		for (Pokemon poke : pokemonJugador) {
			if(poke!=null) {
			sumaNivells += poke.getNivell();
		}
		}

		int nivellMitja = sumaNivells / pokemonJugador.length;
		int random = (Utilitats.random() - 50) / 10; // -5 a +5
		int nivellAjustat = nivellMitja + random;

		while (pokemonRival.getNivell() < nivellAjustat) {
			pokemonRival.pujarNivell();
		}
	}
}