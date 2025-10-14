import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {

        try{
    //GENERAR HASH SHA-256 ------------------------------------------------


            //Aquest es el missatge real
            String missatge = "Hola DAM";
            //Aixo es la encriptacio en SHA256  
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //Traduccio de la encriptacio del hash a bytes
            byte[] hash = md.digest(missatge.getBytes("UTF-8"));


            //inicialitzar SB
            StringBuilder sb = new StringBuilder();
            for(byte b : hash){
                sb.append(String.format("%02x", b));
            }
            System.out.println("\nAra mostrarem el HASH!");
            System.out.println("\nSHA-256: " + sb.toString());




            //XIFRAR AMB AES ------------------------------------------------


            //Inicialitzar KG
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);


            //Generar clau secreta
            SecretKey secretKey = keyGen.generateKey();


            //Creacio del Cipher
            Cipher cipher = Cipher.getInstance("AES");


            //Xifrar missatge del que s'ha creat el HASH
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textXifrat = cipher.doFinal(missatge.getBytes());


            //Mostrar text xifrat amb AES
            System.out.println("\nText xifrat amb AES: " + new String(textXifrat));
            System.out.println("\nLa clave AES es esta: "+ secretKey);
            //XIFRAR KEY AMB RSA ------------------------------------------------


            //Generar un par de claves RSA (pub i priv)
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            //Inicialitzem el generador de key RSA
            keyPairGenerator.initialize(2048);
            KeyPair pair = keyPairGenerator.generateKeyPair();
            //Crear 2 claus una publica i una privada
            PublicKey pubK = pair.getPublic();
            PrivateKey privK = pair.getPrivate();


            //El missatge a xifrar es la secretKey creada amb AES
            //Primer s'ha de passar la secretKey a bites
            byte[] secretKeyByte = secretKey.getEncoded();


            //Per xifrar amb RSA amb la clau publica utilitzem el cipher


            Cipher cipher2 = Cipher.getInstance("RSA");
            cipher2.init(Cipher.ENCRYPT_MODE, pubK);


            byte[] missatgeXifrat = cipher2.doFinal(secretKeyByte);


            //Mostrar missatge xifrat amb clau publica RSA
            System.out.println("\nMissatge xifrat amb clau pública RSA: "+ new String(missatgeXifrat));


            //DESXIFRAR SecretKey AES amb RSA i la seva clau privada ------------------------------------------------


            //inicialitzar cipher amb decrypt_mode i private key
            cipher2.init(Cipher.DECRYPT_MODE, privK);
            byte[] missatgeDesxifrat = cipher2.doFinal(missatgeXifrat);


            System.out.println("\nAquesta es la clau AES desxifrada amb la clau privada: "+ new String(missatgeDesxifrat));


            //DESXIFRAR Missatge amb clau AES ------------------------------------------------
           
            //Primer s'ha de passat el missatge xifrat en array de bytes a SecretKey
            SecretKey missatgeDesxifratKey = new SecretKeySpec(missatgeDesxifrat,"AES");
            //Inicialitzem el cipher amb la clau AES en decrypt
            cipher.init(Cipher.DECRYPT_MODE,missatgeDesxifratKey);
            byte[] missatgeDesxifratEnBytes = cipher.doFinal(textXifrat);


            System.out.println("\nText original: " + new String(missatgeDesxifratEnBytes));


            //MOSTRAR TEXT XIFRAT AMB BASE64 ------------------------------------------------


            System.out.println("\nEl missatge xifrat es llegeix aixi: "+Base64.getEncoder().encodeToString(textXifrat));


            //VERIFICAR EL HASH
            //Primer calcular el hash del missatge recuperat
            //Passar el missatge a String
            String missatgeRecu = new String(missatgeDesxifratEnBytes);


            //Inici Verificacio
            MessageDigest mdVerificacio = MessageDigest.getInstance("SHA-256");
            byte[] hashRecup = mdVerificacio.digest(missatgeRecu.getBytes("UTF-8"));


            //Convertir el HASH recuperat a hexadecimal
            StringBuilder sbRecuperat = new StringBuilder();
            for(byte b : hashRecup){
                sbRecuperat.append(String.format("%02x", b));
            }
            //Ara mostrem els dos hash
            System.out.println("\nHash original: "+ sb.toString());
            System.out.println("Hash recuperat: "+ sbRecuperat.toString());


            if(sb.toString().equals(sbRecuperat.toString())){
                System.out.println("\nEl Hash original i el recuperat són iguals");
            }else{
                System.out.println("\nERROR!!!!!! El Hash original i el recuperat són diferents");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
}
}