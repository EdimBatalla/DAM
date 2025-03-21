package part_01;

import java.util.Scanner;

public class Exercici_02 {

public static void main(String[] args) {
	
	Scanner Scanner = new Scanner (System.in);		
		
		int[][] matriu ={ {1,2}, {3,4} };
		int[][] matriuDos = new int[2][2];
		
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
			
System.out.print(matriu[i][j] + "");
			}
System.out.println();
}
		System.out.println("Pots introduir nous numeros.");
		
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				System.out.println("introdueix els calors per la matriu["+i+"]["+j+"]:");
				
				matriuDos[i][j] = Scanner.nextInt();
			
			}
		}
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
			if (matriu[i][j] == matriuDos[i][j]) {
				System.out.println("En la posició "+i+","+j+" el valor no ha canviat, segueix sent "+matriu[i][j]);
			}else {
				
				System.out.println("En la posició "+i+","+j+" hi havia el valor "+matriu[i][j]+" i ara hi ha el valor "+matriuDos[i][j] );
			}
}
}
        Scanner.close();
    }
}
		
