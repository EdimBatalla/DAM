package PART3;

import java.util.Scanner;
import java.util.Random;

public class Exercici_09 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int endivina = random.nextInt(99) + 1;
		int numero;

		boolean encertat = false;

		System.out.println("Introdueix un numero del 1 al 100:");

		while (!encertat) {
			numero = scanner.nextInt();

			encertat = endevinaNumero(numero, endivina);
		}
		scanner.close();
	}

	public static boolean endevinaNumero(int numero, int endivina) {

		if (numero < endivina) {
			System.out.println("El numero es més gran, torna a intentar-ho.");
			return false;
		} else if (numero > endivina) {
			System.out.println("El numero es més petit, torna a intentar-ho.");
			return false;
		} else {
			System.out.println("El numero es correcte!");
			return true;

		}

	}
}
