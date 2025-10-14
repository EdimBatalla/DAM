//1. Superclasse: Batalla
//○ Atributs comuns:
//■ pokemonJugador: Pokemon → El Pokémon que utilitza el jugador.
//■ pokemonRival: Pokemon → El Pokémon amb qui es combat.
//tornJugador: boolean → Indica si és el torn del jugador o del
//rival.
//■ finalitzada: boolean → Indica si la batalla ha acabat.
//■ recompensa: int → Diners o objectes que es guanyen en acabar
//la batalla.
//
//○ Mètodes comuns (son orientatius).
//■ iniciarBatalla(): Comença la batalla.
//■ tornJugador(): Executa l'atac del jugador.
//■ tornRival(): Executa l'atac del rival.
//■ finalitzarBatalla(): Marca la batalla com a acabada i aplica les
//recompenses.

package pokemon_edim;

import java.util.ArrayList;
import static pokemon_edim.Joc.scanner;

public class Batalla {

	protected Entrenador jugador;
	protected Pokemon pokemonJugador;
	protected Pokemon pokemonRival;
	protected double[][] efectivitats;
	private boolean tornJugador;
	protected boolean finalitzada;
	private int recompensa;
	protected int numTurn;
	protected ArrayList<PokemonEntrenador> pokemonsParticipants;

	// constructor

	public Batalla(Entrenador jugador, Pokemon pokemonJugador, Pokemon pokemonRival, double[][] efectivitats) {
		this.jugador = jugador;
		this.pokemonJugador = pokemonJugador;
		this.pokemonRival = pokemonRival;
		this.efectivitats = efectivitats;
		this.tornJugador = true; // El torn comença amb el jugador
		this.finalitzada = false;
		this.recompensa = 0;
		this.numTurn = 1;
		this.pokemonsParticipants = new ArrayList<PokemonEntrenador>();
	}

	public Pokemon getPokemonJugador() {
		return pokemonJugador;
	}

	public void setPokemonJugador(Pokemon pokemonJugador) {
		this.pokemonJugador = pokemonJugador;
	}

	public Pokemon getPokemonRival() {
		return pokemonRival;
	}

	public void setPokemonRival(Pokemon pokemonRival) {
		this.pokemonRival = pokemonRival;
	}

	public boolean isTornJugador() {
		return tornJugador;
	}

	public void setTornJugador(boolean tornJugador) {
		this.tornJugador = tornJugador;
	}

	public boolean isFinalitzada() {
		return finalitzada;
	}

	public void setFinalitzada(boolean finalitzada) {
		this.finalitzada = finalitzada;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(int recompensa) {
		this.recompensa = recompensa;
	}

	public int getNumTurn() {
		return numTurn;
	}

	public void setNumTurn(int numTurn) {
		this.numTurn = numTurn;
	}

	public Entrenador getJugador() {
		return jugador;
	}

	public void setJugador(Entrenador jugador) {
		this.jugador = jugador;
	}

	public double[][] getEfectivitats() {
		return efectivitats;
	}

	public void setEfectivitats(double[][] efectivitats) {
		this.efectivitats = efectivitats;
	}

	public ArrayList<PokemonEntrenador> getPokemonsParticipants() {
		return pokemonsParticipants;
	}

	public void setPokemonsParticipants(ArrayList<PokemonEntrenador> pokemonsParticipants) {
		this.pokemonsParticipants = pokemonsParticipants;
	}

	public void iniciarBatalla() {
		
		if (pokemonJugador.getVidaActual() > 0) {
		System.out.println("\nComença una batalla Pokedam!");
		System.out.println("El teu primer PokeDam és " + pokemonJugador.getNom() + "!");
		
		if (pokemonJugador instanceof PokemonEntrenador) {
		    PokemonEntrenador primer = (PokemonEntrenador) pokemonJugador;
		    if (!pokemonsParticipants.contains(primer)) {
		        pokemonsParticipants.add(primer);
		    }
		}
		
		this.finalitzada = false;
		while (!this.finalitzada) {
			tornJugador(); 
		}
		}else {
		System.out.println("No pots iniciar la batalla.");
		System.out.println("El teu PokeDam principal està debilitat.");
		System.out.println("Ves a curar-los al centre PokeDam.");
		Joc.menuJoc();
	}
}
	public void tornJugador() {
		System.out.println("\nÉs el teu torn num. " + numTurn + ":");
		System.out.println("	1. Atacar.");
		System.out.println("	2. Objectes.");
		System.out.println("	3. Cambiar PokeDam.");
		System.out.println("	4. Fugir.");
		int opcio = scanner.nextInt();
		scanner.nextLine();

		switch (opcio) {
		case 1:
			Atac atacEscollit = escollirAtac(pokemonJugador);
			int dany = calcularDany(pokemonJugador, pokemonRival, atacEscollit, efectivitats);
			pokemonRival.setVidaActual(pokemonRival.getVidaActual() - dany);

			if (pokemonRival.getVidaActual() < 0) {
				pokemonRival.setVidaActual(0);
			}

			System.out.println("Has utilitzat " + atacEscollit.getNom() + "!");
			System.out.println(pokemonRival.getNom() + " ha rebut " + dany + " de dany. HP["
					+ pokemonRival.getVidaActual() + "/" + pokemonRival.getVidaMaxima() + "]");

			if (pokemonRival.getVidaActual() <= 0) {
				System.out.println(pokemonRival.getNom() + " ha estat derrotat!");
				pokemonRival.setVidaActual(0);
				calcularRecompensa();
				finalitzarBatalla();
			} else {
				tornRival();
			}
			break;
		case 2:
			utilitzarObjectes();
			break;
		case 3:
			cambiarPokemon();
			break;
		case 4:
			System.out.println("\nIntentes fugir...");
			fugir();
			break;
		default:
			System.out.println("Opció no vàlida");
			tornJugador();
			break;
		}
	}

	public Atac escollirAtac(Pokemon pokemonJugador) {
		Pokemon.mostrarAtacs(pokemonJugador);
		System.out.println("	5. Tornar.");
		System.out.println("\nEscull un atac:");
		int eleccio = scanner.nextInt() - 1;

		if (eleccio == 4) {
			tornJugador();
			return null;
		}

		else if (eleccio >= 0 && eleccio < 4) {
			Atac atacEscollit = pokemonJugador.getAtacsPokemon()[eleccio];

			if (atacEscollit.getUsosActuals() > 0) {
				atacEscollit.setUsosActuals(atacEscollit.getUsosActuals() - 1);
				return atacEscollit;
			} else {
				System.out.println("No es pot utilitzar més aquest atac.");
				return escollirAtac(pokemonJugador);
			}
		} else {
			System.out.println("Opció no vàlida.");
			return escollirAtac(pokemonJugador);
		}
	}

	public void tornRival() {

		System.out.println("\nTorn del rival:");

		pokemonRival.ordenarPotenciaAtacs();
		Atac atacRival = null;

		double porcentatgeVidaJugador = pokemonJugador.getVidaActual() * 100 / pokemonJugador.getVidaMaxima();
		double porcentatgeVidaRival = pokemonRival.getVidaActual() * 100 / pokemonRival.getVidaMaxima();

		int indexAtac = -1;

		if (Utilitats.random() > 40) { // ofensiu:
			if (porcentatgeVidaJugador <= 25) { // random entre 2 atacs mes potents
				indexAtac = Utilitats.randomZeroUno();

			} else if (porcentatgeVidaJugador < 75) { // random 30% atac mes potent
				if (Utilitats.random() >= 70) {
					indexAtac = 0;
				} else { // 70% = entre 2n i 3r atac mes potent
					indexAtac = Utilitats.randomZeroUno() + 1;
				}

			} else { // random entre 2n i 3r atac mes potent
				indexAtac = Utilitats.randomZeroUno() + 1;
			}

		} else { // defensiu:
			if (porcentatgeVidaRival <= 25) { // atac mes potent
				indexAtac = 0;

			} else if (porcentatgeVidaRival < 50) { // 2n atac potent
				indexAtac = 1;

			} else if (porcentatgeVidaRival < 75) { // 1r o 3r mes potents
				indexAtac = Utilitats.randomZeroUno() * 2;
			} else { // atac mes fluix
				indexAtac = 3;
			}
		}

		while (indexAtac >= 0 && indexAtac < 4) {
			if (pokemonRival.getAtacsPokemon()[indexAtac].getUsosActuals() > 0) {
				atacRival = pokemonRival.getAtacsPokemon()[indexAtac];
				break;
			} else {
				indexAtac--;
			}
		}
		if (indexAtac == -1) {
			pokemonRival.setVidaActual(pokemonRival.getVidaActual() + 20);
			;
			if (pokemonRival.getVidaActual() > pokemonRival.getVidaMaxima()) {
				pokemonRival.setVidaActual(pokemonRival.getVidaMaxima());
			}
			System.out.println("El rival s'ha curat 20 HP.");
			numTurn++;
			tornJugador();
			return;
		}
		System.out.println(pokemonRival.getNom() + " ha utilitzat " + atacRival.getNom() + "!");

		if (calcularPrecisio(atacRival) == 0) { // calcul precisio
			System.out.println("L'atac ha fallat!");
			numTurn++;
			tornJugador();
		} else {
			int dany = calcularDany(pokemonRival, pokemonJugador, atacRival, efectivitats);
			pokemonJugador.setVidaActual(pokemonJugador.getVidaActual() - dany);
			if (pokemonJugador.getVidaActual() < 0) {
				pokemonJugador.setVidaActual(0);
			}
			System.out.println("EL teu PokeDam: " + pokemonJugador.getNom() + " ha rebut " + dany + " de dany. HP["
					+ pokemonJugador.getVidaActual() + "/" + pokemonJugador.getVidaMaxima() + "]");

			if (pokemonJugador.getVidaActual() <= 0) {
				System.out.println("El teu PokeDam " + pokemonJugador.getNom() + " ha estat derrotat!");
				numTurn++;
				cambiarPokemon();
				return;
			}
			numTurn++;
			tornJugador();
		}
	}

	public void cambiarPokemon() {
		Pokemon[] pokemonsJugador = jugador.getPokemons();
		int contador = 0;		
		int pokemonVius = 0;

		for (Pokemon poke : pokemonsJugador) {
			if (poke != null && poke.getVidaActual() > 0) {
				pokemonVius++;
			}
		}
		if (pokemonVius <= 0) {
			System.out.println("\nNo tens PokeDams disponibles per lluitar.");
			finalitzarBatalla();
		}
		System.out.println("\nEscull un PokeDam:");
		for (int i = 0; i < pokemonsJugador.length; i++) {
			if (pokemonsJugador[i] != null) {
				contador ++;
				System.out.println("	" +(i + 1) + ". " + pokemonsJugador[i].getNom() + " - Nivell: "
						+ pokemonsJugador[i].getNivell() + " - Vida: " + pokemonsJugador[i].getVidaActual());
			}
		}
		System.out.println("	" + (contador + 1) + ". Tornar");
		
		int opcio = scanner.nextInt() - 1;
		scanner.nextLine();
		
		if (opcio==contador){
			if (pokemonsJugador[0].getVidaActual() <= 0 ) {
				System.out.println("El teu primer pokemon està debilitat...");
				cambiarPokemon();
			} else {
			
			tornJugador();
		}
			return;
		}
		
		if (opcio < 0 || opcio >= contador || pokemonsJugador[opcio].getVidaActual() <= 0) {
			System.out.println("Opció no vàlida.");
			cambiarPokemon();
			return;
		}
		
		// comprovem si el Pokémon seleccionat és el mateix que l'actual
		if (pokemonsJugador[opcio] == this.pokemonJugador) {
			System.out.println("No pots escollir el PokeDam que ja tens actiu.");
			cambiarPokemon();
			return;
		}
		// Comprovem si el Pokémon seleccionat està viu
		if (pokemonsJugador[opcio].getVidaActual() > 0) {
			this.pokemonJugador = pokemonsJugador[opcio];
			System.out.println("Has escollit " + pokemonJugador.getNom() + "!");	
		}
		
			// Afegim només si no és el primer i no s'ha afegit encara
			if (pokemonJugador instanceof PokemonEntrenador) {
				PokemonEntrenador seleccionat = (PokemonEntrenador) pokemonJugador;
				if (!pokemonsParticipants.contains(seleccionat)) {
					pokemonsParticipants.add(seleccionat);
				}
			}
			
		numTurn++;
		tornRival();
}

	public int calcularDany(Pokemon atacant, Pokemon defensor, Atac atac, double[][] efectivitatAtacsPokemon) {

		int calculPrecisio = calcularPrecisio(atac);

		if (calculPrecisio == 0) {
			System.out.println("L'atac ha fallat!");
			return 0;
		}

		int nivellAtacant = atacant.getNivell();
		int atacAtacant = atacant.getAtac();
		int defensaDefensor = defensor.getDefensa();
		int potenciaAtac = atac.getPotencia();
		double efectivitat = 1.0;
		;

		String tipusAtac = atac.getTipus();
		String tipusDefensor = defensor.getTipus();
		int indexTipusAtac = -1;
		int indexTipusDefensor = -1;
		String[] tipus = { "aigua", "insecte", "drac", "electric", "fantasma", "foc", "gel", "lluita", "normal",
				"planta", "psiquic", "roca", "terra", "veri", "volador" };

		for (int i = 0; i < tipus.length; i++) {
			if (tipusAtac.equalsIgnoreCase(tipus[i]))
				indexTipusAtac = i;
			if (tipusDefensor.equalsIgnoreCase(tipus[i]))
				indexTipusDefensor = i;
		}

		if (indexTipusAtac != -1 && indexTipusDefensor != -1) {
			efectivitat = efectivitatAtacsPokemon[indexTipusAtac][indexTipusDefensor];
		}

		double dany = (((2 * nivellAtacant / 5) + 2) * potenciaAtac * ((double) atacAtacant / defensaDefensor)) / 50
				+ 2;
		int danyFinal = (int) (dany * efectivitat);
		return danyFinal;
	}

	public int calcularPrecisio( Atac atac) {
		int precisio = atac.getPrecisio(); 

		if (Utilitats.random() > precisio) {
			return 0;
		} else {
			return 1;
		}
	}

	public void utilitzarObjectes() {
		System.out.println("\nEscull un objecte:");
		System.out.println("	1. Pocio. [+20 HP].");
		System.out.println("	2. Superpocio. [+50 HP]");
		System.out.println("	3. Pokeball.");
		System.out.println("	4. Enrere.");

		int opcio = scanner.nextInt();
		scanner.nextLine();

		switch (opcio) {
		case 1:
			if (curarPokemon(pokemonJugador, 20)) {
				System.out.println("Has utilitzat una Pocio.");
			} else {
				utilitzarObjectes();
			}
			break;
		case 2:
			if (curarPokemon(pokemonJugador, 50)) {
				System.out.println("Has utilitzat una Superpocio.");
			} else {
				utilitzarObjectes();
			}
			break;
		case 3:
			if (capturarPokemon()) {
				jugador.afegirPokemon(getPokemonRival());
				finalitzarBatalla();
			} else {
				tornRival();
			}
			break;
		case 4:
			System.out.println("Has tornat enrere.");
			tornJugador();
			break;
		default:
			System.out.println("Opció no vàlida.");
			utilitzarObjectes();
			break;
		}
		System.out.println("Has utilitzat un objecte.");
		System.out.println("Fi del teu torn.");
		tornRival();
	}

	public boolean curarPokemon(Pokemon pokemon, int cura) {
		int vidaActual = pokemon.getVidaActual();
		int vidaMaxima = pokemon.getVidaMaxima();

		if (vidaActual == vidaMaxima) {
			System.out.println("El teu PokeDam ja està a la seva vida màxima.");
			return false;
		} else if (vidaActual < vidaMaxima) {
			vidaActual += cura;
			if (vidaActual > vidaMaxima) {
				vidaActual = vidaMaxima;
			}
			pokemon.setVidaActual(vidaActual);
			System.out.println("El teu PokeDam ha recuperat " + cura + " [HP: " + vidaActual + "/" + vidaMaxima + "]");
		}
		return true;
	}
	
	public void calcularRecompensa() {

		int experienciaBase = 10;
		int dinersGuanyats;
		int experienciaGuanyada;
		int experienciaPerPokemon;

		ArrayList<PokemonEntrenador> vius = new ArrayList<>();
		for (PokemonEntrenador poke : pokemonsParticipants) {
			if (poke != null && poke.getVidaActual() > 0) {
				vius.add(poke);
			}
		}

		experienciaGuanyada = pokemonRival.getNivell() * experienciaBase;
		experienciaPerPokemon = experienciaGuanyada / vius.size();

		for (PokemonEntrenador poke : vius) {
			poke.setExperienciaActual(poke.getExperienciaActual() + experienciaPerPokemon);
			System.out.println("\n" + poke.getNom() + " ha guanyat " + experienciaPerPokemon + " punts d'experiència.");

			while (poke.getExperienciaActual() >= poke.getExperienciaPerPujar()) {
				poke.pujarNivell();

				Pokemon evolucionat = poke.evolucionar(pokemonJugador);

				Pokemon[] titulars = jugador.getPokemons();
				for (int i = 0; i < titulars.length; i++) {
					if (titulars[i] != null && titulars[i].getIdPokemon() == evolucionat.getIdPokemon() - 1) {

						PokemonEntrenador nou = PokemonEntrenador.convertirAPokemonEntrenador(evolucionat);
						titulars[i] = nou;
						break;
					}
				}
			}
		}

		dinersGuanyats = Math.max(1, (int) (pokemonRival.getNivell() * (Utilitats.random() / 10)));
		jugador.setDiners(jugador.getDiners() + dinersGuanyats);
		System.out.println("\nHas guanyat " + dinersGuanyats + " PokeMonedes.");

		pokemonsParticipants.clear();
	}

	public boolean capturarPokemon() {
		System.out.println("Aquest tipus de batalla no permet capturar Pokémon.");
		return false;
	}

	public void fugir() {
		System.out.println("\nNo pots fugir d’aquesta batalla.");
	}
	
	public void finalitzarBatalla() {
		
		System.out.println("La batalla s'ha acabat.");
		this.finalitzada = true;
		Joc.menuJoc();

	}
}