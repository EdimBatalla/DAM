package PART_02;

import java.util.Scanner;

public class Exercici_01 {
	
	public static void main(String[] args) {	
		
		Scanner scanner = new Scanner(System.in);
		
		double saldo = 0;
		double[] moviments = new double [100]; // Array amb el registre del moviments
		int numMoviments = 0; //comptador de moviments
		
		while (true) {
			System.out.println("\n--- Compte Bancari ---");
			System.out.println("\n1.Consulta saldo");
			System.out.println("2.Ingressar");
			System.out.println("3.Retirar");
			System.out.println("4.Consultar històric");
			System.out.println("5.Consultar major ingrés");
			System.out.println("6.Consultar major retirada");
			System.out.println("7.Consultar totals");
			System.out.println("8.Determinar Perfil");
			System.out.println("9.Sortir");
			System.out.println("\nSelecciona una opció:");
			
			int opcio = scanner.nextInt();
			
			switch (opcio) {
				
				case 1:
					System.out.println("\nEl teu saldo és: "+saldo+"€");
				break;
				
				case 2:
					System.out.println("\nQuina quantitat vols ingressar?");
					double ingres = scanner.nextDouble();
					if (ingres < 0) {
				        System.out.println("\nL'import ingressat ha de ser positiu. Torna-ho a intentar.");
				    } else if (ingres > 10000) {
						double comisio = ingres*0.02;
						ingres -= comisio;
						saldo += ingres;
						System.out.println("\nAl superar l'ingrés la quantitat de 10.000€ s'aplica una comisió del 2% que en aquest cas és de "+ comisio +"€");
						System.out.println("S'han ingressat " + ingres + " €");
						System.out.println("El teu saldo és "+saldo+"€");
						moviments[numMoviments++] = ingres;
					} else {
						saldo += ingres;
						System.out.println("\nS'han ingressat " + ingres + " €");
						System.out.println("El saldo actual és: " + saldo + " €");
						moviments[numMoviments++] = ingres;
					}
				break;
				
				case 3:
				    System.out.println("\nQuina quantitat vols retirar?");
				    double retirar = scanner.nextDouble();
				    if (saldo <= 0) {
				        System.out.println("\nNo es poden retirar diners perquè el saldo és insuficient.");
				    } else if (retirar <= 0) {
				        System.out.println("\nL'import a retirar ha de ser positiu. Torna-ho a intentar.");
				    } else if (retirar > saldo) {
				        System.out.println("\nNo es pot retirar aquesta quantitat perquè excedeix el saldo disponible.");
				    } else {
				        saldo -= retirar;
				        System.out.println("El saldo actual és: " + saldo + " €");
				        moviments[numMoviments++] = -retirar;
				    }
				    break;
				
				case 4:
					System.out.println("\nHistòric de moviments:");
					for (int i = 0; i < numMoviments; i++) {
						System.out.println("\n Moviment" + (i+1) + "."+ moviments[i] +"€");
					}
				break;
				
				case 5:
					double maxPositiu = 0;
		            for (int i = 0; i < numMoviments; i++) {
		                if (moviments[i] > 0 && moviments[i] > maxPositiu) {
		                    maxPositiu = moviments[i];
		                }
		            }
		            if (maxPositiu == 0) {
		                System.out.println("\nNo hi ha ingressos registrats.");
		            } else {
		                System.out.println("\nEl moviment positiu més gran és: " + maxPositiu + " €");
		            }
				break;
				
				case 6:
					 double maxNegatiu = 0;
			            for (int i = 0; i < numMoviments; i++) {
			                if (moviments[i] < 0 && moviments[i] < maxNegatiu) {
			                    maxNegatiu = moviments[i];
			                }
			            }
			            if (maxNegatiu == 0) {
			                System.out.println("\nNo hi ha retirades registrades.");
			            } else {
			                System.out.println("\nEl moviment negatiu més gran és: " + maxNegatiu + " €");
			            }
				break;
				
				case 7:
					double sumaIngressos = 0;
		            double sumaRetirades = 0;
		            for (int i = 0; i < numMoviments; i++) {
		                if (moviments[i] > 0) {
		                    sumaIngressos += moviments[i];
		                } else {
		                    sumaRetirades += -moviments[i];
		            	}
		            }
		            System.out.println("\nSuma total d'ingressos: " + sumaIngressos + " €");
		            System.out.println("\nSuma total de retirades: " + sumaRetirades + " €");
		            break;
				
				case 8:
					double totalIngressos = 0;
		            double totalRetirades = 0;
		            for (int i = 0; i < numMoviments; i++) {
		                if (moviments[i] > 0) {
		                    totalIngressos += moviments[i];
		                } else {
		                    totalRetirades += -moviments[i];
		                }
		            }
		            if (totalIngressos > totalRetirades) {
		                System.out.println("\nEl perfil del compte és: Estalviador");
		            } else if (totalRetirades > totalIngressos) {
		                System.out.println("\nEl perfil del compte és: Gastador");
		            } else {
		                System.out.println("\nEl perfil del compte és equilibrat.");
		            }
		            break;
		            
				case 9:
		            System.out.println("\nSortint del programa...");
		            scanner.close();
		            return;
		        
		        default:
		            System.out.println("\nOpció no vàlida, torna a provar.");
		            break;	
					
			}
			
		}
		
		
	}
}