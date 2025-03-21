package P01;

import java.util.Scanner;

public class Exercici_04 {
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introdueix la temperetura en graus Celsius:");
		double temperaturaCelsius = scanner.nextDouble();
		
		double temperaturaFarenheit = (temperaturaCelsius * 9 / 5 + 32);
		
		System.out.println("Si la temperatura en graus Celsius es de "+temperaturaCelsius+" en graus Farenheit sera equivalent a "+temperaturaFarenheit+".");
		
scanner.close();
				
}
}