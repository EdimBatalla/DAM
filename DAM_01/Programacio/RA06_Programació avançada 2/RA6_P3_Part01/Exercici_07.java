package part_01;

import java.util.Scanner;

public class Exercici_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] productes = {"Producte_01", "Producte_02", "Producte_03", "Producte_04", "Producte_05"};
        String[] supermercats = {"Supermercat A", "Supermercat B", "Supermercat C"};
        double[][] preus = new double[5][3];


        for (int i = 0; i < 5; i++) {
            System.out.println("\nIntrodueix els preus per al producte: " + productes[i]);
            for (int j = 0; j < 3; j++) {
                System.out.print(supermercats[j] + ": ");
                preus[i][j] = scanner.nextDouble();
            }
        }


        System.out.println("\nSupermercat més barat per a cada producte:");
        for (int i = 0; i < 5; i++) {
            int indexMin = 0;
            for (int j = 1; j < 3; j++) {
                if (preus[i][j] < preus[i][indexMin]) {
                    indexMin = j;
                }
            }
            System.out.println(productes[i] + " del " + supermercats[indexMin] + " (Preu: " + preus[i][indexMin] + "€)");
        }


        double[] mitjanes = new double[3];
        for (int j = 0; j < 3; j++) {
            double suma = 0;
            for (int i = 0; i < 5; i++) {
                suma += preus[i][j];
            }
            mitjanes[j] = suma / 5;
        }


        int indexSuperMin = 0;
        for (int j = 0; j < 3; j++) {
            if (mitjanes[j] < mitjanes[indexSuperMin]) {
                indexSuperMin = j;
            }
        }

        System.out.println("\nEl supermercat amb el preu mitjà més baix és: " + supermercats[indexSuperMin] +
                " amb una mitjana de " +  mitjanes[indexSuperMin] + "€.");

        scanner.close();
    }
}