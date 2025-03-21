package P01;

import java.util.Scanner;

public class Exercici_07 {
	
	public static void main(String[] args) {	

			Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introdueix el teu pes en quilograms:");
		float pes = scanner.nextFloat();
		
		System.out.print("Introdueix la teva alçada en metres:");
		float altura = scanner.nextFloat();
		
		float imc = pes / (altura * altura);
		System.out.println("El teu IMC és "+imc+".");
		
		scanner.close();
}
}