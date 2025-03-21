package part_01;

import java.util.Scanner;

public class Exercici_06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double[][] matriu = new double[7][4];
		double[] mitjanes = new double [7];
		String[] dies = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"}; 
		

		for (int i=0; i<7; i++) {
			for (int j=0; j<4; j++) {
		System.out.println("Introdueix la temperatura de " + dies[i] + " (" + j + ") :");
				
				matriu[i][j] =scanner.nextDouble();
				
			}
		}
		for (int i=0; i<7; i++) {
			double suma = 0;
			for (int j=0; j<4; j++) {
				suma+=matriu[i][j];
		}
			mitjanes[i] = suma / 4;
		}
		
		for (int i=0; i<7; i++) {
			
			System.out.println("La tempertarura mitjana de " +dies[i]+ " es: "+ mitjanes[i]);
	
	}
		
		 	double maxTemp = mitjanes[0];
	        double minTemp = mitjanes[0];
	        int indexMax = 0;
	        int indexMin = 0;
	        
	        for (int i = 0; i<7; i++ ) {
	        	if (mitjanes[i] > maxTemp) {
	        		maxTemp = mitjanes[i];
	        		indexMax = i;
	        	}
	        	if (mitjanes [i] < minTemp) {
	        		minTemp =mitjanes[i];
	        		indexMin = i;
	        	}
	        
	        }
	        
	        System.out.println("\nEl dia més calorós ha estat " + dies[indexMax] + " amb una temperatura mitjana de " + maxTemp);
	        System.out.println("El dia més fred ha estat " + dies[indexMin] + " amb una temperatura mitjana de " + minTemp);

	        scanner.close();
	    }
	}