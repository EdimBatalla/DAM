package PART3;

import java.util.Scanner;

public class Exercici_10 {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int[] numerosArray = new int[10];
	int total = 0;
	int opcio;
	
	do {
		System.out.println("\n---Gestor de Números---");
		System.out.println("\n1.Afegir un número.");
		System.out.println("2.Mostrar un número.");
		System.out.println("3.Calcular mitjana.");
		System.out.println("4.Sortir.");
		System.out.println("Escull una opció.");
		opcio = scanner.nextInt();
		
		switch (opcio) {
		case 1:
			System.out.println("\nIntrodueix un número");
			int numero = scanner.nextInt();
					total = afegir(numerosArray, numero, total);
			
			break;
		
		case 2:
			System.out.println("Els numeros son:");
			mostra(numerosArray, total);
			break;
			
		case 3:
			double mitjana = mitjana (numerosArray, total);
			System.out.println("La mitjana es:" + mitjana);
			break;
			
		 case 4:
             System.out.println("Sortint del programa.");
             break;
}
	} while (opcio !=4);
		
		scanner.close();}


public static int afegir(int[] array, int numero, int total) {
	
if (total < 10) {
	array[total] = numero;
	System.out.println("afegit");
	return total + 1;
}else {
	System.out.println("L'array està ple.");
	return total;
}
}

public static void mostra(int[] array, int total ) {
	if (total == 0) {
		System.out.println("L'array no te cap número.");
	} else {
		for (int i = 0; i < total; i++) {
			System.out.println("Els números son: "+array[i]);
		}
	}
}

public static double mitjana(int[] array, int total) {
	int suma = 0;
	for (int i = 0; i < total; i ++) {
		suma += array[i];
	}
	return (double) suma / total;
}
}
