package part_01;

import java.util.Scanner;

public class Exercici_03 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);		
			
			int[][] matriu = new int[3][3];
			int[][] matriuDos = new int[3][3];
			int[][] matriuTres = new int[3][3];
			
	        System.out.println("Introdueix els valors per la primera matriu:");
	        llegirMatriu(scanner, matriu);
	        System.out.println("Introdueix els valors per la segona matriu:");
	        llegirMatriu(scanner, matriuDos);

	        sumarMatrius(matriu, matriuDos, matriuTres);

	        System.out.println("\nPrimera matriu:");
	        imprimirMatriu(matriu);
	        System.out.println("\nSegona matriu:");
	        imprimirMatriu(matriuDos);
	        System.out.println("\nSuma de matrius:");
	        imprimirMatriu(matriuTres);

	        scanner.close();
	    }

	    private static void llegirMatriu(Scanner scanner, int[][] matriu) {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print("Valor "+i+","+j+": ");
	                matriu[i][j] = scanner.nextInt();
	            }
	        }
	    }

	    private static void sumarMatrius(int[][] matriu, int[][] matriuDos, int[][] suma) {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                suma[i][j] = matriu[i][j] + matriuDos[i][j];
	            }
	        }
	    }

	    private static void imprimirMatriu(int[][] matriu) {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(matriu[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	}
