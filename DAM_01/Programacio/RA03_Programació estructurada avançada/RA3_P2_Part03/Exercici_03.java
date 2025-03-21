package PART3;

import java.util.Scanner;

public class Exercici_03 {
	

public static int calculaQuadrat (int numero) {
	int resultatOperacio =  numero * numero;
	return resultatOperacio;
}
	
	public static void main(String[] args) {
		
		int numero1;
		int numero2;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introdueix un numero per saber-ne el quadrat:");
		numero1 = scanner.nextInt();
	
		System.out.println("Introdueix un segon numero per saber-ne el quadrat:");
		numero2 = scanner.nextInt();
		
		int resultat1 = calculaQuadrat(numero1);
		int resultat2 = calculaQuadrat(numero2);
		
		System.out.println("El quadrat del numero" +numero1+ "és igual a " +resultat1);
		System.out.println("I el quadrat del numero" +numero2+ "és igual a " +resultat2);
	
		scanner.close();
	}
	
}

