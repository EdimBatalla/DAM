package part_02;

import java.util.ArrayList;
import java.util.Collections;

public class Exercici_05_Coleccions {

	public static void main(String[] args) {

        ArrayList<String> noms = new ArrayList<>();
        noms.add("Anna");
        noms.add("Joan");
        noms.add("Maria");
        noms.add("Pere");
        noms.add("Laura");

        System.out.println("Llista original: " + noms);
        Collections.reverse(noms);
        System.out.println("Llista invertida: " + noms);
    }
}
