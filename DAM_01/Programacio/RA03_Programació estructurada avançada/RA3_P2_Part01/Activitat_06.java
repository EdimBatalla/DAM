package PART_01;

public class Activitat_06 {
	
	// Generar l'array amb els resultats de la taula de multiplicar del 5 en Java
	    public static void main(String[] args) {
	        // Crear un array per guardar els resultats
	        int[] taula5 = new int[10];

	        // Omplir l'array amb els valors de la taula del 5
	        for (int i = 0; i < taula5.length; i++) {
	            taula5[i] = 5 * (i + 1);
	        }

	        // Mostrar els resultats en el format "5 x i = resultat"
	        for (int i = 0; i < taula5.length; i++) {
	            System.out.println("5 x " + (i + 1) + " = " + taula5[i]);
	        }
	    }
	}


