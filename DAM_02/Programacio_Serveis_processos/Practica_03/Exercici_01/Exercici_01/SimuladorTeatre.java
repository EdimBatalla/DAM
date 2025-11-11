package Exercici_01;

import java.util.ArrayList;
import java.util.List;

public class SimuladorTeatre {
    public static void main(String[] args) throws InterruptedException {
        ZonaTeatre platea = new ZonaTeatre("Platea", 30);
        ZonaTeatre amfiteatre = new ZonaTeatre("Amfiteatre", 10);
        ZonaTeatre galeria = new ZonaTeatre("Galeria", 15);

        List<Thread> fils = new ArrayList<>();

        fils.add(new Thread(new ClientReserva("Usuari-1", platea, 5)));
        fils.add(new Thread(new ClientReserva("Usuari-2", platea, 10)));
        fils.add(new Thread(new ClientReserva("Usuari-3", platea, 20))); // probable rebuig

        fils.add(new Thread(new ClientReserva("Usuari-4", amfiteatre, 3)));
        fils.add(new Thread(new ClientReserva("Usuari-5", amfiteatre, 4)));
        fils.add(new Thread(new ClientReserva("Usuari-6", amfiteatre, 5))); // potser rebuig

        fils.add(new Thread(new ClientReserva("Usuari-7", galeria, 7)));
        fils.add(new Thread(new ClientReserva("Usuari-8", galeria, 5)));
        fils.add(new Thread(new ClientReserva("Usuari-9", galeria, 4))); // potser rebuig

        for (Thread t : fils) {
            t.start();
        }
        for (Thread t : fils) {
            t.join();
        }

        System.out.println("----- Estat final -----");
        System.out.println("Platea ocupades:     " + platea.llistarOcupades().size() + " -> " + platea.llistarOcupades());
        System.out.println("Amfiteatre ocupades: " + amfiteatre.llistarOcupades().size() + " -> " + amfiteatre.llistarOcupades());
        System.out.println("Galeria ocupades:    " + galeria.llistarOcupades().size() + " -> " + galeria.llistarOcupades());
    }
}
