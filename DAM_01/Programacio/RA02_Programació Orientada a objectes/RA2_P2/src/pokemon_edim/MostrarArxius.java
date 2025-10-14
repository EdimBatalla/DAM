package pokemon_edim;

import java.util.ArrayList;

public class MostrarArxius {

	public static void mostrarArxius() {

		FitxersCsv llegir = new FitxersCsv("fitxers/pokemons.csv", "fitxers/atacs_pokemon.csv", "fitxers/relacio_pokemons_atacs.csv", "fitxers/gimnasos.csv", "fitxers/entrenadorsGimnas.csv", "fitxers/relacio_entrenador_pokemon.csv", "fitxers/distribucioefectivitat.csv");
		
		System.out.println("Pokemons cargats:");
		for (Pokemon pokes : llegir.llegirPokemons()) {
			Pokemon.mostrarInfo(pokes);
		}

		System.out.println("\nAtacs cargats:");
		for (Atac atts : llegir.llegirAtacs()) {
			Atac.mostrarInfo(atts);
		}

		System.out.println("\nRelacions entre Pokemons i Atacs:");
		for (RelacioPokemonAtac rel : llegir.assignarAtacs()) {
			RelacioPokemonAtac.mostrarInfo(rel);
		}
		
		System.out.println("\nGimnasos cargats:");
		for (Gimnas gim : llegir.llegirGimnasos()) {
			Gimnas.mostrarInfo(gim);
		}
		
		System.out.println("\nEntrenadors cargats:");
		for (EntrenadorIA ent : llegir.llegirEntrenadors()) {
			EntrenadorIA.mostrarInfo(ent);
		}
	}

		public static void mostrarAtacsAssignats(ArrayList<Pokemon> pokemons) {
			System.out.println("\nAtacs assignats als Pokémons:");

			for (Pokemon p : pokemons) {
				System.out.println("Pokemon: " + p.getNom());
				Atac[] atacs = p.getAtacsPokemon();
				for (Atac a : atacs) {
					if (a != null) {
						System.out.println("   - " + a.getNom() + " | Tipus: " + a.getTipus() + " | Potència: " + a.getPotencia());
					}
				}
				System.out.println();
			}
		}
		
		public static void mostrarRelacioEntrenadorPokemon(ArrayList<EntrenadorIA> entrenadors) {
			System.out.println("\nRelacions entre Entrenadors i Pokémons:");

			for (EntrenadorIA ent : entrenadors) {
				System.out.println("Entrenador: " + ent.getNom());
				Pokemon[] pokemons = ent.getPokemons();
				for (Pokemon p : pokemons) {
					if (p != null) {
						System.out.println(
								"   - " + p.getNom() + " | Tipus: " + p.getTipus() + " | Nivell: " + p.getNivell());
					}
				}
				System.out.println();

			}
		}

		public static void mostrarEfectivitats(double[][] efectivitats) {
			System.out.println("Efectivitats entre tipus:");
			for (int i = 0; i < efectivitats.length; i++) {
				for (int j = 0; j < efectivitats[i].length; j++) {
					System.out.print(efectivitats[i][j] + " | ");
				}
				System.out.println();
			}
		}
	}


