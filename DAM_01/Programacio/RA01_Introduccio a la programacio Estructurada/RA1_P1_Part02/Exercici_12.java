package P01_Part2;

import java.util.Scanner;

public class Exercici_12 {
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

    System.out.print("Introdueix un número: ");
    int numero = scanner.nextInt();

    System.out.println("Números parells entre 1 i " + numero + ":");
    for (int i = 1; i <= numero; i++) {
        if (i % 2 == 0) { 
            System.out.println(i);
        }
    }

    scanner.close();
}
}