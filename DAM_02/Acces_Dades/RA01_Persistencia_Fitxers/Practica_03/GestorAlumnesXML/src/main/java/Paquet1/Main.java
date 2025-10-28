package Paquet1;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static final File FITXER = new File("alumnes.dat");

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n--- GESTOR D'ALUMNES ---");
            System.out.println("1. Exportar alumnes a XML");
            System.out.println("2. Llegir alumnes des de XML");
            System.out.println("3. Filtrar aprovats.");
            System.out.println("4. Actualitzar nota.");
            System.out.println("5. Importar CSV XML.");
            System.out.println("6. Exportar JSON.");
            System.out.println("7. Llegir JSON i cercar.");
            System.out.println("8. Comparativa XML vs JSON.");
            System.out.println("0. Sortir");
            System.out.println("Opció: ");
            opcio = Integer.parseInt(sc.nextLine());

            switch (opcio) {

                case 1: GestorJAXB.gestorExportarXML(FITXER);;
                break;
                case 2: GestorJAXB.llegirXML();
                break;
                case 3: GestorJAXB.filtrarAprovats();
                break;
                case 4: {
                    System.out.print("Nom de l'alumne: ");
                    String nom = sc.nextLine();
                    System.out.print("Nova nota: ");
                    double nota = Double.parseDouble(sc.nextLine());
                    GestorJAXB.actualitzarNota(nom, nota);
                break;
                }
                case 5: GestorJAXB.importarCSVaXML();
                break;
                case 6: GestorJAXB.exportarJSON();
                break;
                case 7: {
                    System.out.print("Nom a buscar: ");
                    String nom = sc.nextLine();
                    GestorJAXB.buscarJSON(nom);
                break;
                }
                case 8: GestorJAXB.compararXMLJSON();
                break;
                case 0: System.out.println("Sortint...");
                default: System.out.println("Opció no vàlida");
            }

        } while (opcio != 0);
        sc.close();
    }
}