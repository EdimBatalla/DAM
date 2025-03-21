package P01_Part2;

import java.util.Scanner;

public class Exercici_06 {
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	System.out.print("Introdueix un primer numero:");
	double num1 = scanner.nextDouble();
	
	System.out.print("Introdueix un segon número:");
	double num2 = scanner.nextDouble();
	
	System.out.print("Escull entre les següents operacions:(+, -, *, /)");
	char operacio = scanner.next().charAt(0);
	
	double resultat;
	
	 switch (operacio) {
     case '+':
         resultat = num1 + num2;
         System.out.println("El resultat de la suma és: " + resultat);
         break;
     case '-':
         resultat = num1 - num2;
         System.out.println("El resultat de la resta és: " + resultat);
         break;
     case '*':
         resultat = num1 * num2;
         System.out.println("El resultat de la multiplicació és: " + resultat);
         break;
     case '/':
    	 if (num2 != 0) {
         resultat = num1 / num2;
         System.out.println("El resultat de la divisió és: " + resultat);
    	 } else {
             System.out.println("No es pot dividir entre 0.");
    	 }
             break;
     default:
         System.out.println("Operació no vàlida. Introdueix una de les següents: +, -, *, /.");
 }
     scanner.close();
     
 }
}