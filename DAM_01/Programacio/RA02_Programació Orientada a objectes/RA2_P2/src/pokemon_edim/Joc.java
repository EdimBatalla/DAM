package pokemon_edim;

import java.util.ArrayList;
import java.util.Scanner;

public class Joc {

	private static Entrenador jugador;
	private static ArrayList<Pokemon> pokemonsSalvatjes;
	private static ArrayList<EntrenadorIA> entrenadors;
	private static ArrayList<Gimnas> gimnasos;
	private static double[][] efectivitats;

	static Scanner scanner = new Scanner(System.in);
	
	
	public static ArrayList<Pokemon> getPokemonsSalvatjes() {
		return pokemonsSalvatjes;
	}

	public static void importarArxius() {

		FitxersCsv llegir = new FitxersCsv("fitxers/pokemons.csv", "fitxers/atacs_pokemon.csv",
				"fitxers/relacio_pokemons_atacs.csv", "fitxers/gimnasos.csv", "fitxers/entrenadorsGimnas.csv",
				"fitxers/relacio_entrenador_pokemon.csv", "fitxers/distribucioefectivitat.csv");
		llegir.llegirPokemons();
		llegir.llegirAtacs();
		llegir.assignarAtacs();
		pokemonsSalvatjes = llegir.getPokemons();
		gimnasos = llegir.llegirGimnasos();
		entrenadors = llegir.llegirEntrenadors();
		llegir.assignarPokemons();
		efectivitats = llegir.assignarEfectivitats();
		menuInicial();
	}

	public static void menuInicial() {

		System.out.println("\nBenvingut al joc de PokeDam!");
		System.out.println("Escolliu una opció:");
		System.out.println("\n	1. Iniciar joc");
		System.out.println("	2. Carregar joc");
		System.out.println("	3. Sortir");
		int opcio = scanner.nextInt();
		scanner.nextLine();

		switch (opcio) {
		case 1:
			System.out.println("\nATENCIÓ!!!");
			System.out.println("\nSi inicies una nova partida es perdrà la partida actual.");
			System.out.println("\nEstas segur de que vols continuar? (S/N)");
			String resposta = scanner.next();
			if (resposta.equalsIgnoreCase("S")) {
				System.out.println("\nIniciant joc...");
				crearEntrenador();
				break;
			} else {
				menuInicial();
			}
		case 2:
			System.out.println("\nCarregant el joc...");
			jugador = FitxersTxt.cargarPartida(pokemonsSalvatjes);
			jugador.mostrarInfo();
			menuJoc();
			break;
		case 3:
			System.out.println("\nSortint del joc...");
			MostrarArxius.mostrarArxius();
			MostrarArxius.mostrarAtacsAssignats(pokemonsSalvatjes);
			MostrarArxius.mostrarRelacioEntrenadorPokemon(entrenadors);
			MostrarArxius.mostrarEfectivitats(efectivitats);
			break;
		default:
			System.out.println("\nOpció no vàlida.");
			menuInicial();
		}
	}

	public static void crearEntrenador() {

		System.out.println("\nBenvingut al món de PokeDam!");
		System.out.println("Primer de tot introdueix el teu nom:");
		scanner.nextLine();
		String nomEntrenador = scanner.nextLine();
		System.out.println("\nHola " + nomEntrenador + "!");
		escollirInicial(nomEntrenador);
	}

	public static void escollirInicial(String nomEntrenador) {
		Pokemon[] pokemonsJugador = new Pokemon[6];

		System.out.println("Per començar la teva aventura has de escollir el teu PokeDam incicial.");
		System.out.println("Escull entre els següents PokeDams:");
		System.out.println("\n	1. Bulbasaur");
		System.out.println("	2. Charmander");
		System.out.println("	3. Squirtle");
		int opcio = scanner.nextInt();
		scanner.nextLine();
		int idSeleccionat;

		switch (opcio) {
		case 1:
			System.out.println("\nHas escollit Bulbasaur!");
			idSeleccionat = 1;
			break;
		case 2:
			System.out.println("\nHas escollit Charmander!");
			idSeleccionat = 4;
			break;
		case 3:
			System.out.println("\nHas escollit Squirtle!");
			idSeleccionat = 7;
			break;
		case 4:
			System.out.println("\nHas descobert un Easter Egg! Has escollit Pikachu!");
			idSeleccionat = 25;
			break;
		default:
			System.out.println("\nOpció no vàlida.");
			escollirInicial(nomEntrenador);
			return;
		}

		Pokemon seleccionat = Utilitats.buscarPokemonsPerId(pokemonsSalvatjes, idSeleccionat);
		PokemonEntrenador inicialEntrenador = PokemonEntrenador.convertirAPokemonEntrenador(seleccionat);
		pokemonsJugador[0] = inicialEntrenador;
		Pokemon[] pokemonsReserva = new Pokemon[150];
		jugador = new Entrenador(nomEntrenador, pokemonsJugador, pokemonsReserva, 100);
		jugador.mostrarInfo();
		menuJoc();

	}

	public static void menuJoc() {

		System.out.println("\nMenu de joc:");
		System.out.println("\n	1. Buscar PokeDams Salvatges.");
		System.out.println("	2. Administrar PokeDams.");
		System.out.println("	3. Obrir motxilla.");
		System.out.println("	4. Anar de tendes.");
		System.out.println("	5. Centre PokeDam.");
		System.out.println("	6. Retar Gimnasos.");
		System.out.println("	7. Guardar partida.");
		System.out.println("	8. Mostrar informació del jugador.");
		System.out.println("	9. Sortir del joc.");
		int opcio = scanner.nextInt();
		scanner.nextLine();

		switch (opcio) {
		case 1:
			menuRutaPokemons();
			break;
		case 2:
			gestioPokedams();
			break;
		case 3:
			System.out.println("no implementat");
			break;
		case 4:
			System.out.println("no implementat");
			break;
		case 5:
			jugador.centroPokedam();
			menuJoc();
			break;
		case 6:
			menuEntrenadors();
			break;
		case 7:
			FitxersTxt.guardarPartida(jugador);
			menuJoc();
			break;
		case 8:
			jugador.mostrarInfo();
			menuJoc();
			break;
		case 9:
			System.out.println("Sortint al menú principal...");
			menuInicial();
			break;
		default:
			System.out.println("Opció no vàlida. Torna a intentar-ho.");
			menuJoc();
			break;
		}
	}

	public static void menuRutaPokemons() {

		System.out.println("\nQuina ruta vols explorar?");
		System.out.println("\n	1.Platja.");
		System.out.println("	2.Jardi.");
		System.out.println("	3.Cova de dracs.");
		System.out.println("	4.Central elèctrica.");
		System.out.println("	5.Casa encantada.");
		System.out.println("	6.Zona volcànica.");
		System.out.println("	7.Pista d'esqui.");
		System.out.println("	8.Dojo.");
		System.out.println("	9.Cami normal.");
		System.out.println("	10.Bosc.");
		System.out.println("	11.Manicomi.");
		System.out.println("	12.Muntanya.");
		System.out.println("	13.Terrari.");
		System.out.println("	14.Control de plagues.");
		System.out.println("	15.Zona de nius.");
		System.out.println("	16.Tornar al menu principal.");
		int opcio = scanner.nextInt();
		scanner.nextLine();

		String tipusRuta = null;
		switch (opcio) {
		case 1:
			tipusRuta = "Aigua";
			break;
		case 2:
			tipusRuta = "Insecte";
			break;
		case 3:
			tipusRuta = "Drac";
			break;
		case 4:
			tipusRuta = "Electric";
			break;
		case 5:
			tipusRuta = "Fantasma";
			break;
		case 6:
			tipusRuta = "Foc";
			break;
		case 7:
			tipusRuta = "Gel";
			break;
		case 8:
			tipusRuta = "Lluita";
			break;
		case 9:
			tipusRuta = "Normal";
			break;
		case 10:
			tipusRuta = "Planta";
			break;
		case 11:
			tipusRuta = "Psiquic";
			break;
		case 12:
			tipusRuta = "Roca";
			break;
		case 13:
			tipusRuta = "Terra";
			break;
		case 14:
			tipusRuta = "Veri";
			break;
		case 15:
			tipusRuta = "Volador";
			break;
		case 16:
			Joc.menuJoc();
			break;
		default:
			System.out.println("Opció no vàlida.");
			menuRutaPokemons();
			break;
		}

		Pokemon miPokemon = jugador.getPokemons()[0];
		Pokemon pokemonRival = BatallaEntrenament.generarPokemonAleatori(pokemonsSalvatjes, tipusRuta);
		if (pokemonRival != null) {
			BatallaEntrenament.ajustarNivellPokemon(pokemonRival, jugador.getPokemons());
			System.out.println("\nHas trobat aquest Pokémon:");
			Pokemon.mostrarInfoBatalla(pokemonRival);
			BatallaEntrenament batalla = new BatallaEntrenament(jugador, miPokemon, pokemonRival, efectivitats);
			batalla.iniciarBatalla();

		} else {
			System.out.println("\nNo hi ha cap Pokémon de tipus " + tipusRuta + ".");
		}
	}

	public static void gestioPokedams() {
		int opcio;

		do {
			System.out.println("Que vols fer?");
			System.out.println("	1. Moure PokeDams dintre del equip titular.");
			System.out.println("	2. Guardar un PokeDam a la reserva.");
			System.out.println("	3. Treure un PokeDam de la reserva.");
			System.out.println("	4. Intercambiar un PokeDam entre titulars i reserves.");
			System.out.println("	5. Alliberar un PokeDam.");
			System.out.println("	6. Tornar.");
			System.out.println(" Escull una opció.");
			opcio = scanner.nextInt();

			switch (opcio) {
			case 1:
				jugador.mourePokemons();
				break;
			case 2:
				jugador.guardarPokemons();
				break;
			case 3:
				jugador.treurePokemons();
				break;
			case 4:
				jugador.cambiarPokemons();
				break;
			case 5:
				jugador.alliberarPokemons();
				break;
			case 6:
				menuJoc();
				break;
			default:
				break;
			}

		} while (opcio != 6);

	}
	
	public static void menuEntrenadors() {
		
		Pokemon miPokemon = jugador.getPokemons()[0];
		BatallaGimnas batallaGimnas = new BatallaGimnas(jugador, miPokemon, null, efectivitats, gimnasos, entrenadors);
		int opcio;
		
		do {
			System.out.println("\nContra qui vols lluitar?");
			System.out.println("	1. 1r Gimnàs.");
			System.out.println("	2. 2n Gimnàs.");
			System.out.println("	3. 3r Gimnàs.");
			System.out.println("	4. 4r Gimnàs.");
			System.out.println("	5. 5è Gimnàs.");
			System.out.println("	6. 6è Gimnàs.");
			System.out.println("	7. 7è Gimnàs.");
			System.out.println("	8. Gimnàs Final.");
			System.out.println("	9. Sortir.");
			System.out.println(" Escull una opció.");
			opcio = scanner.nextInt();
			
			if (opcio >= 1 && opcio <= 8) {
	            batallaGimnas.iniciarBatallaGim(opcio);
	        } else if (opcio == 9) {
	            menuJoc();
	        } else {
	            System.out.println("Opció no vàlida.");
	        }
			
		} while (opcio != 9);
}
}