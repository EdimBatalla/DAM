package part_02;

import java.util.ArrayList;
import java.util.Collections;

public class Exercici_02_Coleccions {

	public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(17);
        numeros.add(14);
        numeros.add(12);
        numeros.add(4);
        numeros.add(6);
       
        System.out.println("Els números són: " + numeros);
        
        int mesGran = Collections.max(numeros);
        System.out.println("El valor més gran és: " + mesGran);
    }
}
