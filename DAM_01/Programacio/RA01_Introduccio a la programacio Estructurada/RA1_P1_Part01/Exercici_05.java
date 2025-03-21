package P01;

import java.util.Scanner;

public class Exercici_05 {
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Cuantes hores vols veure sèries aquest cap de setmana?");
		double hores = scanner.nextDouble();
		
		int minuts = (int) (hores * 60);		
		
		System.out.println("Veure "+hores+" hores de sèries són "+minuts+" minuts en total.");
		
		scanner.close();
}
}