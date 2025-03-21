package Repas; 

import java.util.Scanner; 

public class Exercici_03 { 

    static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) { 

        String[][] reparacions = new String[20][5]; // Declarem una matriu de 20 files i 5 columnes per emmagatzemar cada reparació (matrícula, nom, tipus, cost, data)

        int opcio; // Variable per guardar l'opció triada per l'usuari

        do { // Inici del bucle do-while per repetir el menú fins que l'usuari surti

            System.out.println("Sistema reparacions mecànic"); 
            System.out.println("1. Afegir reparació."); 
            System.out.println("2. Buscar reparació."); 
            System.out.println("3. Crear informes."); 
            System.out.println("4. Sortir."); 
            System.out.println("escull opcio:"); 

            opcio = scanner.nextInt(); 
            scanner.nextLine(); 

            switch (opcio) { // Inici del bucle switch 

                case 1: 
                    novaReparacio(reparacions); // Cridem al mètode per afegir una nova reparació passant-li la matriu
                    break; 

                case 2: 
                    buscarReparacio(reparacions); // Cridem al mètode per buscar una reparació per matrícula
                    break; 

                case 3: 
                    informes(reparacions); // Cridem al mètode per generar els informes de reparacions
                    break; 

                case 4: 
                    for (int i = 0; i < reparacions.length; i++) { // Recorrem cada fila de la matriu de reparacions
                        for (int j = 0; j < reparacions[i].length; j++) { // Recorrem cada columna dins de la fila actual
                            System.out.print(reparacions[i][j] + " "); // Imprimim les dades
                        }
                        System.out.println(""); // Afegim un salt de línia al final de cada reparació
                    }
                    System.out.println("Sortir del programa"); 
                    break; 

                default: 
                    System.out.println("opció no valida"); 
                    break; 
            }

        } while (opcio != 4); // El bucle continua mentre opcio no sigui 4

    } 

    public static void novaReparacio(String[][] matriu) { // Mètode per afegir una nova reparació a la matriu

        boolean temporal = false; // Booleà per controlar si s'ha afegit una reparació 

        for (int i = 0; i < matriu.length; i++) { // Recorrem cada fila de la matriu
            for (int j = 0; j < matriu[i].length; j++) { // Recorrem cada columna de la fila actual
                if (matriu[i][0] == null) { // Si la primera posició de la fila està buida, vol dir que aquesta reparació encara no s'ha registrat
                    // 20 reparacions: matricula/nom/tipus/cost/data

                    System.out.println("Introdueix la matricula:"); 
                    matriu[i][0] = scanner.nextLine(); 

                    System.out.println("Introdueix el nom del client:"); 
                    matriu[i][1] = scanner.nextLine(); 

                    System.out.println("Introdueix el tipus de reparació:"); 
                    matriu[i][2] = scanner.nextLine(); 

                    System.out.println("Introdueix el cost de reparació:"); 
                    matriu[i][3] = scanner.nextLine(); 

                    System.out.println("Introdueix la data de reparació:"); 
                    matriu[i][4] = scanner.nextLine(); 

                    temporal = true; // Si s'ha registrat una reparació cambiem el booleà
                    break; // 

                } else if (matriu[i][j] != null && j == matriu[i].length - 1 && i == matriu.length - 1) {
                    // Si hem arribat a l'última posició de l'última fila i tot està omplert, vol dir que l'inventari està ple
                    
                    System.out.println("inventari ple."); 
                }
            }

            if (temporal == true) { // Si ja hem afegit la reparació, sortim del bucle exterior 
                break;
            }
        }
    } 

    public static void buscarReparacio(String[][] matriu) { // Mètode per cercar una reparació segons la matrícula

        boolean temporal = false; // Booleà per controlar si hem trobat la reparació
        System.out.println("Introdueix matricula client:"); 
        String matricula = scanner.nextLine(); 

        System.out.println("Detalls de la reparació: "); 

        for (int i = 0; i < matriu.length; i++) { // Recorrem cada fila de la matriu
            for (int j = 0; j < matriu[i].length; j++) { // Recorrem cada columna de la fila
                if (matricula.equals(matriu[i][0])) { // Comprovem si la matrícula introduïda coincideix amb la registrada
                    System.out.println("El cotxe amb matricula" + matriu[i][j] + " "); // Mostrem el detall de la reparació
                    temporal = true; // Si s'ha trobat una coincidència modifiquem el boleà
                    if (j == matriu[i].length - 1) { // Si hem arribat a l'última columna, sortim del bucle interior
                        break;
                    }
                } else if (i == matriu.length - 1 && j == 1) {
                    // Si hem recorregut la matriu fins al final sense trobar coincidències vol dir que no s'ha trobat cap reparació amb aquesta matrícula
                    System.out.println("no hi ha cap coincidencia."); 
                }
            }
            if (temporal == true) { // Si s'ha trobat la reparació, sortim del bucle exterior
                break;
            }
        }
    } 

    public static void informes(String[][] matriu) { // Mètode per generar un informe dels costos de reparació

        double costTotal = 0; // Variable per acumular el cost total de totes les reparacions
        int numReparacions = 0; // Variable per comptar el nombre de reparacions

        for (int i = 0; i < matriu.length; i++) { // Recorrem cada fila de la matriu
            for (int j = 0; j < matriu[i].length; j++) { // Recorrem cada columna de la fila
                double cost = Double.parseDouble(matriu[i][3]); // Convertim el cost de String a un valor double
                costTotal += cost; // Afegim aquest cost al total acumulat
                numReparacions++; // Incrementem el comptador de reparacions
            } 
        }

        if (numReparacions > 0) { // Si s'han registrat reparacions
            double mitjana = costTotal / numReparacions; // Calculem el cost mitjà per reparació
            System.out.println("Cost total acumulat: " + costTotal); // Mostrem el cost total acumulat
            System.out.println("Cost mitjà per reparació: " + mitjana); // Mostrem el cost mitjà per reparació
        } else { // Si no hi ha reparacions registrades informem que no es pot generar l'informe
            System.out.println("No hi ha reparacions registrades per generar l'informe."); 
        }
    } 

} 

