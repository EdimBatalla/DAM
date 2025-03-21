package part_02;

import java.util.ArrayList;
import java.util.Collections;

public class Exercici_03_Coleccions {

	public static void main(String[] args) {

        ArrayList<Integer> jugador1 = new ArrayList<>();
        ArrayList<Integer> jugador2 = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            jugador1.add(i);
            jugador2.add(i);
        }

        Collections.shuffle(jugador1);
        Collections.shuffle(jugador2);

        int puntsJugador1 = 0;
        int puntsJugador2 = 0;

        for (int i = 0; i < 12; i++) {
            int cartaJugador1 = jugador1.get(i);
            int cartaJugador2 = jugador2.get(i);
            System.out.println("Ronda " + (i + 1) + ": Jugador1 juga " + cartaJugador1 
                               + " vs Jugador2 juga " + cartaJugador2);

            if (cartaJugador1 > cartaJugador2) {
                puntsJugador1++;
                System.out.println("Guanya Jugador1");
            } else if (cartaJugador1 < cartaJugador2) {
                puntsJugador2++;
                System.out.println("Guanya Jugador2");
            } else {
                System.out.println("Empat");
            }

        }

        System.out.println("Resultat final:");
        System.out.println("Jugador1: " + puntsJugador1 + " punts");
        System.out.println("Jugador2: " + puntsJugador2 + " punts");

        if (puntsJugador1 > puntsJugador2) {
            System.out.println("Guanya Jugador1!");
        } else if (puntsJugador1 < puntsJugador2) {
            System.out.println("Guanya Jugador2!");
        } else {
            System.out.println("És un empat!");
        }
    }
}
