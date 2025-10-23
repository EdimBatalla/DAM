package Paquet1;

import java.io.*;
import java.util.*;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class GestorAlumnesSerialitzacio {
    private static final File FITXER = new File("alumnes.dat");
    private static final File CSV = new File("alumnes.csv");

    public static void main(String[] args) {
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

                case 1 -> exportarXML();;
                //case 2 -> llegirXML();
                //case 3 -> filtrarAprovats();
                //case 4 -> actualitzarNota();
                //case 5 -> importardeCSVaXML();
                //case 6 -> exportatJSON();
                //case 7 -> llegirJSON();
                //case 8 -> comparativaXMLSJON();
                case 0 -> System.out.println("Sortint...");
                default -> System.out.println("Opció no vàlida");
            }

        } while (opcio != 0);
        sc.close();
    }

    public static void exportarXML() { //necesitem llegir arxiu CSV a guardar la info arxiu XML
        File fitxerCSV = new File("alumnes.csv");
        File fitxerXML = new File("alumnes.xml");

        try {
            List<Alumne> alumnes = llegirCSV(fitxerCSV);
            if (alumnes.isEmpty()) {
                System.out.println("No hi ha alumnes per exportar.");
                return;
            }

            Alumnes wrapper = new Alumnes(alumnes);
                    JAXBContext ctx = JAXBContext.newInstance(Alumnes.class, Alumne.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        // 4) Escriure a fitxer
        try (OutputStream os = new FileOutputStream(SORTIDA_XML)) {
            marshaller.marshal(wrapper, os);
        }

        System.out.println("XML exportat correctament a: " + SORTIDA_XML.getAbsolutePath());
    } catch (Exception e) {
        System.err.println("Error exportant a XML: " + e.getMessage());
        e.printStackTrace();
    }
}
        }



    }

   
}

