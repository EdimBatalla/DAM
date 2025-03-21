package PART_02;

	import java.util.Scanner;

		public class Exercici_02 {

			public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        String[] titols = new String[100];
		        boolean[] prestat = new boolean[100];
		        String[] usuaris = new String[100];
		        int[] numPrestecs = new int[100];
		        int numLlibres = 0;

		   		 while (true) {
		 			System.out.println("\n--- Gestió Biblioteca ---");
		 			System.out.println("\n1. Consultar estat dels llibres");
		 			System.out.println("2. Afegir un nou llibre a la bibloteca");
		 			System.out.println("3. Realitzar un préstec");
		 			System.out.println("4. Gestionar retorn");
		 			System.out.println("5. Consultar l'històric de prestecs");
		 			System.out.println("6. Llibres més solicitats (Top 5)");
		 			System.out.println("7. Sortir");
		 			System.out.print("\nSelecciona una opció: ");

		         int opcio = scanner.nextInt();

		            switch (opcio) {
	                case 1:
	                    System.out.println("\nEstat dels llibres:");
	                    for (int i = 0; i < numLlibres; i++) {
	                    	String estat;
	                    	if (prestat[i]) {
	                    	    estat = "Prestat a: " + usuaris[i];
	                    	} else {
	                    	    estat = "Disponible";
	                    	}
	                    }
	                    break;

	                case 2:
	                    if (numLlibres < 100) {
	                        System.out.print("\nIntrodueix el títol del llibre: ");
	                        scanner.nextLine();
	                        String titol = scanner.nextLine();
	                        titols[numLlibres] = titol;
	                        prestat[numLlibres] = false;
	                        usuaris[numLlibres] = "";
	                        numPrestecs[numLlibres] = 0;
	                        numLlibres++;
	                        System.out.println("\nLlibre afegit a la biblioteca.");
	                    } else {
	                        System.out.println("\nNo es poden afegir més llibres. Biblioteca plena.");
	                    }
	                    break;

	                case 3:
	                    System.out.print("\nIntrodueix el títol del llibre per realitzar el préstec: ");
	                    scanner.nextLine();
	                    String llibrePrestec = scanner.nextLine();
	                    boolean llibreTrobat = false;
	                    for (int i = 0; i < numLlibres; i++) {
	                        if (titols[i].equals(llibrePrestec) && !prestat[i]){
	                            System.out.print("\nIntrodueix el nom de la persona que agafa el llibre: ");
	                            String persona = scanner.nextLine();
	                            prestat[i] = true;
	                            usuaris[i] = persona;
	                            numPrestecs[i]++;
	                            System.out.println("\nEl llibre ha estat prestat a " + persona);
	                            llibreTrobat = true;
	                            break;
	                        }
	                    }
	                    if (!llibreTrobat) {
	                        System.out.println("\nEl llibre no està disponible per préstec.");
	                    }
	                    break;

	                case 4:
	                    System.out.print("\nIntrodueix el títol del llibre per tornar-lo: ");
	                    scanner.nextLine();
	                    String llibreRetorn = scanner.nextLine();
	                    boolean llibreRetornat = false;
	                    for (int i = 0; i < numLlibres; i++) {
	                        if (titols[i].equalsIgnoreCase(llibreRetorn) && prestat[i]) {
	                            prestat[i] = false;
	                            usuaris[i] = "";
	                            System.out.println("\nEl llibre ha estat retornat.");
	                            llibreRetornat = true;
	                            break;
	                        }
	                    }
	                    if (!llibreRetornat) {
	                        System.out.println("\nEl llibre no està prestat.");
	                    }
	                    break;

	                case 5:
	                    System.out.print("\nIntrodueix el títol del llibre per consultar l'històric de préstecs: ");
	                    scanner.nextLine();
	                    String llibreHistòric = scanner.nextLine();
	                    boolean llibreHistoricTrobat = false;
	                    for (int i = 0; i < numLlibres; i++) {
	                        if (titols[i].equalsIgnoreCase(llibreHistòric)) {
	                            System.out.println("El llibre " + titols[i] + " s'ha prestat " + numPrestecs[i] + " vegades.");
	                            llibreHistoricTrobat = true;
	                            break;
	                        }
	                    }
	                    if (!llibreHistoricTrobat) {
	                        System.out.println("\nEl llibre no es troba a la biblioteca.");
	                    }
	                    break;

	                case 6:
	                    System.out.println("\nLlibres més sol·licitats (Top 5):");
	                    int[] topPrestecs = numPrestecs.clone();
	                    for (int i = 0; i < 5; i++) {
	                        int maxPrestec = -1;
	                        int maxIndex = -1;
	                        for (int j = 0; j < numLlibres; j++) {
	                            if (topPrestecs[j] > maxPrestec) {
	                                maxPrestec = topPrestecs[j];
	                                maxIndex = j;
	                            }
	                        }
	                        if (maxPrestec == -1) break;
	                        System.out.println(titols[maxIndex] + " - " + maxPrestec + " préstecs");
	                        topPrestecs[maxIndex] = -1;
	                    }
	                    break;

	                case 7:
	                    System.out.println("\nSortint del programa...");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("\nOpció no vàlida. Torna a intentar-ho.");
	                    break;
	            }
	        }
	    }
	}