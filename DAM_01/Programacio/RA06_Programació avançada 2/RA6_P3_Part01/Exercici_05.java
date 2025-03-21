package part_01;

import java.util.Scanner;

public class Exercici_05 {

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			
			int[][] matriu = new int[3][3];

			System.out.println("introdueix els valors per la matriu:");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.println("El valor de la posició " + i + "," + j + ":");

					matriu[i][j] = scanner.nextInt();
				}
			}
			System.out.println("\nMatriu Introduida:");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(matriu[i][j] + "");
				}
				System.out.println();
			}

	        for (int j = 0; j < 3; j++) {
	            int sumaColumnes = 0;
	            for (int i = 0; i < 3; i++) { 
	                sumaColumnes += matriu[i][j];
	            }
	            System.out.println("La suma de la columna " + (j + 1) + " és: " + sumaColumnes);
	        }

	        scanner.close();
	    }
	}
			
		

