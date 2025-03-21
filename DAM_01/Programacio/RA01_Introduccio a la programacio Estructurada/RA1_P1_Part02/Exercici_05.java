package P01_Part2;

import java.util.Scanner;

public class Exercici_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Escull el teu grup d'animals preferit: mamífer, au o peix:");
        String animal = scanner.nextLine();
        
        switch (animal) {
        case "mamífer":
        System.out.println("Has escollit els mamífers com el teu grup d'animal preferit. Exemples de mamífers poden ser: elefants, lleons, gossos o gats.");
        break;
        case "au":
        System.out.println("Has escollit les aus com el teu grup d'animals preferit. Exemples d'aus poden ser: àguiles, boltors o pingüins.");
        break;
        case "peix":
        System.out.println("Has escollit els peixos com el teu grup d'animals preferit. Exemples de peixos poden ser: salmons, tunyines o tiburons.");
        break;
        default:
        System.out.println("Has de escollir entre: mamífer, au o peix per obtenir una resposta.");
        break;
        
        }
        
        scanner.close();
        
    }
}