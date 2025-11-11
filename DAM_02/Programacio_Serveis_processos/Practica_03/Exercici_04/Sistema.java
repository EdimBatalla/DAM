package Exercici_04;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

    public static void main(String[] args) throws InterruptedException {
        // Crear diversos articles
        Article art1 = new Article("Article 1", "Contingut inicial A");
        Article art2 = new Article("Article 2", "Contingut inicial B");
        Article art3 = new Article("Article 3", "Contingut inicial C");

        List<Article> articles = List.of(art1, art2, art3);

        // Crear diversos lectors i escriptors
        List<Thread> threads = new ArrayList<>();

        // lectors
        for (int i = 1; i <= 5; i++) {
            Reader reader = new Reader("Lector-" + i, articles, 5);
            threads.add(new Thread(reader));
        }

        // escriptors
        for (int i = 1; i <= 3; i++) {
            Writer writer = new Writer("Escriptor-" + i, articles, 3);
            threads.add(new Thread(writer));
        }

        // Llançar tots els fils
        for (Thread t : threads) {
            t.start();
        }

        // Esperar que tots acabin
        for (Thread t : threads) {
            t.join();
        }

        System.out.println(">>> Tots els lectors i escriptors han acabat.");
    }
}
