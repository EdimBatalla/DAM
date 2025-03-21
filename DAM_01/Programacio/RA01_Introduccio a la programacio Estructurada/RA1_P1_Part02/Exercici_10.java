package P01_Part2;

import java.util.Scanner;

public class Exercici_10 {
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.print("Introdueix un número enter: ");
    int numero = scanner.nextInt();

    System.out.println("Taula de multiplicar del " + numero + ":");
    for (int i = 0; i <= 10; i++) {
        System.out.println(numero + " x " + i + " = " + (numero * i));
    }

    scanner.close();
}
}