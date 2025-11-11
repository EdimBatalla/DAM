package Exercici_05;

import java.util.LinkedList;
import java.util.Queue;

public class SalaEspera {

    private final int maxPac;
    private final Queue<Pacient> cuaUrgents = new LinkedList<>();
    private final Queue<Pacient> cuaNormals = new LinkedList<>();

    public SalaEspera(int maxPac) {
        this.maxPac = maxPac;
    }

    private int totalPacients() {
        return cuaUrgents.size() + cuaNormals.size();
    }

    // Cridat pels pacients
    public synchronized void entrarSala(Pacient p) throws InterruptedException {
        // Si la sala és plena, el pacient espera fins que hi hagi lloc
        while (totalPacients() == maxPac) {
            System.out.println("[SALA] Plena. " + p.getNom() + " espera fora...");
            wait();
        }

        if (p.isUrgent()) {
            cuaUrgents.add(p);
            System.out.println("[SALA] Entra pacient URGENT: " + p.getNom() +
                    " | Urgents=" + cuaUrgents.size() + " Normals=" + cuaNormals.size());
        } else {
            cuaNormals.add(p);
            System.out.println("[SALA] Entra pacient NORMAL: " + p.getNom() +
                    " | Urgents=" + cuaUrgents.size() + " Normals=" + cuaNormals.size());
        }

        // Hi ha un pacient nou → podem despertar el doctor si estava adormit
        notifyAll();
    }

    // Cridat pel doctor per obtenir el següent pacient a atendre
    public synchronized Pacient obtenirSeguentPacient() throws InterruptedException {
        // Si no hi ha cap pacient, el doctor es queda adormit
        while (totalPacients() == 0) {
            System.out.println("[DOCTOR] No hi ha pacients, es queda adormit a la consulta...");
            wait();
        }

        Pacient p;
        // PRIORITAT: primer els urgents, després els normals
        if (!cuaUrgents.isEmpty()) {
            p = cuaUrgents.poll();
        } else {
            p = cuaNormals.poll();
        }

        System.out.println("[SALA] El doctor crida: " + p.getNom() +
                " | Queden Urgents=" + cuaUrgents.size() + " Normals=" + cuaNormals.size());

        // Alliberem una cadira a la sala → altres pacients poden entrar
        notifyAll();

        return p;
    }
}
