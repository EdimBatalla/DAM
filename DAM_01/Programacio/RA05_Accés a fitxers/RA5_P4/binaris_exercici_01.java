package p1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;

public class binaris_exercici_01 {
	public static void main(String[] args) {

		String nomFitxer = "temperatures.bin";
		double[] temperatures = { 17.5, 18.8, 19.2, 16.6, 21.8 };

		try {
			FileOutputStream fitxer;
			DataOutputStream dades;
			fitxer = new FileOutputStream(nomFitxer);
			dades = new DataOutputStream(fitxer);

			for (double num : temperatures) {
				dades.writeDouble(num);
			}
			llegirTemperatures(nomFitxer);
			dades.close();
			fitxer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void llegirTemperatures(String nomFitxer) {
		try {
			FileInputStream fitxer2;
			DataInputStream dades2;
			fitxer2 = new FileInputStream(nomFitxer);
			dades2 = new DataInputStream(fitxer2);
			for (int i = 0; i < 5; i++) {
				double numero = dades2.readDouble();
				System.out.println("Número llegit: " + numero);
			}
			dades2.close();
			fitxer2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



