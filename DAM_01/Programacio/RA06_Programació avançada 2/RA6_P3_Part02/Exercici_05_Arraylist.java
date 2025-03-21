package part_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici_05_Arraylist {

    static ArrayList<String> compra = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio;

        do {
            mostrarMenu();
            opcio = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcio) {
                case 1:
                    afegirProducte(scanner);
                    break;
                case 2:
                    afegirProductePosicio(scanner);
                    break;
                case 3:
                    eliminarProducte(scanner);
                    break;
                case 4:
                    mostrarLlistaCompra();
                    break;
                case 5:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció invàlida. Torna a provar.");
            }
            System.out.println();
        } while (opcio != 5);

        scanner.close();
    }

    // Mètode per mostrar el menú
    public static void mostrarMenu() {
        System.out.println("---- Llista de la compra ----");
        System.out.println("1. Afegir producte");
        System.out.println("2. Afegir producte en una posició concreta");
        System.out.println("3. Eliminar producte");
        System.out.println("4. Mostrar la llista final de la compra");
        System.out.println("5. Sortir");
        System.out.print("Selecciona una opció: ");
    }

    // Mètode per afegir un producte al final de la llista
    public static void afegirProducte(Scanner scanner) {
        System.out.print("Introdueix el nom del producte a afegir: ");
        String producte = scanner.nextLine();
        compra.add(producte);
        System.out.println("Producte afegit correctament.");
    }

    // Mètode per afegir un producte en una posició concreta
    public static void afegirProductePosicio(Scanner scanner) {
        System.out.print("Introdueix el nom del producte a afegir: ");
        String producte = scanner.nextLine();
        System.out.print("Introdueix la posició on vols inserir-lo (començant per 0): ");
        int posicio = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de línia
        
        if (posicio < 0 || posicio > compra.size()) {
            System.out.println("La posició és invàlida. S'afegeix al final de la llista.");
            compra.add(producte);
        } else {
            compra.add(posicio, producte);
            System.out.println("Producte afegit a la posició " + posicio + " correctament.");
        }
    }

    // Mètode per eliminar un producte
    public static void eliminarProducte(Scanner scanner) {
        System.out.print("Introdueix el nom del producte a eliminar: ");
        String producte = scanner.nextLine();
        boolean eliminat = compra.remove(producte);
        
        if (eliminat) {
            System.out.println("Producte eliminat correctament.");
        } else {
            System.out.println("El producte no es troba a la llista.");
        }
    }

    // Mètode per mostrar la llista final
    public static void mostrarLlistaCompra() {
        System.out.println("Llista final de la compra:");
        if (compra.isEmpty()) {
            System.out.println("La llista està buida.");
        } else {
            for (int i = 0; i < compra.size(); i++) {
                System.out.println(i + ". " + compra.get(i));
            }
        }
    }
}
