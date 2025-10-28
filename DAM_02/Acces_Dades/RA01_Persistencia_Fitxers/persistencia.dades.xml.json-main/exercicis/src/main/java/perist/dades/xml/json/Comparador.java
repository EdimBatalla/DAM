package perist.dades.xml.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Comparador { //Exercici 8
    public static void compararArxius(File XML, File JSON) {//metode que conté tots els mètodes per mostrar la comparació
    System.out.println("----- COMPARADOR D'ARXIUS XML I JSON -----\n");
    compararTamany(XML, JSON);
    System.out.println();
    compararLlegibilitat(XML, JSON);
    System.out.println();
    mostrarConclusions();
    }
    public static void compararTamany(File archivoXML, File archivoJSON) {//Comparacio per tamany de fitxer
        long tamanyXML = archivoXML.length();//funció per saber el tamany en bytes
        long tamanyJSON = archivoJSON.length();
        System.out.println("----- COMPARACIÓ DE TAMANY -----");
        System.out.println("XML:  " + tamanyXML + " bytes");
        System.out.println("JSON: " + tamanyJSON + " bytes");
        double diferencia = Math.abs(tamanyXML - tamanyJSON);//retorna la diferencia de tamany exacta tot i ser negatiu
        double percentatge = (diferencia / Math.max(tamanyXML, tamanyJSON)) * 100;//retorna el percentatge de la diferencia
        if (tamanyXML > tamanyJSON) {
            System.out.println("\nJSON és més lleuger per " + (int)diferencia + " bytes (" + String.format("%.1f", percentatge) + "% menys)");
        } else if (tamanyJSON > tamanyXML) {
            System.out.println("\nXML és més lleuger per " + (int)diferencia + " bytes (" + String.format("%.1f", percentatge) + "% menys)");
        } else {
            System.out.println("\nEls dos arxius tenen el mateix tamany");
        }
    }
    public static void compararLlegibilitat(File xml, File json) {//aquest mètode retorna les linies i una mostra de codi
        System.out.println("----- COMPARACIÓ DE LLEGIBILITAT -----\n");
        try {
            BufferedReader xmlReader = new BufferedReader(new FileReader(xml));//BufferedReader per llegir el document
            BufferedReader jsonReader = new BufferedReader(new FileReader(json));
            int liniesXML = 0, liniesJSON = 0;
            int caractersXML = 0, caractersJSON = 0;
            String linia;
            while ((linia = xmlReader.readLine()) != null) {//va llegint linies mentre no sigui null
                liniesXML++;
                caractersXML += linia.length();
            }
            while ((linia = jsonReader.readLine()) != null) {
                liniesJSON++;
                caractersJSON += linia.length();
            }
            xmlReader.close();
            jsonReader.close();
            System.out.println("XML:  " + liniesXML + " líneas, " + caractersXML + " caracteres");
            System.out.println("JSON: " + liniesJSON + " líneas, " + caractersJSON + " caracteres");
            System.out.println("\n--- MOSTRA XML ---");
            mostrarMostra(xml, 5);//es mostren les 5 primeres linies de codi
            System.out.println("\n--- MUOTRA JSON ---");
            mostrarMostra(json, 5);
        } catch (IOException e) {
            System.err.println("Error leyendo archivos: " + e.getMessage());
        }
    }
    public static void mostrarMostra(File arxiu, int numLinies) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arxiu))) {
            String linia;
            int cont = 0;
            while ((linia = reader.readLine()) != null && cont < numLinies) {
                System.out.println(linia);
                cont++;
            }//en aquesta lògica anem mostrant les linies de codi exactes
            if (cont < numLinies) {
                System.out.println("...");
            }
        } catch (IOException e) {
            System.err.println("Error mostrant mostra: " + e.getMessage());
        }
    }
    public static void mostrarConclusions() {//les conclusions les he realitzat posteriorment
        System.out.println("=== CONCLUSIONS ===\n");
        System.out.println("----- JSON PER API REST -----");
        System.out.println("- Més lleuger (menys ample de banda)");
        System.out.println("- Estàndar actual en APIs REST");
        System.out.println("- Més ràpid de parsejar");
        System.out.println("- Compatible amb JavaScript nadivament\n");
        System.out.println("----- XML PER CONFIGURACIÓ D'EMPRESA -----");
        System.out.println("- Validació amb schemas (XSD)");
        System.out.println("- Suporta comentaris");
        System.out.println("- Més flexible amb atributs i namespaces");
        System.out.println("- Tradicional en entorns empresarials");
        System.out.println("- Millor per estructures complexes amb metadades");
    }
}
