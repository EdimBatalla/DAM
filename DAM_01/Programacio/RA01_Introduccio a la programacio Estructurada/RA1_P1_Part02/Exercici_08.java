package P01_Part2;

import java.util.Scanner;

public class Exercici_08 {
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	 String paraula;

     do {
         System.out.print("Escriu la paraula màgica: ");
         paraula = scanner.nextLine();
     } while (!paraula.equalsIgnoreCase("si us plau"));

     System.out.println("Gràcies!");
     scanner.close();

}
}