package PART3;

public class Exercici_04 {


public static int sumaArray (int[] numero) {
	
	int suma = 0;
	for(int i=0; i<numero.length; i++) {
		suma += numero[i];
}
return suma;
	
	
	
	
}	
public static void main(String[] args) {
	
	int valors[]={1,2,3,4};
	int resultat = sumaArray(valors);
	
	System.out.println("la suma dels numeros del array es igual: " +resultat);
	
}	
}
