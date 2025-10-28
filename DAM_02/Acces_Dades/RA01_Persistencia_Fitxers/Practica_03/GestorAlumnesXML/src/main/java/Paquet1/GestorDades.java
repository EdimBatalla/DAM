package Paquet1;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorDades {

public static List<Alumne> llegirDat(File fitxer){
    List<Alumne> llista = new ArrayList<>();
    if (!fitxer.exists()) {
                System.out.println("Encara no hi ha alumnes.");
                return null;
        }else{
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fitxer))) {
                while (true) {
                    try{
                    Alumne a = (Alumne)ois.readObject();
                    llista.add(a);
                }catch (EOFException eof) {
                    break;
                }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error llegint: " + e.getMessage ());
                e.printStackTrace();
            } 
            return llista;
    }
}
}