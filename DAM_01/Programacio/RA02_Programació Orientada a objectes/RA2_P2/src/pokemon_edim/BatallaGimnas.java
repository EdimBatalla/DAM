//Subclasse: BatallaGimnas (hereta de Batalla)
//○ Atributs addicionals:
//■ lider: EntrenadorIA → Líder del gimnàs amb el seu equip
//complet.
//■ medallaObtinguda: boolean → Indica si s'ha obtingut la
//medalla.
//■ nivellBase: int → Nivell base dels Pokémons del líder.
//○ Mètodes addicionals:
//■ iniciarBatalla(): Inicia la batalla amb un líder de gimnàs.
//■ recompensaGimnas(): Aplica recompenses més grans si es
//guanya (ex.: medalles, molts diners).
//■ canviarPokemon(): Permet canviar de Pokémon durant la batalla
//si en tens més de 1.

package pokemon_edim;

import static pokemon_edim.Joc.scanner;

import java.util.ArrayList;

public class BatallaGimnas extends Batalla {

	private ArrayList<EntrenadorIA> entrenadors;
	private ArrayList<Gimnas> gimnasos;
	private EntrenadorIA lider;
	private int nivellBase;
	private String nom;
	private boolean medallaObtinguda;

	// constructor

	public BatallaGimnas(Entrenador jugador, Pokemon pokemonJugador, Pokemon pokemonRival, double[][] efectivitats,
			ArrayList<Gimnas> gimnasos, ArrayList<EntrenadorIA> entrenadors) {
		super(jugador, pokemonJugador, pokemonRival, efectivitats);
		this.entrenadors = entrenadors;
		this.gimnasos = gimnasos;

	}

	public EntrenadorIA getLider() {
		return lider;
	}

	public void setLider(EntrenadorIA lider) {
		this.lider = lider;
	}

	public boolean isMedallaObtinguda() {
		return medallaObtinguda;
	}

	public void setMedallaObtinguda(boolean medallaObtinguda) {
		this.medallaObtinguda = medallaObtinguda;
	}

	public int getNivellBase() {
		return nivellBase;
	}

	public void setNivellBase(int nivellBase) {
		this.nivellBase = nivellBase;
	}

	public static void ajustarNivellPokemonGim (Pokemon[] pokemonsJugador, int nivellBase ){

		for (int i =0; i<pokemonsJugador.length; i++ ) {
			if (pokemonsJugador[i]!=null) {
					while (pokemonsJugador[i].getNivell() < nivellBase) {
						pokemonsJugador[i].pujarNivell();
				}
			}
		}
	}
	
	
	public void iniciarBatallaGim(int idGim) {
		int idLider = -1;

		for (Gimnas gim : gimnasos) {
			if (gim.getIdGimnas() == idGim) {
				this.nivellBase = gim.getNivellBase();
				this.nom = gim.getNom();
				idLider = gim.getIdEntrenador();
				break;
			}
		}

		for (EntrenadorIA ent : entrenadors) {
			if (ent.getIdEntrenador() == idLider) {
				this.lider = ent;
				break;
			}
		}
		
		ajustarNivellPokemonGim (lider.getPokemons(), nivellBase );

		Pokemon[] equipLider = this.lider.getPokemons();
		if (equipLider != null && equipLider.length > 0) {
			Pokemon rivalInicial = equipLider[0];
			super.setPokemonRival(rivalInicial);
		}
		
		if (pokemonJugador instanceof PokemonEntrenador) {
			PokemonEntrenador primer = (PokemonEntrenador) pokemonJugador;
			if (!pokemonsParticipants.contains(primer)) {
				pokemonsParticipants.add(primer);
			}
		}

		System.out.println("\nBenvingut al gimnàs " + this.nom + "! Nivell recomenat: " + this.getNivellBase() + ".");
		System.out.println("Iniciant batalla contra el líder de gimnàs " + this.lider.getNom()
				+ " especialista en PokeDams de tipus " + this.lider.getTipus()+ ".");
		System.out.println("El seu primer PokeDam és: " + equipLider[0].getNom()+ ".");
		super.iniciarBatalla();
	
	}

	@Override
	public void tornRival() {
		System.out.println("Torn de " + this.lider.getNom() + ":");
		
		if (getPokemonRival().getVidaActual() <= 0 && pokemonsRivalsVius()) {
			Pokemon seguent = obtenirSeguentPokemon();
			System.out.println(this.lider.getNom() + " treu el seguent PokeDam: " + seguent.getNom() + "!\n");

			super.setPokemonRival(seguent);
			pokemonRival.ordenarPotenciaAtacs();	
		}
		
			if (this.lider.getEstat().equalsIgnoreCase("ag")) {
				if (Utilitats.random() < 25) { // defensa
					defensar();
						
				} else { // atac
					escollirAtacLider() ;
				}
			}

			if (this.lider.getEstat().equalsIgnoreCase("def")) {
				if (Utilitats.random() < 70) { // defensa
					defensar();	
				} else { // atac
					escollirAtacLider() ;
				}
			}

			if (this.lider.getEstat().equalsIgnoreCase("eq")) {
				if (Utilitats.random() > 60) { // defensa
					defensar();
				} else { // atac
					escollirAtacLider() ;
				}
			}
			
			if (this.lider.getEstat().equalsIgnoreCase("est")) {

				double porcentatgeVidaJugador = pokemonJugador.getVidaActual() * 100 / pokemonJugador.getVidaMaxima();
				double porcentatgeVidaRival = pokemonRival.getVidaActual() * 100 / pokemonRival.getVidaMaxima();

				if (porcentatgeVidaRival <= 25) {
					if (Utilitats.random() < 70) { // 70% defensa
						defensar();
					} else { // 30% atac
						escollirAtacLider() ;
					}

				} else if (porcentatgeVidaJugador < 25) { // 100% atac
					escollirAtacLider() ;

				} else if (porcentatgeVidaRival < 75 || porcentatgeVidaRival > 25 || porcentatgeVidaJugador < 75
						|| porcentatgeVidaJugador > 25) { // 50% atac 50% defensa
					if (Utilitats.random() > 50) { // 50% defensa
						defensar();
					} else { // 50% atac
						escollirAtacLider() ;
					}
				}

					tornJugador();
					numTurn++;
					return;
				}
			
			numTurn++;
				tornJugador();
			}
		
	private void escollirAtacLider() {
		Atac atacRival = null;
		pokemonRival.ordenarPotenciaAtacs();

		// Buscar el primer atac disponible
		for (int i = 0; i < 4; i++) {
			Atac atac = pokemonRival.getAtacsPokemon()[i];
			if (atac != null && atac.getUsosActuals() > 0) {
				atacRival = atac;
				break;
			}
		}

		// Si no hi ha cap atac disponible
		if (atacRival == null) {
			if (pokemonRival.getVidaActual() >= pokemonRival.getVidaMaxima()) {
				System.out.println("El rival no pot fer res útil aquest torn.");
				numTurn++;
				tornJugador();
				return;
			}
			defensar();
			return;
		}

		// Comprovar precisió
		if (calcularPrecisio(atacRival) == 0) {
			System.out.println("L'atac " + atacRival.getNom() + " ha fallat!");
			numTurn++;
			tornJugador();
			return;
		}

		// Executar l'atac
		atacRival.usar();
		int dany = calcularDany(pokemonRival, pokemonJugador, atacRival, efectivitats);
		pokemonJugador.setVidaActual(pokemonJugador.getVidaActual() - dany);
		if (pokemonJugador.getVidaActual() < 0) {
			pokemonJugador.setVidaActual(0);
		}

		System.out.println("EL teu PokeDam: " + pokemonJugador.getNom() + " ha rebut " + dany +
			" de dany. HP[" + pokemonJugador.getVidaActual() + "/" + pokemonJugador.getVidaMaxima() + "]");

		// Si el jugador queda KO
		if (pokemonJugador.getVidaActual() <= 0) {
			System.out.println("El teu PokeDam " + pokemonJugador.getNom() + " ha estat derrotat!");
			numTurn++;
			cambiarPokemon();
			return;
		}

		// Torn del jugador
		numTurn++;
		tornJugador();
	}

	private void defensar() {
		int vida = pokemonRival.getVidaActual();
		int vidaMax = pokemonRival.getVidaMaxima();

		if(vida==vidaMax) {
			escollirAtacLider();
			return;
			
		}
		System.out.println("El rival s'ha curat 20 HP.");
		vida += 20;

		if (vida > vidaMax) {
			vida = vidaMax;
		}

		pokemonRival.setVidaActual(vida);
		numTurn++;
		tornJugador();
	}
	
	private boolean pokemonsRivalsVius() {
		Pokemon[] equip = lider.getPokemons();
		for (int i = 0; i < equip.length; i++) {
			if (equip[i] != null && equip[i].getVidaActual() > 0) {
				return true;
			}
		}
		return false;
	}
	
	private Pokemon obtenirSeguentPokemon() {
		Pokemon[] equip = lider.getPokemons();
		for (int i = 0; i < equip.length; i++) {
			Pokemon rival = equip[i];
			if (rival != null && rival.getVidaActual() > 0) {
				return rival;
			}
		}
		return null;
	}

	@Override
	public void tornJugador() {
		if (finalitzada) return;
		
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

				if (pokemonsRivalsVius()) {
					Pokemon seguent = obtenirSeguentPokemon();
					System.out.println("\nEl rival treu " + seguent.getNom() + "!");
					pokemonRival = seguent;
					pokemonRival.ordenarPotenciaAtacs();
					tornRival();
				} else {
					finalitzarBatalla();
					return;
				}
			} else {
				tornRival();
				return;
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
	
	@Override
	public void calcularRecompensa() {
		
		int experienciaBase = 15;
		int dinersGuanyats;
		int experienciaGuanyada;
		int experienciaPerPokemon;
		ArrayList<PokemonEntrenador> vius = new ArrayList<>();
		
		for (PokemonEntrenador poke : pokemonsParticipants) {
			if (poke !=null && poke.getVidaActual() > 0) {
				vius.add(poke);
			}
		}
		
		if (vius.isEmpty()) {
			if (pokemonJugador instanceof PokemonEntrenador) {
				PokemonEntrenador primer = (PokemonEntrenador) pokemonJugador;
				vius.add(primer);
			}
		}
		
		experienciaGuanyada = pokemonRival.getNivell() * experienciaBase;
		experienciaPerPokemon = experienciaGuanyada / vius.size();		
		
		for (PokemonEntrenador poke: vius) {
				poke.setExperienciaActual(poke.getExperienciaActual() + experienciaPerPokemon);
				System.out.println("\n" + poke.getNom() + " ha guanyat " + experienciaPerPokemon + " punts d'experiència.");
			
				while (poke.getExperienciaActual() >= poke.getExperienciaPerPujar()) {
					poke.pujarNivell();
				}
			}
		 
		dinersGuanyats = Math.max( 1, (int) (pokemonRival.getNivell() * (Utilitats.random() / 5)) );
		jugador.setDiners(jugador.getDiners() + dinersGuanyats);
		System.out.println("\nHas guanyat " + dinersGuanyats + " PokeMonedes.");
		
		pokemonsParticipants.clear();
		}
	
	@Override
	public void finalitzarBatalla() {
		System.out.println("S'ha acabat la batalla!");
		this.finalitzada = true;
		Joc.menuJoc();
	}
}