package P01_Part2;

import java.util.Scanner;

public class Exercici_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introdueix un numero del 1 al 7:");
        int num = scanner.nextInt();
        
        if (num == 1) {
            System.out.println("Dilluns");
        }else if (num == 2) {
        	System.out.println("Dimarts");
        }else if (num == 3) {
        	System.out.println("Dimecres");
        }else if (num == 4) {
        	System.out.println("Dijous");
        }else if (num == 5) {
        	System.out.println("Divendres");
        }else if (num == 6) {
        	System.out.println("Dissabte");
        }else if (num == 7) {
        	System.out.println("Diumenge");
        }else {
        	System.out.println("Número no vàlid.");
        }	
        
        scanner.close();
        
    }
}