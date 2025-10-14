package pokemon_edim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FitxersCsv {

	private String rutaPokemons, rutaAtacs, rutaDistribucio, rutaGimnasos, rutaEntrenadorsGimnas, rutaRelacioEntrenadorPokemon, rutaAssignarEfectivitats;
	private ArrayList<Pokemon> pokemons = new ArrayList<>();
	private ArrayList<Atac> atacsTotals = new ArrayList<>();
	private ArrayList<RelacioPokemonAtac> relacionsPA = new ArrayList<>();
	private ArrayList<Gimnas> gimnasos = new ArrayList<>();
	private ArrayList<EntrenadorIA> entrenadors = new ArrayList<>();
	private ArrayList<RelacioEntrenadorPokemon> relacionsEP = new ArrayList<>();
	private double [][] efectivitats = new double [13][13];

	public FitxersCsv(String rutaPokemons, String rutaAtacs, String rutaRelacioPA, String rutaGimnasos, String rutaEntrenadorsGimnas, String rutaRelacioEntrenadorPokemon, String rutaAssignarEfectivitats) {
        this.rutaPokemons = rutaPokemons;
        this.rutaAtacs = rutaAtacs;
        this.rutaDistribucio = rutaRelacioPA;
        this.rutaGimnasos = rutaGimnasos;
        this.rutaEntrenadorsGimnas = rutaEntrenadorsGimnas;
        this.rutaRelacioEntrenadorPokemon = rutaRelacioEntrenadorPokemon;
        this.rutaAssignarEfectivitats = rutaAssignarEfectivitats;
	}
	
	public ArrayList<Pokemon> llegirPokemons() {
		try {
			FileReader fitxer = new FileReader(this.rutaPokemons);
			BufferedReader dades = new BufferedReader(fitxer);
			String linia;
			dades.readLine(); // saltar primera linea
			while ((linia = dades.readLine()) != null) {
				if (linia.trim().isEmpty())
					continue;

				String[] part = linia.split(",");
				int idPokemon = Integer.parseInt(part[0]);
				String nom = part[1];
				String tipus = part[2];
				int nivell = Integer.parseInt(part[3]);
				int vidaActual = Integer.parseInt(part[4]);
				int atac = Integer.parseInt(part[5]);
				int defensa = Integer.parseInt(part[6]);
				pokemons.add(new Pokemon(idPokemon, nom, tipus, nivell, vidaActual, atac, defensa));
			}
			dades.close();
			fitxer.close();
			return pokemons;

		} catch (IOException e) {
			System.out.println("Error al llegir l'arxiu: " + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Atac> llegirAtacs() {
		try {
			FileReader fitxer = new FileReader(this.rutaAtacs);
			BufferedReader dades = new BufferedReader(fitxer);
			String linia;
			dades.readLine();
			while ((linia = dades.readLine()) != null) {
				if (linia.trim().isEmpty())
					continue;

				String[] part = linia.split(",");
				int idAtac = Integer.parseInt(part[0]);
				String nom = part[1];
				String tipus = part[2];
				int potencia = Integer.parseInt(part[3]);
				int precisio = Integer.parseInt(part[4]);
				int usosMaxims = Integer.parseInt(part[5]);
				atacsTotals.add(new Atac(idAtac, nom, tipus, potencia, precisio, usosMaxims));
			}
			dades.close();
			fitxer.close();
			return atacsTotals;

		} catch (IOException e) {
			System.out.println("Error al llegir l'arxiu: " + e.getMessage());
			return null;
		}
	}

	public ArrayList<RelacioPokemonAtac> assignarAtacs() {
	    ArrayList<RelacioPokemonAtac> relacionsPA = new ArrayList<>();
	    try {
	        FileReader fitxer = new FileReader(this.rutaDistribucio);
	        BufferedReader dades = new BufferedReader(fitxer);
	        String linia;
	        dades.readLine(); // saltem la capçalera

	        while ((linia = dades.readLine()) != null) {
	            if (linia.trim().isEmpty()) continue;

	            String[] part = linia.split(",");
	            int idPokemon = Integer.parseInt(part[0]);
	            int idAtac = Integer.parseInt(part[1]);

	            relacionsPA.add(new RelacioPokemonAtac(idPokemon, idAtac));

	            for (Pokemon poke : pokemons) {
	                if (poke.getIdPokemon() == idPokemon) {
	                    for (Atac total : atacsTotals) {
	                        if (total.getIdAtac() == idAtac) {
	                            // Assignem l'atac si hi ha espai (màxim 4)
	                            Atac[] atacs = poke.getAtacsPokemon();
	                            for (int i = 0; i < atacs.length; i++) {
	                                if (atacs[i] == null) {
	                                    atacs[i] = total;
	                                    break;
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }

	        dades.close();
	        fitxer.close();
	        return relacionsPA;

		} catch (IOException e) {
			System.out.println("Error al llegir l'arxiu: " + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Gimnas> llegirGimnasos() {
		try {
			FileReader fitxer = new FileReader(this.rutaGimnasos);
			BufferedReader dades = new BufferedReader(fitxer);
			String linia;
			dades.readLine(); // salem la primera linea
			
			while((linia = dades.readLine()) !=null) {
				if(linia.trim().isEmpty()) continue;
				
				String[] part = linia.split(",");
				int idGimnas = Integer.parseInt(part[0]);
				String nom = part[1];
				String tipus = part[2];
				int idEntrenador = Integer.parseInt(part[3]);
				int nivellBase = Integer.parseInt(part[4]);
				
				gimnasos.add(new Gimnas(idGimnas, nom, tipus, idEntrenador, nivellBase));
			}
			
			dades.close();
			fitxer.close();
			return gimnasos;
			
			} catch (IOException e) {
				System.out.println("Error al llegir l'arxiu: " + e.getMessage());
				return null;
			}		
	}
	
	public ArrayList<EntrenadorIA> llegirEntrenadors() {
		try {
			FileReader fitxer = new FileReader(this.rutaEntrenadorsGimnas);
			BufferedReader dades = new BufferedReader(fitxer);
			String linia;
			dades.readLine(); // saltem la primera linea

			while ((linia = dades.readLine()) != null) {
				if (linia.trim().isEmpty())
					continue;

				String[] part = linia.split(",");
				int idEntrenador = Integer.parseInt(part[0]);
				String nom = part[1];
				String tipus = part[2];
				String estat = part[3];
				boolean esGimnas = Boolean.parseBoolean(part[4]);
				
				Pokemon[]pokemonsJugador=new Pokemon[6];
				Pokemon[]pokemonsReserva=new Pokemon[150];
				
				entrenadors.add(new EntrenadorIA(nom, pokemonsJugador, pokemonsReserva, 0, idEntrenador, tipus, estat, esGimnas));
			}

			dades.close();
			fitxer.close();
			return entrenadors; 

		} catch (IOException e) {
			System.out.println("Error al llegir l'arxiu: " + e.getMessage());
			return null;
		}
	}
	
	public ArrayList<RelacioEntrenadorPokemon> assignarPokemons() {
		 ArrayList<RelacioEntrenadorPokemon> relacionsPE = new ArrayList<>();
		 try {
		 FileReader fitxer = new FileReader(this.rutaRelacioEntrenadorPokemon);
		 BufferedReader dades = new BufferedReader(fitxer);
		 String linia;
		 dades.readLine(); //saltem a la primera linea
		 
		 while ((linia = dades.readLine()) !=null) {
			 if(linia.trim().isEmpty())
				 continue;
		 
		 String[] part = linia.split(",");
		 int idEntrenador = Integer.parseInt(part[0]);
		 int idPokemon = Integer.parseInt(part[1]);
		 
		 relacionsEP.add(new RelacioEntrenadorPokemon(idEntrenador,idPokemon));
		 
		 for(EntrenadorIA entrenador : entrenadors) {
			 if(entrenador.getIdEntrenador() == idEntrenador) {
				 for(Pokemon poke : pokemons) {
					 if(poke.getIdPokemon() == idPokemon) {
						 Pokemon[] pokemonsJugador = entrenador.getPokemons();
						 for(int i = 0; i < pokemonsJugador.length; i++) {
                             if(pokemonsJugador[i] == null) {
                                 pokemonsJugador[i] = poke;
                                 break;
                             	}
                         	}
					 	}
				 	}
			 	}
		 	}
		 }
		 dades.close();
	        fitxer.close();
	        return relacionsEP;

		} catch (IOException e) {
			System.out.println("Error al llegir l'arxiu: " + e.getMessage());
			return null;
		 } 
	}
	
	public double[][] assignarEfectivitats() {
		double[][] efectivitats = new double[15][15];
		 
		 try {
			 FileReader fitxer = new FileReader(this.rutaAssignarEfectivitats);
			 BufferedReader dades = new BufferedReader(fitxer);
			 dades.readLine(); // saltem la primera linea
			 String linia;
			 int contador = 0; 
				
			 while ((linia = dades.readLine()) !=null) {
				 if(linia.trim().isEmpty())
					 continue;
			
				String[]parts = linia.split(",");

			 
			 
			 for(int i=0; i<efectivitats[0].length;i++){
			 	efectivitats[contador][i] = Double.parseDouble(parts[(i+1)]);
			 }
			 contador ++;
			 }   
			 
		        dades.close();
		        fitxer.close();
		        return efectivitats;

			} catch (IOException e) {
				System.out.println("Error al llegir l'arxiu: " + e.getMessage());
				return null;
			}
	}
	
	
	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}

	public ArrayList<Atac> getAtacs() {
		return atacsTotals;
	}

	public ArrayList<RelacioPokemonAtac> getRelacions() {
		return relacionsPA;
	}
	
	public ArrayList<Gimnas> getGimnasos() {
		return gimnasos;
	}
	
	public ArrayList<EntrenadorIA> getEntrenadors() {
		return entrenadors;
	}
	
	public ArrayList<RelacioEntrenadorPokemon> getRelacionsEP() {
		return relacionsEP;
	}
}