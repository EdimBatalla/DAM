
import java.security.SecureRandom;

public class Exercici01 {

    public static void main(String[] args) {

        //declarem un array amb els noms dels usuaris
        String[] usuaris = {"Anna", "Joan", "Laura", "Pau"};

        //creem un objecte SecureRandom per generar claus aleatòries
       SecureRandom secureRandom = new SecureRandom();

        //per a cada usuari generem una clau AES de 128 bits (16 bytes)
        for (String usuari : usuaris) {

            byte[] clau = new byte[16];  
            secureRandom.nextBytes(clau);

            //convertim la clau a una representació hexadecimal per imprimir-la
            StringBuilder sb = new StringBuilder();
            
            //convertim cada byte a hexadecimal
            for(byte b : clau){
            sb.append(String.format("%02x", b));

}
            //imprimim l'usuari i la seva clau AES
            System.out.println("Usuari: " + usuari + " - Clau AES (128bits): " + sb.toString());

        }
    }
}
