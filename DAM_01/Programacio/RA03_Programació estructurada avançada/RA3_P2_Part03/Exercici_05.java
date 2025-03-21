package PART3;

import java.util.Scanner;

public class Exercici_05 {
	

	public static void mostraPrimers (int numero) {
		
		
		for (int valor = 2; valor <= numero; valor++){
			
			boolean primo = true;
			for (int comprobar = 2; comprobar < valor-1; comprobar++){
				if (valor % comprobar == 0) {
					primo = false;
					break;
				}
			}	
				 if (primo == true) {
				System.out.println(valor+ " es primo");
			}
	}}
			
			
	
		
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	System.out.println("Introdueix un numero sencer:");
	int numero = scanner.nextInt();
	
	mostraPrimers(numero);
	scanner.close();
	
}}