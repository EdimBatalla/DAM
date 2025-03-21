package P01_Part2;

import java.util.Scanner;

public class Exercici_14 {
	
	    public static void main(String[] args) {
	    	Scanner scanner = new Scanner(System.in);
	    	
	    	System.out.print("Introdueix una paraula: ");
	        String paraula = scanner.nextLine();

	        System.out.println("Forma triangular de la paraula:");
	        for (int i = 1; i <= paraula.length(); i++) {
	            System.out.println(paraula.substring(0, i));
	        }

	        scanner.close();
	    }
	}