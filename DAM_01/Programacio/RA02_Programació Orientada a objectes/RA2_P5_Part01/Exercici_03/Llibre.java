package Exercici_03;

public class Llibre {

	private String titol;
	private String autor;
	private int anyPublicacio;

	public Llibre(String titol, String autor, int anyPublicacio) {
		this.titol = titol;
		this.autor = autor;
		this.anyPublicacio = anyPublicacio;

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
}