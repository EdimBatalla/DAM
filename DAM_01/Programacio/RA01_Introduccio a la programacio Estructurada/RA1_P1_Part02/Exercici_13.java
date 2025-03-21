package P01_Part2;

import java.util.Scanner;
import java.util.Random;

public class Exercici_13 {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        int numeroAleatori = random.nextInt(100) + 1;
	        int intent, intents = 0;

	        System.out.println("Endevina el número (entre 1 i 100):");

	        do {
	            System.out.print("Introdueix un número: ");
	            intent = scanner.nextInt();
	            intents++;

	            if (intent < numeroAleatori) {
	                System.out.println("El número és més gran!");
	            } else if (intent > numeroAleatori) {
	                System.out.println("El número és més petit!");
	            }
	        } while (intent != numeroAleatori);

	        System.out.println("Enhorabona! Has endevinat el número en " + intents + " intents.");
	        scanner.close();
	    }
	}