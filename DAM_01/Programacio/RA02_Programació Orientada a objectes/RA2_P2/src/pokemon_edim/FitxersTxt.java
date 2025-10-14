package pokemon_edim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FitxersTxt {
	
	public static void guardarPartida(Entrenador jugador) {
		
		try {
		FileWriter fitxer;
		PrintWriter dades;
		fitxer = new FileWriter("fitxers/partida.txt");
		dades = new PrintWriter(fitxer);
		
		dades.println(jugador.getNom());
		dades.println(jugador.getDiners());
		dades.println("----- PokeDams Titulars -----");

		for (Pokemon poke : jugador.getPokemons()) {
			if (poke != null) {
				
				String linia = (poke.getIdPokemon() + ";" + poke.getNom() + ";" + poke.getTipus() + ";" + poke.getNivell() + ";" + poke.getVidaActual() + ";" + poke.getVidaMaxima() + ";" + poke.getAtac() + ";" + poke.getDefensa());
				
				if (poke instanceof PokemonEntrenador) {
			            PokemonEntrenador pe = (PokemonEntrenador) poke;
			            linia += ";" + pe.getExperienciaActual() + ";" + pe.getExperienciaPerPujar();
			        }

			        dades.println(linia);
			    }else {
			    	dades.println("null");
			    }
			}
		
		dades.println("----- PokeDams Reserves -----");
		for (Pokemon poke : jugador.getPokemonsReserva()) {
            if (poke != null) {
                String linia = poke.getIdPokemon() + ";" +
                        poke.getNom() + ";" +
                        poke.getTipus() + ";" +
                        poke.getNivell() + ";" +
                        poke.getVidaActual() + ";" +
                        poke.getVidaMaxima() + ";" +
                        poke.getAtac() + ";" +
                        poke.getDefensa();
                		
                if (poke instanceof PokemonEntrenador) {
		            PokemonEntrenador pe = (PokemonEntrenador) poke;
		            linia += ";" + pe.getExperienciaActual() + ";" + pe.getExperienciaPerPujar();
		        }
                
                dades.println(linia);
            }
		}
                
		System.out.println("Partida guardada correctament.");
	
		dades.close();
		fitxer.close();
		
	} catch (IOException e) {
         e.printStackTrace();
	}
}
	
	public static Entrenador cargarPartida(ArrayList<Pokemon> pokemonsSalvatjes) {
		Entrenador jugador = null;

        try {
            FileReader fitxer = new FileReader("fitxers/partida.txt");
            BufferedReader dades = new BufferedReader(fitxer);

            String nomJugador = dades.readLine();
            int diners = Integer.parseInt(dades.readLine());
           
            Pokemon[] pokemonsJugador = new Pokemon [6];
            Pokemon[] pokemonsReserva = new Pokemon [150];
            
            String linia;
            int i = 0;
            int j = 0;
            
            // Saltar fins als pokemons titulars
            while ((linia = dades.readLine()) != null && !linia.equals("----- PokeDams Titulars -----")) {}
            // Llegir titulars
            while ((linia = dades.readLine()) != null && !linia.equals("----- PokeDams Reserves -----") && i < pokemonsJugador.length) {
                pokemonsJugador[i] = linia.equals("null") ? null : cargarPokemon(linia, pokemonsSalvatjes);
                i++;
            }
            // Llegir reserves
            while ((linia = dades.readLine()) != null && j < pokemonsReserva.length) {
                pokemonsReserva[j] = cargarPokemon(linia, pokemonsSalvatjes);
                j++;
            }

            jugador = new Entrenador(nomJugador, pokemonsJugador, pokemonsReserva, diners);
            System.out.println("Partida carregada correctament.");

            dades.close();
            fitxer.close();

        } catch (java.io.FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer de partida. Encara no hi ha cap partida guardada.");
        } catch (IOException e) {
            System.out.println("Error en llegir el fitxer de partida.");
            e.printStackTrace();
        }
        return jugador;
    }
	
	private static PokemonEntrenador cargarPokemon(String linia, ArrayList<Pokemon> pokemonsSalvatjes) {
		
		String[] parts = linia.split(";");

	    int id = Integer.parseInt(parts[0]);
	    String nom = parts[1];
	    String tipus = parts[2];
	    int nivell = Integer.parseInt(parts[3]);
	    int vidaActual = Integer.parseInt(parts[4]);
	    int vidaMaxima = Integer.parseInt(parts[5]);
	    int atac = Integer.parseInt(parts[6]);
	    int defensa = Integer.parseInt(parts[7]);
	    int experienciaActual = Integer.parseInt(parts[8]);
	    int experienciaPerPujar = Integer.parseInt(parts[9]);

	    PokemonEntrenador poke = new PokemonEntrenador(id, nom, tipus, nivell, vidaActual, vidaMaxima, atac, defensa, experienciaActual, experienciaPerPujar);

	    // Afegim els atacs iguals que el Pokémon salvatge corresponent
	    Pokemon original = Utilitats.buscarPokemonsPerId(pokemonsSalvatjes, id);
	    if (original != null) {
	        poke.setAtacsPokemon(original.getAtacsPokemon());
	    }

	    return poke;
	}
	
}