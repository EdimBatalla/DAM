package PART_02;

import java.util.Random;
import java.util.Scanner;

public class Exercici_03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean jugarDeNou = true;

        while (jugarDeNou) {
            System.out.println("\nBenvingut al joc del Buscaminas!");
            System.out.print("Introdueix la llargada del tauler (mínim 5): ");
            int llargadaTauler = scanner.nextInt();

            // Validem que el tauler tingui almenys 5 caselles
            while (llargadaTauler < 5) {
                System.out.print("El tauler ha de tenir almenys 5 caselles. Torna a introduir: ");
                llargadaTauler = scanner.nextInt();
            }

            System.out.print("Introdueix el nombre de mines (mínim 1, màxim " + (llargadaTauler - 1) + "): ");
            int numMines = scanner.nextInt();

            // Validem el nombre de mines
            while (numMines < 1 || numMines >= llargadaTauler) {
                System.out.print("Nombre invàlid de mines. Torna a introduir: ");
                numMines = scanner.nextInt();
            }

            char[] mines = new char[llargadaTauler];
            char[] taulerJugador = new char[llargadaTauler];

            // Inicialitzar el tauler
            for (int i = 0; i < llargadaTauler; i++) {
                taulerJugador[i] = '-';
                mines[i] = '0'; // Caselles segures
            }

            // Col·locar les mines de manera aleatòria
            int minesSituades = 0;
            while (minesSituades < numMines) {
                int posicio = random.nextInt(llargadaTauler);
                if (mines[posicio] != 'M') {
                    mines[posicio] = 'M';
                    minesSituades++;
                }
            }

            boolean jocActiu = true;
            int casellesRevelades = 0;

            // Bucle principal del joc
            while (jocActiu) {
                // Mostrem l'estat actual del tauler
                for (char casella : taulerJugador) {
                    System.out.print(casella + " ");
                }
                System.out.println();

                System.out.print("Selecciona una casella (de 0 a " + (llargadaTauler - 1) + "): ");
                int seleccio = scanner.nextInt();

                // Validem que la selecció sigui vàlida
                while (seleccio < 0 || seleccio >= llargadaTauler) {
                    System.out.print("Posició invàlida. Torna a introduir: ");
                    seleccio = scanner.nextInt();
                }

                // Si el jugador selecciona una mina
                if (mines[seleccio] == 'M') {
                    System.out.println("\nBOOM! Has perdut. Hi havia una mina.");
                    jocActiu = false;

                    // Mostrem totes les mines
                    for (char casella : mines) {
                        System.out.print(casella + " ");
                    }
                    System.out.println();
                } else {
                    // Comptar mines al voltant de la casella seleccionada
                    int minesAlVoltant = 0;
                    for (int i = seleccio - 3; i <= seleccio + 3; i++) {
                        if (i >= 0 && i < llargadaTauler && mines[i] == 'M') {
                            minesAlVoltant++;
                        }
                    }

                    // Actualitzar el tauler del jugador
                    taulerJugador[seleccio] = (char) ('0' + minesAlVoltant);
                    casellesRevelades++;

                    // Comprovar si el jugador ha guanyat
                    if (casellesRevelades == llargadaTauler - numMines) {
                        System.out.println("\nFelicitats! Has descobert totes les caselles segures. Has guanyat!");
                        jocActiu = false;

                        // Mostrem totes les mines
                        for (char casella : mines) {
                            System.out.print(casella + " ");
                        }
                        System.out.println();
                    }
                }
            }

            // Preguntar si vol tornar a jugar
            System.out.print("Vols tornar a jugar? (s/n): ");
            scanner.nextLine(); // Consumir el salt de línia pendent
            String resposta = scanner.nextLine().toLowerCase();
            jugarDeNou = resposta.equals("s");
        }

        System.out.println("Gràcies per jugar! Fins aviat!");
        scanner.close();
    }
}