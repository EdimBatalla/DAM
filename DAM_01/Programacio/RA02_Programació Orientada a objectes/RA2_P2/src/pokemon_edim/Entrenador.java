package pokemon_edim;

import java.util.ArrayList;
import static pokemon_edim.Joc.scanner;

public class Entrenador {

	private String nom;
	private Pokemon[] pokemonsJugador = new Pokemon[6];
	private int diners;
	private ArrayList<Objecte> objectes = new ArrayList<Objecte>();
	private Medalla[] medalles = new Medalla[8];
	private Pokemon[] pokemonsReserva = new Pokemon[150];

	// constructor
	public Entrenador(String nom, Pokemon[] pokemonsJugador, Pokemon[] pokemonsReserva, int diners) {
		this.nom = nom;
		this.pokemonsJugador = pokemonsJugador;
		this.pokemonsReserva = pokemonsReserva;
		this.diners = diners;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Pokemon[] getPokemons() {
		return pokemonsJugador;
	}

	public void setPokemons(Pokemon[] pokemonsJugador) {
		this.pokemonsJugador = pokemonsJugador;
	}

	public int getDiners() {
		return diners;
	}

	public void setDiners(int diners) {
		this.diners = diners;
	}

	public Medalla[] getMedalles() {
		return medalles;
	}

	public void setMedalles(Medalla[] medalles) {
		this.medalles = medalles;
	}

	public Pokemon[] getPokemonsReserva() {
		return pokemonsReserva;
	}

	public void setPokemonsReserva(Pokemon[] pokemonsReserva) {
		this.pokemonsReserva = pokemonsReserva;
	}

	public void mostrarInfo() {
		System.out.println("\nInformació del jugador: ");
		System.out.println("Nom: " + nom);
		System.out.println("Diners: " + diners);
		System.out.println("Equip de Pokémons: ");

		for (Pokemon poke : pokemonsJugador) {
			if (poke != null) {
				System.out.println(poke.getNom() + " - Nivell: " + poke.getNivell() + " | Vida: " + poke.getVidaActual()
						+ "/" + poke.getVidaMaxima() + " | Exp: " + ((PokemonEntrenador) poke).getExperienciaActual()
						+ "/" + ((PokemonEntrenador) poke).getExperienciaPerPujar());
			}

		}
	}

	public void afegirPokemon(Pokemon poke) {

		if (!(poke instanceof PokemonEntrenador)) {
			poke = PokemonEntrenador.convertirAPokemonEntrenador(poke);
		}

		boolean afegit = false;

		for (int i = 0; i < pokemonsJugador.length; i++) {
			if (pokemonsJugador[i] == null) {
				pokemonsJugador[i] = poke;
				System.out.println("Pokemon afegit a l'equip: " + poke.getNom());
				afegit = true;
				break;
			}
		}

		if (!afegit) {
			System.out.println("L'equip ja està ple. No es pot afegir més Pokemon.");
			System.out.println("Que vols fer?");
			System.out.println("1. Guardar el PokeDam al PC de Reserves.");
			System.out.println("2. Alliberar el PokeDam.");

			int opcio = scanner.nextInt();
			scanner.nextLine();

			switch (opcio) {

			case 1:
				boolean afegitReserva = false;
				for (int j = 0; j < pokemonsReserva.length; j++) {
					if (pokemonsReserva[j] == null) {
						pokemonsReserva[j] = poke;
						System.out.println("PokeDam guardat al PC de reserves.");
						afegitReserva = true;
						break;
					}
				}

				if (!afegitReserva) {
					System.out.println("El PC de reserves està ple. No es pot afegir més Pokemon.");
					System.out.println("El PokeDam ha sigut alliberat.");
				}
				break;

			case 2:
				System.out.println("El PokeDam ha sigut alliberat.");
				break;

			default:
				System.out.println("Opció no vàlida.");
				afegirPokemon(poke);
				break;
			}
		}
	}

	public void centroPokedam() {

		for (Pokemon poke : pokemonsJugador) {
			if (poke != null) {
				poke.setVidaActual(poke.getVidaMaxima());

				Atac[] atacs = poke.getAtacsPokemon();
				if (atacs != null) {
					for (Atac atac : atacs) {
						if (atac != null) {
							atac.setUsosActuals(atac.getUsosMaxims());
						}
					}
				}
			}
		}
		System.out.println("Tots els teus PokeDams estan restaurats!");
	}

	public void mourePokemons() { // moure Pokemons del equip titular

		for (int i = 0; i < pokemonsJugador.length; i++) {
			if (pokemonsJugador[i] != null) {
				System.out
						.println(i + 1 + " - " + pokemonsJugador[i].getNom() + " | " + pokemonsJugador[i].getNivell());
			}
		}

		System.out.println("Quin PokeDam vols cambiar? (selecciona el número)");
		int eleccioA = scanner.nextInt();

		System.out.println("Per quin PokeDam el vols cambiar? (selecciona el número");
		int eleccioB = scanner.nextInt();

		if (eleccioA < 1 || eleccioB < 1 || eleccioA > pokemonsJugador.length || eleccioB > pokemonsJugador.length
				|| pokemonsJugador[eleccioA - 1] == null || pokemonsJugador[eleccioB - 1] == null) {
			System.out.println("Opció no vàlida.");
			return;
		}

		Pokemon temporal = pokemonsJugador[eleccioA - 1];
		pokemonsJugador[eleccioA - 1] = pokemonsJugador[eleccioB - 1];
		pokemonsJugador[eleccioB - 1] = temporal;

		System.out.println("Els PokeDams " + pokemonsJugador[eleccioA - 1].getNom() + " i "
				+ pokemonsJugador[eleccioB - 1].getNom() + " han estat intercanviats.");
	}

	public void guardarPokemons() { // guardar Pokemons de titulars a reserves
		boolean espai = false;

		for (int i = 0; i < pokemonsReserva.length; i++) {
			if (pokemonsReserva[i] == null) {
				espai = true;
				break;
			}
		}

		if (!espai) {
			System.out.println("No hi han espais a la reserva de PokeDams");
			return;
		}

		int comptador = 0;
		for (int i = 0; i < pokemonsJugador.length; i++) {
			if (pokemonsJugador[i] != null) {
				comptador++;
			}
		}

		if (comptador <= 1) {
			System.out.println("Has de tenir com a mínim un PokeDam a l'equip titular.");
			return;
		}

		System.out.println("PokeDams disponibles per guardar:");
		for (int i = 0; i < pokemonsJugador.length; i++) {
			if (pokemonsJugador[i] != null) {
				System.out.println(
						(i + 1) + " - " + pokemonsJugador[i].getNom() + " | Nivell: " + pokemonsJugador[i].getNivell());
			}
		}

		System.out.println("Quin PokeDam vols guardar (selecciona el número)");
		int eleccio = scanner.nextInt();

		if (eleccio < 1 || eleccio > pokemonsJugador.length || pokemonsJugador[eleccio - 1] == null) {
			System.out.println("Opció no vàlida.");
			return;
		}

		int idSeleccionat = pokemonsJugador[eleccio - 1].getIdPokemon();
		for (int i = 0; i < pokemonsReserva.length; i++) {
			if (pokemonsReserva[i] != null) {
				if (idSeleccionat == pokemonsReserva[i].getIdPokemon()) {
					System.out.println("Ja tens aquest PokeDam a la reserva i no es poden tenir duplicats.");
					return;
				}
			}
		}

		for (int i = 0; i < pokemonsReserva.length; i++) {
			if (pokemonsReserva[i] == null) {
				pokemonsReserva[i] = pokemonsJugador[eleccio - 1];
				System.out.println(pokemonsJugador[eleccio - 1].getNom() + " s'ha guardat a la reserva.");
				pokemonsJugador[eleccio - 1] = null;
				break;
			}
		}
	}

	public void treurePokemons() { // treure Pokemons de reserves a titulars
		boolean espai = false;

		for (int i = 0; i < pokemonsJugador.length; i++) {
			if (pokemonsJugador[i] == null) {
				espai = true;
				break;
			}
		}
		if (!espai) {
			System.out.println("No hi han espais al equip titular.");
			return;
		}
		System.out.println("Pokemons a la reserva:");
		boolean reserves = false;
		for (int i = 0; i < pokemonsReserva.length; i++) {
			if (pokemonsReserva[i] != null) {

				System.out.println(
						(i + 1) + " - " + pokemonsReserva[i].getNom() + " | Nivell: " + pokemonsReserva[i].getNivell());
				reserves = true;
			}
		}
		if (!reserves) {
			System.out.println("No tens cap Pokemon a la reserva.");
			return;
		}
		System.out.println("Quin pokemon vols treure? (selecciona el número)");
		int eleccio = scanner.nextInt();

		if (eleccio < 1 || eleccio > pokemonsReserva.length || pokemonsReserva[eleccio - 1] == null) {
			System.out.println("Opció no vàlida.");
			return;
		}
		for (int i = 0; i < pokemonsJugador.length; i++) {
			if (pokemonsJugador[i] == null) {
				pokemonsJugador[i] = pokemonsReserva[eleccio - 1];
				System.out.println(pokemonsReserva[eleccio - 1].getNom() + " s'ha tret al equip titular.");
				pokemonsReserva[eleccio - 1] = null;
				break;
			}
		}
	}

	public void cambiarPokemons() { // cambiar Pokemons entre equip titular i reserves
		boolean trobat = false;
		System.out.println("PokeDams a la reserva:");
		for (int i = 0; i < pokemonsReserva.length; i++) {
			if (pokemonsReserva[i] != null) {
				System.out.println(
						(i + 1) + " - " + pokemonsReserva[i].getNom() + " | Nivell: " + pokemonsReserva[i].getNivell());
				trobat = true;
			}
		}
		if (!trobat) {
			System.out.println("No tens cap PokeDam a la reserva.");
			return;
		}
		System.out.println("Quin pokemon vols treure? (selecciona el número)");
		int eleccioA = scanner.nextInt();

		if (eleccioA < 1 || eleccioA > pokemonsReserva.length || pokemonsReserva[eleccioA - 1] == null) {
			System.out.println("Opció no vàlida.");
			return;
		}
		System.out.println("\n PokeDams titulars:");
		for (int i = 0; i < pokemonsJugador.length; i++) {
			if (pokemonsJugador[i] != null) {
				System.out.println(
						(i + 1) + " - " + pokemonsJugador[i].getNom() + " | Nivell: " + pokemonsJugador[i].getNivell());
			}
		}
		System.out.println("Quin pokemon vols guardar? (selecciona el número)");
		int eleccioB = scanner.nextInt();

		if (eleccioB < 1 || eleccioB > pokemonsJugador.length || pokemonsJugador[eleccioB - 1] == null) {
			System.out.println("Opció no vàlida per a l'equip titular.");
			return;
		}
		Pokemon temp = pokemonsReserva[eleccioA - 1];
		pokemonsReserva[eleccioA - 1] = pokemonsJugador[eleccioB - 1];
		pokemonsJugador[eleccioB - 1] = temp;

		System.out.println("Has canviat " + pokemonsJugador[eleccioB - 1].getNom() + " per "
				+ pokemonsReserva[eleccioA - 1].getNom());
	}

	public void alliberarPokemons() { // eliminar Pokemons
		int opcio;
		int eleccio;

		do {
			System.out.println("D'on vols alliberar el PokeDam?");
			System.out.println("1. Del equip titular.");
			System.out.println("2. De la reserva.");
			System.out.println("3. Tornar.");
			opcio = scanner.nextInt();

			switch (opcio) {
			case 1:
				int contador = 0;
				for (int i = 0; i < pokemonsJugador.length; i++) {
					if (pokemonsJugador[i] != null) {
						System.out.println((i + 1) + " - " + pokemonsJugador[i].getNom() + " | Nivell: "
								+ pokemonsJugador[i].getNivell());
						contador++;
					}
				}

				if (contador == 1) {
					System.out.println("No pots quedar-te sense PokeDams al equip titular.");
					break;
				}

				System.out.println("Quin pokemon vols alliberar? (selecciona el número)");
				eleccio = scanner.nextInt();

				if (eleccio < 1 || eleccio > pokemonsJugador.length || pokemonsJugador[eleccio - 1] == null) {
					System.out.println("Opció no vàlida.");
				} else {
					System.out
							.println("Has alliberat " + pokemonsJugador[eleccio - 1].getNom() + " de l'equip titular.");
					pokemonsJugador[eleccio - 1] = null;
				}
				break;

			case 2:
				boolean trobat = false;

				for (int i = 0; i < pokemonsReserva.length; i++) {
					if (pokemonsReserva[i] != null) {
						System.out.println((i + 1) + " - " + pokemonsReserva[i].getNom() + " | Nivell: "
								+ pokemonsReserva[i].getNivell());
						trobat = true;
					}
				}

				if (!trobat) {
					System.out.println("No tens cap PokeDam a la reserva.");
					return;
				}

				System.out.println("Quin pokemon vols alliberar? (selecciona el número)");
				eleccio = scanner.nextInt();
				if (eleccio < 1 || eleccio > pokemonsReserva.length || pokemonsReserva[eleccio - 1] == null) {
					System.out.println("Opció no vàlida.");
				} else {
					System.out.println("Has alliberat " + pokemonsReserva[eleccio - 1].getNom() + " dels reserves.");
					pokemonsReserva[eleccio - 1] = null;
				}
				break;

			case 3:
				Joc.gestioPokedams();
				break;

			default:
				System.out.println("Escull una opció vàlida.");
				break;
			}
		} while (opcio != 3);

	}
}