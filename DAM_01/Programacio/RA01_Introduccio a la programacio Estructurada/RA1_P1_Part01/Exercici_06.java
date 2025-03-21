package P01;

import java.util.Scanner;

public class Exercici_06 {
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introdueix el preu brut del producte: ");
		float preuBrut = scanner.nextFloat();
		
		System.out.print("Introdueix el % del IVA: ");
		int iva =  scanner.nextInt();
				
				
		float preuNet = (float) (preuBrut * iva / 100f + preuBrut);
					
		System.out.println("El preu amb IVA inclòs és de "+preuNet+"€");
		
		scanner.close();
}
}