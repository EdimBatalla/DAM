package part_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici_01_Arraylist {

	public static void main(String[] args) {
		
		ArrayList<String> assistents = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		afegirAssistents(assistents, scanner);
        mostraAssistents(assistents);

	}
	
	public static void afegirAssistents(ArrayList<String> assistents, Scanner scanner) {
		String resposta;
		do {
		System.out.print("Afegeix el seguent assistent:");
		String assistant = scanner.nextLine();
        assistents.add(assistant); 
        System.out.print("Vols afegir més assistents?: s/n");
		resposta = scanner.nextLine();
		
		} while (resposta.equals ("s"));
		}
	
	public static void mostraAssistents(ArrayList<String> assistents) {
		System.out.println(assistents.size());
		System.out.println(assistents);
	}
}

