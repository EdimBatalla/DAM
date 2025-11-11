package Exercici_02;

import java.util.Arrays;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) throws InterruptedException {
        int MAX_CAP = 4;
        Passaplats passaplats = new Passaplats(MAX_CAP);

        List<String> receptes = Arrays.asList("Pasta", "Amanida", "Pizza", "Sopa", "Hamburguesa");

        Cuiner cuiner1 = new Cuiner("Cuiner-1", passaplats, 10, receptes);
        Cuiner cuiner2 = new Cuiner("Cuiner-2", passaplats, 10, receptes);

        // En total es cuinen 20 plats, els cambrers n'han de servir 20 entre tots
        Cambrer cambrer1 = new Cambrer("Cambrer-1", passaplats, 10);
        Cambrer cambrer2 = new Cambrer("Cambrer-2", passaplats, 10);

        Thread tCuiner1 = new Thread(cuiner1);
        Thread tCuiner2 = new Thread(cuiner2);
        Thread tCambrer1 = new Thread(cambrer1);
        Thread tCambrer2 = new Thread(cambrer2);

        tCuiner1.start();
        tCuiner2.start();
        tCambrer1.start();
        tCambrer2.start();

        tCuiner1.join();
        tCuiner2.join();
        tCambrer1.join();
        tCambrer2.join();

        System.out.println(">>> Tots els cuiners i cambrers han acabat. Restaurant tancat.");
    }
}
