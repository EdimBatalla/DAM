package perist.dades.xml.json;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final File FITXER = new File("alumnes.dat");
    private static final File FITXERXML = new File("alumnes.xml");
    private static final File FITXERCSV = new File("alumnes.csv");
    private static File FITXERJSON = new File("alumnes.json");
    public static void main(String[] args) throws Exception {

        System.out.println("----- PERSISTÈNCIA DE DADES EN XML -----\n");
        List<Alumne> llistaAlumnesDat = GestorDades.llegirDat(FITXER);
        LlistaAlumnes alumnesDat = new LlistaAlumnes(llistaAlumnesDat);
        GestorJAXB.serialitzarXML(alumnesDat); //Exercici 1
        int opcio;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\n----- MENÚ -----");
            System.out.println("1. Llegir alumnes del XML."); //Exercici 2
            System.out.println("2. Filtrar els aprovats."); //Exerici 3
            System.out.println("3. Actualitzar nota."); //Exerici 4
            System.out.println("4. Imporar alumnes de CSV i serialitzar a XML."); //Exerici 5
            System.out.println("5. Exportar a document JSON."); //Exerici 6
            System.out.println("6. Llegir JSON.");//Exerici 7
            System.out.println("7. Cercar a fitxer JSON.");//Exerici 7
            System.out.println("8. Comparar arxius XML i JSON.");//Exercici 8
            System.out.println("0. Sortir");
            System.out.print("Opció: ");
            opcio = Integer.parseInt(sc.nextLine());
            switch(opcio){
                case 1 -> GestorJAXB.alumnesXML(FITXERXML); //Exercici 2
                case 2 -> GestorJAXB.filtrarAprovats(FITXERXML);//Exerici 3
                case 3 -> GestorJAXB.actualitzarNota(FITXERXML,sc);//Exerici 4
                case 4 -> GestorDades.serialitzarCsvAxml(FITXERCSV, FITXERXML);//Exerici 5
                case 5 -> FITXERJSON = GestorJson.exportarXMLaJSON(FITXERXML); //Exercici 6
                case 6 -> GestorJson.llegirJSON(FITXERJSON);//Exercici 6
                case 7 -> GestorJson.cercarAjson(sc, FITXERJSON);//Exercici 7
                case 8 -> Comparador.compararArxius(FITXERXML, FITXERJSON);//Exercici 8
                case 0 -> System.out.println("Sortint...");
                default -> System.out.println("Opció no vàlida");
            }
        }while (opcio != 0);
        sc.close();
    }
}