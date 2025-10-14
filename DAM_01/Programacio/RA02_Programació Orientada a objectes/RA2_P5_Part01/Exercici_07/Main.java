package Exercici_07;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
			
			Scanner scanner = new Scanner(System.in);
			Biblioteca biblioteca = new Biblioteca();
			
			Llibre llibre0 = new Llibre ("El Hobbit","J.R.R. Tolkien",1930);
			Llibre llibre1 = new Llibre("La Comunidad del Anillo","J.R.R. Tolkien",1954);
			Llibre llibre2 = new Llibre("Las dos Torres","J.R.R. Tolkien",1954);
			Llibre llibre3 = new Llibre("El retorno del Rey","J.R.R. Tolkien",1955);
			
			biblioteca.llibresIntroduits(llibre0);
			biblioteca.llibresIntroduits(llibre1);
	        biblioteca.llibresIntroduits(llibre2);
	        biblioteca.llibresIntroduits(llibre3);
			
			int opcio;
			
			do {
				System.out.println("Gestor de Llibres:");
				System.out.println("\n1. Afegir llibre");
				System.out.println("2. Mostrar llibres");
				System.out.println("3. Buscar llibre");
				System.out.println("4. Sortir");
				System.out.println("Selecciona una opció:");
				opcio = scanner.nextInt();
				scanner.nextLine();
				
				switch(opcio) {
				case 1:
				biblioteca.afegirLlibre();
				break;
				case 2:
				biblioteca.mostrarLlibres();
				Llibre.comptarLlibres();
				break;
				case 3:
				biblioteca.buscarLlibre();
				break;
				case 4:
				System.out.println("\nSortint del programa...");
				break;
				default:
			    System.out.println("\nOpció incorrecta.");
				break;
				}
			} 
			while (opcio !=4);
			
			scanner.close();
			}				
		}	