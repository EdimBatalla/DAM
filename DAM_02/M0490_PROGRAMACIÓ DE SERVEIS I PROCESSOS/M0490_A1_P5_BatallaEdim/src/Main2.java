import java.security.MessageDigest;

public class Main2 {
    
    public static void main(String[] args) {

try{
        String missatge = "Hola DAM";

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] hash = md.digest(missatge.getBytes("UTF-8"));

        StringBuilder sb = new StringBuilder();
        for(byte b : hash){
            sb.append(String.format("%02x", b));
        }

        System.out.println("\nAra mostrarem el HASH!");
        System.out.println("\nSHA-256: " + sb.toString());



     }   catch(Exception e){
        e.printStackTrace();
}

try{
    String missatge = "Hola Caravaca";

    MessageDigest ms = MessageDigest.getInstance(algorithm:"SHA-256");

    byte[] hash= md.digest(missatge.getBytes(charsetName:"UTF-8"));

    StringBuilder 



    


}
}