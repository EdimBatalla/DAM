package part_02;

import java.util.Arrays;

public class Exercici_01_Coleccions {

	    public static void main(String[] args) {
	
	        int[] notes = {7, 5, 9, 4};											//Array amb les notes del examen

	        Arrays.sort(notes);													//Ordenem l'array de menor a major

	        System.out.print("Notes ordenades de menor a major: ");				//En un bucle for creem una variable int on es guardarà el valor temporal				
	        for (int nota : notes) {
	            System.out.print(nota + " ");
	        }
	    }
	}