package P01;

import java.util.Scanner;

public class Exercici_08 {
	
	public static void main(String[] args) {	

			Scanner scanner = new Scanner(System.in);
			
			double saldo = 1000.0;
			
				System.out.println("--- Compte Bancari ---");
				System.out.println("1. Consultar saldo");
				System.out.println("2. Dipositar diners");
				System.out.println("3. Retirar diners");
				System.out.println("4. Sortir");
				System.out.print("Selecciona una opció: ");
 
            int opcio = scanner.nextInt();

            switch (opcio) {
            
            case 1:
                System.out.print("El seu saldo és: "+saldo+"€");
                               
            break;
            
            case 2:
            	System.out.println("Quina quantitat vol dipositrar?");
            			float ingressar = scanner.nextFloat();
            			
            			float saldoAct = (float) (ingressar + saldo);
            	System.out.printf("Has dipositat "+ingressar+"€. Saldo actual: "+saldoAct+"€");
            			
            break;		
            
            case 3:
            	System.out.println("Quina quantitat vol retirar?");
            			float retirar = scanner.nextFloat();
            			
            			float saldoAct2 = (float) (saldo - retirar);
                    	System.out.printf("Has retirat "+retirar+"€. Saldo actual: "+saldoAct2+"€");
            break;
            
            case 4:
            	System.out.println("Gràcies per utilitzar els nostres serveis");
            break;            
            }          
                        
            scanner.close();

	}
}