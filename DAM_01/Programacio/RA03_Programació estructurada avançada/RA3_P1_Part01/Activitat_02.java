package PART_01;

public class Activitat_02 {

	public static void main(String[] args) {
		 // Declarem i inicialitzem l'array amb els dies de les semana
        String[] dies = {"Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge"};
	
        // Modifiquem el valor de "Dimecres" per "Mitjan setmana"
        dies[2] = "Mitja Setmana";
        
        // Mostrem els dies per pantalla
        for (int i = 0; i < dies.length; i++) {
            System.out.println("El dia de la setmana " + (i + 1) + ": " + dies[i]);
        }
	}
}
