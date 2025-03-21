package PART_01;

import java.util.Scanner;

public class Activitat_04 {

	public static void main(String[] args) {

		// Crear un array per emmagatzemar els noms dels jugadors
        String[] jugadors = new String[5];
        Scanner scanner = new Scanner(System.in);
        
        // Demanar els noms dels jugadors
        System.out.println("Introdueix els noms dels 5 jugadors/es de l'equip:");
        for (int i = 0; i < jugadors.length; i++) {
            System.out.print("Nom del jugador/a " + (i + 1) + ": ");
            jugadors[i] = scanner.nextLine();
            }
        
        // Mostrar els noms en ordre invers
        System.out.println("\nNoms dels jugadors/es en ordre invers:");
        for (int i = jugadors.length - 1; i >= 0; i--) {
            System.out.println(jugadors[i]);
        }
        
            scanner.close(); // Tanquem l'objecte Scanner
        }
    }