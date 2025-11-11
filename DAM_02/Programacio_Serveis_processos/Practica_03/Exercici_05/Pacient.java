
package Exercici_05;

public class Pacient implements Runnable {

    private final String nom;
    private final boolean urgent;
    private final SalaEspera sala;
    private boolean ates = false; // per saber quan el doctor ja l'ha atès

    public Pacient(String nom, boolean urgent, SalaEspera sala) {
        this.nom = nom;
        this.urgent = urgent;
        this.sala = sala;
    }

    public String getNom() {
        return nom;
    }

    public boolean isUrgent() {
        return urgent;
    }

    @Override
    public void run() {
        try {
            // Intentar entrar a la sala (si està plena, el pacient espera fins que hi hagi lloc)
            sala.entrarSala(this);
            System.out.println("[PACIENT " + nom + "] S'ha assegut a la sala d'espera. Urgent=" + urgent);

            // Esperar que el doctor el cridi
            esperarAtencio();

            System.out.println("[PACIENT " + nom + "] Ja ha estat atès i marxa del consultori.");
        } catch (InterruptedException e) {
            System.out.println("[PACIENT " + nom + "] interromput.");
            Thread.currentThread().interrupt();
        }
    }

    // El pacient espera fins que el doctor el marqui com a atès
    private void esperarAtencio() throws InterruptedException {
        synchronized (this) {
            while (!ates) {
                wait();
            }
        }
    }

    // El doctor crida aquest mètode quan acaba d'atendre'l
    public void avisarAtencio() {
        synchronized (this) {
            ates = true;
            notify();
        }
    }

    @Override
    public String toString() {
        return "Pacient{" + nom + ", urgent=" + urgent + "}";
    }
}
