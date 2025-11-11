package Exercici_03;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ClientCaixer implements Runnable {

    private final String nomClient;
    private final List<CompteBancari> comptes;
    private final int operacions;

    public ClientCaixer(String nomClient, List<CompteBancari> comptes, int operacions) {
        this.nomClient = nomClient;
        this.comptes = comptes;
        this.operacions = operacions;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= operacions; i++) {
                // Triem un compte aleatori
                CompteBancari compte = comptes.get(
                        ThreadLocalRandom.current().nextInt(comptes.size())
                );

                // Triem una operació aleatòria: 0 = ingressar, 1 = retirar, 2 = consultar
                int op = ThreadLocalRandom.current().nextInt(3);

                switch (op) {
                    case 0 -> { // Ingressar
                        double quantitat = quantitatAleatoria();
                        System.out.println("[" + nomClient + "] vol INGRESSAR " + quantitat +
                                " al compte " + compte.getIdCompte());
                        compte.ingressar(quantitat);
                    }
                    case 1 -> { // Retirar
                        double quantitat = quantitatAleatoria();
                        System.out.println("[" + nomClient + "] vol RETIRAR " + quantitat +
                                " del compte " + compte.getIdCompte());
                        compte.retirar(quantitat);
                    }
                    case 2 -> { // Consultar
                        System.out.println("[" + nomClient + "] vol CONSULTAR el compte " + compte.getIdCompte());
                        compte.consultarSaldo();
                    }
                }

                // Petita pausa entre operacions per veure millor la concurrència
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 400));
            }
            System.out.println("[" + nomClient + "] ha acabat les operacions.");
        } catch (InterruptedException e) {
            System.out.println("[" + nomClient + "] interromput.");
            Thread.currentThread().interrupt();
        }
    }

    private double quantitatAleatoria() {
        // Quantitats entre 10 i 200
        return ThreadLocalRandom.current().nextInt(10, 201);
    }
}