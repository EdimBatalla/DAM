package Paquet1;

import java.io.*;
import java.util.*;

public class GestorAlumnesSerialitzacio {
    private static final File FITXER = new File("alumnes.dat");
    private static final File CSV = new File("alumnes.csv");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n--- GESTOR D'ALUMNES (SERIALITZACIÓ) ---");
            System.out.println("1. Afegir alumne");
            System.out.println("2. Llistar alumnes");
            System.out.println("3. Llistar alumnes ordenats per nota desc.");
            System.out.println("4. Mostrar millor i pitjor alumne.");
            System.out.println("5. Estadístiques de les notes.");
            System.out.println("6. Actualitzar nota d'un alumne.");
            System.out.println("7. Eliminar tots els alumnes suspesos.");
            System.out.println("8. Importat alumnes desde un fitxer .csv");
            System.out.println("9. Fer un backup del fitxer.");
            System.out.println("10. Restaurar desde backup.");
            System.out.println("0. Sortir");
            System.out.println("Opció: ");
            opcio = Integer.parseInt(sc.nextLine());

            switch (opcio) {

                case 1 -> afegirAlumne(sc);
                case 2 -> llistarAlumnes();
                case 3 -> llistarAlumnesDesc();
                case 4 -> mostrarMillorPitjorAlumne();
                case 5 -> mostrarEstadistiques();
                case 6 -> actualitzarNota();
                case 7 -> eliminarSuspesos();
                case 8 -> importarCSV();
                case 9 -> backup();
                case 10 -> restaurarBackup();
                case 0 -> System.out.println("Sortint...");
                default -> System.out.println("Opció no vàlida");
            }
        } while (opcio != 0);
        sc.close();
    }

    private static void afegirAlumne(Scanner sc) {
        System.out.println("Nom: ");
        String nom = sc.nextLine();
        System.out.println("Nota ");
        double nota = Double.parseDouble(sc.nextLine());

        try {
            boolean existeix = FITXER.exists();
            ObjectOutputStream oos;
            if (existeix) {
                // Append sense rescriure capçalera
                oos = new AppendableObjectOutputStream(new FileOutputStream(FITXER, true));
            } else {
                // primer cop: capçalera normal
                oos = new ObjectOutputStream(new FileOutputStream(FITXER));
            }

            oos.writeObject(new Alumne(nom, nota));
            oos.close();
            System.out.println("Alumne afegit correctement!");

        } catch (IOException e) {
            System.out.println("Error escrivint: " + e.getMessage());
        }
    }

    private static void llistarAlumnes() {
        if (!FITXER.exists()) {
            System.out.println("Encara no hi ha alumnes.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXER))) {
            System.out.println("\n--- LLISTA D'ALUMNES ---");
            while (true) {
                try {
                    Alumne a = (Alumne) ois.readObject();
                    System.out.println(a);
                } catch (EOFException eof) {
                    break; // final de fitxer
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error llegint: " + e.getMessage());
        }
    }

    private static void llistarAlumnesDesc() {
        // comprobem si existeix l'arxiu
        if (!FITXER.exists()) {
            System.out.println("Encara no hi ha alumnes.");
            return;
        }

        // arraylist per guardar tots els alumnes
        List<Alumne> tots = new ArrayList<>();

        // llegir tots els alumnes del arxiu i els afegim al arraylist tots
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXER))) {
            while (true) {
                try {
                    tots.add((Alumne) ois.readObject());
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error llegint: " + e.getMessage());
            return;
        }

        // creem arraylist pels alumnes aprobats
        List<Alumne> aprovats = new ArrayList<>();
        // recorrem l'arraylist tots i comprobem per cada alumne si ha aprobat, si es
        // que si l'afegim a l'arraylist aprovats
        for (Alumne a : tots) {
            if (a.getNota() >= 5) {
                aprovats.add(a);
            }
        }

        // comprovem si hi ha algun alumne aprobat
        if (aprovats.isEmpty()) {
            System.out.println("No hi ha cap alumne aprovat.");
            return;
        }

        // comparem les notes dels alumnes i les ordanem l'arraylist d'aprovats de forma
        // descendent
        aprovats.sort(Comparator.comparingDouble(Alumne::getNota).reversed());

        // imprimim cada alumne del arraylist d'aprovats
        System.out.println("\n--- LLISTA D'ALUMNES DESC. ---");
        for (Alumne a : aprovats) {
            System.out.println(a);
        }

    }

    public static void mostrarMillorPitjorAlumne() {
        // Comprovem si existeix el fitxer abans de res
        if (!FITXER.exists()) {
            System.out.println("Encara no hi ha alumnes.");
            return;
        }

        // Guardem l'objecte complet
        Alumne millorAlumne = null;
        Alumne pitjorAlumne = null;

        // Comprobem notes d'alumnes i actualitzem variables si es necessari
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXER))) {
            while (true) {
                try {
                    Alumne a = (Alumne) ois.readObject();

                    if (millorAlumne == null || a.getNota() > millorAlumne.getNota()) {
                        millorAlumne = a;
                    }
                    if (pitjorAlumne == null || a.getNota() < pitjorAlumne.getNota()) {
                        pitjorAlumne = a;
                    }

                } catch (EOFException eof) {
                    break; // senyal de final
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error llegint: " + e.getMessage());
            return;
        }

        // Si no hi ha cap alumne dins el fitxer
        if (millorAlumne == null) {
            System.out.println("No hi ha alumnes a mostrar.");
            return;
        }

        // Missatges per terminal
        System.out
                .println("El millor alumne és " + millorAlumne.getNom() + " amb una nota de " + millorAlumne.getNota());
        System.out
                .println("El pitjor alumne és " + pitjorAlumne.getNom() + " amb una nota de " + pitjorAlumne.getNota());
    }

    public static void mostrarEstadistiques() {

        if (!FITXER.exists()) {
            System.out.println("Encara no hi ha alumnes.");
            return;
        }

        double sumaNotes = 0;
        int contador = 0;
        double millorNota = Double.NEGATIVE_INFINITY;
        double pitjorNota = Double.POSITIVE_INFINITY;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXER))) {
            while (true) {
                try {
                    Alumne a = (Alumne) ois.readObject();
                    sumaNotes += a.getNota();
                    contador++;

                    if (a.getNota() > millorNota) {
                        millorNota = a.getNota();
                    }

                    if (a.getNota() < pitjorNota) {
                        pitjorNota = a.getNota();
                    }

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error llegint: " + e.getMessage());
            return;
        }

        if (contador == 0) {
            System.out.println("No hi ha alumnes a mostrar.");
            return;
        }

        double mitjana = (sumaNotes / contador);
        System.out.printf("La mitjana de totes les notes és: %.2f%n", mitjana);
        System.out.println("La nota màxima és: " + millorNota + " i la nota mínima és: " + pitjorNota);

    }

    public static void actualitzarNota() {
        if (!FITXER.exists()) {
            System.out.println("Encara no hi ha alumnes.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el nom de l'alumne a actualitzar: ");
        String nom = sc.nextLine();
        System.out.print("Introdueix la nova nota: ");
        double novaNota = Double.parseDouble(sc.nextLine());

        List<Alumne> alumnes = new ArrayList<>();
        boolean trobat = false;

        // Llegeix tots els alumnes
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXER))) {
            while (true) {
                try {
                    Alumne a = (Alumne) ois.readObject();
                    if (a.getNom().equalsIgnoreCase(nom)) {
                        a.setNota(novaNota);
                        trobat = true;
                    }
                    alumnes.add(a);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error llegint: " + e.getMessage());
            return;
        }

        if (!trobat) {
            System.out.println("No s'ha trobat cap alumne amb aquest nom.");
            return;
        }

        // Torna a escriure tots els alumnes al fitxer
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FITXER))) {
            for (Alumne a : alumnes) {
                oos.writeObject(a);
            }
            System.out.println("Nota actualitzada correctament.");
        } catch (IOException e) {
            System.out.println("Error escrivint: " + e.getMessage());
        }
    }

    public static void eliminarSuspesos() {
        if (!FITXER.exists()) {
            System.out.println("Encara no hi ha alumnes.");
            return;
        }

        List<Alumne> alumnes = new ArrayList<>();

        // Llegeix tots els alumnes
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FITXER))) {
            while (true) {
                try {
                    Alumne a = (Alumne) ois.readObject();
                    if (a.getNota() >= 5) { // Només afegeix els aprovats
                        alumnes.add(a);
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error llegint: " + e.getMessage());
            return;
        }

        // Torna a escriure només els alumnes aprovats al fitxer
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FITXER))) {
            for (Alumne a : alumnes) {
                oos.writeObject(a);
            }
            System.out.println("Alumnes suspesos eliminats correctament.");
        } catch (IOException e) {
            System.out.println("Error escrivint: " + e.getMessage());
        }

    }

    public static void importarCSV() {
        if (!CSV.exists()) {
            System.out.println("El fitxer CSV no existeix.");
            return;
        }

        boolean append = FITXER.exists();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV));
                ObjectOutputStream oos = append
                        ? new AppendableObjectOutputStream(new FileOutputStream(FITXER, true))
                        : new ObjectOutputStream(new FileOutputStream(FITXER))) {

            String linia;
            boolean primer = true;

            while ((linia = br.readLine()) != null) {
                // Evita la primera línia si conté les capçaleres
                if (primer && linia.toLowerCase().contains("nom")) {
                    primer = false;
                    continue;
                }
                primer = false;

                String[] parts = linia.split(",");
                if (parts.length != 4) {
                    System.out.println("Línia ignorada (format incorrecte): " + linia);
                    continue;
                }

                Alumne alumne = new Alumne(parts[0].trim(), Double.parseDouble(parts[3].trim()));
                oos.writeObject(alumne);

            }

            System.out.println("Importació completada correctament.");

        } catch (IOException e) {
            System.out.println("Error llegint/escrivint: " + e.getMessage());
        }
    }

    public static void backup() {
        if(!FITXER.exists()) {
            System.out.println("El fitxer d'alumnes no existeix.");
            return;
        }

        File backupFile = new File("alumnes_backup.dat");

        try (InputStream is = new FileInputStream(FITXER);
             OutputStream os = new FileOutputStream(backupFile)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            System.out.println("Backup creat correctament a " + backupFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error fent el backup: " + e.getMessage());
        }
    }

    public static void restaurarBackup() {
        File backupFile = new File("alumnes_backup.dat");
        if (!backupFile.exists()) {
            System.out.println("El fitxer de backup no existeix.");
            return;
        }

        try (InputStream is = new FileInputStream(backupFile);
             OutputStream os = new FileOutputStream(FITXER)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            System.out.println("Restauració des del backup completada correctament.");

        } catch (IOException e) {
            System.out.println("Error restauran el backup: " + e.getMessage());
        }
    }
}

