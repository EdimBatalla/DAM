package part_01;

import java.util.Random;

public class Exercici_09 {
    public static void main(String[] args) {
        char[][] mapa = new char[8][8];
        Random random = new Random();

        char[] opcions = {'C', 'R', 'P', 'T'};
        char[] opcionsSenseR = {'T', 'P'}; 
        char[] opcionsSenseC = {'R', 'P', 'T'}; 
        char[] opcionsDespresP = {'T', 'C'};  

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (j >= 2 && mapa[i][j - 1] == 'C' && mapa[i][j - 2] == 'C') {
                    mapa[i][j] = opcionsSenseR[random.nextInt(opcionsSenseR.length)];
                } 
                else if (j >= 2 && mapa[i][j - 1] == 'R' && mapa[i][j - 2] == 'R') {
                    mapa[i][j] = opcionsSenseC[random.nextInt(opcionsSenseC.length)];
                } 
                else if (j > 0 && mapa[i][j - 1] == 'P') {
                    mapa[i][j] = opcionsDespresP[random.nextInt(opcionsDespresP.length)];
                } 
                else {
                    mapa[i][j] = opcions[random.nextInt(opcions.length)];
                }
            }
        }


        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {

                if (mapa[i][j] == 'T') {
                    boolean tieneR = (j > 0 && mapa[i][j - 1] == 'R') || (j < mapa[i].length - 1 && mapa[i][j + 1] == 'R');
                    if (!tieneR) {
                        mapa[i][j] = 'R';  
                    }
                }

                if (mapa[i][j] == 'P' && j < mapa[i].length - 1 && mapa[i][j + 1] == 'R') {
                    mapa[i][j + 1] = opcionsDespresP[random.nextInt(opcionsDespresP.length)];
                }
            }
        }

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }
}
