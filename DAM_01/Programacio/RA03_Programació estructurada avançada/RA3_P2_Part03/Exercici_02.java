package PART3;

import java.util.Scanner;

public class Exercici_02 {

public static boolean determinaParell (int a) {

if( a % 2 == 0) {
return true;

}else {
	return false;
}
}

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);

System.out.println("Introdueix un numero enter.");
int numero = scanner.nextInt();
if(determinaParell(numero) == true) {
	System.out.println("El numero es parell.");
}else {
	System.out.println("el numero es senar.");
}

scanner.close();
}
}