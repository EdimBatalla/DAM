package Exercici_05;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Llibre llibre1 = new Llibre("La Comunidad del Anillo","J.R.R. Tolkien",1954);
		Llibre llibre2 = new Llibre("Las dos Torres","J.R.R. Tolkien",1954);
		Llibre llibre3 = new Llibre("El retorno del Rey","J.R.R. Tolkien",1955);
		
		System.out.println("\nInformació dels llibres:");
		llibre1.mostrarInfo();
		llibre2.mostrarInfo();
		llibre3.mostrarInfo();
		
		Llibre llibre0 = new Llibre ("","",0);
		llibre0.setAnyPublicacio(1937);
		llibre0.setAutor("J.R.R. Tolkien");
		llibre0.setTitol("El Hobbit");
		
		System.out.println("Títol: " + llibre0.getTitol() + ", Autor: " + llibre0.getAutor() + ", Any de Publicació: " + llibre0.getAnyPublicacio());
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Llibre> llibres = new ArrayList<>();
		System.out.println("Quants llibres vols introduir?");
		int numLlibres = scanner.nextInt();
		scanner.nextLine();
		
		for (int i=0; i<numLlibres; i++) {
			System.out.println("Introdueix la informacio del llibre " + (i+1));
			System.out.println("Títol: ");
			String titol=scanner.nextLine();
			System.out.println("Autor: ");
			String autor=scanner.nextLine();
			System.out.println("Any de la publicació:");
			int anyPublicacio = scanner.nextInt();
			scanner.nextLine();
			llibres.add(new Llibre(titol,autor,anyPublicacio));	
		}
		
		System.out.println("\nLlista de llibre intorduïts:");
		for(Llibre llibre:llibres) {
			llibre.mostrarInfo();
		}
		scanner.close();
		}
		
		
	}	
