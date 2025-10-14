package Exercici_09;

public class Llibre {

	private String titol;
	private String autor;
	private int anyPublicacio;
	private static int comptadorLlibres = 0; 

	public Llibre(String titol, String autor, int anyPublicacio) {
		this.titol = titol;
		this.autor = autor;
		this.anyPublicacio = anyPublicacio;
		comptadorLlibres++;
	}
	
	public String getTitol() { return titol; }
	public void setTitol(String titol) { this.titol = titol; }
	public String getAutor() { return autor; }
	public void setAutor(String autor) { this.autor = autor; }
	public int getAnyPublicacio() { return anyPublicacio; }
	public void setAnyPublicacio(int anyPublicacio) { this.anyPublicacio = anyPublicacio; }

	
	public void mostrarInfo() {
		System.out.println("Títol: " + titol + ", Autor: " + autor + ", Any de Publicació: " + anyPublicacio);
		}
	
	public static void comptarLlibres() {
		
		 System.out.println("\nHi ha " + comptadorLlibres + " llibres en total.");
		
	}
	
}



