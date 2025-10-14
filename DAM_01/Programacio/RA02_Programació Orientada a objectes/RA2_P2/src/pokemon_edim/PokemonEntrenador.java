package pokemon_edim;

import java.util.ArrayList;

public class PokemonEntrenador extends Pokemon {
	
	private int experienciaActual;
	private int experienciaPerPujar;
	
	//constructor
	public PokemonEntrenador(int idPokemon, String nom, String tipus, int nivell, int vidaActual, int vidaMaxima, int atac, int defensa, int experienciaActual, int experienciaPerPujar) {
		super(idPokemon, nom, tipus, nivell, vidaActual, vidaMaxima, atac, defensa);
		
		this.experienciaActual = experienciaActual;
		this.experienciaPerPujar = experienciaPerPujar;
	}
	
	public int getExperienciaActual() {
		return experienciaActual;
	}

	public void setExperienciaActual(int experienciaActual) {
		this.experienciaActual = experienciaActual;
	}

	public int getExperienciaPerPujar() {
		return experienciaPerPujar;
	}

	public void setExperienciaPerPujar(int experienciaPerPujar) {
		this.experienciaPerPujar = experienciaPerPujar;
	}

	
	public static void mostrarInfo(PokemonEntrenador pokemon) {
	    System.out.println("ID: " + pokemon.getIdPokemon());
	    System.out.println("Nom: " + pokemon.getNom());
	    System.out.println("Tipus: " + pokemon.getTipus());
	    System.out.println("Nivell: " + pokemon.getNivell());
	    System.out.println("Experiència per pujar de nivell: " + (pokemon.getExperienciaActual() - pokemon.getExperienciaPerPujar()));
	    System.out.println("Vida Actual: " + pokemon.getVidaActual());
	    System.out.println("Vida Màxima: " + pokemon.getVidaMaxima());
	    System.out.println("Atac: " + pokemon.getAtac());
	    System.out.println("Defensa: " + pokemon.getDefensa());
	}
	


	public static PokemonEntrenador convertirAPokemonEntrenador(Pokemon poke) {
    	
    	int nivell       = poke.getNivell();
        int expPerPujar  = experienciaPerNivell(nivell);
		PokemonEntrenador pokemonEntrenador = new PokemonEntrenador(
				
	        poke.getIdPokemon(),
	        poke.getNom(),
	        poke.getTipus(),
	        nivell,
	        poke.getVidaActual(),
	        poke.getVidaMaxima(),
	        poke.getAtac(),
	        poke.getDefensa(),
	        0, // experienciaActual inicial
	        expPerPujar 
	    );
		
		ArrayList<Atac> atacsCopia = new ArrayList<>();
	    for (Atac atac : poke.getAtacsPokemon()) {
	        atacsCopia.add(new Atac(atac.getIdAtac(), atac.getNom(), atac.getTipus(), atac.getPotencia(), atac.getPrecisio(), atac.getUsosMaxims()));
	    }

	    pokemonEntrenador.setAtacsPokemon(atacsCopia.toArray(new Atac[0]));
	    return pokemonEntrenador;
	}
	
	private static int experienciaPerNivell(int nivell) {
		if (nivell < 100) {
			int experiencia = 10;
			for (int i = 2; i < nivell; i++) {
			experiencia *= 1.1;
			}
			return (int) experiencia;
		} else {
			return Integer.MAX_VALUE; // ja no pot pujar més
		}
	}

	@Override
	public void pujarNivell() {
		//sumar experienca sobrant
		int expAnterior = experienciaPerNivell(this.getNivell());
		setExperienciaActual(this.getExperienciaActual() - expAnterior);

		setNivell(this.getNivell() + 1);
		
		//calcul exp necessaria pel seguent nivel
		this.experienciaPerPujar = experienciaPerNivell(this.getNivell());
		
		setVidaMaxima(this.getVidaMaxima() + 3);
		setVidaActual(this.getVidaMaxima());
		setAtac(this.getAtac() +2);
		setDefensa(this.getDefensa()+2);
		
		System.out.println(getNom() + " ha pujat de nivell a " + this.getNivell());
		System.out.println("Vida màxima: " + this.getVidaMaxima());
		System.out.println("Atac: " + this.getAtac());
		System.out.println("Defensa: " + this.getDefensa());
	}
	
	public Pokemon evolucionar(Pokemon actual) {
		ArrayList<Pokemon> pokemonsSalvatjes= Joc.getPokemonsSalvatjes();
	    // Busquem el Pokémon amb ID = actual.getId() + 1
	   
		for (Pokemon candidato : pokemonsSalvatjes) {
	        if (candidato.getIdPokemon() == actual.getIdPokemon() + 1 && candidato.getNivell() <= actual.getNivell()){
	            System.out.println("\n" + actual.getNom() + " ha evolucionat a " + candidato.getNom()
	            );
	            return candidato;
	        }
	    }

	    return actual;
	}
	
}