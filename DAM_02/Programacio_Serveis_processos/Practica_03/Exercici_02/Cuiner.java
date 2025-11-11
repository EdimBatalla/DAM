package Exercici_02;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Cuiner implements Runnable {
    private final String nom;
    private final Passaplats passaplats;
    private final int platsACuinar;
    private final List<String> receptes;

    public Cuiner(String nom, Passaplats passaplats, int platsACuinar, List<String> receptes) {
        this.nom = nom;
        this.passaplats = passaplats;
        this.platsACuinar = platsACuinar;
        this.receptes = receptes;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= platsACuinar; i++) {
                String nomPlat = receptes.get(ThreadLocalRandom.current().nextInt(receptes.size()));
                Plat p = new Plat(i, nomPlat, nom);

                System.out.println("[" + nom + "] Cuinant " + p);
                Thread.sleep(ThreadLocalRandom.current().nextInt(200, 600)); // simulacío de temps de cuina

                passaplats.posarPlat(p);
            }
            System.out.println("[" + nom + "] Ha acabat de cuinar (" + platsACuinar + " plats).");
        } catch (InterruptedException e) {
            System.out.println("[" + nom + "] interrumput mentre cuinava.");
            Thread.currentThread().interrupt();
        }
    }
}
