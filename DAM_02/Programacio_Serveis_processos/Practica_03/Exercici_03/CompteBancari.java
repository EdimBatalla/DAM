package Exercici_03;

public class CompteBancari {

    private final String idCompte;
    private double saldo; 

    public CompteBancari(String idCompte, double saldoInicial) {
        this.idCompte = idCompte;
        this.saldo = saldoInicial;
    }

    public String getIdCompte() {
        return idCompte;
    }

    // Ingressar diners
    public synchronized void ingressar(double quantitat) {
        if (quantitat <= 0) {
            System.out.println("[COMPTE " + idCompte + "] Ingrés invàlid: " + quantitat);
            return;
        }
        double saldoAnterior = saldo;
        saldo += quantitat;
        System.out.println("[COMPTE " + idCompte + "] INGRÉS " + quantitat +
                " | Abans: " + saldoAnterior + " | Després: " + saldo);
    }

    // Retirar diners
    public synchronized boolean retirar(double quantitat) {
        if (quantitat <= 0) {
            System.out.println("[COMPTE " + idCompte + "] Retirada invàlida: " + quantitat);
            return false;
        }

        if (quantitat > saldo) {
            System.out.println("[COMPTE " + idCompte + "] RETIRADA DENEGADA " + quantitat +
                    " | Saldo actual: " + saldo);
            return false;
        }

        double saldoAnterior = saldo;
        saldo -= quantitat;
        System.out.println("[COMPTE " + idCompte + "] RETIRADA " + quantitat +
                " | Abans: " + saldoAnterior + " | Després: " + saldo);
        return true;
    }

    // Consultar saldo (lectura consistent)
    public synchronized double consultarSaldo() {
        System.out.println("[COMPTE " + idCompte + "] CONSULTA saldo: " + saldo);
        return saldo;
    }
}
