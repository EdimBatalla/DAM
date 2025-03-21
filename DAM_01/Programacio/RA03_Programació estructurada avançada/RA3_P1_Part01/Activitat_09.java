package PART_01;

import java.util.Scanner;

public class Activitat_09 {

    // Programa per ordenar una llista de notes
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);

        // Crear l'array per guardar les notes
        double[] notes = new double[10];

        // Demanar les notes per pantalla
        System.out.println("Introdueix 10 notes:");
        for (int i = 0; i < notes.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notes[i] = scanner.nextDouble();
        }

        // Ordenar l'array en ordre ascendent sense funcions predefinides
        for (int i = 0; i < notes.length - 1; i++) {
            for (int j = i + 1; j < notes.length; j++) {
                if (notes[i] > notes[j]) {
                    // Intercanviar els valors
                    double temp = notes[i];
                    notes[i] = notes[j];
                    notes[j] = temp;
                }
            }
        }

        // Mostrar l'array ordenat per pantalla
        System.out.println("\nNotes ordenades en ordre ascendent:");
        for (double nota : notes) {
            System.out.print(nota + " ");
        }
    scanner.close();
    }
}


