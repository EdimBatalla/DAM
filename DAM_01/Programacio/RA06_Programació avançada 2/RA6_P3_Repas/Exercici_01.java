package Repas; 

import java.util.Scanner; 

public class Exercici_01 { 

    static Scanner scanner = new Scanner(System.in); 
    static int nextCodi = 1; // Variable estàtica per assignar un codi únic a cada producte, començant per 1

    public static void main(String[] args) { // Mètode principal: punt d'entrada del programa
        String[] productes = new String[50]; // Array per emmagatzemar fins a 50 noms de productes
        int[] codis = new int[50]; // Array per emmagatzemar els codis dels productes
        double[] preus = new double[50]; // Array per emmagatzemar els preus dels productes

        int numProductes = 0; // Comptador per mantenir el nombre de productes afegits

        menu(numProductes, productes, codis, preus); 
    }

    public static void menu(int numProductes, String[] productes, int[] codis, double[] preus) { 
        // Mètode que mostra el menú principal 

        int opcio; // Variable per guardar l'opció seleccionada

        do { // Bucle do-while per repetir el menú fins que sortim
            System.out.println("\nMenu de Productes:"); 
            System.out.println("1. Afegir Producte"); 
            System.out.println("2. Cercar Producte"); 
            System.out.println("3. Eliminar Producte"); 
            System.out.println("4. Mostrar inventari"); 
            System.out.println("5. Sortir"); 
            System.out.println("Escull una opció:"); 

            opcio = scanner.nextInt(); // Llegim l'opció introduïda per l'usuari 
            scanner.nextLine(); // Consumim el salt de línia

            switch (opcio) { 
                case 1: 
                    numProductes = afegirProducte(numProductes, productes, codis, preus); // Afegim el producte i actualitzem el comptador
                    break; 

                case 2: 
                    cercarProducte(numProductes, productes, codis, preus); // Cerquem el producte pel seu codi
                    break; 

                case 3: 
                    numProductes = eliminarProducte(numProductes, productes, codis, preus); // Eliminem el producte i actualitzem el comptador
                    break; 

                case 4: 
                    mostrarInventari(numProductes, productes, codis, preus); // Mostrem tots els productes registrats
                    break; 

                case 5: 
                    System.out.println("Gràcies per utilitzar el programa, bon dia."); // Missatge de sortida del programa
                    break; 

                default: 
                    System.out.println("opcio no valida."); // Missatge d'error
            }
        } while (opcio != 5); // El bucle continua fins que l'usuari tria l'opció de sortir (5)
    }

    public static int afegirProducte(int numProductes, String[] productes, int[] codis, double[] preus) { 
        // Mètode per afegir un nou producte a l'inventari
        if (numProductes < productes.length) { // Comprovem que encara hi ha espai per afegir productes
            System.out.println("Introdueix nom producte: "); 
            productes[numProductes] = scanner.nextLine(); // Llegim el nom i l'emmagatzemem en l'array

            codis[numProductes] = nextCodi++; // Assignem un codi únic al producte i incrementem la variable nextCodi

            System.out.println("Introduix el preu: "); 
            preus[numProductes] = scanner.nextDouble(); // Llegim el preu i l'emmagatzemem en l'array
            scanner.nextLine(); 

            System.out.println("Producte afegit correctement."); // Confirmem que el producte s'ha afegit
            System.out.println("Producte: " + productes[numProductes] + " amb un preu de: " 
                + preus[numProductes] + " amb el codi assignat: " + codis[numProductes]); // Mostrem els detalls del producte

            return numProductes + 1; // Incrementem i retornem el nou nombre total de productes
        } else { // Si no hi ha espai disponible per a més productes
            System.out.println("El sistema esta ple de productes."); // Informem que l'inventari està ple
            return numProductes; // Retornem el comptador sense canvis
        }
    }

    public static void cercarProducte(int numProductes, String[] productes, int[] codis, double[] preus) { 
        // Mètode per cercar un producte segons el seu codi
        System.out.println("Introdueix el codi del producte que vols buscar:"); 
        int codiBuscar = scanner.nextInt(); 

        for (int i = 0; i < numProductes; i++) { // Recorrem l'array fins al nombre de productes registrats
            if (codis[i] == codiBuscar) { // Si el codi de l'element actual coincideix amb el codi cercat
                System.out.println("Producte: " + productes[i] + " amb un preu de: " 
                    + preus[i] + " amb el codi assignat: " + codis[i]); // Mostrem els detalls del producte
                return; // Sortim del mètode
            }
        }
    }

    public static int eliminarProducte(int numProductes, String[] productes, int[] codis, double[] preus) { 
        // Mètode per eliminar un producte de l'inventari
        System.out.println("Introdueix el codi del producte que vols eliminar:"); 
        int codiEliminar = scanner.nextInt(); // Llegim el codi a eliminar

        // Recorrem l'array de codis per buscar el producte amb el codi indicat
        for (int i = 0; i < codis.length; i++) {
            if (codiEliminar == codis[i]) { // Si trobem el producte amb el codi correcte
                codis[i] = 0; // Posem 0 al codi per marcar que s'ha eliminat
                productes[i] = null; // Assignem null al nom del producte
                preus[i] = 0; // Assignem 0 al preu del producte
                break; // Sortim del bucle ja que hem eliminat el producte
            } else if (i + 1 == numProductes && codiEliminar != codis[i]) { 
                // Si arribem al final de la llista de productes i no hem trobat el codi
                System.out.println("Codi no trobat."); // Informem que el codi no existeix
                return numProductes; // Retornem el nombre de productes sense modificar
            }
        }
        System.out.print("Producte eliminat"); // Informem que el producte s'ha eliminat
        return numProductes - 1; // Decrementem el comptador de productes i el retornem
    }

    public static void mostrarInventari(int numProductes, String[] productes, int[] codis, double[] preus) { 
        // Mètode per mostrar tots els productes de l'inventari
        System.out.println("Inventari:"); 

        for (int i = 0; i < numProductes; i++) { // Recorrem tots els productes registrats
            if (codis[i] == 0) { // Si el codi és 0, significa que aquest producte ha estat eliminat
                // No es mostra aquest producte
            } else { // Si el producte existeix (codi diferent de 0)
                System.out.println("Producte " + (i + 1) + ": " + productes[i] 
                    + " amb un preu de: " + preus[i] + " amb el codi assignat: " + codis[i]); 
                // Mostrem els detalls del producte (número, nom, preu i codi)
            }
        }
    }
}
