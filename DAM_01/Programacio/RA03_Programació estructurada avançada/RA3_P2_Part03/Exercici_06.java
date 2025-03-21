package PART3;

import java.util.Scanner;

public class Exercici_06 {

	// es cridara la funcio segons el numero de valors que introduim.
	public static int sumaDos(int numA, int numB) {

		return numA + numB;

	}

	public static int sumaTres(int numA, int numB, int numC) {

		return numA + numB + numC;

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introdueix el primer numero:");
		int numA = scanner.nextInt();
		System.out.println("Introdueix el segon numero:");
		int numB = scanner.nextInt();

		System.out.println("vols introduir un tercer numero? s/n");

		String pregunta = scanner.next();

		if (pregunta.equals("s")) {
			System.out.println("Introdueix el tercer numero:");
			int numC = scanner.nextInt();
			System.out.println("La suma de tres números és: " + sumaTres(numA, numB, numC));
		} else {
			System.out.println("La suma de dos números és: " + sumaDos(numA, numB));
		}

		scanner.close();
	}
}