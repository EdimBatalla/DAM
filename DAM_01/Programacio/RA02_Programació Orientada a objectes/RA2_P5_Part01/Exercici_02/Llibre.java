package Exercici_02;

public class Llibre {

	private String titol;
	private String autor;
	private int anyPublicacio;

	public Llibre(String titol, String autor, int anyPublicacio) {
		this.titol = titol;
		this.autor = autor;
		this.anyPublicacio = anyPublicacio;
	}
	
	public void mostrarInfo() {
		System.out.println("Títol: " + titol + ", Autor: " + autor + ", Any de Publicació: " + anyPublicacio);
		}
}