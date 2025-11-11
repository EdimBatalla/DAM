package Exercici_01;

public class ClientReserva implements Runnable {
    private final String nomClient;
    private final ZonaTeatre zona;
    private final int quantitat;

    public ClientReserva(String nomClient, ZonaTeatre zona, int quantitat) {
        this.nomClient = nomClient;
        this.zona = zona;
        this.quantitat = quantitat;
    }

    @Override
    public void run() {
        ResultatReserva resultat = zona.reservar(quantitat);
        System.out.println("[" + nomClient + "] " + resultat);
    }
}
