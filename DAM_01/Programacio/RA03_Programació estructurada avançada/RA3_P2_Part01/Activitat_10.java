package PART_01;

public class Activitat_10 {
	
	public static void main(String[] args) {
        // Llistes de noms i puntuacions
        String[] noms = {"Anna", "Joan", "Maria", "Pere", "Laia", "Marc", "Júlia", "Oriol", "Pol", "Carla"};
        int[] puntuacions = {450, 200, 700, 400, 150, 900, 300, 800, 100, 600};

        // Ordenem els jugadors per puntuació utilitzant l'algorisme de bombolla (bubble sort)
        for (int i = 0; i < puntuacions.length - 1; i++) {
            for (int j = i + 1; j < puntuacions.length; j++) {
                if (puntuacions[i] < puntuacions[j]) {
                    // Intercanviem les puntuacions
                    int tempPuntuacio = puntuacions[i];
                    puntuacions[i] = puntuacions[j];
                    puntuacions[j] = tempPuntuacio;

                    // Intercanviem els noms corresponents
                    String tempNom = noms[i];
                    noms[i] = noms[j];
                    noms[j] = tempNom;
                }
            }
        }

     // Mostrem els tres primers jugadors
        for (int i = 0; i < 3; i++) {
            String posicio;
            switch (i) {
                case 0:
                    posicio = "Primer ";
                    break;
                case 1:
                    posicio = "Segon ";
                    break;
                case 2:
                    posicio = "Tercer ";
                    break;
                default:
                    posicio = "";
                    break;
            }
            System.out.println(posicio + "Jugador amb puntuació:");
            System.out.println(noms[i] + ": " + puntuacions[i] + " punts\n");
        }
	}
}        
        