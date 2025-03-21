package P01_Part2;

import java.util.Scanner;

public class Exercici_11 {
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.print("Introdueix un número enter: ");
    int numero = scanner.nextInt();
    int suma = 0;

    for (int i = 1; i <= numero; i++) {
        suma += i;
       
        System.out.println("La suma dels números del 1 al " + numero + " és: " + suma);
   
    }

    scanner.close();
}
}