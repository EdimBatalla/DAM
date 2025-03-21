package part_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici_02_Arraylist {

    
    public static void main(String[] args) {
    	
    	ArrayList<String> alumnes = new ArrayList<>();
    	ArrayList<Double> notes = new ArrayList<>();
    	ArrayList<Boolean> aprovats = new ArrayList<>();
    	Scanner scanner = new Scanner(System.in);
    	
    	afegirNotes(alumnes, notes, scanner);
    	comprobarAprovats(notes, aprovats);
    	imprimir(alumnes, aprovats, notes);
}

	public static void afegirNotes(ArrayList<String> alumnes, ArrayList<Double> notes, Scanner scanner) {
		String resposta;
		do {
			System.out.print("Afegeix el seguent alumne: ");
			String alumne = scanner.nextLine();
			alumnes.add(alumne); 
			System.out.print("Afegeix la seva nota: ");
			double nota = scanner.nextDouble();
			notes.add(nota); 
			scanner.nextLine();
			System.out.print("Vols afegir més dades?: s/n");
			resposta = scanner.nextLine();
		
		} while (resposta.equals ("s"));
	}
	
	public static void comprobarAprovats(ArrayList<Double> notes,ArrayList<Boolean> aprovats) {
		for (double nota : notes) { 
		if (nota >= 5) {
			aprovats.add(true);
		} else {
			aprovats.add(false);
		}
	}
	}
	
	public static void imprimir(ArrayList<String> alumnes, ArrayList<Boolean> aprovats, ArrayList<Double> notes) {
		for (int i = 0; i < alumnes.size(); i++) {
			System.out.println("\nAlumne: " + alumnes.get(i) + ": " + (aprovats.get(i) ? "aprovat" : "suspes") + " amb " + notes.get(i));

		
	}
	}
}
