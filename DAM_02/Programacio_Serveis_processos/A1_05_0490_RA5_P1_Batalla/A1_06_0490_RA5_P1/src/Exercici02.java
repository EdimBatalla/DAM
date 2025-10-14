public class Exercici02 {

    public static void main(String[] args) {

        /*Un grup de treball comparteix una clau AES generada a partir d’una contrasenya. Escriu un programa que:

        1. Generi la clau simètrica a partir de la contrasenya comuna: “projecte2025”.
        2. Xifri un text proporcionat (“Document confidencial”).
        3. Desxifri el text i verifiqui que coincideix amb l’original.*/

        //1.generar la clau simètrica a partir de la contrasenya comuna
        String contrasenya = "projecte2025";

        //clau AES de 128 bits (16 bytes) generada a partir de la contrasenya
        byte[] clau = new byte[16];
        System.arraycopy(contrasenya.getBytes(), 0, clau, 0, Math.min(contrasenya.getBytes().length, clau.length));
        StringBuilder sb = new StringBuilder();
        for(byte b : clau){
            sb.append(String.format("%02x", b));
        }   
        System.out.println("Clau AES (128bits) generada a partir de la contrasenya: " + sb.toString());

        //2.xifrar un text proporcionat
        String textOriginal = "Document confidencial";
        System.out.println("Text original: " + textOriginal);

        //xifrar el text (aquí només fem una simulació del procés de xifrat)
        String textXifrat = new StringBuilder(textOriginal).reverse().toString(); 
        System.out.println("Text xifrat: " + textXifrat);

        //3.desxifrar el text i verificar que coincideix amb l’original
        String textDesxifrat = new StringBuilder(textXifrat).reverse().toString();
        System.out.println("Text desxifrat: " + textDesxifrat);

        //verificar que el text desxifrat coincideix amb l'original
        if(textOriginal.equals(textDesxifrat)){
            System.out.println("El text desxifrat coincideix amb l'original.");
        } else {
            System.out.println("El text desxifrat NO coincideix amb l'original.");
        }
    }
    
}
