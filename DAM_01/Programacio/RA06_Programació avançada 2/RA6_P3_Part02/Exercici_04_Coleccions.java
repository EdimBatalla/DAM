package part_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici_04_Coleccions {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Integer> numeros = new ArrayList<>();
	        
	        System.out.println("Introdueix 10 números del 1 al 10:");
	
	        for (int i = 0; i < 10; i++) {
	            int num = scanner.nextInt();
	  
	            if (num < 1 || num > 10) {
	                System.out.println("El número ha de ser entre 1 i 10. Torna a introduir:");
	                i--; 
	                continue;
	            }
	            numeros.add(num);
	        }
	        
	        System.out.println("Introdueix un altre número:");
	        int x = scanner.nextInt();
	        
	        int count = 0;
	        for (int num : numeros) {
	            if (num == x) {
	                count++;
	            }
	        }
	        
	        System.out.println("El número " + x + " apareix " + count + " vegades a la llista.");
	        scanner.close();
	    }
	}
