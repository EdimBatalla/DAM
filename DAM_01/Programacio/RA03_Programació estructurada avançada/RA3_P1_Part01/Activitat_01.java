package PART_01;

public class Activitat_01 {

	public static void main(String[] args) {
        // Declarem i inicialitzem l'array amb les notes
        int[] notes = {8, 7, 9, 6, 10};

        // Mostrem les notes per pantalla
        for (int i = 0; i < notes.length; i++) {
            System.out.println("Nota de l'alumne " + (i + 1) + ": " + notes[i]);
        }
    }
}
