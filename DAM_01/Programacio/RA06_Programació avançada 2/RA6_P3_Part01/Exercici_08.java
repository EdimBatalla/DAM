package part_01;

import java.util.Scanner;

public class Exercici_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] estudiants = {"Estudiant_01", "Estudiant_02", "Estudiant_03", "Estudiant_04", "Estudiant_05"};
        String[] assignatures = {"Assignatura A", "Assignatura B", "Addignatura C"};
        int[][] notes = new int[5][3];


        for (int i = 0; i < 5; i++) {
            System.out.println("\nIntroduint les notes per a: " + estudiants[i]);
            for (int j = 0; j < 3; j++) {
                System.out.print(assignatures[j] + ": ");
                notes[i][j] = scanner.nextInt();
            }
        }


        int millorNotaTotal = 0;
        String millorEstudiant = "";

        int pitjorNota = notes[0][0]; 
        String pitjorEstudiant = estudiants[0];
        String assignaturaPitjor = assignatures[0];


        System.out.println("\nTotes les notes:");
        for (int i = 0; i < 5; i++) {
            int sumaNotes = 0;
            System.out.println(estudiants[i] + ":");
            for (int j = 0; j < 3; j++) {
                System.out.println("  " + assignatures[j] + ": " + notes[i][j]);
                sumaNotes += notes[i][j];


                if (notes[i][j] < pitjorNota) {
                    pitjorNota = notes[i][j];
                    pitjorEstudiant = estudiants[i];
                    assignaturaPitjor = assignatures[j];
                }
            }
            System.out.println("  Total: " + sumaNotes);


            if (sumaNotes > millorNotaTotal) {
                millorNotaTotal = sumaNotes;
                millorEstudiant = estudiants[i];
            }
            System.out.println(); 
        }

        System.out.println("\nL'estudiant amb la millor nota total és: " + millorEstudiant + " amb " + millorNotaTotal + " punts.");
        System.out.println("L'estudiant amb la pitjor nota ha estat: " + pitjorEstudiant + " en l'assignatura de " + assignaturaPitjor + " amb un " + pitjorNota + ".");

        scanner.close();
        }
    }
