package P01;

import java.util.Scanner;

public class Exercici_09 {
	
	public static void main(String[] args) {	

			Scanner scanner = new Scanner(System.in);
           
			System.out.print("Introdueix el cost dels billets del transport:");
			float transport = scanner.nextFloat();			
			
			System.out.print("Introdueix el cost per nit en el hotel:");
			float hotel = scanner.nextFloat();	
			
			System.out.print("Introdueix quantes nits et quedaràs en el hotel?");
			float nits = scanner.nextFloat();
			
			float preuTotal = transport + ( hotel * nits );
			
			System.out.println("El cost total del teu viatge serà de "+preuTotal+"€.");
			
scanner.close();

}
}			