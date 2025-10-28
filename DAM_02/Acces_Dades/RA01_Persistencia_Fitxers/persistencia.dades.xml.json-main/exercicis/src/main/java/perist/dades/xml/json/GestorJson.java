package perist.dades.xml.json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GestorJson {
    public static File exportarXMLaJSON(File xml){
        LlistaAlumnes llistaXml = GestorJAXB.deserialitzarXML(xml);
          try {//es deserialitza el xml obtenint la llista del alumnes
        Gson gson = new GsonBuilder().setPrettyPrinting().create();//creació del gson builder
        File arxiuJSON = new File("alumnes.json");//definim el nou json
        Writer writer = new FileWriter(arxiuJSON);//inicialitzar un writer per esciure al json
        gson.toJson(llistaXml, writer);//amb la llista i el writer es crea el json
        writer.close();
        System.out.println("JSON exportat correctament a: " + arxiuJSON.getAbsolutePath());
        return arxiuJSON;
    } catch (IOException e) {
        System.err.println("Error escrivint l'arxiu JSON: " + e.getMessage());
        e.printStackTrace();
        return null;
    }
    }
    public static LlistaAlumnes carregarJSON(File json){
        if(json.exists()){
            try {//per carregar el json
                Gson gson = new Gson();//s'inicialitza un nou gson
                Reader reader = new FileReader(json);//s'inicialitza un lector de json
                LlistaAlumnes dades = gson.fromJson(reader, LlistaAlumnes.class);
                reader.close();//amb parametres: lector i la clase que es llegirà s'introdueixen
                return dades;//en una nova llista alumnes que es retorna
            } catch (IOException e) {
                System.err.println("Error llegint l'arxiu JSON: " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }else{
            return null;
        }
    }
    public static void llegirJSON(File json){
        LlistaAlumnes llista = carregarJSON(json);//carreguem el json
        if(llista != null){
            System.out.println("Llista d'alumnes en arxiu JSON:\n");
            System.out.println(llista.alumnes);
        } else {//com torna una llistaAlumnes la mostrem per consola
            System.err.println("No es pot carregar l'arxiu JSON.");
        }
    }
    public static void cercarAjson(Scanner sc, File json){
        System.out.println("Introdueix de l'alumne que vols cercar: ");
        String nomAlumne = sc.nextLine();//busquem per nom amb scanner
        List<Alumne> llista = carregarJSON(json).getAlumnes();
        boolean trobat = false;//carreguem el json i treiem una list d'alumnes
        for(Alumne a : llista){
            if(a.nom.equals(nomAlumne)){
                System.out.println("\nAlumne trobat: ");
                System.out.println(a);
                trobat = true;
            }//si es troba l'alumne es mostra per consola
        }
        if(!trobat){
            System.out.println("L'alumne no s'ha trobat al fitxer JSON...\n");
        }
    }
}
