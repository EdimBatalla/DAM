package Paquet1;

import java.io.*;

public class SerialitzacioExemple {
    public static void main(String[] args) {
        File fitxer = new File("alumnes.dat");

        // --- Escriure objectes ---
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fitxer))) {
            Alumne a1 = new Alumne("Anna", 8.5);
            Alumne a2 = new Alumne("Bernat", 7.2);

            oos.writeObject(a1);
            oos.writeObject(a2);

            System.out.println("S'han escrit alumnes a: " + fitxer.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- Llegir objectes ---

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fitxer))) {
            while (true) {
                try {
                    Alumne alumne = (Alumne) ois.readObject();
                    System.out.println("Llegit: " + alumne);
                } catch (EOFException eof) {
                    // Quan arribem al final del fitxer, sortim del bucle

                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}