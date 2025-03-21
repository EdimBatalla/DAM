package PART3;

import java.util.Scanner;

public class Exercici_07 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("introdueix un numero:");
		int num = scanner.nextInt();

		System.out.println("El seu factorial es: " + factorial(num));

		scanner.close();
	}

	public static int factorial(int numero) {

		int factorial = 1;
		for (int i = 1; i <= numero; ++i) {
			factorial *= i;
		}
		return factorial;

	}
}