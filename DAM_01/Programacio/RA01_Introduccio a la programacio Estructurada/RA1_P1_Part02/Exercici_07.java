package P01_Part2;

import java.util.Scanner;

public class Exercici_07 {
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.print("Introdueix un numero sencer:");
    int num = scanner.nextInt();
    
    int i = num - 1; 
    do {
        System.out.println(i); 
        i--; 
    } while (i >= 0); 
    
    scanner.close(); 
}
}