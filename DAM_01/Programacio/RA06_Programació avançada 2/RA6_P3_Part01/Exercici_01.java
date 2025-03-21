package part_01;

import java.util.Scanner;

public class Exercici_01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[][] matriu = new int[3][3];
		
		System.out.println("Introdueix un valor per omplir la matriu");
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.println("introdueix els valors per la matriu["+i+"]["+j+"]:");
			
				matriu[i][j] = scanner.nextInt();
			
			}
		}
		
		System.out.println("\nMatriu Introduida:");
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(matriu[i][j] +"");
			}
			System.out.println();
		}
		scanner.close();
	}
}
