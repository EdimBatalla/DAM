package P01_Part2;

import java.util.Scanner;

public class Exercici_01 {
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	System.out.print("Introdueix el nom d'usuari:");
	String usuari = scanner.nextLine();
	
	System.out.print("Introdueix la teva contrasenya (només numeros):");
	String contrasenya	= scanner.nextLine();
	
	 if (usuari.equals("admin") && contrasenya.equals("1234")) {
         System.out.println("Accés concedit");
     } else {
         System.out.println("Accés denegat");
     }

	scanner.close();
	}
}
