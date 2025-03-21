package Repas; 

public class Exercici_02 { 

    public static void main(String[] args) { 
        // Definim una matriu amb els nombres de visitants per cada dia de cada atracció
        int[][] visitants = {
            {5, 6, 7, 8, 9, 10, 11},
            {15, 16, 17, 18, 19, 20, 21},
            {20, 22, 24, 26, 28, 30, 40},
            {50, 51, 52, 53, 54, 56, 57},
            {69, 25, 44, 41, 89, 75, 22}
        };
        // Declarem un array que emmagatzemarà el total de visitants per cada atracció
        int[] totalVisitants = new int[5];

        // Cridem al mètode que calcula el total de visitants per cada atracció
        totalVisitantsAtraccio(visitants, totalVisitants);
        // Cridem al mètode que determina l'atracció estrella
        atraccioEstrella(totalVisitants);
    }

    // Mètode que calcula el total de visitants per cada atracció
    public static int[] totalVisitantsAtraccio(int[][] visitants, int[] totalVisitants) {

        // Primer recorrem la matriu per imprimir tots els valors dels visitants
        for (int i = 0; i < visitants.length; i++) { // Recorrem cada fila = atraccions
            for (int j = 0; j < visitants[i].length; j++) { // Recorrem cada element dins de la fila
                System.out.print(visitants[i][j] + " "); // Imprimim el valor de cada posició
            }
            System.out.println(); // Salt de línia després d'imprimir cada fila
        }
        
        // Recorrem la matriu per calcular la suma dels visitants per cada atracció
        for (int i = 0; i < visitants.length; i++) {
            int suma = 0; // Inicialitzem la variable suma per l'atracció actual
            for (int j = 0; j < visitants[i].length; j++) { // Recorrem cada element de la fila
                suma = suma + visitants[i][j]; // Afegim el nombre de visitants de la posició actual a la suma
                // Guardem la suma parcial a l'array totalVisitants per l'atracció actual
                totalVisitants[i] = suma;
            }
            // Imprimim el total de visitants calculat per l'atracció actual
            System.out.print("l'atraccio " + totalVisitants[i]);
        }
        System.out.println(); 

        // Retornem l'array amb el total de visitants per cada atracció
        return totalVisitants;
    }

    // Mètode que determina quina atracció l'atracció estrella
    public static int atraccioEstrella(int[] totalVisitants) {

        // Ordenem l'array totalVisitants de manera descendent utilitzant el metode de la bombolla
        for (int i = 0; i < totalVisitants.length - 1; i++) { // Recorrem l'array
            for (int j = 0; j < totalVisitants.length - 1 - i; j++) { // Comparem els valors
                // Si l'element actual és menor que el següent, els intercanviem
                if (totalVisitants[j] < totalVisitants[j + 1]) {
                    int vaso = totalVisitants[j + 1]; // Guardem temporalment el valor del següent element
                    totalVisitants[j + 1] = totalVisitants[j]; // Assignem l'element actual a la posició següent
                    totalVisitants[j] = vaso; // Assignem el valor guardat a la posició actual
                }
            }
        }
        // Després d'ordenar, el primer element és l'atracció estrella
        System.out.print("l'atraccio estrella es " + totalVisitants[0]);
        // Retornem aquest valor
        return totalVisitants[0];
    }
}
