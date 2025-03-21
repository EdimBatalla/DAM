package PART_01;

public class Activitat_08 {
	// Programa per comptar partits amb més de 2 gols marcats
	    public static void main(String[] args) {
	        // Array amb els gols marcats en els 10 últims partits
	        int[] gols = {4, 2, 5, 3, 1, 5, 2, 4, 3, 1};

	        // Variable per comptar els partits amb més de 2 gols
	        int partitsMesDeDosGols = 0;

	        // Recorre l'array i compta els partits amb més de 2 gols
	        for (int gol : gols) {
	            if (gol > 2) {
	                partitsMesDeDosGols++;
	            }
	        }

	        // Mostrar el resultat
	        System.out.println("Nombre de partits amb més de 2 gols: " + partitsMesDeDosGols);
	    }
	}

