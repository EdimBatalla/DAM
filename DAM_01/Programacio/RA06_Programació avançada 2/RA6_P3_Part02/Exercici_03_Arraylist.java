package part_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici_03_Arraylist {

    // Llistes per gestionar els videojocs de la botiga i les ofertes.
    static ArrayList<String> videojocs = new ArrayList<>();
    static ArrayList<Double> preus = new ArrayList<>();

    static ArrayList<String> videojocsOferta = new ArrayList<>();
    static ArrayList<Double> preusOferta = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio;
        
        do {
            mostrarMenu();
            opcio = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcio) {
                case 1:
                    afegirJoc(scanner);
                    break;
                case 2:
                    eliminarJoc(scanner);
                    break;
                case 3:
                    mostrarJocs();
                    break;
                case 4:
                    mostrarJocsOferta();
                    break;
                case 5:
                    afegirJocOferta(scanner);
                    break;
                case 6:
                    eliminarJocOferta(scanner);
                    break;
                case 7:
                    System.out.println("Sortint...");
                    break;
                default:
                    System.out.println("Opció invàlida. Torna a intentar.");
            }
            System.out.println();
        } while (opcio != 7);
        
        scanner.close();
    }

    // Mètode per mostrar el menú d'opcions.
    public static void mostrarMenu() {
        System.out.println("---- Videojocs DAM ----");
        System.out.println("1. Afegir joc a la botiga");
        System.out.println("2. Eliminar joc de la botiga");
        System.out.println("3. Mostrar jocs a la botiga");
        System.out.println("4. Mostrar jocs en oferta");
        System.out.println("5. Afegir joc a ofertes");
        System.out.println("6. Eliminar joc d'ofertes");
        System.out.println("7. Sortir");
        System.out.print("Selecciona una opció: ");
    }

    // Mètode per afegir un joc a la botiga.
    public static void afegirJoc(Scanner scanner) {
        System.out.print("Introdueix el nom del joc: ");
        String nomJoc = scanner.nextLine();
        System.out.print("Introdueix el preu del joc: ");
        double preu = scanner.nextDouble();
        scanner.nextLine(); // Consumeix el salt de línia
        videojocs.add(nomJoc);
        preus.add(preu);
        System.out.println("Joc afegit correctament a la botiga.");
    }

    // Mètode per eliminar un joc de la botiga.
    public static void eliminarJoc(Scanner scanner) {
        System.out.print("Introdueix el nom del joc a eliminar de la botiga: ");
        String jocEliminar = scanner.nextLine();
        int index = videojocs.indexOf(jocEliminar);
        if (index != -1) {
            videojocs.remove(index);
            preus.remove(index);
            System.out.println("Joc eliminat correctament de la botiga.");
        } else {
            System.out.println("El joc no existeix a la botiga.");
        }
    }

    // Mètode per mostrar tots els jocs de la botiga.
    public static void mostrarJocs() {
        System.out.println("Jocs disponibles a la botiga:");
        if (videojocs.isEmpty()){
            System.out.println("No hi ha jocs a la botiga.");
        } else {
            for (int i = 0; i < videojocs.size(); i++) {
                System.out.println("- " + videojocs.get(i) + " : " + preus.get(i) + " €");
            }
        }
    }

    // Mètode per mostrar els jocs en oferta.
    public static void mostrarJocsOferta() {
        System.out.println("Jocs en oferta:");
        if (videojocsOferta.isEmpty()){
            System.out.println("No hi ha jocs en oferta.");
        } else {
            for (int i = 0; i < videojocsOferta.size(); i++) {
                System.out.println("- " + videojocsOferta.get(i) + " : " + preusOferta.get(i) + " €");
            }
        }
    }

    // Mètode per afegir un joc a la llista d’ofertes: es mou de la botiga a ofertes.
    public static void afegirJocOferta(Scanner scanner) {
        System.out.print("Introdueix el nom del joc a afegir a ofertes: ");
        String jocOferta = scanner.nextLine();
        int indexOferta = videojocs.indexOf(jocOferta);
        if (indexOferta != -1) {
            System.out.print("Introdueix el preu d'oferta: ");
            double preuOfertaJoc = scanner.nextDouble();
            scanner.nextLine(); // Consumeix el salt de línia
            // Afegir a la llista d’ofertes
            videojocsOferta.add(jocOferta);
            preusOferta.add(preuOfertaJoc);
            // Eliminar de la botiga
            videojocs.remove(indexOferta);
            preus.remove(indexOferta);
            System.out.println("Joc mogut a ofertes correctament.");
        } else {
            System.out.println("El joc no existeix a la botiga.");
        }
    }

    // Mètode per eliminar un joc de la llista d’ofertes.
    public static void eliminarJocOferta(Scanner scanner) {
        System.out.print("Introdueix el nom del joc a eliminar de ofertes: ");
        String jocEliminarOferta = scanner.nextLine();
        int indexOfertaEliminar = videojocsOferta.indexOf(jocEliminarOferta);
        if (indexOfertaEliminar != -1) {
            videojocsOferta.remove(indexOfertaEliminar);
            preusOferta.remove(indexOfertaEliminar);
            System.out.println("Joc eliminat de ofertes correctament.");
        } else {
            System.out.println("El joc no existeix a la llista d’ofertes.");
        }
    }
}
