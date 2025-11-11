package Exercici_02;

import java.util.LinkedList;
import java.util.Queue;

public class Passaplats {
    private final int maxCap;
    private final Queue<Plat> cua = new LinkedList<>();

    public Passaplats(int maxCap) {
        this.maxCap = maxCap;
    }

    public synchronized void posarPlat(Plat p) throws InterruptedException {
        // Si el passaplats està ple, el cuiner espera
        while (cua.size() == maxCap) {
            System.out.println("[PASSAPLATS] Ple. Cuiner espera...");
            wait();
        }

        cua.add(p);
        System.out.println("[PASSAPLATS] Cuiner deixa: " + p + " | Plats a la barra: " + cua.size());

        // Notifiquem cambrers (i altres cuiners) que hi ha hagut canvi
        notifyAll();
    }

    public synchronized Plat agafarPlat() throws InterruptedException {
        // Si el passaplats està buit, el cambrer espera
        while (cua.isEmpty()) {
            System.out.println("[PASSAPLATS] Buit. Cambrer espera...");
            wait();
        }

        Plat p = cua.remove();
        System.out.println("[PASSAPLATS] Cambrer agafa: " + p + " | Plats a la barra: " + cua.size());

        // Notifiquem cuiners (i altres cambrers) que hi ha espai o canvi d'estat
        notifyAll();
        return p;
    }
}
