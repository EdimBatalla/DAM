package P01_Part2;

import java.util.Scanner;

public class Exercici_09 {
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int numero;

	do {
		System.out.print("Intente endevinar un numero dintre el rang correcte: ");
		numero = scanner.nextInt();
    if (numero < 1 || numero > 100) {
        System.out.println("Número fora de rang. Torna a intentar-ho.");
    }
	} while (numero < 1 || numero > 100);

	System.out.println("El número " + numero + " és vàlid. Gràcies!");

	scanner.close();
}
}