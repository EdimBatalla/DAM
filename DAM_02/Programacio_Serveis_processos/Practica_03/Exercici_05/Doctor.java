package Exercici_05;

import java.util.concurrent.ThreadLocalRandom;

public class Doctor implements Runnable {

    private final SalaEspera sala;
    private final int pacientsATendre;

    public Doctor(SalaEspera sala, int pacientsATendre) {
        this.sala = sala;
        this.pacientsATendre = pacientsATendre;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < pacientsATendre; i++) {
                // Espera fins que hi hagi un pacient (dins obtenirSeguentPacient)
                Pacient p = sala.obtenirSeguentPacient();

                System.out.println("[DOCTOR] Està atenent: " + p.getNom());
                // Simulem el temps de visita
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1200));

                System.out.println("[DOCTOR] Ha acabat amb: " + p.getNom());
                // Avisem el pacient que ja pot marxar
                p.avisarAtencio();
            }

            System.out.println("[DOCTOR] Ha acabat la jornada.");
        } catch (InterruptedException e) {
            System.out.println("[DOCTOR] interromput.");
            Thread.currentThread().interrupt();
        }
    }
}
