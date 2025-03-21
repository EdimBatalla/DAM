package PART3;



public class Exercici_08 {

	public static void main(String[] args) {

		int[] array1 = {5, 5, 6, 7, 7, 8, 8, 9, 10}; 
        int[] array2 = {1, 2, 2, 3, 4, 4};          
        int[] array3 = {1, 2, 3, 4, 5};        
        int[] array4 = {1, 1, 2, 1, 1};             

        System.out.println("Elements únics en array1: " + comptaUnics(array1)); 
        System.out.println("Elements únics en array2: " + comptaUnics(array2)); 
        System.out.println("Elements únics en array3: " + comptaUnics(array3)); 
        System.out.println("Elements únics en array4: " + comptaUnics(array4)); 

	}

	public static int comptaUnics(int[] array) {
	    int comptadorUnics = 0;
	    int i, j;
	    int[] numUnics = new int [array.length];
	
	   
	    for (i = 0; i < array.length; i++) {
	    
		    boolean esUnic = true;
	    
	        for (j = 0; j < array.length; j++) {
	        	if (i != j ) {
		        	if(array[i] == array[j]) {
		        	
			            esUnic = false;
			            break;
		        	}
		        }       
	        }
	        if (esUnic == true) {
	        	numUnics[comptadorUnics] = array[i];
	            comptadorUnics++;
	        }
	    }
	    
	    for (i = 0; i < comptadorUnics; i++) {
	    	System.out.println(numUnics[i]+", ");
	    }
	    return comptadorUnics;
	}
	}
