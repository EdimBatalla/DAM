package PART_01;

public class Activitat_03 {

	public static void main(String[] args) {

		 // Declarem i inicialitzem l'array de tipus boolean per indicar les llums enceses i apagades
        boolean[] llums = {true, false, true, false};
        
        //Mostrem l'estat actual de la llum
        System.out.println("Estat inicial de les llums.");
        for (int i = 0; i < llums.length; i++) {
        	System.out.println("Llum " + (i + 1) + ": " + (llums[i] ? "Encesa" : "Apagada"));
        }
        
        //Canviem l'estat de la segona llum
        llums[1] = !llums[1];
        
        //Mostrem l'estat actualitzat de les llums
        System.out.println("\nEstat actualitzat de les llums.");
        for (int i = 0; i < llums.length; i++) {
        	System.out.println("Llum" + (i + 1) + ": " + (llums[i] ? "Encesa" : "Apagada"));
        }
        
	}
        
}       
        
