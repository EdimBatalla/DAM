package Exercici_04;

import java.util.concurrent.ThreadLocalRandom;

public class Article {

    private final String title;
    private String content;

    // Control de concurrència
    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    public Article(String title, String initialContent) {
        this.title = title;
        this.content = initialContent;
    }

    public String getTitle() {
        return title;
    }

    // --- LECTOR ---
    public void read(String readerName) throws InterruptedException {
        // Fase d'entrada 
        synchronized (this) {
            // Lectors només poden entrar si:
            // - No hi ha escriptor escrivint
            // - No hi ha escriptors esperant 
            while (writers > 0 || writeRequests > 0) {
                wait();
            }
            readers++;
        }

        // Zona de lectura (sense bloquejar altres lectors)
        System.out.println("[" + readerName + "] LLEGINT '" + title + "': " + content);
        Thread.sleep(ThreadLocalRandom.current().nextInt(200, 600));

        // Fase de sortida 
        synchronized (this) {
            readers--;
            // Si era l'últim lector, potser hi ha un escriptor esperant
            notifyAll();
        }
    }

    // --- ESCRIPTOR ---
    public void write(String writerName, String newContent) throws InterruptedException {
        // Fase d'entrada 
        synchronized (this) {
            writeRequests++; // Indiquem que hi ha un escriptor que vol entrar
            while (readers > 0 || writers > 0) {
                // Espera fins que no hi hagi ningú dins
                wait();
            }
            writeRequests--;
            writers++;
        }

        // Zona d'escriptura 
        System.out.println("[" + writerName + "] ESCRIVINT '" + title + "'...");
        Thread.sleep(ThreadLocalRandom.current().nextInt(400, 900));
        content = newContent;
        System.out.println("[" + writerName + "] HA ACTUALITZAT '" + title + "' -> " + content);

        // Fase de sortida 
        synchronized (this) {
            writers--;
            notifyAll(); // Pot haver-hi lectors i/o altres escriptors esperant
        }
    }
}
