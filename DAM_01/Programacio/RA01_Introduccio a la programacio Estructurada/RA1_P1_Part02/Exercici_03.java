package P01_Part2;

import java.util.Scanner;

public class Exercici_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introdueix un any:");
        int any = scanner.nextInt();
        
        if (any % 4 == 0 && any % 100 !=0 || any % 400 == 0) {
        	System.out.println("Aquest és un any de traspàs.");
        } else {
            System.out.println("Aquest no és un any de traspàs");
        }
        
        scanner.close();
}
}