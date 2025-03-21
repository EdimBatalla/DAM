package part_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici_04_Arraylist {
    
    // ArrayList per gestionar les 5 taules (inicialment buides)
    static ArrayList<String> taules = new ArrayList<>(5);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio;

        // Inicialitzem l'ArrayList amb 5 posicions null
        for (int i = 0; i < 5; i++) {
            taules.add(null);
        }

        do {
            mostrarMenu();
            opcio = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcio) {
                case 1:
                    assignarClient(scanner);
                    break;
                case 2:
                    canviarClient(scanner);
                    break;
                case 3:
                    alliberarTaula(scanner);
                    break;
                case 4:
                    mostrarTaules();
                    break;
                case 5:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció invàlida. Torna a intentar.");
            }
            System.out.println();
        } while (opcio != 5);

        scanner.close();
    }

    // Mètode per mostrar el menú d'opcions.
    public static void mostrarMenu() {
        System.out.println("---- Restaurant ----");
        System.out.println("1. Assignar client a una taula");
        System.out.println("2. Canviar el nom d'una taula (nou client)");
        System.out.println("3. Alliberar una taula");
        System.out.println("4. Mostrar les taules");
        System.out.println("5. Sortir");
        System.out.print("Selecciona una opció: ");
    }

    // Mètode per assignar un client a una taula si està buida.
    public static void assignarClient(Scanner scanner) {
        System.out.print("Introdueix el número de taula (1-5): ");
        int taula = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de línia

        if (taula < 1 || taula > 5) {
            System.out.println("Número de taula invàlid.");
            return;
        }

        if (taules.get(taula - 1) != null) {
            System.out.println("La taula ja està ocupada.");
        } else {
            System.out.print("Introdueix el nom del client: ");
            String client = scanner.nextLine();
            taules.set(taula - 1, client);
            System.out.println("Client assignat correctament a la taula " + taula + ".");
        }
    }

    // Mètode per canviar el client d'una taula.
    public static void canviarClient(Scanner scanner) {
        System.out.print("Introdueix el número de taula (1-5) per canviar el client: ");
        int taula = scanner.nextInt();
        scanner.nextLine(); // Consumeix el salt de línia

        if (taula < 1 || taula > 5) {
            System.out.println("Número de taula invàlid.");
            return;
        }

        System.out.print("Introdueix el nou nom del client: ");
        String client = scanner.nextLine();
        taules.set(taula - 1, client);
        System.out.println("S'ha canviat el client de la taula " + taula + ".");
    }

    // Mètode per alliberar una taula.
    public static void alliberarTaula(Scanner scanner) {
        System.out.print("Introdueix el número de taula (1-5) per alliberar: ");
        int taula = scanner.nextInt();
        scanner.nextLine(); 

        if (taula < 1 || taula > 5) {
            System.out.println("Número de taula invàlid.");
            return;
        }

        if (taules.get(taula - 1) == null) {
            System.out.println("La taula ja està buida.");
        } else {
            taules.set(taula - 1, null);
            System.out.println("La taula " + taula + " ha estat alliberada.");
        }
    }

    // Mètode per mostrar l'estat de totes les taules.
    public static void mostrarTaules() {
        System.out.println("Estat de les taules:");
        for (int i = 0; i < 5; i++) {
            if (taules.get(i) == null) {
                System.out.println("Taula " + (i + 1) + ": BUIT");
            } else {
                System.out.println("Taula " + (i + 1) + ": " + taules.get(i));
            }
        }
    }
}
