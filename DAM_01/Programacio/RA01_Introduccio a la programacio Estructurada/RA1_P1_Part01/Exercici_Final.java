package P01;

import java.util.Scanner;

public class Exercici_Final {

	public static void main(String[] args) {	

			Scanner scanner = new Scanner(System.in);
			int punts = 0;

			System.out.println("Benvingut al Quiz del número 8");
			System.out.print("Pregunta 1: Quant és 8 + 8?");

			int resposta1 = scanner.nextInt();	
				if (resposta1 == 16) {

				System.out.println("Correcte!");
				punts++;
				} else {
				System.out.println("Incorrecte.");
				System.out.println("La resposta correcta era 16.");
				}

			System.out.print("Pregunta 2: Quant es 8 - 8?");
			int resposta2 = scanner.nextInt();
				if (resposta2 == 0) {
				System.out.println("Correcte!");
				punts++;
				} else {
				System.out.println("Incorrecte.");
				System.out.println("La resposta correcta era 0.");
				}

			System.out.print("Pregunta 3: Quant es 8 x 8?");
			int resposta3 = scanner.nextInt();
				if (resposta3 == 64) {
				System.out.println("Correcte!");
				punts++;
				} else {
				System.out.println("Incorrecte.");
				System.out.println("La resposta correcta era 64.");
				}

				System.out.println("\nPuntuació final: "+punts+" de 3.");

				if (punts == 3) {
		            System.out.println("Enhorabona! Has guanyat el Quiz del número 8!");
		        } else {
		            System.out.println("Gràcies per participar i pel teu esforç!");
		        }

				scanner.close();

	}	

}