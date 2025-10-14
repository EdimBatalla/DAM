package Exercici_02;

public class Main {
	
	public static void main(String[] args) {
		
		Llibre llibre1 = new Llibre("La Comunidad del Anillo","J.R.R. Tolkien",1954);
		Llibre llibre2 = new Llibre("Las dos Torres","J.R.R. Tolkien",1954);
		Llibre llibre3 = new Llibre("El retorno del Rey","J.R.R. Tolkien",1955);
		
		System.out.println("\nInformació dels llibres:");
		llibre1.mostrarInfo();
		llibre2.mostrarInfo();
		llibre3.mostrarInfo();
	
	}
	
}