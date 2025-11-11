package Exercici_05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Consultori {

    public static void main(String[] args) throws InterruptedException {
        int MAX_PAC = 3;       // capacitat sala d'espera
        int NUM_PACIENTS = 8;  // total pacients que vindran

        SalaEspera sala = new SalaEspera(MAX_PAC);

        // Doctor que atendrà tots els pacients
        Doctor doctor = new Doctor(sala, NUM_PACIENTS);
        Thread filDoctor = new Thread(doctor, "Doctor");

        // Crear pacients (alguns urgents, alguns normals)
        List<Thread> filsPacients = new ArrayList<>();
        for (int i = 1; i <= NUM_PACIENTS; i++) {
            boolean urgent = ThreadLocalRandom.current().nextBoolean();
            Pacient p = new Pacient("Pacient-" + i, urgent, sala);
            Thread t = new Thread(p, "Pacient-" + i);
            filsPacients.add(t);
        }

        // Comencem el doctor i després els pacients (o al revés, és igual)
        filDoctor.start();
        for (Thread t : filsPacients) {
            t.start();
            // Podem posar un petit retard perquè no arribin tots exactament a la vegada
            Thread.sleep(100);
        }

        // Esperem que tots els pacients acabin
        for (Thread t : filsPacients) {
            t.join();
        }
        // Esperem que acabi el doctor
        filDoctor.join();

        System.out.println(">>> Consultori tancat. Tots han estat atesos o rebutjats si no han entrat.");
    }
}
