package perist.dades.xml.json;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorDades {
    public static List<Alumne> llegirDat(File fitxer){ //Exercici 1
        List<Alumne> llista = new ArrayList<>();
        if (!fitxer.exists()) {
                System.out.println("Encara no hi ha alumnes.");
                return null;
        }else{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fitxer))) {
                while (true) {//amb el ois anem llegin linies objecte i guardant en un list
                    try {
                        Alumne a = (Alumne) ois.readObject();
                        llista.add(a);
                    } catch (EOFException eof) {
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error llegint: " + e.getMessage());
                e.printStackTrace();
            }
            return llista;//el metode retorna sempre una llista d'alumnes del doc .dat
        }
    }
    public static void serialitzarCsvAxml(File arxiucsv, File fitxerXML) throws Exception {
        System.out.println("----- PROCÉS DE SERIALITZACIÓ D'ALUMNES DES DE CSV -----");
        LlistaAlumnes antiga = GestorJAXB.deserialitzarXML(fitxerXML);
        List<Alumne> alumnes = antiga.getAlumnes();//Gestor JAXB per deserialitzar
        try (BufferedReader br = new BufferedReader(new FileReader(arxiucsv))) {
            String linia;//llegir cada linia del csv, fent split i guardant els camps necessaris
            while ((linia = br.readLine()) != null) {
                String[] camps = linia.split(",");
                if (camps.length >= 4) {
                    String nom = camps[0].trim();
                    double nota = Double.parseDouble(camps[2].trim());
                    alumnes.add(new Alumne(nom, nota));
                }//es guarden els alumens en una nova llista
            }
            System.out.println("----- PREPARANT DADES... -----");
            System.out.println("\n----- DADES PREPARADES -----");
            LlistaAlumnes nova = new LlistaAlumnes(alumnes);
            GestorJAXB.serialitzar(nova);//es crea una nova llista amb un list com a parametre
            System.out.println("");//es serialitza a xml
            System.out.println("----- PROCÉS DE SERIALITZACIÓ REALITZAT -----\n");
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error convertint les dades: " + e.getMessage());
        }
    }
}
