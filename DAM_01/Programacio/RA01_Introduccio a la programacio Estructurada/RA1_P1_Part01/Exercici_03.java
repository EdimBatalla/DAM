package P01;

import java.util.Scanner;

public class Exercici_03 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introdueix el preu del producte:");
		double preu	= scanner.nextDouble();
		System.out.print("Introdueix el percentatge de descompte:");
		int percentatgeDescompte = scanner.nextInt();
		
		int descompte = (int) (preu * percentatgeDescompte / 100);
		double preuFinal = preu - descompte;
		
		System.out.println ("El preu final després d'un descompte de "+percentatgeDescompte+"% és de "+preuFinal+" euros.");
		
scanner.close();				
	}
}
