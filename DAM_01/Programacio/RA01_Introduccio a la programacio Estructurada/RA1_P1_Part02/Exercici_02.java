package P01_Part2;

import java.util.Scanner;

public class Exercici_02 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.print("Introdueix la nota del examen:");
	double nota = scanner.nextDouble();
	
	if (nota >= 9 && nota <= 10) {
         System.out.println("Excel·lent");
	}else if (nota >= 7 && nota < 9) {
    	System.out.println("Notable");
	}else if (nota >= 5 && nota < 7 ) {
    	System.out.println("Aprobat");
	}else if ( nota >= 0 && nota <5) {
    	System.out.println("Suspès");
	}else {
		System.out.println("La nota ha d'estar entre 0 i 10");
	}

	scanner.close();
	}
}
