//Crear la subclasse EntrenadorIA per representar els entrenadors controlats per
//la màquina. Aquesta subclasse inclou tant els entrenadors de gimnàs com
//entrenadors aleatoris que es poden trobar en el món del joc (els entrenadors
//no es fa aquí). EN AQUESTA PART SOL FAREM ELS ENTRENADORS DEL
//GIMNAS.
//● Atributs principals de la subclasse EntrenadorIA:
//tipus: Tipus de Pokémon que utilitza (Foc, Aigua, etc.).
//○ estat: Estratègia del combat (Agressiu, Defensiu, Equilibrat, Estratègic).
//○ esGimnas: Booleà que indica si és un líder de gimnàs o un entrenador
//aleatori. Al fitxer apareix amb 0 o 1.
//
//● HAURÀS DE PENSAR SI FICAR LA ID DEL ENTRENADOR A LA CLASSE
//ENTRENADOR O LA SUBCLASSE!!!!!

package pokemon_edim;

public class EntrenadorIA extends Entrenador {
	
	private String tipus;
	private String estat;
	private boolean esGimnas;
	private int idEntrenador;
	
	//constructor
	public EntrenadorIA(String nom, Pokemon[] pokemonsJugador, Pokemon[] pokemonsReserva, int diners,int idEntrenador, String tipus, String estat, boolean esGimnas) {
		super(nom, pokemonsJugador, pokemonsReserva, diners);
		this.tipus = tipus;
		this.estat = estat;
		this.esGimnas = esGimnas;
		this.idEntrenador = idEntrenador;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		this.estat = estat;
	}

	public boolean getEsGimnas() {
		return esGimnas;
	}

	public void setEsGimnas(boolean esGimnas) {
		this.esGimnas = esGimnas;
	}

	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}
	
//	@Override
//	public void mostrarInfo() {
//		System.out.println("ID: " + idEntrenador);
//        System.out.println("Nom: " + getNom());
//        System.out.println("Tipus: " + tipus);
//        System.out.println("Estat: " + estat);
//        System.out.println("Es Gimnas: " + esGimnas);
//    }

	public static void mostrarInfo(EntrenadorIA entrenadorIA) {
	    System.out.println("ID: " + entrenadorIA.getIdEntrenador());
	    System.out.println("Nom: " + entrenadorIA.getNom());
	    System.out.println("Tipus: " + entrenadorIA.getTipus());
	    System.out.println("Estat: " + entrenadorIA.getEstat());
	    System.out.println("Es Gimnas: " + entrenadorIA.getEsGimnas());
	}
}