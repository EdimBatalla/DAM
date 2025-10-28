package Paquet1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import jakarta.xml.bind.*;

public class GestorJAXB {

    public static void gestorExportarXML(File fitxerDat) throws Exception {
    List<Alumne> llista = GestorDades.llegirDat(fitxerDat);

    if (llista == null || llista.isEmpty()) {
        System.out.println("No hi ha alumnes per exportar.");
        return;
    }

    LlistaAlumnes grup = new LlistaAlumnes(llista);
    serialitzarXML(grup);
}

    public static void serialitzarXML(LlistaAlumnes grup) throws Exception{
        JAXBContext context = JAXBContext.newInstance(LlistaAlumnes.class);
        //Serialitzar a XML
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File out = new File("alumnes.xml");
        m.marshal(grup, out);
        System.out.println("Fitxer generat: " + out.getAbsolutePath());
        
        //Deserialitzar XML
        Unmarshaller um = context.createUnmarshaller();
        LlistaAlumnes recuperat = (LlistaAlumnes) um.unmarshal(out);
        System.out.println("Llista recuperada: " + recuperat.alumnes);
    }

    public static LlistaAlumnes deserialitzarXML(File in) throws Exception {
    if (!in.exists()) {
        System.out.println("No s'ha trobat l'arxiu: " + in.getAbsolutePath());
        return new LlistaAlumnes(); 
    }

    JAXBContext context = JAXBContext.newInstance(LlistaAlumnes.class);
    Unmarshaller um = context.createUnmarshaller();
    return (LlistaAlumnes) um.unmarshal(in);
}

    public static void llegirXML() throws Exception {
        File in = new File("alumnes.xml");
        LlistaAlumnes rec = deserialitzarXML(in);

        if (rec.getAlumnes() == null || rec.getAlumnes().isEmpty()) {
            System.out.println("La llista d'alumnes és buida o no existeix el fitxer XML.");
            return;
        }

        System.out.println("\n Alumnes des de arxiu XML:");
        int i = 1;
        for (Alumne a : rec.getAlumnes()) {
            System.out.println((i++) + ". " + a);
        }
    }  

    public static void filtrarAprovats() throws Exception {
        File in = new File("alumnes.xml");
        LlistaAlumnes rec = deserialitzarXML(in);

        if (rec.getAlumnes() == null || rec.getAlumnes().isEmpty()) {
            System.out.println("No hi ha alumnes a l'XML.");
            return;
        }

        List<Alumne> aprovats = new ArrayList<>();
        for (Alumne a : rec.getAlumnes()) {
            if (a.nota >= 5) aprovats.add(a);
        }
        aprovats.sort((a, b) -> Double.compare(b.nota, a.nota));

        LlistaAlumnes out = new LlistaAlumnes(aprovats);
        JAXBContext ctx = JAXBContext.newInstance(LlistaAlumnes.class);
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(out, new File("aprovats.xml"));

        System.out.println("Fitxer aprovats.xml creat correctament.");
    }

    public static void actualitzarNota(String nom, double novaNota) throws Exception {
        File in = new File("alumnes.xml");
        LlistaAlumnes rec = deserialitzarXML(in);

        if (rec.getAlumnes() == null || rec.getAlumnes().isEmpty()) {
        System.out.println("No hi ha alumnes a l'XML.");
        return;
        }

        boolean trobat = false;
        for (Alumne a : rec.getAlumnes()) {
            if(a.nom != null && a.nom.trim().equalsIgnoreCase(nom.trim())) {
                a.nota = novaNota;
                trobat = true;
                break;
            }
        }

        if (!trobat) {
            System.out.println("No s'ha trobat l'alumne " + nom);
            return;
        }

        JAXBContext ctx = JAXBContext.newInstance(LlistaAlumnes.class);
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(rec, in);

        System.out.println("Nota actualitzada per l'alumne " + nom + " i fitxer alumnes.xml actualitzat.");
        }

    public static void importarCSVaXML() throws Exception {
        File csv = new File("alumnes.csv");
        File in  = new File("alumnes.xml");

        LlistaAlumnes rec = deserialitzarXML(in);
        if (rec.getAlumnes() == null) rec.alumnes = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(csv.toPath(), StandardCharsets.UTF_8)) {
            String line;
            boolean primera = true;

            while ((line = br.readLine()) !=null) {
                if (line.isBlank()) continue;
                if (primera) { primera = false; continue;}

                String[] t = line.split("[;,]");
                if (t.length < 4) continue;

                String nom = t[0].trim();
                String notaString = t[3].trim().replace(',', '.');

                if (nom.isEmpty()) continue;

                double nota;
                try {
                    nota = Double.parseDouble(notaString);
                }catch (NumberFormatException e) {
                    continue;
                }

                rec.alumnes.add(new Alumne(nom, nota));
            }
        }

        JAXBContext ctx = JAXBContext.newInstance(LlistaAlumnes.class);
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(rec, in);

        System.out.println("Importació realitzada correctement.");
    }

    public static void exportarJSON() throws Exception {
        File in = new File("alumnes.xml");
        LlistaAlumnes rec = deserialitzarXML(in);

        if (rec.getAlumnes() == null || rec.getAlumnes().isEmpty()) {
            System.out.println("No hi ha alumnes a l'arxiu XML.");
            return;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fw = new FileWriter("alumnes.json", StandardCharsets.UTF_8)) {
            gson.toJson(rec.getAlumnes(), fw);
        }

        System.out.println("Fitxer alumnes.json creat correctement.");
    }

    public static void buscarJSON(String nom) throws Exception {
        Path p = Path.of("alumnes.json");
        if (!Files.exists(p)) {
            System.out.println("No existeix l'arxiu: alumnes.json");
            return;
        }

        String json = Files.readString(p, StandardCharsets.UTF_8);
        Type listType = new TypeToken<java.util.List<Alumne>>(){}.getType();
        java.util.List<Alumne> llista = new Gson().fromJson(json, listType);

        if (llista == null || llista.isEmpty()) {
            System.out.println("Llista buida al JSON.");
            return;
        }

        for (Alumne a : llista) {
            if (a.nom != null && a.nom.trim().equalsIgnoreCase(nom.trim())) {
                System.out.println("Trobat: " + a);
                return;
            }
        }
        System.out.println("No s'ha trobat: " + nom);
    }

    public static void compararXMLJSON() throws Exception {
        Path xmlPath = Path.of("alumnes.xml");
        if (!Files.exists(xmlPath)) {
            System.out.println("No s'ha trobat l'arxiu: alumnes.xml");
        return;
        }

        Path jsonPath = Path.of("alumnes.json");
            if (!Files.exists(jsonPath)) {
                try {
                    exportarJSON();
                } catch (Exception e) {
                    System.out.println("No s'ha pogut generar alumnes.json: " + e.getMessage());
                    return;
                }
            }

            long xmlBytes = Files.size(xmlPath);
            long jsonBytes = Files.size(jsonPath);

            System.out.println("\nComparació de mida:");
            System.out.println("alumnes.xml  = " + formatBytes(xmlBytes));
            System.out.println("alumnes.json = " + formatBytes(jsonBytes));

            if (jsonBytes > xmlBytes) {
                System.out.println("L'arxiu JSON és més gran que l'arxiu XML.");
            } else if (jsonBytes < xmlBytes) {
                System.out.println("L'arxiu XML és més gran que l'arxiu JSON.");
            } else {
                System.out.println("L'arxiu JSON i l'arxiu XML són de la mateixa mida.");
            }
             
            long xmlLines  = Files.lines(xmlPath, StandardCharsets.UTF_8).count();
            long jsonLines = Files.lines(jsonPath, StandardCharsets.UTF_8).count();


            System.out.println("\nComparació de línies:");
            System.out.println("alumnes.xml  = " + xmlLines + " línies.");
            System.out.println("alumnes.json = " + jsonLines + " línies.");
            
            if (xmlLines > jsonLines) {
                System.out.println("L'arxiu XML té més línies que l'arxiu JSON.");
            } else if (xmlLines < jsonLines) {
                System.out.println("L'arxiu JSON té més línies que l'arxiu XML.");
            } else {
                System.out.println("L'arxiu JSON i l'arxiu XML tenen les mateixes línies.");
            }
    }

    private static String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        double kb = bytes / 1024.0;
        if (kb < 1024) return String.format(java.util.Locale.ROOT, "%.2f KB", kb);
        double mb = kb / 1024.0;
        return String.format(java.util.Locale.ROOT, "%.2f MB", mb);
    }


}
