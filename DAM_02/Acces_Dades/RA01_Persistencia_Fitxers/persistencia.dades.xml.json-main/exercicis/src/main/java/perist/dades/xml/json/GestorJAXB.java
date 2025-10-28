package perist.dades.xml.json;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.xml.bind.*;

public class GestorJAXB {
    public static void serialitzarXML(LlistaAlumnes grup) throws Exception{ //Exercici 1
        JAXBContext context = JAXBContext.newInstance(LlistaAlumnes.class);
        // --- Serialitzar a XML ---
        Marshaller m = context.createMarshaller();//marshaller per serialitzar a un xml
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File out = new File("alumnes.xml");
        m.marshal(grup, out);//marshal amb parametres llistaAlumnes i un fitxer
        System.out.println("Fitxer generat: " + out.getAbsolutePath());
        // --- Deserialitzar des de XML ---
        Unmarshaller um = context.createUnmarshaller();//metode per recuperar els alumnes
        LlistaAlumnes recuperat = (LlistaAlumnes) um.unmarshal(out);
        System.out.println("Llista recuperada: " + recuperat.alumnes);
    }
    public static void serialitzar(LlistaAlumnes grup) throws Exception{ //Exercici 4
        JAXBContext context = JAXBContext.newInstance(LlistaAlumnes.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File out = new File("alumnes.xml");
        m.marshal(grup, out);//aixo es un metode concret nomes per serialitzar
    }
    public static LlistaAlumnes deserialitzarXML(File fitxer) { //Exercici 2
        if (!fitxer.exists()) {
            System.out.println("Encara no hi ha alumnes.");
            return null;
        }
        try {
            JAXBContext context = JAXBContext.newInstance(LlistaAlumnes.class);
            Unmarshaller um = context.createUnmarshaller();
            return (LlistaAlumnes) um.unmarshal(fitxer);

        } catch (JAXBException e) {
            System.out.println("Error al deserialitzar l'XML: " + e.getMessage());
            e.printStackTrace();
            return null;
        }//aixo es un metode concret per deserialitzar un xml
    }
    public static void alumnesXML(File fitxer) throws Exception{ //Exercici 2
        LlistaAlumnes recuperat = deserialitzarXML(fitxer);
        System.out.println("Llista alumnes al XML: " + recuperat.alumnes);
    }//unifica el metode deserialitzar per mostrar els alumnes al xml
    public static void filtrarAprovats(File fitxer) throws Exception{ //Exercici 3
        if (!fitxer.exists()) {
            System.out.println("Encara no hi ha alumnes.");
        }else{
            LlistaAlumnes recuperat = deserialitzarXML(fitxer);//es deserialitza el xml
            List<Alumne> totsAlumnes = recuperat.getAlumnes();//es guarden els alumnes en un list
            int numAlumnes = totsAlumnes.size();
            int cont = 0;
            List<Alumne> ordenat = new ArrayList<>();//nova list per mostrar els aprovats ordenats
            do{
                Alumne major = new Alumne("nom",-1);//nou alumne que sempre es substituirà
                for(Alumne a : totsAlumnes){
                    if(a.nota > major.nota){
                        major = a;//si la nota de la llista es major a -1 es guarda
                    }
                }
                totsAlumnes.remove(major);//s'elimina el major de la list perque
                if(major.nota >= 5){//no es repeteixi a la nova list
                    ordenat.add(major);
                }
                cont++;
            } while(numAlumnes != cont);
            System.out.println("\nLlista dels aprovats ordenats de forma descendent:");
            for(Alumne a : ordenat){
                System.out.println(a);//mostrar els alumnes ordenats
            }
        }
    }
    public static void actualitzarNota(File fitxer, Scanner sc) throws Exception{ //Exercici 4
        if (!fitxer.exists()) {
            System.out.println("Encara no hi ha alumnes.");
        }else{
            LlistaAlumnes recuperat = deserialitzarXML(fitxer);//deserialitzar el xml
            List<Alumne> totsAlumnes = recuperat.getAlumnes();//per crear una list amb els alumnes
            System.out.println("----- CANVI DE NOTA -----\n");
            System.out.println("Introdueix el nom de l'alumne:");
            String nomAlumne = sc.nextLine();//buscar alumne introduint nom per scanner
            boolean ok = false;
            for(Alumne a : totsAlumnes){
                if(a.nom.equals(nomAlumne)){//si es troba l'alumne
                    System.out.println("Alumne trobat: "+ a);
                    System.out.println("\nIntrodueix la nova nota: ");
                    double novaNota = Double.parseDouble(sc.nextLine());
                    a.nota = novaNota;//es demana introduir la nova nota
                    System.out.println("Nota actualitzada correctament.");
                    ok = true;//es substitueix la antiga nota per la nova
                }
            }
            if(!ok){
                System.out.println("No s'ha trobat cap alumne amb nom "+ nomAlumne);
            }
            LlistaAlumnes nova = new LlistaAlumnes(totsAlumnes);
            serialitzar(nova);//es crea una nova LlistaAlumnes amb la nota actualitzada
        }//i es serialitza altre cop el document xml
    }
}