package Exercici_02;

import java.util.concurrent.ThreadLocalRandom;

public class Cambrer implements Runnable {
    private final String nom;
    private final Passaplats passaplats;
    private final int platsAServir;

    public Cambrer(String nom, Passaplats passaplats, int platsAServir) {
        this.nom = nom;
        this.passaplats = passaplats;
        this.platsAServir = platsAServir;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= platsAServir; i++) {
                Plat p = passaplats.agafarPlat();
                System.out.println("[" + nom + "] Servint " + p);
                Thread.sleep(ThreadLocalRandom.current().nextInt(300, 800)); // simulació servei
            }
            System.out.println("[" + nom + "] Ha acabat de servir (" + platsAServir + " plats).");
        } catch (InterruptedException e) {
            System.out.println("[" + nom + "] interrumput mentre servia.");
            Thread.currentThread().interrupt();
        }
    }
}
