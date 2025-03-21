package Repas;

import java.util.Random;  
import java.util.Scanner; 

public class Exercici_04 {

    // Random i Scanner compartits per tot el programa
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    // Mapa real amb el codi i les trampes
    static char[][] mapa = new char[5][5];

    // Mapa que veu el jugador, amb les caselles ocultes
    static char[][] mapaVisible = new char[5][5];

    // Comptador d'intents disponibles
    static int intents = 10;

    // Posició actual del jugador
    static int fila = -1;
    static int columna = -1;

    // Per saber si la partida s'ha acabat
    static boolean partidaAcabada = false;

    // Comptador de caselles que el jugador ha explorat
    static int casellesExplorades = 0;

    public static void main(String[] args) {
        System.out.println("Benvingut al joc de buscar el codi de DAM");
        System.out.println("Has perdut el teu codi, el podràs trobar?");
        int opcio;

        do {
            // Menú principal amb les 3 opcions
            System.out.println("\nMenú de joc");
            System.out.println("1. Nova partida.");
            System.out.println("2. Decidir moviment.");
            System.out.println("3. Sortir del joc.");
            opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    generarMapa();  // Crear el mapa real amb codi i trampes
                    generarMapaVisible();  // Crear el mapa visible pel jugador
                    mostrarMapaVisible();  // Mostrar el mapa ocult al jugador
                    break;

                case 2:
                    if (partidaAcabada) {
                        System.out.println("La partida anterior ja ha acabat. Inicia una nova partida.");
                    } else {
                        if (fila == -1 && columna == -1) {
                            primerMoviment();  // Primer moviment lliure
                        } else {
                            nouMoviment();  // Moviments posteriors
                        }
                        mostrarMapaVisible();  // Mostrar el mapa després del moviment
                        System.out.println("Caselles explorades: " + casellesExplorades);
                        System.out.println("Intents restants: " + intents);
                    }
                    break;

                case 3:
                    System.out.println("Sortint del joc.");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }
        } while (opcio != 3);
    }

    public static void generarMapa() {
        int trampes = 0;  // Comptador de trampes

        // Inicialitzem totes les caselles com segures
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mapa[i][j] = 's';
            }
        }

        // Es situa el codi en una casella aleatòria
        mapa[random.nextInt(5)][random.nextInt(5)] = 'C';

        // Es situen 5 trampes en caselles segures
        while (trampes < 5) {
            int filaTrampa = random.nextInt(5);
            int columnaTrampa = random.nextInt(5);

            if (mapa[filaTrampa][columnaTrampa] == 's') {
                mapa[filaTrampa][columnaTrampa] = 'X';
                trampes++;
            }
        }

        // Reset de variables globals per nova partida
        fila = -1;
        columna = -1;
        intents = 10;
        casellesExplorades = 0;
        partidaAcabada = false;
    }

    public static void generarMapaVisible() {
        // Inici del mapa visible amb totes les caselles ocultes
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mapaVisible[i][j] = '-';
            }
        }
    }

    public static void mostrarMapaVisible() {
        // Mostrar el mapa visible 
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(mapaVisible[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void primerMoviment() {
        boolean ok = false;

        // Primer moviment, el jugador pot triar qualsevol casella
        while (!ok) {
            System.out.println("Escull la posició inicial:");
            System.out.print("Fila (0-4): ");
            fila = scanner.nextInt();
            System.out.print("Columna (0-4): ");
            columna = scanner.nextInt();

            if (fila >= 0 && fila < 5 && columna >= 0 && columna < 5) {
                ok = true;
                explorarPosicio(fila, columna);
                intents--;
            } else {
                System.out.println("Posició incorrecta.");
            }
        }
    }

    public static void nouMoviment() {
        if (intents <= 0) {
            System.out.println("No et queden intents! Has perdut.");
            partidaAcabada = true;
            mostrarMapaFinal();
            return;
        }

        // Moviment a casella adjacent
        System.out.println("Decideix la següent casella:");
        System.out.print("Fila (0-4): ");
        int novaFila = scanner.nextInt();
        System.out.print("Columna (0-4): ");
        int novaColumna = scanner.nextInt();

        boolean esAdjacent = 
            (novaFila == fila && (novaColumna == columna + 1 || novaColumna == columna - 1)) ||
            (novaColumna == columna && (novaFila == fila + 1 || novaFila == fila - 1));

        if (esAdjacent) {
            fila = novaFila;
            columna = novaColumna;
            explorarPosicio(fila, columna);
            intents--;
        } else {
            System.out.println("Moviment no vàlid! Només pots moure't a caselles adjacents.");
        }
    }

    public static void explorarPosicio(int fila, int columna) {
        if (mapa[fila][columna] == 'C') {
            System.out.println("Felicitats! Has trobat el codi de DAM!");
            partidaAcabada = true;
            mostrarMapaFinal();
        } else if (mapa[fila][columna] == 'X') {
            System.out.println("Has caigut en una trampa! Fi de la partida.");
            partidaAcabada = true;
            mostrarMapaFinal();
        } else if (mapaVisible[fila][columna] == '-') {
            mapaVisible[fila][columna] = 'O';
            casellesExplorades++;
            comprovarTrampes(fila, columna);
        }
    }

    public static void comprovarTrampes(int fila, int columna) {
        int trampesProperes = 0;

        // Comprovem totes les caselles del voltant
        if (fila > 0 && mapa[fila - 1][columna] == 'X') trampesProperes++;
        if (fila < 4 && mapa[fila + 1][columna] == 'X') trampesProperes++;
        if (columna > 0 && mapa[fila][columna - 1] == 'X') trampesProperes++;
        if (columna < 4 && mapa[fila][columna + 1] == 'X') trampesProperes++;

        if (trampesProperes == 1) System.out.println("Hi ha una trampa a prop.");
        else if (trampesProperes > 1) System.out.println("Hi ha moltes trampes a prop.");
    }

    public static void mostrarMapaFinal() {
        System.out.println("\nMapa final:");
        mostrarMapaVisible();
        System.out.println("\nMapa real:");
        mostrarMapaReal();
    }

    public static void mostrarMapaReal() {
        for (char[] fila : mapa) {
            for (char casella : fila) System.out.print(casella + " ");
            System.out.println();
        }
    }
}

