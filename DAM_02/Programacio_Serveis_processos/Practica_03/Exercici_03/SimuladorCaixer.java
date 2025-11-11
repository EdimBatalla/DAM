package Exercici_03;

import java.util.ArrayList;
import java.util.List;

public class SimuladorCaixer {

    public static void main(String[] args) throws InterruptedException {
        // Crear diversos comptes
        CompteBancari compte1 = new CompteBancari("ES00-1111", 500);
        CompteBancari compte2 = new CompteBancari("ES00-2222", 1000);
        CompteBancari compte3 = new CompteBancari("ES00-3333", 200);

        List<CompteBancari> comptes = List.of(compte1, compte2, compte3);

        // Crear diversos clients (fils)
        List<Thread> fils = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ClientCaixer client = new ClientCaixer("Client-" + i, comptes, 10);
            fils.add(new Thread(client));
        }

        // Llançar fils
        for (Thread t : fils) {
            t.start();
        }

        // Esperar que tots acabin
        for (Thread t : fils) {
            t.join();
        }

        System.out.println("----- SALDOS FINALS -----");
        for (CompteBancari c : comptes) {
            c.consultarSaldo();
        }
    }
}
