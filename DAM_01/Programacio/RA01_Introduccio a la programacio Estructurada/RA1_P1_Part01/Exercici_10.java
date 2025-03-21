package P01;

import java.util.Scanner;

public class Exercici_10 {
	
	public static void main(String[] args) {	

			Scanner scanner = new Scanner(System.in);
           
			System.out.print("Introdueix el capital prestat:");
			float capital = scanner.nextFloat();			
			
			System.out.print("Introdueix tipus d'interès anual:");
			float interes = scanner.nextFloat();	
			
			System.out.print("Introdueix quants quants anys disposen per retornar el préstec:");
			float anys = scanner.nextFloat();
			
			
			float interesMensual = interes / 12 / 100;
			float numMesos = anys * 12;
			
			double quotaMensual = (capital * interesMensual * Math.pow(1 + interesMensual, numMesos)) 
                    / (Math.pow(1 + interesMensual, numMesos) - 1);
			
			System.out.println("Amb un préstec de "+capital+" euros al "+interes+" % a pagar en "+anys+" anys, hauràs de pagar "+quotaMensual+" euros al mes.");
			
scanner.close();

}

}			