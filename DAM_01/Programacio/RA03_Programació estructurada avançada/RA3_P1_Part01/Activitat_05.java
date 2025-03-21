package PART_01;

import java.util.Scanner;

public class Activitat_05 {

	public static void main(String[] args) {
		
		// Crear un array per emmagatzemar la temperatura de 7 dies
        Double[] temperatures = new Double[7];
        Scanner scanner = new Scanner(System.in);
        
        // Demanar les temperatures
        System.out.println("Introdueix les temperatures dels 7 dies de la setmana:");
        for (int i = 0; i < temperatures.length; i++) {
            System.out.print("Temperatura del dia " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
        }
            // Calcular la temperatura mitjana
            double suma = 0;
            for (double temperatura : temperatures) {
                suma += temperatura;
            }
            double mitjana = suma / temperatures.length;
            
        // Mostrar la temperatura mitjana
        System.out.println("\nLa temperatura mitjana de la setmana és: " + mitjana + "°C");

            scanner.close(); // Tancar el Scanner
        
        }
	}
