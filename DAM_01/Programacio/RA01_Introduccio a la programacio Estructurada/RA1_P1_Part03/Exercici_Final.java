package P01;

import java.util.Scanner;
import java.util.Random;

public class Exercici_Final {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int vidaJugador = 20;
        int vidaRival = 20;

        System.out.print("Hola, quin és el teu nom?: ");
        String nomJugador = scanner.nextLine();
        System.out.println("Benvingut " + nomJugador + ". Sóc el teu rival en aquest combat de PokeDAM.");
        System.out.println("Comencem!!!");

        // Bucle principal del joc
        while (vidaJugador > 0 && vidaRival > 0) {
            System.out.println("\nLa teva vida és: " + vidaJugador);
            System.out.println("La vida del teu rival és: " + vidaRival);

            // Mostra el menú d'accions
            System.out.println("\n- - - - Menú d'accions. - - - -");
            System.out.println("1. Atac Senzill (2 danys, sempre funciona).");
            System.out.println("2. Atac Poderós (4 danys, però pot fallar).");
            System.out.println("3. Atac Especial (molt dany però autoinfligeix).");
            System.out.println("4. Poció de curació (cura 3 punts).");
            System.out.println("5. Rendirse.");
            System.out.print("\nEscull la teva següent acció: ");
            int opcio = scanner.nextInt();

            // Accions del jugador
            switch (opcio) {
                case 1:
                    vidaRival -= 2;
                    System.out.println("Has fet 2 punts de dany al teu rival.");
                    break;
                case 2:
                    if (random.nextInt(2) == 1) {
                        vidaRival -= 4;
                        System.out.println("\nL'atac poderós ha funcionat! Fas 4 punts de dany.");
                    } else {
                        System.out.println("\nL'atac poderós ha fallat!");
                    }
                    break;
                case 3:
                    int atacEspecial = random.nextInt(7);
                    int danyPropi = random.nextInt(4) + 1;
                    vidaRival -= atacEspecial;
                    vidaJugador -= danyPropi;
                    System.out.println("\nHas utilitzat l'atac especial!");
                    System.out.println("Has fet " + atacEspecial + " punts de dany al rival.");
                    System.out.println("Però t'has fet " + danyPropi + " punts de dany.");
                    break;
                case 4:
                    vidaJugador += 3;
                    System.out.println("\nHas utilitzat una poció de curació. Cura 3 punts de vida.");
                    break;
                case 5:
                    System.out.println("\nRendirse no és una opció gallina! Perds 1 punt de vida.");
                    vidaJugador -= 1;
                    break;
                default:
                    System.out.println("\nOpció no vàlida! Perds el torn.");
            }

            // Comprovar si el rival ha perdut
            if (vidaRival <= 0) {
                System.out.println("\nFelicitats! Has guanyat la batalla PokeDAM.");
                break;
            }

            // Torn del rival
            System.out.println("\n- - - - Torn del rival - - - -");
            if (vidaRival <= 6) {
                vidaRival += 3;
                System.out.println("\nEl teu rival ha utilitzat una poció de curació restaurant 3 punts de vida.");
            } else if (vidaJugador <= 4) {
                int accio1 = random.nextInt(2);
                if (accio1 == 0) {
                    vidaJugador -= 2;
                    System.out.println("\nEl teu rival t'ha fet 2 punts de dany.");
                } else {
                    if (random.nextInt(2) == 1) {
                        vidaJugador -= 4;
                        System.out.println("\nL'atac poderós del rival ha funcionat! Et fa 4 punts de dany.");
                    } else {
                        System.out.println("\nL'atac poderós del rival ha fallat!");
                    }
                }
            } else if (vidaJugador >= 4 && vidaJugador <= 10) {
                int accio1 = random.nextInt(2);
                if (accio1 == 0) {
                    if (random.nextInt(2) == 1) {
                        vidaJugador -= 4;
                        System.out.println("\nL'atac poderós del rival ha funcionat! Et fa 4 punts de dany.");
                    } else {
                        System.out.println("\nL'atac poderós del rival ha fallat!");
                    }
                } else {
                    int atacEspecial = random.nextInt(7);
                    int danyPropi = random.nextInt(4) + 1;
                    vidaRival -= danyPropi;
                    vidaJugador -= atacEspecial;
                    System.out.println("\nEl teu rival ha utilitzat l'atac especial!");
                    System.out.println("Et fa " + atacEspecial + " punts de dany.");
                    System.out.println("Però s'ha fet " + danyPropi + " punts de dany a ell mateix.");
                }
            } else if (vidaJugador <= 20 && vidaJugador >= 11){
                int accio1 = random.nextInt(4);
                switch (accio1) {
                    case 0:
                        vidaJugador -= 2;
                        System.out.println("\nEl teu rival t'ha fet 2 punts de dany.");
                        break;
                    case 1:
                        if (random.nextInt(2) == 1) {
                            vidaJugador -= 4;
                            System.out.println("\nL'atac poderós del rival ha funcionat! Et fa 4 punts de dany.");
                        } else {
                            System.out.println("\nL'atac poderós del rival ha fallat!");
                        }
                        break;
                    case 2:
                        int atacEspecial = random.nextInt(7);
                        int danyPropi = random.nextInt(4) + 1;
                        vidaRival -= danyPropi;
                        vidaJugador -= atacEspecial;
                        System.out.println("\nEl teu rival ha utilitzat l'atac especial!");
                        System.out.println("Et fa " + atacEspecial + " punts de dany.");
                        System.out.println("Però s'ha fet " + danyPropi + " punts de dany.");
                        break;
                    case 3:
                        vidaRival += 3;
                        System.out.println("\nEl teu rival ha utilitzat una poció de curació restaurant 3 punts de vida.");
                        break;
                		}
            		}
            
            // Comprovar si el jugador ha perdut
            if (vidaJugador <= 0) {
                System.out.println("\nQuina pena! Has perdut la batalla PokeDAM...");
                break;
            }
        }

        scanner.close();
    }
}
